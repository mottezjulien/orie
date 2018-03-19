package fr.jmottez.parc.scenario.facade.assembler;

import fr.jmottez.parc.scenario.core.domain.model.ScenarioTargetModel;
import fr.jmottez.parc.scenario.facade.dto.ScenarioTargetDTO;
import org.springframework.stereotype.Component;

@Component
public class ScenarioTargetFacadeAssembler {

    public ScenarioTargetDTO fromModel(ScenarioTargetModel eachNode) {
        return new ScenarioTargetDTO();
    }
}
