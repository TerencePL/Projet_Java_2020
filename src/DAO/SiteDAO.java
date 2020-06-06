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
public class SiteDAO extends DAO<Site>{
    
    public SiteDAO() throws ClassNotFoundException, SQLException{
        super();
    }

    public ArrayList<Site> all() {
        ArrayList<Site> all= new ArrayList<>();
        
        try {         
            Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);          
            ResultSet rs1=stmt.executeQuery("SELECT * FROM site");           
            while(rs1.next()){
                int id=rs1.getInt("id");  
                int nom=rs1.getInt("nom");
                
                Site site = new Site();
                site = this.find(id);
                
                all.add(site);           
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SiteDAO.class.getName()).log(Level.SEVERE, null, ex); //Logger.getLogger(ClasseDAO.class.getName())  <= ClasseDA0, pas bulletinDAO (pk?)
        }
        
        return all;
    }

  //Return la séance dont l'Id_seance correspond à l'Id
    @Override
    public Site find(int id) { 
        Site site = new Site();
       
        try {
            Statement stmt=con.createStatement();            
            rs=stmt.executeQuery("SELECT * FROM site WHERE id="+id);
            
            if(rs.next()){
            	
            	 int id1=rs.getInt("id");  
                 String nom =rs.getString("nom");

               
                //Instancier la séance à return
                site =new Site(id1,nom);
            }
            
            
            
        } catch (SQLException ex) {  //catch (SQLException | ClassNotFoundException ex)
            Logger.getLogger(SiteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return site;
        
    }

    @Override
    public Site create(Site site) {
        Statement stmt;
        
        int id = site.getId();  
        String nom = site.getNom();

       // int id_trimestre=bulletin.getTrimestre().getId_trimestre();
        
        try {
        	 System.out.println("Balise DAO/SiteDAO");
        	 
            stmt = con.createStatement();
            PreparedStatement prepare=con.prepareStatement("INSERT INTO site (id,nom) VALUES ("+id+","+nom+")");
            
            /*
            prepare.setInt(1,id);
            prepare.setString(2,email);
            */
            
            prepare.executeUpdate();
            
            if(prepare!=null){
                System.out.println("Seance_salle ajouté dans la base de données.");
                
                //recuperer l'id auto-incrémenté par la BDD
                rs=stmt.executeQuery("SELECT id FROM site WHERE id="+id); //+" AND id_inscription="+id_inscription
                if(rs.first()){
                    int id1=rs.getInt("id");                
                    site.setId(id1);
                }                
            }else{
                throw new SQLException();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SiteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return site;
        
    }

    @Override
    public void delete(Site site) {
        try {
            stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            rs=stmt.executeQuery("DELETE site WHERE id="+site.getId());
            
            if(rs.first()){
                System.out.println("le site numéro "+ site.getId()+site+"a été supprimé.");
            }
            else
                throw new SQLException();
        } catch (SQLException ex) {
        	System.out.println("Catch sql exception DAO/SitesDAO");
            Logger.getLogger(SiteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override //One ne modifie que l'ID utilisateur
    public Site update(Site site) {
        
        try {
            Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            rss=stmt.executeUpdate("UPDATE site SET id='"+site.getId()+"' WHERE id= "+site.getId());
            
            if(rss!=0){
               site=this.find(site.getId());     
            }
        } 
        catch (SQLException ex) 
        {System.out.println("Aucune ligne affectée");}       
        return  site;
    }  
}
