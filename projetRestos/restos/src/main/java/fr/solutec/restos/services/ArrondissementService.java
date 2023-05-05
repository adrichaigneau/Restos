package fr.solutec.restos.services;

import fr.solutec.restos.entites.Arrondissement;
import fr.solutec.restos.entites.Type;
import fr.solutec.restos.repositories.ArrondissementRepository;
import fr.solutec.restos.repositories.TypeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArrondissementService {

    private ArrondissementRepository arrondissementRepository;

    public ArrondissementService(ArrondissementRepository arrondissementRepository) {
        this.arrondissementRepository = arrondissementRepository;
    }

    public Optional<Arrondissement> findById(int id) {
        return this.arrondissementRepository.findById(id);
    }

    public Iterable<Arrondissement> findAll() {
        return this.arrondissementRepository.findAll();
    }
}
