package Modele;

import java.sql.ResultSet;
import java.sql.SQLException;


public class Etudiant {

	private int id_utilisateur; //clé primaire
    private int numero;
    private int id_groupe; //clé étrangère
    
    //Constructeur par default
    public Etudiant(){
        id_utilisateur=0;
        numero=0;
        id_groupe=0;      
    }

    //constructeur surchargé
    public Etudiant(int id_utilisateur,int numero, int id_groupe) {
        this.id_utilisateur = id_utilisateur;
        this.numero = numero;
        this.id_groupe = id_groupe;
    }
    
    /**
     *Afficher 
     */
    public void afficher(){
        System.out.println("Id_utilisateur:" + id_utilisateur);
        System.out.println("Numero:" + numero);
        System.out.println("Id_groupe:" + id_groupe);
    } 
    
    
    public int getId_utilisateur() {
		return id_utilisateur;
	}
	public void setId_utilisateur(int id_utilisateur) {
		this.id_utilisateur = id_utilisateur;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getId_groupe() {
		return id_groupe;
	}
	public void setId_groupe(int id_groupe) {
		this.id_groupe = id_groupe;
	}
    
    
}
