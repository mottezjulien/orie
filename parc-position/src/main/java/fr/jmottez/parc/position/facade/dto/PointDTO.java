package fr.jmottez.parc.position.facade.dto;

public class PointDTO {
    private float lat;
    private float lng;

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLat() {
        return lat;
    }

    public void setLng(float lng) {
        this.lng = lng;
    }

    public float getLng() {
        return lng;
    }
}
