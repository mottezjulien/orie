package fr.orie.scenario.core.service;

import fr.orie.scenario.core.domain.assembler.ScenarioTargetModelAssembler;
import fr.orie.scenario.core.domain.model.ScenarioNodeModel;
import fr.orie.scenario.core.domain.model.ScenarioTargetListObjectiveModel;
import fr.orie.scenario.core.domain.model.ScenarioTargetModel;
import fr.orie.scenario.core.domain.model.ScenarioTargetObjectiveModel;
import fr.orie.scenario.persistence.entity.ScenarioNodeEntity;
import fr.orie.scenario.persistence.entity.target.AbstractScenarioNodeTargetEntity;
import fr.orie.scenario.persistence.entity.target.ScenarioNodeTargetItemPointEntity;
import fr.orie.scenario.persistence.entity.target.ScenarioNodeTargetListEntity;
import fr.orie.scenario.persistence.repository.ScenarioNodeRepository;
import fr.orie.scenario.persistence.repository.ScenarioNodeTargetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ScenarioTargetService {

    @Autowired
    ScenarioTargetModelAssembler assembler;

    @Autowired
    ScenarioNodeTargetRepository repository;

    @Autowired
    ScenarioNodeRepository nodeRepository;


    public Optional<ScenarioTargetModel> findAllByNode(ScenarioNodeModel nodeModel) {
        Optional<ScenarioNodeEntity> opt = nodeRepository.findByIdFetchTarget(nodeModel.getUuId());
        if (opt.isPresent()) {
            ScenarioNodeEntity root = opt.get();
            ScenarioTargetModel targetModel = new ScenarioTargetModel();
            targetModel.setUuId(root.getTarget().getUuId());
            targetModel.setObjective(buildRecursive(root.getTarget()));
            return Optional.of(targetModel);
        }
        return Optional.empty();
    }

    private ScenarioTargetObjectiveModel buildRecursive(AbstractScenarioNodeTargetEntity entity) {
        switch (entity.type()) {
            case LIST:
                ScenarioTargetListObjectiveModel model = (ScenarioTargetListObjectiveModel) assembler.fromEntity(entity);
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
