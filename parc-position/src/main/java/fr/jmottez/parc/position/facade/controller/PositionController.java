package fr.jmottez.parc.position.facade.controller;

import fr.jmottez.parc.position.core.service.PositionService;
import fr.jmottez.parc.position.facade.assembler.PositionFacadeAssembler;
import fr.jmottez.parc.position.facade.dto.PositionDTO;
import fr.jmottez.parc.position.facade.exception.NotFoundFacadeException;
import fr.jmottez.parc.position.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/position")
public class PositionController {

    //adminAccess ??? UserAccess --> utiliser une facade écran

    @Autowired
    private PositionFacadeAssembler facadeAssembler;

    @Autowired
    private PositionService service;

    @Autowired
    private PositionRepository repository;

    @RequestMapping(method = RequestMethod.GET, path = "/{uuId}")
    @ResponseBody
    public PositionDTO findByUuId(@PathVariable(value = "uuId") String uuId) {
        return service.findByUuId(uuId)
                .map(model -> facadeAssembler.toDto(model))
                .orElseThrow(() -> new NotFoundFacadeException());
    }

    @RequestMapping(method = RequestMethod.POST, name = "/")
    @ResponseBody
    public PositionDTO save(@RequestBody PositionDTO input) {
        return facadeAssembler.toDto(service.save(facadeAssembler.fromDto(input)));
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{uuId}")
    public ResponseEntity<Void> delete(@PathVariable(value = "uuId") String uuId) {
        service.findByUuId(uuId)
                .ifPresent(toDelete -> service.delete(toDelete));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}