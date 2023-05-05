package fr.solutec.restos.entites;

import javax.persistence.*;

@Entity
@Table( name = "prix")
public class Prix {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String categorie;

    public Prix() {
    }

    public Prix(int id, String categorie) {
        this.id = id;
        this.categorie = categorie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
}
