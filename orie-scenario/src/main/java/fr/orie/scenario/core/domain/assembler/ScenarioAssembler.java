package fr.orie.scenario.core.domain.assembler;

import fr.orie.scenario.core.domain.model.ScenarioModel;
import fr.orie.scenario.persistence.entity.ScenarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Component
public class ScenarioAssembler {

    @Autowired
    private ScenarioNodeAssembler nodeAssembler;

    public Stream<ScenarioModel> fromEntities(Iterable<ScenarioEntity> entities) {
        List<ScenarioModel> models = new ArrayList<>();
        entities.forEach(entity -> models.add(fromEntity(entity)));
        return models.stream();
    }

    public ScenarioModel fromEntity(ScenarioEntity entity) {
        ScenarioModel model = new ScenarioModel();
        model.setUuId(entity.getUuId());
        entity.getNodes().forEach(node -> model.getNodes().add(nodeAssembler.fromEntity(node)));
        return model;
    }

    public ScenarioEntity toEntity(ScenarioModel model) {
        ScenarioEntity entity = new ScenarioEntity();
        entity.setUuId(model.getUuId());
        model.getNodes().forEach(node -> entity.getNodes().add(nodeAssembler.toEntity(node)));
        return entity;
    }
}
