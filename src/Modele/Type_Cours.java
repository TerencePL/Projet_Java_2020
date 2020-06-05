package Modele;

import java.sql.ResultSet;
import java.sql.SQLException;


public class Type_Cours {
    private int id; //cl� primaire
    private String nom;
    
    //Constructeur par default
    public Type_Cours(){
        id = 0;
        nom = "";     
    }

    //constructeur surcharg�
    public Type_Cours(int id,String nom) {
        this.id = id;
        this.nom = nom;
    }
    
    /**
     *Afficher 
     */
    public void afficher(){
        System.out.println("Id:" + id);
        System.out.println("Nom:" + nom);
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
    
    
}
