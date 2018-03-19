package fr.jmottez.parc.scenario.facade.controller;

import fr.jmottez.parc.scenario.core.service.ScenarioTargetService;
import fr.jmottez.parc.scenario.facade.assembler.ScenarioNodeFacadeAssembler;
import fr.jmottez.parc.scenario.facade.assembler.ScenarioTargetFacadeAssembler;
import fr.jmottez.parc.scenario.facade.dto.ScenarioNodeDTO;
import fr.jmottez.parc.scenario.facade.dto.ScenarioTargetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Flux;


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
    public ScenarioTargetDTO findByNode(ScenarioNodeDTO node) {
        return assembler.fromModel(service.findByNode(nodeAssembler.toModel(node)));
    }


}
