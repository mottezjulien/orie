package fr.orie.scenario.core.domain.model;

import fr.orie.scenario.persistence.entity.target.ScenarioNodeTargetOperator;

import java.util.ArrayList;
import java.util.List;

public class ScenarioTargetListObjectiveModel implements ScenarioTargetObjectiveModel {

    private ScenarioNodeTargetOperator operator;

    private List<ScenarioTargetObjectiveModel> items = new ArrayList<>();

    public void setOperator(ScenarioNodeTargetOperator operator) {
        this.operator = operator;
    }

    public ScenarioNodeTargetOperator getOperator() {
        return operator;
    }

    public List<ScenarioTargetObjectiveModel> getItems() {
        return items;
    }
}
