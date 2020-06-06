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
public class UtilisateurDAO extends DAO<Utilisateur>{
    
    public UtilisateurDAO() throws ClassNotFoundException, SQLException{
        super();
    }

    public ArrayList<Utilisateur> all() {
        ArrayList<Utilisateur> all= new ArrayList<>();
        
        try {         
            Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);          
            ResultSet rs1=stmt.executeQuery("SELECT * FROM utilisateur");           
            while(rs1.next()){
                int id=rs1.getInt("id");  
                String nom=rs1.getString("nom");
                String prenom = rs1.getString("prenom");
                
                Utilisateur util = new Utilisateur();//Instancier la classe puis l'ajouter Ã  l'Array de toutes les classes
                util = this.find(id);
                
                all.add(util);
                
            }
            
        } catch (SQLException ex) 
        {
        	System.out.print(ex);
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex); //Logger.getLogger(ClasseDAO.class.getName())  <= ClasseDA0, pas bulletinDAO (pk?)
        }
        
        return all;
    }

  //Retourne l'enseignant dont l'ID correspond à l'ID DU COURS!
    @Override
    public Utilisateur find(int id) { 
        Utilisateur util = new Utilisateur();
        //Trimestre trimestre=new Trimestre();
        //Inscription inscription=new Inscription();
        
        
        try {
            Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);            
            rs=stmt.executeQuery("SELECT * FROM utilisateur WHERE id="+id);
            
            if(rs.next()){
                int id1=rs.getInt("id");
                String email=rs.getString("email");
                String passwd = rs.getString("email");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                int droit = rs.getInt("droit");
                
                //int id_trimestre=rs.getInt("id_trimestre");
                //int id_inscription=rs.getInt("id_inscription");
                
                //Instancier un trimestre
                //TrimestreDAO trimestredao=new TrimestreDAO();
                //trimestre=trimestredao.find(id_trimestre);
                              
                //Instancier une inscription
                //InscriptionDAO inscriptiondao=new InscriptionDAO();
                //inscription=inscriptiondao.find(id_inscription);
                
                //Instancier le bulletin Ã  retourner
                util =new Utilisateur(id1,email,passwd,nom,prenom,droit);
            }
            
            
            
        } catch (SQLException ex) {  //catch (SQLException | ClassNotFoundException ex)
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return util;
        
    }

    @Override
    public Utilisateur create(Utilisateur util) {
        Statement stmt;
        
        int id = util.getId();
        String email= util.getEmail();
        String passwd = util.getPasswd();
        String nom = util.getNom();
        String prenom = util.getPrenom();
        int droit = util.getDroit();
       // int id_trimestre=bulletin.getTrimestre().getId_trimestre();
        
        try {
        	 System.out.println("Balise DAO/UtilisateurDAO");
           // stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            stmt = con.createStatement();
            //PreparedStatement prepare=con.prepareStatement("INSERT INTO cours (id,nom) VALUES ("+id+","+nom+")");
            PreparedStatement prepare=con.prepareStatement("INSERT INTO utilisateur (id,email,passwd,nom,prenom,droit) VALUES (?,?,?,?,?,?)");
                   
            prepare.setInt(1,id);
            prepare.setString(2,email);
            prepare.setString(3,passwd);
            prepare.setString(4,nom);
            prepare.setString(5,prenom);
            prepare.setInt(6, droit);
            
            prepare.executeUpdate();
            
            if(prepare!=null){
                System.out.println("Utilisateurs ajouté dans la base de données.");
                
                //recuperer l'id auto-incrémenté par la BDD
                rs=stmt.executeQuery("SELECT id FROM utilisateur WHERE id="+id); //+" AND id_inscription="+id_inscription
                if(rs.first()){
                    int id1=rs.getInt("id");                
                    util.setId(id1);
                }                
            }else{
                throw new SQLException();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return util;
        
    }

    @Override
    public void delete(Utilisateur util) {
        try {
            stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            rs=stmt.executeQuery("DELETE utilisateur WHERE id="+util.getId());
            
            if(rs.first()){
                System.out.println("L'utilisateur numéro "+ util.getId()+util+"a été supprimé.");
            }
            else
                throw new SQLException();
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override //One ne modifie que l'ID utilisateur
    public Utilisateur update(Utilisateur util) {
        
        try {
            Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            rss=stmt.executeUpdate("UPDATE utilisateur SET id='"+util.getId()+"' WHERE id= "+util.getId());
            
            if(rss!=0){
                util=this.find(util.getId());
                
            }
        } catch (SQLException ex) {
            System.out.println("Aucune ligne affectée");
        }
        
        return util;
    }
    
}
