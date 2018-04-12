package fr.jmottez.parc.user.core.service;

import fr.jmottez.parc.user.core.assembler.UserModelAssembler;
import fr.jmottez.parc.user.core.model.UserModel;
import fr.jmottez.parc.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Stream;

public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserModelAssembler assembler;

    public Stream<UserModel> findAll() {
        return repository.streamFindAll().map(entity -> assembler.fromEntity(entity));
    }

}
