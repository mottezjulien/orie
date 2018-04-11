package fr.orie.scenario.facade.assembler;

import fr.orie.scenario.core.domain.model.ScenarioNodeModel;
import fr.orie.scenario.facade.dto.ScenarioNodeDTO;
import org.springframework.stereotype.Component;

@Component
public class ScenarioNodeFacadeAssembler {

    /*
    private String label;
    private String quickDesc;
    private
    private ScenarioNodeObjectifDTO objectif; //(position, combi de réussite, temps ...)


    desc
    objectif/reussite
    gains (text description, video, images)   (dans le dto ??)
    pertes

    On commence par les entities !!!*/


    public ScenarioNodeModel toModel(ScenarioNodeDTO dto) {
        ScenarioNodeModel model = new ScenarioNodeModel();
        model.setUuId(dto.getUuId());
        //model.setLabel(dto.getLabel());
        //model.set(dto.get());
        return model;
    }

    public ScenarioNodeDTO fromModel(ScenarioNodeModel model) {
        ScenarioNodeDTO dto = new ScenarioNodeDTO();
        dto.setUuId(model.getUuId());
        return dto;
    }
}
