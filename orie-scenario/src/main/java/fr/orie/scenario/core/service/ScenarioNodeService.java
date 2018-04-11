package fr.orie.scenario.core.service;

import fr.orie.scenario.core.domain.assembler.ScenarioAssembler;
import fr.orie.scenario.core.domain.assembler.ScenarioNodeAssembler;
import fr.orie.scenario.core.domain.model.ScenarioModel;
import fr.orie.scenario.core.domain.model.ScenarioNodeModel;
import fr.orie.scenario.persistence.repository.ScenarioNodeRepository;
import fr.orie.scenario.persistence.repository.ScenarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Stream;

@Service
public class ScenarioNodeService {

    @Autowired
    private ScenarioNodeRepository repository;

    @Autowired
    private ScenarioNodeAssembler assembler;

    public Stream<ScenarioNodeModel> findAll() {
        return assembler.fromEntities(repository.findAll());
    }

    public Optional<ScenarioNodeModel> findById(String scenarioId) {
        return repository.findById(scenarioId)
                .map(entity -> assembler.fromEntity(entity));
    }

    public ScenarioNodeModel save(ScenarioNodeModel scenarioModel) {
        return assembler.fromEntity(repository.save(assembler.toEntity(scenarioModel)));
    }

    public void delete(String scenarioId) {
        repository.deleteById(scenarioId);
    }


}
