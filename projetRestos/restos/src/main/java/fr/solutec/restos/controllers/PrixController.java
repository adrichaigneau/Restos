package fr.solutec.restos.controllers;

import fr.solutec.restos.entites.Prix;
import fr.solutec.restos.entites.Restaurant;
import fr.solutec.restos.services.PrixService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin
@RequestMapping(path = "prix", produces = APPLICATION_JSON_VALUE)
@RestController
public class PrixController {

    private PrixService prixService;

    public PrixController(PrixService prixService) {
        this.prixService = prixService;
    }

    @CrossOrigin
    @GetMapping
    public @ResponseBody Iterable<Prix> findAll() {
        return this.prixService.findAll();
    }
}
