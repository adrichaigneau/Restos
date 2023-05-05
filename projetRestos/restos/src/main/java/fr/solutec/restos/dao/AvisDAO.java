package fr.solutec.restos.dao;

import fr.solutec.restos.entites.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class AvisDAO {
    private JdbcTemplate jdbcTemplate;

    public AvisDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Avis> search(Map<String, Object> params) {
        List<Avis> aviss = new ArrayList<>();
        String QUERY =
                "SELECT a.id as a_id, a.surnom as a_surnom, a.texte as a_texte, r.id as r_id, r.nom as r_nom, r.adresse as r_adresse, r.tel as r_tel, t.id as t_id, t.nom as t_nom" +
                        " FROM AVIS a JOIN RESTAURANT r ON id_restaurant = r.id JOIN THEME t ON id_theme = t.id";
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
            Avis avis = new Avis();
            Restaurant restaurant = new Restaurant();
            Theme theme = new Theme();

            restaurant.setId((int) item.get("r_id"));
            restaurant.setNom((String) item.get("r_nom"));
            restaurant.setAdresse((String) item.get("r_adresse"));
            restaurant.setTel((String) item.get("r_tel"));

            theme.setId((int) item.get("t_id"));
            theme.setNom((String) item.get("t_nom"));

            avis.setId((int) item.get("a_id"));
            avis.setSurnom((String) item.get("a_surnom"));
            avis.setTexte((String) item.get("a_texte"));
            avis.setRestaurant(restaurant);
            avis.setTheme(theme);

            aviss.add(avis);
        }
        return List.copyOf(aviss);
    }
}
