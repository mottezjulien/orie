package fr.jmottez.parc.user.facade.controller;

import fr.jmottez.parc.user.core.service.UserService;
import fr.jmottez.parc.user.facade.assembler.UserDTOAssembler;
import fr.jmottez.parc.user.facade.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;


@Controller
@RequestMapping(value = "/user")
public class UserController {

    //AdminAccess ??? UserAccess --> utiliser une facade écran

    @Autowired
    private UserService service;

    @Autowired
    private UserDTOAssembler assembler;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public List<UserDTO> all() {
        return service.findAll()
                .map(model -> assembler.fromUserModel(model))
                .collect(Collectors.toList());
    }

}
