package fr.solutec.restos.controllers;

import fr.solutec.restos.entites.Arrondissement;
import fr.solutec.restos.entites.Type;
import fr.solutec.restos.services.ArrondissementService;
import fr.solutec.restos.services.TypeService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin
@RequestMapping(path = "arrondissement", produces = APPLICATION_JSON_VALUE)
@RestController
public class ArrondissementController {
    public ArrondissementService arrondissementService;

    public ArrondissementController(ArrondissementService arrondissementService) {
        this.arrondissementService = arrondissementService;
    }

    @CrossOrigin
    @GetMapping(path="{id}")
    public @ResponseBody Optional<Arrondissement> findById(@PathVariable int id){
        return this.arrondissementService.findById(id);
    }

    @CrossOrigin
    @GetMapping
    public @ResponseBody Iterable<Arrondissement> findAll(){
        return this.arrondissementService.findAll();
    }
}
