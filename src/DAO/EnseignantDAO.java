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
public class EnseignantDAO extends DAO<Enseignant>{
    
    public EnseignantDAO() throws ClassNotFoundException, SQLException{
        super();
    }

    public ArrayList<Enseignant> all() {
        ArrayList<Enseignant> all= new ArrayList<>();
        
        try {         
            Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);          
            ResultSet rs1=stmt.executeQuery("SELECT * FROM enseignant");           
            while(rs1.next()){
                int id=rs1.getInt("id_utilisateur");  
                int id_cours=rs1.getInt("id_cours");
                
                Enseignant enseign = new Enseignant();//Instancier la classe puis l'ajouter Ã  l'Array de toutes les classes
                enseign = this.find(id_cours);
                
                all.add(enseign);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EnseignantDAO.class.getName()).log(Level.SEVERE, null, ex); //Logger.getLogger(ClasseDAO.class.getName())  <= ClasseDA0, pas bulletinDAO (pk?)
        }
        
        return all;
    }

  //Retourne l'enseignant dont l'ID correspond à l'ID DU COURS!
    @Override
    public Enseignant find(int id_cours) { 
        Enseignant enseign = new Enseignant();
        //Trimestre trimestre=new Trimestre();
        //Inscription inscription=new Inscription();
        
        
        try {
            Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);            
            rs=stmt.executeQuery("SELECT * FROM enseignant WHERE id_cours="+id_cours);
            
            if(rs.next()){
                int id_utilisateur=rs.getInt("id_utilisateur");
                //int id_trimestre=rs.getInt("id_trimestre");
                //int id_inscription=rs.getInt("id_inscription");
                
                //Instancier un trimestre
                //TrimestreDAO trimestredao=new TrimestreDAO();
                //trimestre=trimestredao.find(id_trimestre);
                              
                //Instancier une inscription
                //InscriptionDAO inscriptiondao=new InscriptionDAO();
                //inscription=inscriptiondao.find(id_inscription);
                
                //Instancier le bulletin Ã  retourner
                enseign=new Enseignant(id_utilisateur,id_cours);
            }
            
            
            
        } catch (SQLException ex) {  //catch (SQLException | ClassNotFoundException ex)
            Logger.getLogger(EnseignantDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return enseign;
        
    }

    @Override
    public Enseignant create(Enseignant enseign) {
        Statement stmt;
        
        int id_utilisateur = enseign.getId_utilisateur();
        int id_cours = enseign.getId_cours();
       // int id_trimestre=bulletin.getTrimestre().getId_trimestre();
        
        try {
        	 System.out.println("Balise DAO/EnseignantDAO");
           // stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            stmt = con.createStatement();
            //PreparedStatement prepare=con.prepareStatement("INSERT INTO cours (id,nom) VALUES ("+id+","+nom+")");
            PreparedStatement prepare=con.prepareStatement("INSERT INTO enseignant (id_utilisateur,id_cours) VALUES (?,?)");
                   
            prepare.setInt(1,id_utilisateur);
            prepare.setInt(2, id_cours);
            
            prepare.executeUpdate();
            
            if(prepare!=null){
                System.out.println("Enseignant ajouté dans la base de données.");
                
                //recuperer l'id
                rs=stmt.executeQuery("SELECT id_utilisateur FROM enseignant WHERE id_utilisateur="+id_utilisateur); //+" AND id_inscription="+id_inscription
                if(rs.first()){
                    int id_utilisateur1=rs.getInt("id_utilisateur");                
                    enseign.setId(id_utilisateur1);
                }                
            }else{
                throw new SQLException();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CoursDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return enseign;
        
    }

    @Override
    public void delete(Enseignant enseign) {
        try {
            stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            rs=stmt.executeQuery("DELETE enseignant WHERE id_utilisateur="+enseign.getId_utilisateur());
            
            if(rs.first()){
                System.out.println("L'enseignant numéro "+enseign.getId_utilisateur()+enseign+"a été supprimé.");
            }
            else
                throw new SQLException();
        } catch (SQLException ex) {
            Logger.getLogger(EnseignantDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void deleteId(int id) {
        try {
        	System.out.println("suppression Enseignant ID");
        	//Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            //rs=stmt.executeQuery("DELETE FROM `cours` WHERE id=15");
            
        	 Statement stmt = con.createStatement();
             PreparedStatement prepare=con.prepareStatement("DELETE FROM `enseignant` WHERE id_utilisateur="+id);
             prepare.executeUpdate();
        	
            
            if(rs.first()){
                System.out.println("L'enseignant numéro "+id+"a été supprimé.");
            }
            else
                throw new SQLException();
        } catch (SQLException ex) {
            Logger.getLogger(EnseignantDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override //One ne modifie que l'ID utilisateur
    public Enseignant update(Enseignant enseign) {
        
        try {
            Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            rss=stmt.executeUpdate("UPDATE enseignant SET id_utilisateur='"+enseign.getId_utilisateur()+"' WHERE id= "+enseign.getId_utilisateur());
            
            if(rss!=0){
                enseign=this.find(enseign.getId_utilisateur());
                
            }
        } catch (SQLException ex) {
            System.out.println("Aucune ligne affectÃ©e");
        }
        
        return enseign;
    }
    
}
