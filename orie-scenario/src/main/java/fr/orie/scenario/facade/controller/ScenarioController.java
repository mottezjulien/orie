package fr.orie.scenario.facade.controller;

import fr.orie.scenario.core.service.ScenarioService;
import fr.orie.scenario.facade.assembler.ScenarioFacadeAssembler;
import fr.orie.scenario.facade.dto.ScenarioDTO;
import fr.orie.shared.facade.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;


@Controller
@RequestMapping(value = "/scenario")
public class ScenarioController {

    @Autowired
    private ScenarioService service;

    @Autowired
    private ScenarioFacadeAssembler assembler;

    @GetMapping("/")
    @ResponseBody
    public Stream<ScenarioDTO> findAll() {
        return service.findAll()
                .map(model -> assembler.fromModel(model));
    }

    @GetMapping("/{scenarioId}")
    @ResponseBody
    public ScenarioDTO findById(@PathVariable(value = "scenarioId") String scenarioId) {
        return assembler.fromModel(service.findById(scenarioId)
                .orElseThrow(() -> new ResourceNotFoundException()));
    }

    @PostMapping("/")
    @ResponseBody
    public ScenarioDTO save(@RequestBody ScenarioDTO request) {
        return assembler.fromModel(service.save(assembler.toModel(request)));
    }

    @DeleteMapping("/{scenarioId}")
    public ResponseEntity<Void> delete(@PathVariable(value = "scenarioId") String scenarioId) {
        service.delete(scenarioId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
