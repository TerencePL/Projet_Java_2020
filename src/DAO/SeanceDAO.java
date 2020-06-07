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
public class SeanceDAO extends DAO<Seance>{
    
    public SeanceDAO() throws ClassNotFoundException, SQLException{
        super();
    }

    public ArrayList<Seance> all() {
        ArrayList<Seance> all= new ArrayList<>();
        
        try {         
            Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);          
            ResultSet rs1=stmt.executeQuery("SELECT * FROM seance");           
            while(rs1.next()){
                int id=rs1.getInt("id");  
                int semaine=rs1.getInt("semaine");
                Date date=rs1.getDate("date");
                int heure_debut=rs1.getInt("heure_debut");
                int heure_fin = rs1.getInt("heure_fin");
                int etat = rs1.getInt("etat");
                int id_cours = rs1.getInt("id_cours");
                int id_type = rs1.getInt("id_type");
                
                
                Seance seance = new Seance();
                seance = this.find(id);
                
                all.add(seance);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SeanceDAO.class.getName()).log(Level.SEVERE, null, ex); //Logger.getLogger(ClasseDAO.class.getName())  <= ClasseDA0, pas bulletinDAO (pk?)
        }
        
        return all;
    }

  //Return la séance dont l'Id correspond à l'Id
    @Override
    public Seance find(int id) { 
        Seance seance = new Seance();
       
        try {
            Statement stmt=con.createStatement();            
            rs=stmt.executeQuery("SELECT * FROM seance WHERE id="+id);
            
            if(rs.next()){
            	
            	 int id_seance=rs.getInt("id");  
                 int semaine=rs.getInt("semaine");
                 Date date=rs.getDate("date");
                 int heure_debut=rs.getInt("heure_debut");
                 int heure_fin = rs.getInt("heure_fin");
                 int etat = rs.getInt("etat");
                 int id_cours = rs.getInt("id_cours");
                 int id_type = rs.getInt("id_type");
               
                //Instancier la séance à return
                seance =new Seance(id_seance,semaine,date,heure_debut,heure_fin,etat,id_cours,id_type);
            }
            
            
            
        } catch (SQLException ex) {  //catch (SQLException | ClassNotFoundException ex)
            Logger.getLogger(SeanceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return seance;
        
    }
    
	public Seance findId_Cours(int id) {
		Seance seance = new Seance();
	       
        try {
            Statement stmt=con.createStatement();            
            rs=stmt.executeQuery("SELECT * FROM seance WHERE id_cours="+id);
            
            if(rs.next()){
            	
            	 int id_seance=rs.getInt("id");  
                 int semaine=rs.getInt("semaine");
                 Date date=rs.getDate("date");
                 int heure_debut=rs.getInt("heure_debut");
                 int heure_fin = rs.getInt("heure_fin");
                 int etat = rs.getInt("etat");
                 int id_cours = rs.getInt("id_cours");
                 int id_type = rs.getInt("id_type");
               
                //Instancier la séance à return
                seance =new Seance(id_seance,semaine,date,heure_debut,heure_fin,etat,id_cours,id_type);
            }
            
            
            
        } catch (SQLException ex) {  //catch (SQLException | ClassNotFoundException ex)
            Logger.getLogger(SeanceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return seance;
	}

    @Override
    public Seance create(Seance seance) {
        Statement stmt;
        
        int id = seance.getId();  
        int semaine = seance.getSemaine();
        Date date = seance.getDate();
        int heure_debut= seance.getHeure_debut();
        int heure_fin = seance.getHeure_fin();
        int etat = seance.getEtat();
        int id_cours = seance.getId_cours();
        int id_type = seance.getId_type();
       // int id_trimestre=bulletin.getTrimestre().getId_trimestre();
        
        try {
        	 System.out.println("Balise DAO/SeanceDAO");
        	 
            stmt = con.createStatement();
            PreparedStatement prepare=con.prepareStatement("INSERT INTO seance (id,semaine,date,heure_debut,heure_fin,etat,id_cours,id_type) VALUES ('"+id+"','"+semaine+"','"+date+"','"+heure_debut+"','"+heure_fin+"','"+etat+"','"+id_cours+"','"+id_type+"')");
            
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
                System.out.println("S&ance ajouté dans la base de données.");
                
                //recuperer l'id auto-incrémenté par la BDD
                rs=stmt.executeQuery("SELECT id FROM seance WHERE id_cours='"+id+"' AND date='"+date+"'"); //+" AND id_inscription="+id_inscription
                if(rs.first()){
                    int id1=rs.getInt("id");  
                    System.out.println("!!!!!!!!!!!!id_seance: "+id1);
                    seance.setId(id1);
                }                
            }else{
                throw new SQLException();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SeanceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return seance;
        
    }

    @Override
    public void delete(Seance seance) {
        try {
            stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            rs=stmt.executeQuery("DELETE seance WHERE id="+seance.getId());
            
            if(rs.first()){
                System.out.println("L'utilisateur numéro "+ seance.getId()+seance+"a été supprimé.");
            }
            else
                throw new SQLException();
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override //One ne modifie que l'ID utilisateur
    public Seance update(Seance seance) {
        
        try {
            Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            rss=stmt.executeUpdate("UPDATE seance SET id='"+seance.getId()+"' WHERE id= "+seance.getId());
            
            if(rss!=0){
                seance=this.find(seance.getId());
                
            }
        } 
        catch (SQLException ex) 
        {System.out.println("Aucune ligne affectée");}
        
        return  seance;
    }


    
}

