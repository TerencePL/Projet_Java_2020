package Modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

public class Seance {
    private int id; //clé primaire
    private int semaine;
    private Date date;
    private int heure_debut;
    private int heure_fin;
    private int etat;
    private int id_cours; //clé étrangère
    private int id_type; //clé étrangère
    
  //Constructeur par default
    public Seance(){
        id = 0;
        semaine = 0;
        date = new Date(01/01/2020);
        heure_debut = 0;
        heure_fin = 0;
        etat=0;
        id_cours = 0;     
        id_type = 0;   
    }

    //constructeur surchargé
    public Seance(int id,int semaine,Date date,int heure_debut, int heure_fin,int etat,int id_cours,int id_type) {
    	this.id = id;
    	this.semaine = semaine;
    	this.date = date;
    	this.heure_debut = heure_debut;
    	this.heure_fin = heure_fin;
    	this.etat= heure_fin;
    	this.id_cours = id_cours;     
    	this.id_type = id_type;   
    }
    
    /**
     *Afficher 
     */
    public void afficher(){
        System.out.println("Id:" + id);
        System.out.println("Semaine:" + semaine);
        System.out.println("Date:" + date);
        System.out.println("Heure debut:" + heure_debut);
        System.out.println("Heure_Fin:" + heure_fin);
        System.out.println("Etat:" + etat);
        System.out.println("Id_cours:" + id_cours);
        System.out.println("Id_type:" + id_type);
    } 
    
    
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSemaine() {
		return semaine;
	}
	public void setSemaine(int semaine) {
		this.semaine = semaine;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getHeure_debut() {
		return heure_debut;
	}
	public void setHeure_debut(int heure_debut) {
		this.heure_debut = heure_debut;
	}
	public int getHeure_fin() {
		return heure_fin;
	}
	public void setHeure_fin(int heure_fin) {
		this.heure_fin = heure_fin;
	}
	public int getEtat() {
		return etat;
	}
	public void setEtat(int etat) {
		this.etat = etat;
	}
	public int getId_cours() {
		return id_cours;
	}
	public void setId_cours(int id_cours) {
		this.id_cours = id_cours;
	}
	public int getId_type() {
		return id_type;
	}
	public void setId_type(int id_type) {
		this.id_type = id_type;
	}
    
    
    
  
}
