package DAO;

import Modele.*;
import static DAO.Connexion.*;
import java.sql.*;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *Joue le role de classe intermÃ©diaire entre la table bulletin de la BD et la classe Bulletin
 * Gère les requÃªtes

 */
public class Seance_SallesDAO extends DAO<Seance_Salles>{
    
    public Seance_SallesDAO() throws ClassNotFoundException, SQLException{
        super();
    }

    public ArrayList<Seance_Salles> all() {
        ArrayList<Seance_Salles> all= new ArrayList<>();
        
        try {         
            Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);          
            ResultSet rs1=stmt.executeQuery("SELECT * FROM seance_salles");           
            while(rs1.next()){
                int id_seance=rs1.getInt("id_seance");  
                int id_salle=rs1.getInt("id_salle");
                
                Seance_Salles seance_salles = new Seance_Salles();
                seance_salles = this.find(id_seance);
                
                all.add(seance_salles);           
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Seance_SallesDAO.class.getName()).log(Level.SEVERE, null, ex); //Logger.getLogger(ClasseDAO.class.getName())  <= ClasseDA0, pas bulletinDAO (pk?)
        }
        
        return all;
    }

  //Return la séance dont l'Id_seance correspond à l'Id
    @Override
    public Seance_Salles find(int id) { 
        Seance_Salles seance_salles = new Seance_Salles();
       
        try {
            Statement stmt=con.createStatement();            
            rs=stmt.executeQuery("SELECT * FROM seance_salles WHERE id_seance="+id);
            
            if(rs.next()){
            	
            	 int id_seance=rs.getInt("id_seance");  
                 int id_salle=rs.getInt("id_salle");

               
                //Instancier la séance à return
                seance_salles =new Seance_Salles(id_seance,id_salle);
            }
            
            
            
        } catch (SQLException ex) {  //catch (SQLException | ClassNotFoundException ex)
            Logger.getLogger(Seance_SallesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return seance_salles;
        
    }

    @Override
    public Seance_Salles create(Seance_Salles seance_salle) {
        Statement stmt;
        
        int id_seance = seance_salle.getId_seance();  
        int id_salle = seance_salle.getId_salle();

       // int id_trimestre=bulletin.getTrimestre().getId_trimestre();
        
        try {
        	 System.out.println("Balise DAO/Seance_SallesDAO");
        	 
            stmt = con.createStatement();
            PreparedStatement prepare=con.prepareStatement("INSERT INTO seance_salles (id_seance,id_salle) VALUES ("+id_seance+","+id_salle+")");
            
            /*
            prepare.setInt(1,id);
            prepare.setString(2,email);
            prepare.setString(3,passwd);
            prepare.setString(4,nom);
            prepare.setString(5,prenom);
            prepare.setInt(6, droit);
            */
            
            prepare.executeUpdate();
            
            if(prepare!=null){
                System.out.println("Seance_salle ajouté dans la base de données.");
                
                //recuperer l'id auto-incrémenté par la BDD
                rs=stmt.executeQuery("SELECT id FROM seance_salles WHERE id_seance='"+id_seance+"'"); //+" AND id_inscription="+id_inscription
                if(rs.first()){
                    int id1=rs.getInt("id_seance");                
                    seance_salle.setId_seance(id1);
                }                
            }else{
                throw new SQLException();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Seance_SallesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return seance_salle;
        
    }

    @Override
    public void delete(Seance_Salles seance_salle) {
        try {
            stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            rs=stmt.executeQuery("DELETE seance_salles WHERE id_seance="+seance_salle.getId_seance());
            
            if(rs.first()){
                System.out.println("la seance_salles numéro "+ seance_salle.getId_seance()+seance_salle+"a été supprimé.");
            }
            else
                throw new SQLException();
        } catch (SQLException ex) {
        	System.out.println("Catch sql exception DAO/Seance_SallesDAO");
            Logger.getLogger(Seance_SallesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override //One ne modifie que l'ID utilisateur
    public Seance_Salles update(Seance_Salles seance_salle) {
        
        try {
            Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            rss=stmt.executeUpdate("UPDATE seance_salles SET id='"+seance_salle.getId_seance()+"' WHERE id= "+seance_salle.getId_seance());
            
            if(rss!=0){
                seance_salle=this.find(seance_salle.getId_seance());     
            }
        } 
        catch (SQLException ex) 
        {System.out.println("Aucune ligne affectée");}       
        return  seance_salle;
    }  
}