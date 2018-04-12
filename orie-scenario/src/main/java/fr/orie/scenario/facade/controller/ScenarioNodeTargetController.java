package fr.orie.scenario.facade.controller;

import fr.orie.scenario.core.service.ScenarioNodeTargetService;
import fr.orie.scenario.facade.assembler.ScenarioTargetFacadeAssembler;
import fr.orie.scenario.facade.dto.ScenarioNodeDTO;
import fr.orie.scenario.facade.dto.ScenarioTargetDTO;
import fr.orie.shared.facade.exception.ResourceNotFoundException;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@Api(value = "Scenario node target API", description = "The scenario node target API", tags = "Scenario node target")
@Controller
@RequestMapping(value = "/scenario/node/target")
public class ScenarioNodeTargetController {

    @Autowired
    private ScenarioNodeTargetService service;

    @Autowired
    private ScenarioTargetFacadeAssembler assembler;

    @ApiOperation(value = "Find all scenario node targets", response = ScenarioTargetDTO.class, tags = "Scenario node target")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Scenario node target found", response = ScenarioTargetDTO.class),
            @ApiResponse(code = 400, message = "Request rejected", response = Error.class)
    })
    @GetMapping("/")
    @ResponseBody
    public Stream<ScenarioTargetDTO> findAll() {
        return service.findAll()
                .map(model -> assembler.fromModel(model));
    }

    @ApiOperation(value = "Find a scenario node target by target id", response = ScenarioTargetDTO.class, tags = "Scenario node target")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Scenario node target found", response = ScenarioTargetDTO.class),
            @ApiResponse(code = 400, message = "Request rejected", response = Error.class)
    })
    @GetMapping("/{scenarioTargetId}/targetId")
    @ResponseBody
    public ScenarioTargetDTO findById(@ApiParam(value = "targetId", required = true) @PathVariable(value = "targetId") String targetId) {
        return assembler.fromModel(service.findById(targetId)
                .orElseThrow(() -> new ResourceNotFoundException()));
    }

    @ApiOperation(value = "Find a scenario node target by node id", response = ScenarioTargetDTO.class, tags = "Scenario node target")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Scenario node target found", response = ScenarioTargetDTO.class),
            @ApiResponse(code = 400, message = "Request rejected", response = Error.class)
    })
    @GetMapping(path = "/{scenarioNodeId}/nodeId" )
    public ScenarioTargetDTO findByNodeId(@ApiParam(value = "scenarioNodeId", required = true) @PathVariable(value = "scenarioNodeId") String scenarioNodeId) {
        return assembler.fromModel(service.findByNodeId(scenarioNodeId)
                .orElseThrow(() -> new ResourceNotFoundException()));
    }

    @ApiOperation(value = "Save a scenario node target", response = ScenarioTargetDTO.class, tags = "Scenario node target")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Scenario node target saved", response = ScenarioTargetDTO.class),
            @ApiResponse(code = 400, message = "Request rejected", response = Error.class)
    })
    @PostMapping("/")
    @ResponseBody
    public ScenarioTargetDTO save(@ApiParam(value = "request", required = true) @RequestBody ScenarioTargetDTO request) {
        return assembler.fromModel(service.save(assembler.toModel(request)));
    }

    @ApiOperation(value = "Delete a scenario node target", response = ScenarioTargetDTO.class, tags = "Scenario node target")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Scenario node target deleted", response = ScenarioTargetDTO.class),
            @ApiResponse(code = 400, message = "Request rejected", response = Error.class)
    })
    @DeleteMapping("/{scenarioId}")
    public ResponseEntity<Void> delete(@ApiParam(value = "scenarioNodeId", required = true) @PathVariable(value = "targetId") String targetId) {
        service.delete(targetId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
