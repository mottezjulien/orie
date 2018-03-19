package fr.jmottez.parc.position.core.service;

import fr.jmottez.parc.position.core.assembler.PositionAssembler;
import fr.jmottez.parc.position.core.model.PositionModel;
import fr.jmottez.parc.position.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PositionService {

    @Autowired
    private PositionAssembler assembler;

    @Autowired
    private PositionRepository repository;

    public Optional<PositionModel> findByUuId(String uuId) {
        return repository.findByUuId(uuId)
                .map(entity -> assembler.fromEntity(entity));
    }

    public PositionModel save(PositionModel model) {
        return assembler.fromEntity(repository.save(assembler.toEntity(model)));
    }

    public void delete(PositionModel model) {
        repository.delete(assembler.toEntity(model));
    }
}
