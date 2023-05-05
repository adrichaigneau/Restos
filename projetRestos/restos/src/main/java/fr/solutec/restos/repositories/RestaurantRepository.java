package fr.solutec.restos.repositories;

import fr.solutec.restos.entites.Restaurant;

import org.springframework.data.repository.CrudRepository;

public interface RestaurantRepository extends CrudRepository<Restaurant, Integer> {
}
