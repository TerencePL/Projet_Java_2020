package Modele;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Enseignant {
    private int id_utilisateur;
    private int id_cours;

    
    //Constructeur par default
    public Enseignant(){
        id_utilisateur=0;
        id_cours=0;      
    }

    //constructeur surchargé
    public Enseignant(int id_utilisateur, int id_cours) {
        this.id_utilisateur = id_utilisateur;
        this.id_cours = id_cours;
    }
    
    /**
     *Afficher un cours
     */
    public void afficher(){
        System.out.println("Id_utilisateur:" + id_utilisateur);
        System.out.println("Id_cours:" + id_cours);
    } 
    
    
    
    //Getters 
    public int getId_utilisateur() {
        return id_utilisateur;
    }
    
    public String getId_cours() {
        return id_cours;
    }

    //Setters
    public void setId(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }
    
    public void setId_cours(int id_cours) {
        this.id_cours = id_cours;
    }
    
}
