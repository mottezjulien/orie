package fr.orie.scenario.facade.assembler;

import fr.orie.scenario.core.domain.model.ScenarioTargetModel;
import fr.orie.scenario.facade.dto.ScenarioTargetDTO;
import org.springframework.stereotype.Component;

@Component
public class ScenarioTargetFacadeAssembler {

    public ScenarioTargetDTO fromModel(ScenarioTargetModel eachNode) {
        return new ScenarioTargetDTO();
    }
}
