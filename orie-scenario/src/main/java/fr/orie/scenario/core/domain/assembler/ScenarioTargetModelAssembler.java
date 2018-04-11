package fr.orie.scenario.core.domain.assembler;

import fr.orie.scenario.core.domain.model.ScenarioTargetListObjectiveModel;
import fr.orie.scenario.core.domain.model.ScenarioTargetObjectiveModel;
import fr.orie.scenario.core.domain.model.ScenarioTargetPointObjectiveModel;
import fr.orie.scenario.persistence.entity.target.AbstractScenarioNodeTargetEntity;
import fr.orie.scenario.persistence.entity.target.ScenarioNodeTargetItemPointEntity;
import fr.orie.scenario.persistence.entity.target.ScenarioNodeTargetListEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ScenarioTargetModelAssembler {

    public ScenarioTargetObjectiveModel fromEntity(AbstractScenarioNodeTargetEntity entity) {
        switch (entity.type()){
            case POINT:
                return fromPointEntity((ScenarioNodeTargetItemPointEntity)entity);
            case LIST:
                return fromListEntity((ScenarioNodeTargetListEntity)entity);
                default:
                    return null;
        }
    }

    private ScenarioTargetObjectiveModel fromPointEntity(ScenarioNodeTargetItemPointEntity entity) {
        ScenarioTargetPointObjectiveModel model = new ScenarioTargetPointObjectiveModel();
        model.setRadiusMeter(entity.getRadiusMeter());
        model.setPointUuId(entity.getPointUuId());
        return model;
    }

    private ScenarioTargetObjectiveModel fromListEntity(ScenarioNodeTargetListEntity entity) {
        ScenarioTargetListObjectiveModel model = new ScenarioTargetListObjectiveModel();
        model.setOperator(entity.getOperator());
        entity.getItems().forEach(item -> model.getItems().add(fromEntity(item)));
        return model;
    }

}

