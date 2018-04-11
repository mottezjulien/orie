package fr.orie.scenario.core.domain.model;

public class ScenarioTargetModel {

    private String uuId;
    private String label;
    private ScenarioTargetObjectiveModel objective;

    public String getUuId() {
        return uuId;
    }

    public void setUuId(String uuId) {
        this.uuId = uuId;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public ScenarioTargetObjectiveModel getObjective() {
        return objective;
    }

    public void setObjective(ScenarioTargetObjectiveModel objective) {
        this.objective = objective;
    }
}
