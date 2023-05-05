package fr.solutec.restos.controllers;

import fr.solutec.restos.entites.Avis;
import fr.solutec.restos.entites.Restaurant;
import fr.solutec.restos.services.AvisService;
import fr.solutec.restos.services.RestaurantService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin
@RequestMapping(path = "avis", produces = APPLICATION_JSON_VALUE)
@RestController
public class AvisController {

        private AvisService avisService;

    public AvisController(AvisService avisService) {
        this.avisService = avisService;
    }

    @CrossOrigin
        @GetMapping
        public @ResponseBody List<Avis> search(
                @RequestParam(required = false) String surnom,
                @RequestParam(required = false) String texte,
                @RequestParam(required = false) int resto,
                @RequestParam(required = false) String theme){
            Map<String, Object> params = new HashMap<>();
            params.put("a.surnom", surnom);
            params.put("a.texte", texte);
            params.put("r.id", resto);
            params.put("t.nom", theme);
            return this.avisService.search(params);
        }

        @CrossOrigin
        @GetMapping (path = "{id}")
        public @ResponseBody Optional<Avis> findById(@PathVariable  int id) {
            return this.avisService.finById(id);
        }

        @CrossOrigin
        @PostMapping
        public void save(@RequestBody Avis avis) {
            this.avisService.save(avis);
        }
}
