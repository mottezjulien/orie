package fr.orie.scenario.facade.assembler;

import fr.orie.scenario.core.domain.model.ScenarioNodeTargetModel;
import fr.orie.scenario.facade.dto.ScenarioTargetDTO;
import org.springframework.stereotype.Component;

@Component
public class ScenarioTargetFacadeAssembler {

    public ScenarioTargetDTO fromModel(ScenarioNodeTargetModel model) {
        ScenarioTargetDTO dto = new ScenarioTargetDTO();
        dto.setUuId(model.getUuId());
        return dto;
    }
}
