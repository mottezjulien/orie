package fr.orie.position.persistence;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PositionEntity {

    @Column(name="UUID")
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String uuId;

    @Column(name = "LAT")
    private Float lat;

    @Column(name = "LNG")
    private Float lng;

    public String getUuId() {
        return uuId;
    }

    public void setUuId(String uuId) {
        this.uuId = uuId;
    }

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
