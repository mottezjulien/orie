package fr.orie.scenario.facade.controller;

import fr.orie.scenario.core.service.ScenarioService;
import fr.orie.scenario.facade.assembler.ScenarioFacadeAssembler;
import fr.orie.scenario.facade.dto.ScenarioDTO;
import fr.orie.scenario.facade.dto.ScenarioTargetDTO;
import fr.orie.shared.facade.exception.ResourceNotFoundException;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@Api(value = "Scenario API", description = "The scenario API", tags = "Scenario")
@Controller
@RequestMapping(value = "/scenario")
public class ScenarioController {

    @Autowired
    private ScenarioService service;

    @Autowired
    private ScenarioFacadeAssembler assembler;

    @ApiOperation(value = "Find all scenarios", response = ScenarioDTO.class, tags = "Scenario")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Scenario found", response = ScenarioDTO.class),
            @ApiResponse(code = 400, message = "Request rejected", response = Error.class)
    })
    @GetMapping("/")
    @ResponseBody
    public Stream<ScenarioDTO> findAll() {
        return service.findAll()
                .map(model -> assembler.fromModel(model));
    }

    @ApiOperation(value = "Find a scenario by id", response = ScenarioDTO.class, tags = "Scenario")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Scenario found", response = ScenarioDTO.class),
            @ApiResponse(code = 400, message = "Request rejected", response = Error.class)
    })
    @GetMapping("/{scenarioId}")
    @ResponseBody
    public ScenarioDTO findById(@ApiParam(value = "scenarioId", required = true) @PathVariable(value = "scenarioId") String scenarioId) {
        return assembler.fromModel(service.findById(scenarioId)
                .orElseThrow(() -> new ResourceNotFoundException()));
    }

    @ApiOperation(value = "Save a scenario", response = ScenarioDTO.class, tags = "Scenario")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Scenario saved", response = ScenarioDTO.class),
            @ApiResponse(code = 400, message = "Request rejected", response = Error.class)
    })
    @PostMapping("/")
    @ResponseBody
    public ScenarioDTO save(@ApiParam(value = "request", required = true) @RequestBody ScenarioDTO request) {
        return assembler.fromModel(service.save(assembler.toModel(request)));
    }

    @ApiOperation(value = "Delete a scenario", response = ScenarioDTO.class, tags = "Scenario")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Scenario deleted", response = ScenarioDTO.class),
            @ApiResponse(code = 400, message = "Request rejected", response = Error.class)
    })
    @DeleteMapping("/{scenarioId}")
    public ResponseEntity<Void> delete(@ApiParam(value = "scenarioId", required = true) @PathVariable(value = "scenarioId") String scenarioId) {
        service.delete(scenarioId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
