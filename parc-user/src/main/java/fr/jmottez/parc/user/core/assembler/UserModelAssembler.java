package fr.jmottez.parc.user.core.assembler;

import fr.jmottez.parc.user.core.model.UserModel;
import fr.jmottez.parc.user.repository.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserModelAssembler {

    public UserModel fromEntity(UserEntity entity) {
        UserModel model = new UserModel();
        model.setUuId(entity.getUuId());
        model.setLogin(entity.getLogin());
        return model;
    }
}
