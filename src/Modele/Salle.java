package Modele;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Salle {
    private int id; //cl� primaire
    private String nom;
    private int capacite;
    private int id_site; //cl� �trang�re
}
