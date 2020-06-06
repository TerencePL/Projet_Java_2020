package Modele;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Seance_Groupes {
    private int id_seance; 
    private int id_groupe;
    
  //Constructeur par default
    public Seance_Groupes(){
        id_seance = 0;
        id_groupe = 0;     
    }

    //constructeur surchargé
    public Seance_Groupes(int id_seance, int id_groupe) {
        this.id_seance = id_seance;
        this.id_groupe = id_groupe;
    }
    
    /**
     *Afficher dans le console
     */
    public void afficher(){
        System.out.println("Id_seance:" + id_seance);
        System.out.println("Id_groupe:" + id_groupe);
    } 
    
	public int getId_seance() {
		return id_seance;
	}
	public void setId_seance(int id_seance) {
		this.id_seance = id_seance;
	}
	public int getId_groupe() {
		return id_groupe;
	}
	public void setId_groupe(int id_groupe) {
		this.id_groupe = id_groupe;
	} 
    
    
}
