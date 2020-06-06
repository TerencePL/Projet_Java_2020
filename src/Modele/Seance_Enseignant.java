package Modele;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Seance_Enseignant {
    private int id_seance; 
    private int id_enseignant;
    
    //Constructeur par default
    public Seance_Enseignant(){
        id_seance = 0;
        id_enseignant = 0;     
    }

    //constructeur 
    public Seance_Enseignant(int id_enseignant,int id_seance) {
        this.id_enseignant = id_enseignant;
        this.id_seance = id_seance;
    }
    
    /**
     *Afficher dans le console
     */
    public void afficher(){
        System.out.println("Id_enseignant:" + id_enseignant);
        System.out.println("Id_seance:" + id_seance);
    } 
    
    
	public int getId_seance() {
		return id_seance;
	}
	public void setId_seance(int id_seance) {
		this.id_seance = id_seance;
	}
	public int getId_enseignant() {
		return id_enseignant;
	}
	public void setId_enseignant(int id_enseignant) {
		this.id_enseignant = id_enseignant;
	} 
    
    
}
