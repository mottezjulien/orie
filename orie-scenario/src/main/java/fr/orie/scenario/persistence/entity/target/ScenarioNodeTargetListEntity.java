package fr.orie.scenario.persistence.entity.target;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ScenarioNodeTargetListEntity extends AbstractScenarioNodeTargetEntity {

    @OneToMany(fetch = FetchType.LAZY)
    private List<AbstractScenarioNodeTargetEntity> items;

    @Column(name = "OPERATOR")
    private ScenarioNodeTargetOperator operator;

    public List<AbstractScenarioNodeTargetEntity> getItems() {
        if(items == null){
            items = new ArrayList<>();
        }
        return items;
    }

    public void setItems(List<AbstractScenarioNodeTargetEntity> items) {
        this.items = items;
    }

    public ScenarioNodeTargetOperator getOperator() {
        if(operator == null){
            operator = ScenarioNodeTargetOperator.AND;
        }
        return operator;
    }

    public void setOperator(ScenarioNodeTargetOperator operator) {
        this.operator = operator;
    }
}
