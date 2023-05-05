package fr.solutec.restos.services;

import fr.solutec.restos.entites.Arrondissement;
import fr.solutec.restos.entites.Theme;
import fr.solutec.restos.repositories.ThemeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ThemeService {

    private ThemeRepository themeRepository;

    public ThemeService(ThemeRepository themeRepository) {
        this.themeRepository = themeRepository;
    }

    public Optional<Theme> findById(int id) {
        return this.themeRepository.findById(id);
    }

    public Iterable<Theme> findAll() {
        return this.themeRepository.findAll();
    }

    public void save(Theme theme) {
        this.themeRepository.save(theme);
    }
}
