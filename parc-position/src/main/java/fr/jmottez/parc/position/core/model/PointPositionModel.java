package fr.jmottez.parc.position.core.model;

public class PointPositionModel
        implements PositionModel {

    private String uuid;
    private PointModel point;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public PointModel getPoint() {
        return point;
    }

    public void setPoint(PointModel point) {
        this.point = point;
    }
}
