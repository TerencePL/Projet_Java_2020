package Modele;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Salle {
    private int id; //clé primaire
    private String nom;
    private int capacite;
    private int id_site; //clé étrangère
}
