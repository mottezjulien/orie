package fr.orie.scenario.facade.dto;

import java.util.ArrayList;
import java.util.List;

public class ScenarioTargetListDTO implements ScenarioTargetDTO {

    private String uuId;

    private List<ScenarioTargetDTO> items = new ArrayList<>();

    public void setUuId(String uuId) {
        this.uuId = uuId;
    }

    public String getUuId() {
        return uuId;
    }

    public List<ScenarioTargetDTO> getItems() {
        return items;
    }
}
