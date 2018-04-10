package fr.orie.scenario.facade.assembler;

import fr.orie.scenario.core.domain.model.ScenarioNodeModel;
import fr.orie.scenario.facade.dto.ScenarioNodeDTO;
import org.springframework.stereotype.Component;

@Component
public class ScenarioNodeFacadeAssembler {

    public ScenarioNodeModel toModel(ScenarioNodeDTO dto) {
        ScenarioNodeModel model = new ScenarioNodeModel();
        //model.set(dto.get());
        return model;
    }

    public ScenarioNodeDTO fromModel(ScenarioNodeModel model) {
        return new ScenarioNodeDTO();
    }
}
