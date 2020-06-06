package Modele;

import java.sql.ResultSet;
import java.sql.SQLException;


public class Groupe {
    private int id; //clé primaire
    private String nom;
    private int id_groupe; //clé étrangère
    
    //Constructeur par default
    public Groupe(){
        id=0;
        nom="";
        id_groupe=0;      
    }

    //constructeur 
    public Groupe(int id,String nom, int id_groupe) {
        this.id = id;
        this.nom = nom;
        this.id_groupe = id_groupe;
    }
    
    /**
     *Afficher dans le console 
     */
    public void afficher(){
        System.out.println("Id:" + id);
        System.out.println("Nom:" + nom);
        System.out.println("Id_groupe:" + id_groupe);
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
	public int getId_groupe() {
		return id_groupe;
	}
	public void setId_groupe(int id_groupe) {
		this.id_groupe = id_groupe;
	}
    
    
}
