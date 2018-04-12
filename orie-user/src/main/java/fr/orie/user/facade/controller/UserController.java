package fr.orie.user.facade.controller;

import fr.orie.user.core.service.UserService;
import fr.orie.user.facade.assembler.UserDTOAssembler;
import fr.orie.user.facade.dto.UserDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;


@Api(value = "User API", description = "The user API", tags = "User target")
@Controller
@RequestMapping(value = "/user")
public class UserController {

    //AdminAccess ??? UserAccess --> utiliser une facade écran

    @Autowired
    private UserService service;

    @Autowired
    private UserDTOAssembler assembler;

    @ApiOperation(value = "Find all users", response = UserDTO.class, tags = "User")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Users found", response = UserDTO.class),
            @ApiResponse(code = 400, message = "Request rejected", response = Error.class)
    })
    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public List<UserDTO> findAll() {
        return service.findAll()
                .map(model -> assembler.fromUserModel(model))
                .collect(Collectors.toList());
    }

}
