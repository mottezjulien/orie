package fr.orie.scenario.persistence.entity.target;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class ScenarioNodeTargetPointEntity extends AbstractScenarioNodeTargetEntity {

    @Column(name="POINT_UUID")
    private String pointUuId;

    @Column
    private int radiusMeter;

    public String getPointUuId() {
        return pointUuId;
    }

    public void setPointUuId(String pointUuId) {
        this.pointUuId = pointUuId;
    }

    public int getRadiusMeter() {
        return radiusMeter;
    }

    public void setRadiusMeter(int radiusMeter) {
        this.radiusMeter = radiusMeter;
    }

    @Override
    public AbstractScenarioNodeTargetEntityType type() {
        return AbstractScenarioNodeTargetEntityType.POINT;
    }
}
