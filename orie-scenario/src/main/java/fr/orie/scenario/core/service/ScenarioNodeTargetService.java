package fr.orie.scenario.core.service;

import fr.orie.scenario.core.domain.assembler.ScenarioNodeTargetAssembler;
import fr.orie.scenario.core.domain.model.ScenarioNodeModel;
import fr.orie.scenario.core.domain.model.ScenarioNodeTargetListModel;
import fr.orie.scenario.core.domain.model.ScenarioNodeTargetModel;
import fr.orie.scenario.persistence.entity.ScenarioNodeEntity;
import fr.orie.scenario.persistence.entity.target.AbstractScenarioNodeTargetEntity;
import fr.orie.scenario.persistence.entity.target.ScenarioNodeTargetListEntity;
import fr.orie.scenario.persistence.repository.ScenarioNodeRepository;
import fr.orie.scenario.persistence.repository.ScenarioNodeTargetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ScenarioNodeTargetService {

    @Autowired
    ScenarioNodeTargetAssembler assembler;

    @Autowired
    ScenarioNodeTargetRepository repository;

    @Autowired
    ScenarioNodeRepository nodeRepository;


    public Optional<ScenarioNodeTargetModel> findByNodeId(String nodeId) {
        Optional<ScenarioNodeEntity> opt = nodeRepository.findByIdFetchTarget(nodeId);
        if (opt.isPresent()) {
            return Optional.of(buildRecursive(opt.get().getTarget()));
        }
        return Optional.empty();
    }

    private ScenarioNodeTargetModel buildRecursive(AbstractScenarioNodeTargetEntity entity) {
        switch (entity.type()) {
            case LIST:
                ScenarioNodeTargetListModel model = (ScenarioNodeTargetListModel) assembler.fromEntity(entity);
                Optional<ScenarioNodeTargetListEntity> optList = repository.findListFetchItemsById(entity.getUuId());
                optList.ifPresent(entityList -> entityList.getItems().forEach(itemEntity -> {
                    model.getItems().add(buildRecursive(itemEntity));
                }));
                return model;
            default:
                return assembler.fromEntity(entity);
        }
    }

}
