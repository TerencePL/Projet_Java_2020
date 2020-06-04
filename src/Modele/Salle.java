package Modele;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Salle {
    private int id; //clé primaire
    private String nom;
    private int capacite;
    private int id_site; //clé étrangère
    
    //Constructeur par default
    public Salle(){
        id=0;
        nom="";
        capacite=0;
        id_site=0;      
    }

    //constructeur surchargé
    public Salle(int id,String nom,int capacite, int id_site) {
        this.id = id;
        this.nom = nom;
        this.capacite = capacite;
        this.id_site = id_site;
    }
    
    /**
     *Afficher 
     */
    public void afficher(){
        System.out.println("Id:" + id);
        System.out.println("Nom:" + nom);
        System.out.println("Capacite:" + capacite);
        System.out.println("Id_site:" + id_site);
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
	public int getCapacite() {
		return capacite;
	}
	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}
	public int getId_site() {
		return id_site;
	}
	public void setId_site(int id_site) {
		this.id_site = id_site;
	}
    
    
    
}
