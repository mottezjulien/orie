package fr.orie.scenario.persistence.entity;

import fr.orie.scenario.persistence.entity.target.AbstractScenarioNodeTargetEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ScenarioNodeEntity {

    @Column(name="UUID")
    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String uuId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SCENARIO_UUID")
    private ScenarioEntity scenario;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TARGET_ROOT_TREE_UUID")
    private AbstractScenarioNodeTargetEntity rootTreeTarget;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="SCENARIO_RESULT",
            joinColumns=@JoinColumn(name="SCENARIO_UUID", referencedColumnName="UUID"),
            inverseJoinColumns=@JoinColumn(name="RESULT_UUID", referencedColumnName="UUID"))
    private Set<AbstractScenarioNodeResultEntity> results;

    public String getUuId() {
        return uuId;
    }

    public void setUuId(String uuId) {
        this.uuId = uuId;
    }

    public ScenarioEntity getScenario() {
        return scenario;
    }

    public void setScenario(ScenarioEntity scenario) {
        this.scenario = scenario;
    }

    public AbstractScenarioNodeTargetEntity getRootTreeTarget() {
        return rootTreeTarget;
    }

    public void setRootTreeTarget(AbstractScenarioNodeTargetEntity rootTreeTarget) {
        this.rootTreeTarget = rootTreeTarget;
    }

    public Set<AbstractScenarioNodeResultEntity> getResults() {
        if(results == null) {
            results = new HashSet<>();
        }
        return results;
    }

    public void setResults(Set<AbstractScenarioNodeResultEntity> results) {
        this.results = results;
    }
}
