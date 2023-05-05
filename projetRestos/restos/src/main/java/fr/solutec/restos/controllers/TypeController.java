package fr.solutec.restos.controllers;

import fr.solutec.restos.entites.Restaurant;
import fr.solutec.restos.entites.Type;
import fr.solutec.restos.services.TypeService;
import org.springframework.web.bind.annotation.*;

import java.util.Observable;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin
@RequestMapping(path = "type", produces = APPLICATION_JSON_VALUE)
@RestController
public class TypeController {
    public TypeService typeService;

    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    @CrossOrigin
    @GetMapping (path="{id}")
    public @ResponseBody Optional<Type> findById(@PathVariable int id){
        return this.typeService.findById(id);
    }

    @CrossOrigin
    @GetMapping
    public @ResponseBody Iterable<Type> findAll(){
        return this.typeService.findAll();
    }

    @CrossOrigin
    @PostMapping
    public void findById(@RequestBody Type type) {
        this.typeService.save(type);
    }
}
