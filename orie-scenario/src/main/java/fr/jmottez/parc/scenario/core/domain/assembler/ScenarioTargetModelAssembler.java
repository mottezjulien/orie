package fr.jmottez.parc.scenario.core.domain.assembler;


import fr.jmottez.parc.scenario.core.domain.model.ScenarioTargetModel;
import fr.jmottez.parc.scenario.repository.entity.target.AbstractScenarioNodeTargetEntity;
import org.springframework.stereotype.Component;

@Component
public class ScenarioTargetModelAssembler {

    public ScenarioTargetModel fromEntity(AbstractScenarioNodeTargetEntity entity) {
        return new ScenarioTargetModel();
    }
}
