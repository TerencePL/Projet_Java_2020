package DAO;

import Modele.*;
import static DAO.Connexion.*;
import java.sql.*;
import java.util.ArrayList;


/**
 *Interface DAO permettant de mapper correctement les tables de la BD avec les classes 
 * @param <T>
 */

public abstract class DAO<T>{
    
    protected static Connection con=null;
     
    /**
     * Cree une connection 
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public DAO() throws ClassNotFoundException, SQLException{
        try{
        	System.out.println("test");
            Class.forName("com.mysql.jdbc.Driver");
            //con=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+Connexion.getBdd()+"?autoReconnect=true&useSSL=false", Connexion.getUsername(), Connexion.getPassword());
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+"javabdd"+"?autoReconnect=true&useSSL=false","root", "");
            
            if(con==null){
                throw new ClassNotFoundException();          
            }
        }
        catch(ClassNotFoundException | SQLException e){
            System.out.println("Probl�me de connexion.");
            
        }
}
    
    
    /**
     * Retourne toutes les colonnes
     * @return
     */
    public abstract ArrayList<T> all();
    
    /**
     * Recup une colonne via l'id
     * @param id id
     * @return
     */
    public abstract T find(int id);
    
    /**
     * Créer une entrée à une bdd par rapport à l'objet
     * @param obj objet de n'importe quel type
     * @return
     */
    public abstract T create(T obj);
    
    /**
     * Supprimme une ligne d'une table via l'objet en param
     * @param obj objet de n'importe quel type
     */
    public abstract void delete(T obj);
    
    /**
     *
     * @param obj objet de n'importe quel type
     * @return
     */
    public abstract T update(T obj);
}