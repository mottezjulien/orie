package fr.orie.position.facade.controller;

import fr.orie.position.core.service.PositionService;
import fr.orie.position.facade.assembler.PositionFacadeAssembler;
import fr.orie.position.facade.dto.PositionDTO;
import fr.orie.position.facade.exception.NotFoundFacadeException;
import fr.orie.position.persistence.PositionRepository;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Api(value = "Position API", description = "The position API", tags = "Position")
@Controller
@RequestMapping(value = "/position")
public class PositionController {

    //adminAccess ??? UserAccess --> utiliser une facade écran

    @Autowired
    private PositionFacadeAssembler facadeAssembler;

    @Autowired
    private PositionService service;

    @Autowired
    private PositionRepository repository;

    @ApiOperation(value = "Find all positions", response = PositionDTO.class, tags = "Scenario")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Scenario found", response = PositionDTO.class),
            @ApiResponse(code = 400, message = "Request rejected", response = Error.class)
    })
    @RequestMapping(method = RequestMethod.GET, path = "/{uuId}")
    @ResponseBody
    public PositionDTO findById(@ApiParam(value = "positionId", required = true) @PathVariable(value = "positionId") String positionId) {
        return service.findByUuId(positionId)
                .map(model -> facadeAssembler.toDto(model))
                .orElseThrow(() -> new NotFoundFacadeException());
    }

    @ApiOperation(value = "Save position", response = PositionDTO.class, tags = "Scenario")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Position saved", response = PositionDTO.class),
            @ApiResponse(code = 400, message = "Request rejected", response = Error.class)
    })
    @RequestMapping(method = RequestMethod.POST, name = "/")
    @ResponseBody
    public PositionDTO save(@ApiParam(value = "request", required = true) @RequestBody PositionDTO request) {
        return facadeAssembler.toDto(service.save(facadeAssembler.fromDto(request)));
    }

    @ApiOperation(value = "Delete position", response = PositionDTO.class, tags = "Scenario")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Position deleted", response = PositionDTO.class),
            @ApiResponse(code = 400, message = "Request rejected", response = Error.class)
    })
    @RequestMapping(method = RequestMethod.DELETE, path = "/{positionId}")
    public ResponseEntity<Void> delete(@ApiParam(value = "positionId", required = true) @PathVariable(value = "positionId") String uuId) {
        service.findByUuId(uuId)
                .ifPresent(toDelete -> service.delete(toDelete));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}