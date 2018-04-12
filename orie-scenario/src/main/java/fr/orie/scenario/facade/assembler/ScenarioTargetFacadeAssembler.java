package fr.orie.scenario.facade.assembler;

import fr.orie.scenario.core.domain.model.ScenarioNodeTargetListModel;
import fr.orie.scenario.core.domain.model.ScenarioNodeTargetModel;
import fr.orie.scenario.core.domain.model.ScenarioNodeTargetPointModel;
import fr.orie.scenario.facade.dto.ScenarioTargetDTO;
import fr.orie.scenario.facade.dto.ScenarioTargetListDTO;
import fr.orie.scenario.facade.dto.ScenarioTargetPointDTO;
import org.springframework.stereotype.Component;

@Component
public class ScenarioTargetFacadeAssembler {

    public ScenarioTargetDTO fromModel(ScenarioNodeTargetModel model) {
        if(model instanceof ScenarioNodeTargetPointModel) {
            return fromPointModel((ScenarioNodeTargetPointModel) model);
        }
        if(model instanceof ScenarioNodeTargetListModel) {
            return fromListModel((ScenarioNodeTargetListModel) model);
        }
        return null;
    }

    private ScenarioTargetPointDTO fromPointModel(ScenarioNodeTargetPointModel model) {
        ScenarioTargetPointDTO dto = new ScenarioTargetPointDTO();
        dto.setUuId(model.getUuId());
        dto.setRadiusMeter(model.getRadiusMeter());
        dto.setPointUuId(model.getPointUuId());
        return dto;
    }

    private ScenarioTargetListDTO fromListModel(ScenarioNodeTargetListModel model) {
        ScenarioTargetListDTO dto = new ScenarioTargetListDTO();
        dto.setUuId(model.getUuId());
        model.getItems().forEach(item -> dto.getItems().add(fromModel(item)));
        return dto;
    }

    public ScenarioNodeTargetModel toModel(ScenarioTargetDTO dto) {
        if(dto instanceof ScenarioTargetPointDTO) {
            return toPointModel((ScenarioTargetPointDTO) dto);
        }
        if(dto instanceof ScenarioTargetListDTO) {
            return toListModel((ScenarioTargetListDTO) dto);
        }
        return null;
    }

    private ScenarioNodeTargetPointModel toPointModel(ScenarioTargetPointDTO dto) {
        ScenarioNodeTargetPointModel model = new ScenarioNodeTargetPointModel();
        model.setUuId(dto.getUuId());
        return model;
    }

    private ScenarioNodeTargetListModel toListModel(ScenarioTargetListDTO dto) {
        ScenarioNodeTargetListModel model = new ScenarioNodeTargetListModel();
        model.setUuId(dto.getUuId());
        dto.getItems().forEach(item -> model.getItems().add(toModel(item)));
        return model;
    }

}
