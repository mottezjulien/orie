package fr.orie.scenario.persistence.repository;

import fr.orie.scenario.persistence.entity.ScenarioNodeEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ScenarioNodeRepository extends CrudRepository<ScenarioNodeEntity, String> {

    @Query(value = "SELECT node FROM ScenarioNodeEntity node LEFT JOIN FETCH node.rootTreeTarget target WHERE node.uuId = :uuId")
    Optional<ScenarioNodeEntity> findByIdFetchTarget(@Param("uuId") String uuId);

}