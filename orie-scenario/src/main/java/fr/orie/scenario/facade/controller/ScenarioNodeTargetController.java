package fr.orie.scenario.facade.controller;

import fr.orie.scenario.core.service.ScenarioNodeTargetService;
import fr.orie.scenario.facade.assembler.ScenarioNodeFacadeAssembler;
import fr.orie.scenario.facade.assembler.ScenarioTargetFacadeAssembler;
import fr.orie.scenario.facade.dto.ScenarioNodeDTO;
import fr.orie.scenario.facade.dto.ScenarioTargetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.stream.Stream;


@Controller
@RequestMapping(value = "/scenario/target")
public class ScenarioNodeTargetController {

    @Autowired
    private ScenarioNodeTargetService service;

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
