package fr.orie.scenario.core.service;

import fr.orie.scenario.core.domain.assembler.ScenarioAssembler;
import fr.orie.scenario.core.domain.model.ScenarioModel;
import fr.orie.scenario.persistence.entity.ScenarioEntity;
import fr.orie.scenario.persistence.repository.ScenarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Stream;

@Service
public class ScenarioService {

    @Autowired
    private ScenarioRepository repository;

    @Autowired
    private ScenarioAssembler assembler;

    public Stream<ScenarioModel> findAll() {
        return assembler.fromEntities(repository.findAll());
    }

    public Optional<ScenarioModel> findById(String scenarioId) {
        return repository.findById(scenarioId)
                .map(entity -> assembler.fromEntity(entity));
    }

    public ScenarioModel save(ScenarioModel scenarioModel) {
        return assembler.fromEntity(repository.save(assembler.toEntity(scenarioModel)));
    }

    public void delete(String scenarioId) {
        repository.deleteById(scenarioId);
    }
}
