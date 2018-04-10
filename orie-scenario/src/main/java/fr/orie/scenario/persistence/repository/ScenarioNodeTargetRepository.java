package fr.orie.scenario.persistence.repository;

import fr.orie.scenario.core.domain.model.ScenarioNodeModel;
import fr.orie.scenario.persistence.entity.target.AbstractScenarioNodeTargetEntity;
import fr.orie.scenario.persistence.entity.target.ScenarioNodeTargetListEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public interface ScenarioNodeTargetRepository extends CrudRepository<AbstractScenarioNodeTargetEntity, String> {

    @Query(value = "SELECT list FROM ScenarioNodeTargetListEntity list LEFT JOIN FETCH list.items items WHERE list.uuId = :uuId")
    Optional<ScenarioNodeTargetListEntity> findListFetchItemsById(@Param("uuId") String uuId);

}