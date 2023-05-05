package fr.solutec.restos.dao;

import fr.solutec.restos.entites.Type;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.*;

public class TypeDAO {

    private JdbcTemplate jdbcTemplate;

    public TypeDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Type> search(Map<String, Object> params) {
        List<Type> types = new ArrayList();
        String QUERY = "SELECT * from TYPE";

        if (!params.isEmpty()) {
            List<String> keys = List.copyOf(params.keySet());

            for (int i=0; i < keys.size(); i++) {
                if (i==0) {
                    QUERY += " WHERE " + keys.get(i) + " LIKE '%" + params.get(keys.get(i)) + "%'";
                }

                else {
                    QUERY += " AND " + keys.get(i) + " LIKE '%" + params.get(keys.get(i)) + "%'";
                }
            }
        }

        List<Map<String, Object>> items = jdbcTemplate.queryForList(QUERY);

        for (Map<String, Object> item : items) {
            Type type = new Type();

            type.setId((int) item.get("id"));
            type.setNom((String) item.get("nom"));

            types.add(type);

        }


        return List.copyOf(types);
    }
}
