package fr.solutec.restos.entites;

import javax.persistence.*;

@Entity
@Table( name = "avis")
public class Avis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String surnom;

    String texte;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "id_restaurant")
    Restaurant restaurant;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "id_theme")
    Theme theme;

    public Avis() {
    }

    public Avis(int id, String surnom, String texte, Restaurant restaurant, Theme theme) {
        this.id = id;
        this.surnom = surnom;
        this.texte = texte;
        this.restaurant = restaurant;
        this.theme = theme;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurnom() {
        return surnom;
    }

    public void setSurnom(String surnom) {
        this.surnom = surnom;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }
}
