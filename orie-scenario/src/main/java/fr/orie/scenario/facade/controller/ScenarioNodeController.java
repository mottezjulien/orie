package fr.orie.scenario.facade.controller;

import fr.orie.scenario.core.service.ScenarioNodeService;
import fr.orie.scenario.core.service.ScenarioService;
import fr.orie.scenario.facade.assembler.ScenarioFacadeAssembler;
import fr.orie.scenario.facade.assembler.ScenarioNodeFacadeAssembler;
import fr.orie.scenario.facade.dto.ScenarioDTO;
import fr.orie.scenario.facade.dto.ScenarioNodeDTO;
import fr.orie.shared.facade.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;


@Controller
@RequestMapping(value = "/scenario/node")
public class ScenarioNodeController {

    @Autowired
    private ScenarioNodeService service;

    @Autowired
    private ScenarioNodeFacadeAssembler assembler;

    @GetMapping("/")
    @ResponseBody
    public Stream<ScenarioNodeDTO> findAll() {
        return service.findAll()
                .map(model -> assembler.fromModel(model));
    }

    @GetMapping("/{scenarioNodeId}")
    @ResponseBody
    public ScenarioNodeDTO findById(@PathVariable(value = "scenarioNodeId") String scenarioNodeId) {
        return assembler.fromModel(service.findById(scenarioNodeId)
                .orElseThrow(() -> new ResourceNotFoundException()));
    }

    @PostMapping("/")
    @ResponseBody
    public ScenarioNodeDTO save(@RequestBody ScenarioNodeDTO request) {
        return assembler.fromModel(service.save(assembler.toModel(request)));
    }

    @DeleteMapping("/{scenarioId}")
    public ResponseEntity<Void> delete(@PathVariable(value = "scenarioId") String scenarioId) {
        service.delete(scenarioId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
