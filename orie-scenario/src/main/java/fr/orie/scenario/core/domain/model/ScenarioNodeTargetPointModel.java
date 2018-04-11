package fr.orie.scenario.core.domain.model;

public class ScenarioNodeTargetPointModel extends ScenarioNodeTargetModel {

    private int radiusMeter;
    private String pointUuId;

    public void setRadiusMeter(int radiusMeter) {
        this.radiusMeter = radiusMeter;
    }

    public int getRadiusMeter() {
        return radiusMeter;
    }

    public void setPointUuId(String pointUuId) {
        this.pointUuId = pointUuId;
    }

    public String getPointUuId() {
        return pointUuId;
    }
}
