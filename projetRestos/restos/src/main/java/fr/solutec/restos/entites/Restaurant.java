package fr.solutec.restos.entites;
import javax.persistence.*;

@Entity
@Table( name = "restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String nom;
    String adresse;
    String tel;
    String maps;
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "id_type")
    Type type;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "id_prix")
    Prix prix;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "id_arrondissement")
    Arrondissement arrondissement;

    public Restaurant() {
    }

    public Restaurant(int id, String nom, String adresse, String tel, String maps, Type type, Prix prix, Arrondissement arrondissement) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.tel = tel;
        this.maps = maps;
        this.type = type;
        this.prix = prix;
        this.arrondissement = arrondissement;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMaps() {
        return maps;
    }

    public void setMaps(String maps) {
        this.maps = maps;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Prix getPrix() {
        return prix;
    }

    public void setPrix(Prix prix) {
        this.prix = prix;
    }

    public Arrondissement getArrondissement() {
        return arrondissement;
    }

    public void setArrondissement(Arrondissement arrondissement) {
        this.arrondissement = arrondissement;
    }
}

