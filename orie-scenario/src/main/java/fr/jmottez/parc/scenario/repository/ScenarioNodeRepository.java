package fr.jmottez.parc.scenario.repository;

import fr.jmottez.parc.scenario.repository.entity.ScenarioNodeEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ScenarioNodeRepository extends CrudRepository<ScenarioNodeEntity, String> {

    /*@EntityGraph(value = "ScenarioNodeEntity.details", type = EntityGraph.EntityGraphType.LOAD)
    Optional<ScenarioNodeEntity> findByuuId(String uuid);*/

}