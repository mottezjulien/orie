package fr.jmottez.parc.scenario.repository;

import fr.jmottez.parc.scenario.repository.entity.ScenarioEntity;
import org.springframework.data.repository.CrudRepository;

public interface ScenarioRepository extends CrudRepository<ScenarioEntity, String> {

    /*@Query("select s from ScenarioEntity s join fetch s.nodes n " +
            "where s.uuId = (select s2.uuId from ScenarioEntity s2 join s.nodes n2 where n2 = ?1)")
    Optional<ScenarioEntity> findByNodeWithNodes(ScenarioNodeEntity child);*/

}