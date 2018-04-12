package fr.orie.user.facade.assembler;

import fr.orie.user.core.model.UserModel;
import fr.orie.user.facade.dto.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserDTOAssembler {

    public UserDTO fromUserModel(UserModel model) {
        UserDTO dto = new UserDTO();
        dto.setUuId(model.getUuId());
        dto.setLogin(model.getLogin());
        return dto;
    }
}
