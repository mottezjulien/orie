package fr.orie.position.facade.dto;

public class PointPositionDTO implements PositionDTO {

    private String uuid;
    private PointDTO point;

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }

    public void setPoint(PointDTO point) {
        this.point = point;
    }

    public PointDTO getPoint() {
        return point;
    }
}
