package fr.orie.user.core.service;

import fr.orie.user.core.assembler.UserModelAssembler;
import fr.orie.user.core.model.UserModel;
import fr.orie.user.repository.UserRepository;
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
