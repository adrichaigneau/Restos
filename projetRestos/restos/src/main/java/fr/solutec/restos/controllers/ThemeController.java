package fr.solutec.restos.controllers;

import fr.solutec.restos.entites.Theme;
import fr.solutec.restos.entites.Type;
import fr.solutec.restos.services.ThemeService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin
@RequestMapping(path = "theme", produces = APPLICATION_JSON_VALUE)
@RestController
public class ThemeController {
    public ThemeService themeService;

    public ThemeController(ThemeService themeService) {
        this.themeService = themeService;
    }

    @CrossOrigin
    @GetMapping(path="{id}")
    public @ResponseBody Optional<Theme> findById(@PathVariable int id){
        return this.themeService.findById(id);
    }

    @CrossOrigin
    @GetMapping
    public @ResponseBody Iterable<Theme> findAll(){
        return this.themeService.findAll();
    }

    @CrossOrigin
    @PostMapping
    public void findById(@RequestBody Theme theme) {
        this.themeService.save(theme);
    }
}
