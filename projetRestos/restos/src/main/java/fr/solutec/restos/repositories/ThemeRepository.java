package fr.solutec.restos.repositories;

import fr.solutec.restos.entites.Theme;
import org.springframework.data.repository.CrudRepository;

public interface ThemeRepository extends CrudRepository<Theme, Integer> {
}
