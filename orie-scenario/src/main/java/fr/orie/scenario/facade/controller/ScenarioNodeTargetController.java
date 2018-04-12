package fr.orie.scenario.facade.controller;

import fr.orie.scenario.core.service.ScenarioNodeTargetService;
import fr.orie.scenario.facade.assembler.ScenarioNodeFacadeAssembler;
import fr.orie.scenario.facade.assembler.ScenarioTargetFacadeAssembler;
import fr.orie.scenario.facade.dto.ScenarioDTO;
import fr.orie.scenario.facade.dto.ScenarioNodeDTO;
import fr.orie.scenario.facade.dto.ScenarioTargetDTO;
import fr.orie.shared.facade.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;


@Controller
@RequestMapping(value = "/scenario/node/target")
public class ScenarioNodeTargetController {

    @Autowired
    private ScenarioNodeTargetService service;

    @Autowired
    private ScenarioTargetFacadeAssembler assembler;

    @GetMapping("/")
    @ResponseBody
    public Stream<ScenarioTargetDTO> findAll() {
        return service.findAll()
                .map(model -> assembler.fromModel(model));
    }

    @GetMapping("/{scenarioTargetId}/targetId")
    @ResponseBody
    public ScenarioTargetDTO findById(@PathVariable(value = "targetId") String targetId) {
        return assembler.fromModel(service.findById(targetId)
                .orElseThrow(() -> new ResourceNotFoundException()));
    }

    @GetMapping(path = "/{scenarioNodeId}/nodeId" )
    public ScenarioTargetDTO findByNodeId(@PathVariable(value = "scenarioNodeId") String scenarioNodeId) {
        return assembler.fromModel(service.findByNodeId(scenarioNodeId)
                .orElseThrow(() -> new ResourceNotFoundException()));
    }

    @PostMapping("/")
    @ResponseBody
    public ScenarioTargetDTO save(@RequestBody ScenarioTargetDTO request) {
        return assembler.fromModel(service.save(assembler.toModel(request)));
    }

    @DeleteMapping("/{scenarioId}")
    public ResponseEntity<Void> delete(@PathVariable(value = "targetId") String targetId) {
        service.delete(targetId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
