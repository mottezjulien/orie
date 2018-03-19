package fr.jmottez.parc.scenario.repository.entity.target;

import fr.jmottez.parc.scenario.repository.entity.target.AbstractScenarioNodeTargetEntity;
import fr.jmottez.parc.scenario.repository.entity.target.ScenarioNodeTargetOperator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ScenarioNodeTargetListEntity extends AbstractScenarioNodeTargetEntity {

    @OneToMany(fetch = FetchType.LAZY)
    private List<AbstractScenarioNodeTargetEntity> operands;

    @Column(name = "OPERATOR")
    private ScenarioNodeTargetOperator operator;

    public List<AbstractScenarioNodeTargetEntity> getOperands() {
        if(operands == null){
            operands = new ArrayList<>();
        }
        return operands;
    }

    public void setOperands(List<AbstractScenarioNodeTargetEntity> operands) {
        this.operands = operands;
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
