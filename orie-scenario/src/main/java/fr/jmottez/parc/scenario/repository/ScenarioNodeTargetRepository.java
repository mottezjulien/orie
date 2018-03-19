package fr.jmottez.parc.scenario.repository;

import fr.jmottez.parc.scenario.core.domain.model.ScenarioNodeModel;
import fr.jmottez.parc.scenario.repository.entity.ScenarioEntity;
import fr.jmottez.parc.scenario.repository.entity.target.AbstractScenarioNodeTargetEntity;
import org.springframework.data.repository.CrudRepository;
import reactor.core.publisher.Flux;

public interface ScenarioNodeTargetRepository extends CrudRepository<AbstractScenarioNodeTargetEntity, String> {

    Flux<AbstractScenarioNodeTargetEntity> findByNode(ScenarioNodeModel node);

    /*@Query("select s from ScenarioEntity s join fetch s.nodes n " +
            "where s.uuId = (select s2.uuId from ScenarioEntity s2 join s.nodes n2 where n2 = ?1)")
    Optional<ScenarioEntity> findByNodeWithNodes(ScenarioNodeEntity child);*/

}