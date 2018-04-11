package fr.orie.scenario.core.domain.model;

public class ScenarioNodeModel {

    private String uuId;
    private ScenarioTargetObjectiveModel target;

    public String getUuId() {
        return uuId;
    }

    public void setUuId(String uuId) {
        this.uuId = uuId;
    }

    public void setTarget(ScenarioTargetObjectiveModel target) {
        this.target = target;
    }

    public ScenarioTargetObjectiveModel getTarget() {
        return target;
    }
}
