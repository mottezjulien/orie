package fr.orie.scenario.core.domain.assembler;


import fr.orie.scenario.core.domain.model.ScenarioTargetModel;
import fr.orie.scenario.persistence.entity.target.AbstractScenarioNodeTargetEntity;
import org.springframework.stereotype.Component;

@Component
public class ScenarioTargetModelAssembler {

    public ScenarioTargetModel fromEntity(AbstractScenarioNodeTargetEntity entity) {
        return new ScenarioTargetModel();
    }
}
