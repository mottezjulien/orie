package fr.jmottez.parc.position.repository;

import fr.jmottez.parc.generic.entity.AbstractEntityUuId;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class PositionEntity
        extends AbstractEntityUuId {

    @Column(name = "LAT")
    private Float lat;

    @Column(name = "LNG")
    private Float lng;


    public Float getLat() {
        if(lat == null) {
            lat = 0.0f;
        }
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }

    public Float getLng() {
        if(lng == null) {
            lng = 0.0f;
        }
        return lng;
    }

    public void setLng(Float lng) {
        this.lng = lng;
    }
}
