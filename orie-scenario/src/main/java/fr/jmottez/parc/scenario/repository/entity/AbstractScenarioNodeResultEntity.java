package fr.jmottez.parc.scenario.repository.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class AbstractScenarioNodeResultEntity  {

    @Column(name="UUID")
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String uuId;

    public String getUuId() {
        return uuId;
    }

    public void setUuId(String uuId) {
        this.uuId = uuId;
    }

}