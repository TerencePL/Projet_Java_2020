package Modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

public class Seance {
    private int id; //clé primaire
    private int semaine;
    private Date date;
    private Date heure_debut;
    private Date heure_fin;
    private int etat;
    private int id_cours; //clé étrangère
    private int id_type; //clé étrangère
}
