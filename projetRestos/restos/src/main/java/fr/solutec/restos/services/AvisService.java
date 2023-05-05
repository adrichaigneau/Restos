package fr.solutec.restos.services;

import fr.solutec.restos.dao.AvisDAO;
import fr.solutec.restos.entites.Avis;
import fr.solutec.restos.entites.Restaurant;
import fr.solutec.restos.repositories.AvisRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class AvisService {
    private AvisDAO avisDAO;
    private AvisRepository avisRepository;

    public AvisService(AvisDAO avisDAO, AvisRepository avisRepository) {
        this.avisDAO = avisDAO;
        this.avisRepository = avisRepository;
    }

    public List<Avis> search(Map<String, Object> params) {
        Map<String, Object> nparams = new HashMap<>();
        for (String key : params.keySet()) {
            if (params.get(key) != null) {
                nparams.put(key, params.get(key));
            }
        }
        return this.avisDAO.search(nparams);
    }

    public Optional<Avis> finById(int id) {
        return this.avisRepository.findById(id);
    }

    public void save(Avis avis) {
        this.avisRepository.save(avis);
    }
}
