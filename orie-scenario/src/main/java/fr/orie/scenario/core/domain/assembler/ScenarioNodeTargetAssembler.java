package fr.orie.scenario.core.domain.assembler;

import fr.orie.scenario.core.domain.model.ScenarioModel;
import fr.orie.scenario.core.domain.model.ScenarioNodeTargetListModel;
import fr.orie.scenario.core.domain.model.ScenarioNodeTargetModel;
import fr.orie.scenario.core.domain.model.ScenarioNodeTargetPointModel;
import fr.orie.scenario.persistence.entity.ScenarioEntity;
import fr.orie.scenario.persistence.entity.target.AbstractScenarioNodeTargetEntity;
import fr.orie.scenario.persistence.entity.target.ScenarioNodeTargetPointEntity;
import fr.orie.scenario.persistence.entity.target.ScenarioNodeTargetListEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


@Component
public class ScenarioNodeTargetAssembler {

    public Stream<ScenarioNodeTargetModel> fromEntities(Iterable<AbstractScenarioNodeTargetEntity> entities) {
        List<ScenarioNodeTargetModel> models = new ArrayList<>();
        entities.forEach(entity -> models.add(fromEntity(entity)));
        return models.stream();
    }

    public ScenarioNodeTargetModel fromEntity(AbstractScenarioNodeTargetEntity entity) {
        switch (entity.type()){
            case POINT:
                return fromPointEntity((ScenarioNodeTargetPointEntity)entity);
            case LIST:
                return fromListEntity((ScenarioNodeTargetListEntity)entity);
            default:
                return null;
        }
    }

    private ScenarioNodeTargetModel fromPointEntity(ScenarioNodeTargetPointEntity entity) {
        ScenarioNodeTargetPointModel model = new ScenarioNodeTargetPointModel();
        model.setUuId(entity.getUuId());
        model.setRadiusMeter(entity.getRadiusMeter());
        model.setPointUuId(entity.getPointUuId());
        return model;
    }

    private ScenarioNodeTargetModel fromListEntity(ScenarioNodeTargetListEntity entity) {
        ScenarioNodeTargetListModel model = new ScenarioNodeTargetListModel();
        model.setUuId(entity.getUuId());
        model.setOperator(entity.getOperator());
        entity.getItems().forEach(item -> model.getItems().add(fromEntity(item)));
        return model;
    }

    public AbstractScenarioNodeTargetEntity toEntity(ScenarioNodeTargetModel model) {
        //TODO
        ScenarioNodeTargetPointEntity entity = new ScenarioNodeTargetPointEntity();
        entity.setUuId(model.getUuId());
        return entity;
    }
}

