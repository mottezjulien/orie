package fr.orie.scenario.core.domain.model;

public class ScenarioNodeModel {

    private String uuId;

    private ScenarioNodeTargetModel target;

    public String getUuId() {
        return uuId;
    }

    public void setUuId(String uuId) {
        this.uuId = uuId;
    }

    public ScenarioNodeTargetModel getTarget() {
        return target;
    }

    public void setTarget(ScenarioNodeTargetModel target) {
        this.target = target;
    }
}
