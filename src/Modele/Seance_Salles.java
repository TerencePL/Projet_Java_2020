package Modele;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Seance_Salles {
    private int id_seance; 
    private int id_salle;
    
  //Constructeur par default
    public Seance_Salles(){
        id_seance = 0;
        id_salle = 0;     
    }

    //constructeur surchargé
    public Seance_Salles(int id_seance,int id_salle) {
        this.id_seance = id_seance;
        this.id_salle = id_salle;
    }
    
    /**
     *Afficher 
     */
    public void afficher(){
        System.out.println("Id_seance:" + id_seance);
        System.out.println("Id_salle:" + id_salle);
    } 
    
	public int getId_seance() {
		return id_seance;
	}
	public void setId_seance(int id_seance) {
		this.id_seance = id_seance;
	}
	public int getId_salle() {
		return id_salle;
	}
	public void setId_salle(int id_salle) {
		this.id_salle = id_salle;
	} 
    
    
    
}
