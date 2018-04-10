package fr.orie.scenario.facade.controller;

import fr.orie.scenario.core.service.ScenarioTargetService;
import fr.orie.scenario.facade.assembler.ScenarioNodeFacadeAssembler;
import fr.orie.scenario.facade.assembler.ScenarioTargetFacadeAssembler;
import fr.orie.scenario.facade.dto.ScenarioNodeDTO;
import fr.orie.scenario.facade.dto.ScenarioTargetDTO;
import fr.orie.shared.facade.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Stream;


@Controller
@RequestMapping(value = "/scenario/target")
public class ScenarioTargetController {

    @Autowired
    private ScenarioTargetService service;

    @Autowired
    private ScenarioTargetFacadeAssembler assembler;

    @Autowired
    private ScenarioNodeFacadeAssembler nodeAssembler;

    @GetMapping(path = "/")
    public Stream<ScenarioTargetDTO> findAllByNode(ScenarioNodeDTO node) {
        return service.findAllByNode(nodeAssembler.toModel(node))
                .stream()
                .map(model -> assembler.fromModel(model));
    }

}
