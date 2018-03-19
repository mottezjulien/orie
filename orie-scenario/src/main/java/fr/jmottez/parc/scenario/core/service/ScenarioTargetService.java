package fr.jmottez.parc.scenario.core.service;

import fr.jmottez.parc.scenario.core.domain.assembler.ScenarioTargetModelAssembler;
import fr.jmottez.parc.scenario.core.domain.model.ScenarioNodeModel;
import fr.jmottez.parc.scenario.core.domain.model.ScenarioTargetModel;
import fr.jmottez.parc.scenario.repository.ScenarioNodeRepository;
import fr.jmottez.parc.scenario.repository.ScenarioNodeTargetRepository;
import fr.jmottez.parc.scenario.repository.entity.ScenarioNodeEntity;
import fr.jmottez.parc.scenario.repository.entity.target.AbstractScenarioNodeTargetEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Optional;
import java.util.stream.Stream;

@Service
public class ScenarioTargetService {

    @Autowired
    ScenarioNodeTargetRepository repository;

    @Autowired
    ScenarioTargetModelAssembler assembler;

    @Autowired
    ScenarioNodeRepository nodeRepository;

    public Optional<ScenarioTargetModel> findByNode(ScenarioNodeModel node) {
        Optional<ScenarioNodeEntity> optionalScenarioNodeEntity = nodeRepository.custom_findByUuidFetchTarget(node.getUuid());
        if(optionalScenarioNodeEntity.isPresent()) {

        }

    }

    //alors, tu pars sur le
    /*
    public Flux<ScenarioTargetModel> findByNode(ScenarioNodeModel node) {
        Flux<AbstractScenarioNodeTargetEntity> targetEntities = repository.findByNode(node);
        return targetEntities.map(target -> assembler.fromEntity(target));
    }*/



}
