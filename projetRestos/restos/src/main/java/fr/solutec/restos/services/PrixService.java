package fr.solutec.restos.services;
import fr.solutec.restos.entites.Prix;
import fr.solutec.restos.entites.Restaurant;
import fr.solutec.restos.repositories.PrixRepository;
import org.springframework.stereotype.Service;

@Service
public class PrixService {

    private PrixRepository prixRepository;

    public PrixService(PrixRepository prixRepository) {
        this.prixRepository = prixRepository;
    }
    public Iterable<Prix> findAll() {
        return this.prixRepository.findAll();
    }
}
