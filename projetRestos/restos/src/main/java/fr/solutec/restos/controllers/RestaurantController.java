package fr.solutec.restos.controllers;

import fr.solutec.restos.entites.Restaurant;
import fr.solutec.restos.services.RestaurantService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin
@RequestMapping(path = "restaurant", produces = APPLICATION_JSON_VALUE)
@RestController
public class RestaurantController {

    private RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @CrossOrigin
    @GetMapping
    public @ResponseBody List<Restaurant> search(
            @RequestParam(required = false) String nom,
            @RequestParam(required = false) String adresse,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String prix,
            @RequestParam(required = false) String maps,
            @RequestParam(required = false) String arr){
        Map<String, Object> params = new HashMap<>();
        params.put("r.nom", nom);
        params.put("r.adresse", adresse);
        params.put("t.nom", type);
        params.put("p.categorie", prix);
        params.put("p.maps", maps);
        params.put("a.numero", arr);
        return this.restaurantService.search(params);
    }

    @CrossOrigin
    @GetMapping (path = "{id}")
    public @ResponseBody Optional<Restaurant> findById(@PathVariable  int id) {
        return this.restaurantService.finById(id);
    }

    @CrossOrigin
    @PostMapping
    public void save(@RequestBody Restaurant restaurant) {
        this.restaurantService.save(restaurant);
    }
}
