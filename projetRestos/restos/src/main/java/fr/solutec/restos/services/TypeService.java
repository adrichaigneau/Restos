package fr.solutec.restos.services;

import fr.solutec.restos.entites.Type;
import fr.solutec.restos.repositories.TypeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TypeService {
    private TypeRepository typeRepository;

    public TypeService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    public Optional<Type> findById(int id) {
        return this.typeRepository.findById(id);
    }

    public Iterable<Type> findAll() {
        return this.typeRepository.findAll();
    }

    public void save(Type type) {
        this.typeRepository.save(type);
    }
}
