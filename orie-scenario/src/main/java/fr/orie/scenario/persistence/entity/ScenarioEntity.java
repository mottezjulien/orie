package fr.orie.scenario.persistence.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NamedEntityGraph(name = "ScenarioEntity.nodes",
        attributeNodes = @NamedAttributeNode("nodes"))
public class ScenarioEntity {

    @Column(name="UUID")
    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String uuId;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "scenario")
    private Set<ScenarioNodeEntity> nodes;

    public String getUuId() {
        return uuId;
    }

    public void setUuId(String uuId) {
        this.uuId = uuId;
    }

    public Set<ScenarioNodeEntity> getNodes() {
        if (nodes != null) {
            nodes = new HashSet<>();
        }
        return nodes;
    }

    public void setNodes(Set<ScenarioNodeEntity> nodes) {
        this.nodes = nodes;
    }
}
