package Modele;

import java.sql.ResultSet;
import java.sql.SQLException;


public class Utilisateur {
    private int id; //clé primaire
    private String email;
    private String passwd;
    private String nom;
    private String prenom;
    private int droit;
    
    //Constructeur par default
    public Utilisateur(){
        id = 0;
        email = "";
        passwd = "";
        nom = "";
        prenom = "";
        droit =0;
    }

    //constructeur 
    public Utilisateur(int id,String email,String passwd,String nom,String prenom,int droit) {
        this.id = id;
        this.email = email;
        this.passwd = passwd;
        this.nom = nom;
        this.prenom = prenom;
        this.droit = droit;
    }
    
    /**
     *Afficher dans le console 
     */
    public void afficher(){
        System.out.println("Id:" + id);
        System.out.println("Email:" + email);
        System.out.println("Password:" + passwd);
        System.out.println("Nom:" + nom);
        System.out.println("Prenom:" + prenom);
        System.out.println("Droit:" + droit);
    } 
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getDroit() {
		return droit;
	}
	public void setDroit(int droit) {
		this.droit = droit;
	} 
    
    
}
