package fr.orie.scenario.core.domain.assembler;

import fr.orie.scenario.core.domain.model.ScenarioModel;
import fr.orie.scenario.core.domain.model.ScenarioNodeModel;
import fr.orie.scenario.persistence.entity.ScenarioNodeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Component
public class ScenarioNodeAssembler {

    @Autowired
    private ScenarioNodeTargetAssembler targetAssembler;

    public Stream<ScenarioNodeModel> fromEntities(Iterable<ScenarioNodeEntity> entities) {
        List<ScenarioNodeModel> models = new ArrayList<>();
        entities.forEach(entity -> models.add(fromEntity(entity)));
        return models.stream();
    }

    public ScenarioNodeModel fromEntity(ScenarioNodeEntity entity) {
        ScenarioNodeModel model = new ScenarioNodeModel();
        model.setUuId(entity.getUuId());
        model.setTarget(targetAssembler.fromEntity(entity.getTarget()));
        return model;
    }

    public ScenarioNodeEntity toEntity(ScenarioNodeModel model) {
        ScenarioNodeEntity entity = new ScenarioNodeEntity();
        entity.setUuId(model.getUuId());
        entity.setTarget(targetAssembler.toEntity(model.getTarget()));
        return entity;
    }


}
