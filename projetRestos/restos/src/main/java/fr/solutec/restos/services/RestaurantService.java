package fr.solutec.restos.services;

import fr.solutec.restos.dao.RestaurantDAO;
import fr.solutec.restos.entites.Restaurant;
import fr.solutec.restos.repositories.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RestaurantService {
    private RestaurantDAO restaurantDAO;
    private RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantDAO restaurantDAO, RestaurantRepository restaurantRepository) {
        this.restaurantDAO = restaurantDAO;
        this.restaurantRepository = restaurantRepository;
    }

    public List<Restaurant> search(Map<String, Object> params) {
        Map<String, Object> nparams = new HashMap<>();
        for (String key : params.keySet()) {
            if (params.get(key) != null) {
                nparams.put(key, params.get(key));
            }
        }
        return this.restaurantDAO.search(nparams);
    }

    public Optional<Restaurant> finById(int id) {
        return this.restaurantRepository.findById(id);
    }

    public void save(Restaurant restaurant) {
        this.restaurantRepository.save(restaurant);
    }
}
