package fr.orie.scenario.facade.assembler;

import fr.orie.scenario.core.domain.model.ScenarioModel;
import fr.orie.scenario.facade.dto.ScenarioDTO;
import org.springframework.stereotype.Component;

@Component
public class ScenarioFacadeAssembler {

    public ScenarioDTO fromModel(ScenarioModel model) {
        ScenarioDTO dto = new ScenarioDTO();
        dto.setUuId(model.getUuId());
        return dto;
    }
}
