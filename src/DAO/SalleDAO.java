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
public class SalleDAO extends DAO<Salle>{
    
    public SalleDAO() throws ClassNotFoundException, SQLException{
        super();
    }

    public ArrayList<Salle> all() {
        ArrayList<Salle> all= new ArrayList<>();
        
        try {         
            Statement stmt=con.createStatement(); 
            //Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE); 
            ResultSet rs1=stmt.executeQuery("SELECT * FROM salle");           
            while(rs1.next()){
                int id=rs1.getInt("id");  
                String nom = rs1.getString("nom");
                int capacite = rs1.getInt("capacite");
                int id_site=rs1.getInt("id_site");
                
                Salle salle = new Salle();
                salle = this.find(id);
                
                all.add(salle);           
            }
            
        } catch (SQLException ex) {
        	System.out.println("SQL exception DAO/DalleDAO");
            Logger.getLogger(SalleDAO.class.getName()).log(Level.SEVERE, null, ex); //Logger.getLogger(ClasseDAO.class.getName())  <= ClasseDA0, pas bulletinDAO (pk?)
        }
        
        return all;
    }

  //Return la séance dont l'Id_seance correspond à l'Id
    @Override
    public Salle find(int id) { 
        Salle salle = new Salle();
       
        try {
            Statement stmt=con.createStatement();            
            rs=stmt.executeQuery("SELECT * FROM salle WHERE id="+id);
            
            if(rs.next()){
            	
            	 int id1=rs.getInt("id");  
            	 String nom = rs.getString("nom");
            	 int capacite = rs.getInt("capacite");
                 int id_site=rs.getInt("id_site");

               
                //Instancier la séance à return
                salle =new Salle(id1,nom,capacite,id_site);
            }
            
            
            
        } catch (SQLException ex) {  //catch (SQLException | ClassNotFoundException ex)
            Logger.getLogger(SalleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salle;
        
    }

    @Override
    public Salle create(Salle salle) {
        Statement stmt;
        
        int id = salle.getId();  
        String nom = salle.getNom();
        int capacite = salle.getCapacite();
        int id_site = salle.getId_site();

       // int id_trimestre=bulletin.getTrimestre().getId_trimestre();
        
        try {
        	 System.out.println("Balise DAO/SalleDAO");
        	 
            stmt = con.createStatement();
            PreparedStatement prepare=con.prepareStatement("INSERT INTO salle (id,nom,capacite,id_site) VALUES ("+id+","+nom+","+capacite+","+id_site+")");
            
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
                rs=stmt.executeQuery("SELECT id FROM salle WHERE id="+id); //+" AND id_inscription="+id_inscription
                if(rs.first()){
                    int id1=rs.getInt("id");                
                    salle.setId(id1);
                }                
            }else{
                throw new SQLException();
            }
            
        } catch (SQLException ex) {
        	System.out.println("SQLException DAO/SalleDAO");
            Logger.getLogger(SalleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salle;
        
    }

    @Override
    public void delete(Salle salle) {
        try {
            stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            rs=stmt.executeQuery("DELETE salle WHERE id="+salle.getId());
            
            if(rs.first()){
                System.out.println("la seance_salles numéro "+ salle.getId()+salle+"a été supprimé.");
            }
            else
                throw new SQLException();
        } catch (SQLException ex) {
        	System.out.println("Catch sql exception DAO/Seance_SallesDAO");
            Logger.getLogger(SalleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override //One ne modifie que l'ID utilisateur
    public Salle update(Salle salle) {
        
        try {
            Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            rss=stmt.executeUpdate("UPDATE salle SET id='"+salle.getId()+"' WHERE id= "+salle.getId());
            
            if(rss!=0){
                salle=this.find(salle.getId());     
            }
        } 
        catch (SQLException ex) 
        {System.out.println("Aucune ligne affectée");}       
        return salle;
    }  
}