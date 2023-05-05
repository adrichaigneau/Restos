package fr.solutec.restos.entites;

import javax.persistence.*;

@Entity
@Table( name = "arrondissement")
public class Arrondissement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    int numero;

    public Arrondissement() {
    }

    public Arrondissement(int id, int numero) {
        this.id = id;
        this.numero = numero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
