package fr.solutec.restos.repositories;

import fr.solutec.restos.entites.Prix;

import org.springframework.data.repository.CrudRepository;

public interface PrixRepository extends CrudRepository<Prix, Integer> {
}
