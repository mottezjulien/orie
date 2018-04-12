package fr.orie.scenario.facade.controller;

import fr.orie.scenario.core.service.ScenarioNodeService;
import fr.orie.scenario.facade.assembler.ScenarioNodeFacadeAssembler;
import fr.orie.scenario.facade.dto.ScenarioNodeDTO;
import fr.orie.shared.facade.exception.ResourceNotFoundException;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;


@Api(value = "User API", description = "the user API", tags = "Users")
@Controller
@RequestMapping(value = "/scenario/node")
public class ScenarioNodeController {

    @Autowired
    private ScenarioNodeService service;

    @Autowired
    private ScenarioNodeFacadeAssembler assembler;

    @ApiOperation(value = "Find all scenario nodes", response = ScenarioNodeDTO.class, tags = "Scenario node")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Scenario node found", response = ScenarioNodeDTO.class),
            @ApiResponse(code = 400, message = "Request rejected", response = Error.class)
    })
    @GetMapping("/")
    @ResponseBody
    public Stream<ScenarioNodeDTO> findAll() {
        return service.findAll()
                .map(model -> assembler.fromModel(model));
    }

    @ApiOperation(value = "Find a scenario node by node id", response = ScenarioNodeDTO.class, tags = "Scenario node")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Scenario node found", response = ScenarioNodeDTO.class),
            @ApiResponse(code = 400, message = "Request rejected", response = Error.class)
    })
    @GetMapping("/{scenarioNodeId}")
    @ResponseBody
    public ScenarioNodeDTO findById(@ApiParam(value = "scenarioNodeId", required = true) @PathVariable(value = "scenarioNodeId") String scenarioNodeId) {
        return assembler.fromModel(service.findById(scenarioNodeId)
                .orElseThrow(() -> new ResourceNotFoundException()));
    }

    @ApiOperation(value = "Save a scenario node", response = ScenarioNodeDTO.class, tags = "Scenario node")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Scenario node saved", response = ScenarioNodeDTO.class),
            @ApiResponse(code = 400, message = "Request rejected", response = Error.class)
    })
    @PostMapping("/")
    @ResponseBody
    public ScenarioNodeDTO save(@ApiParam(value = "request", required = true) @RequestBody ScenarioNodeDTO request) {
        return assembler.fromModel(service.save(assembler.toModel(request)));
    }

    @ApiOperation(value = "Delete a scenario node", response = ScenarioNodeDTO.class, tags = "Scenario node")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Scenario node deleted", response = ScenarioNodeDTO.class),
            @ApiResponse(code = 400, message = "Request rejected", response = Error.class)
    })
    @DeleteMapping("/{scenarioId}")
    public ResponseEntity<Void> delete(@ApiParam(value = "scenarioNodeId", required = true) @PathVariable(value = "scenarioNodeId") String scenarioNodeId) {
        service.delete(scenarioNodeId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
