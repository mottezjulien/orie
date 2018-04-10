package fr.orie.scenario.core.service;

import fr.orie.scenario.core.domain.assembler.ScenarioTargetModelAssembler;
import fr.orie.scenario.core.domain.model.ScenarioNodeModel;
import fr.orie.scenario.core.domain.model.ScenarioTargetModel;
import fr.orie.scenario.persistence.entity.target.AbstractScenarioNodeTargetEntity;
import fr.orie.scenario.persistence.entity.target.ScenarioNodeTargetListEntity;
import fr.orie.scenario.persistence.repository.ScenarioNodeRepository;
import fr.orie.scenario.persistence.repository.ScenarioNodeTargetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ScenarioTargetService {

    @Autowired
    ScenarioTargetModelAssembler assembler;

    @Autowired
    ScenarioNodeTargetRepository repository;

    @Autowired
    ScenarioNodeRepository nodeRepository;


    public List<ScenarioTargetModel> findAllByNode(ScenarioNodeModel nodeModel) {
        List<ScenarioTargetModel> list = new ArrayList<>();
        nodeRepository
                .findByIdFetchTarget(nodeModel.getUuid())
                .ifPresent(node -> {
                    AbstractScenarioNodeTargetEntity root = node.getRootTreeTarget();
                    list.add(assembler.fromEntity(root));
                    list.addAll(findAllItemsRecursive(root)
                            .stream()
                            .map(entity -> assembler.fromEntity(entity)).collect(Collectors.toList()));
                });
        return list;
    }

    private List<AbstractScenarioNodeTargetEntity> findAllItemsRecursive(AbstractScenarioNodeTargetEntity targetParent) {
        List<AbstractScenarioNodeTargetEntity> list = new ArrayList<>();
        if (targetParent instanceof ScenarioNodeTargetListEntity) {
            Stream<AbstractScenarioNodeTargetEntity> items = repository.findItemsById(targetParent.getUuId());
            items.forEach(item -> {
                list.add(item);
                list.addAll(findAllItemsRecursive(item));
            });
        }
        return list;
    }


}
