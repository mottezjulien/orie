package fr.orie.scenario.persistence.repository;

import fr.orie.scenario.persistence.entity.ScenarioEntity;
import org.springframework.data.repository.CrudRepository;

public interface ScenarioRepository extends CrudRepository<ScenarioEntity, String> {

}