package fr.orie.scenario.core.domain.model;

import java.util.ArrayList;
import java.util.List;

public class ScenarioModel {

    private String uuId;

    private List<ScenarioNodeModel> nodes = new ArrayList<>();

    public String getUuId() {
        return uuId;
    }

    public void setUuId(String uuId) {
        this.uuId = uuId;
    }

    public List<ScenarioNodeModel> getNodes() {
        return nodes;
    }
}
