package Modele;

import java.sql.ResultSet;
import java.sql.SQLException;


public class Cours {
    private int id;
    private String nom;

    //Constructeur par default
    public Cours(){
        id=0;
        nom=null;      
    }

    //constructeur 
    public Cours(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }
    
    /**
     *Afficher dans le console
     */
    public void afficher(){
        System.out.println("Id:" + id);
        System.out.println("Nom:" + nom);
        //System.out.println(classe.getId_classe()+" "+classe.getNom());
        //System.out.println(eleve.getId()+" "+eleve.getNom());
    } 
    
    
    
    //Getters 
    public int getId() {
        return id;
    }    
    public String getNom() {
        return nom;
    }
    //Setters
    public void setId(int id) {
        this.id = id;
    } 
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    /*
    @Override
    public boolean equals(Object inscription){
        return inscription instanceof Inscription &&
                ((Inscription) inscription).id_inscription==this.id_inscription &&
                ((Inscription) inscription).classe.equals(this.classe)&&
                ((Inscription) inscription).eleve.equals(this.eleve);
    } */

    
}
