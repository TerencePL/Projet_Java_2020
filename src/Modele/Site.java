package Modele;

import java.sql.ResultSet;
import java.sql.SQLException;


public class Site {
    private int id; //cl� primaire
    private String nom;
    
    //Constructeur par default
    public Site(){
        id = 0;
        nom = "";     
    }

    //constructeur
    public Site(int id,String nom) {
        this.id = id;
        this.nom = nom;
    }
    
    /**
     *Afficher dans le console
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
