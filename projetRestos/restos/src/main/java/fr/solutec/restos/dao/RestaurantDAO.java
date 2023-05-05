package fr.solutec.restos.dao;

import fr.solutec.restos.entites.Arrondissement;
import fr.solutec.restos.entites.Prix;
import fr.solutec.restos.entites.Restaurant;
import fr.solutec.restos.entites.Type;
import org.springframework.stereotype.Component;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.*;

@Component

public class RestaurantDAO {

    private JdbcTemplate jdbcTemplate;

    public RestaurantDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Restaurant> search(Map<String, Object> params) {
        List<Restaurant> restaurants = new ArrayList<>();
        String QUERY =
                "SELECT r.id as r_id, r.nom as r_nom, r.adresse as r_adresse, r.tel as r_tel, r.maps as r_maps, t.id as t_id, t.nom as t_nom, p.id as p_id, p.categorie as p_categorie, a.id as a_id, a.numero as a_numero" +
                " FROM RESTAURANT r JOIN TYPE t ON id_type = t.id JOIN PRIX p ON id_prix = p.id JOIN ARRONDISSEMENT a ON id_arrondissement = a.id";
        if (!params.isEmpty()) {
            List<String> keys = List.copyOf(params.keySet()); // join date
            for (int i = 0; i < keys.size(); i++) {

                if (keys.get(i) == "p.categorie" || keys.get(i) == "a.numero") {
                    if (i==0) {
                        QUERY += " WHERE " + keys.get(i) + " = '" + params.get(keys.get(i)) + "'";
                    }
                    else {
                        QUERY += " AND " + keys.get(i) + " = '" + params.get(keys.get(i)) + "'";
                    }
                }
                else {
                    if (i == 0) {
                        QUERY += " WHERE " + keys.get(i) + " Like '%" + params.get(keys.get(i)) + "%'";
                    }

                    else {
                        QUERY += " AND " + keys.get(i) + " Like '%" + params.get(keys.get(i)) + "%'";
                    }
                }
            }
        }
        List<Map<String, Object>> items = jdbcTemplate.queryForList(QUERY);
        for (Map<String, Object> item : items) {
            Restaurant restaurant = new Restaurant();
            Type type = new Type();
            Prix prix = new Prix();
            Arrondissement arrondissement = new Arrondissement();

            restaurant.setId((int) item.get("r_id"));
            restaurant.setNom((String) item.get("r_nom"));
            restaurant.setAdresse((String)item.get("r_adresse"));
            restaurant.setTel((String) item.get("r_tel"));
            restaurant.setMaps((String) item.get("r_maps"));

            type.setId((int)item.get("t_id"));
            type.setNom((String)item.get("t_nom"));

            prix.setId((int)item.get("p_id"));
            prix.setCategorie((String)item.get("p_categorie"));

            arrondissement.setId((int)item.get("a_id"));
            arrondissement.setNumero((int)item.get("a_numero"));

            restaurant.setType(type);
            restaurant.setPrix(prix);
            restaurant.setArrondissement(arrondissement);

            restaurants.add(restaurant);
        }
        return List.copyOf(restaurants);
    }
}
