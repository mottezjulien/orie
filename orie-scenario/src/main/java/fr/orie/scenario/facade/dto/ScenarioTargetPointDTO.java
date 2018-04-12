package fr.orie.scenario.facade.dto;

public class ScenarioTargetPointDTO implements ScenarioTargetDTO {

    private String uuId;
    private int radiusMeter;
    private String pointUuId;

    public void setUuId(String uuId) {
        this.uuId = uuId;
    }

    public String getUuId() {
        return uuId;
    }

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
