package fr.orie.scenario.facade.controller;

import fr.orie.scenario.core.service.ScenarioService;
import fr.orie.scenario.core.service.ScenarioTargetService;
import fr.orie.scenario.facade.assembler.ScenarioFacadeAssembler;
import fr.orie.scenario.facade.assembler.ScenarioNodeFacadeAssembler;
import fr.orie.scenario.facade.assembler.ScenarioTargetFacadeAssembler;
import fr.orie.scenario.facade.dto.ScenarioDTO;
import fr.orie.scenario.facade.dto.ScenarioNodeDTO;
import fr.orie.scenario.facade.dto.ScenarioTargetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.stream.Stream;


@Controller
@RequestMapping(value = "/scenario")
public class ScenarioController {

    @Autowired
    private ScenarioService service;

    @Autowired
    private ScenarioFacadeAssembler assembler;

    @GetMapping(path = "/")
    public Stream<ScenarioDTO> findAll() {
        return service.findAll()
                .map(model -> assembler.fromModel(model));
    }

}
