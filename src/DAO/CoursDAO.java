package DAO;



import Modele.*;
import static DAO.Connexion.*;
import java.sql.*;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *Joue le role de classe intermédiaire entre la table bulletin de la BD et la classe Bulletin
 * G�re les requêtes

 */
public class CoursDAO extends DAO<Cours>{
    
    public CoursDAO() throws ClassNotFoundException, SQLException{
        super();
    }

    public ArrayList<Cours> all() {
        ArrayList<Cours> all= new ArrayList<>();
        
        try {         
            Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);          
            ResultSet rs1=stmt.executeQuery("SELECT * FROM cours");           
            while(rs1.next()){
                int id=rs1.getInt("id");                                
                
                Cours cours=new Cours();//Instancier la classe puis l'ajouter à l'Array de toutes les classes
                cours=this.find(id);
                
                all.add(cours);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CoursDAO.class.getName()).log(Level.SEVERE, null, ex); //Logger.getLogger(ClasseDAO.class.getName())  <= ClasseDA0, pas bulletinDAO (pk?)
        }
        
        return all;
    }

    
    @Override
    public Cours find(int id) {
        Cours cours=new Cours();
        //Trimestre trimestre=new Trimestre();
        //Inscription inscription=new Inscription();
        
        
        try {
            Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);            
            rs=stmt.executeQuery("SELECT * FROM cours WHERE id="+id);
            
            if(rs.next()){
                String nom=rs.getString("nom");
                //int id_trimestre=rs.getInt("id_trimestre");
                //int id_inscription=rs.getInt("id_inscription");
                
                //Instancier un trimestre
                //TrimestreDAO trimestredao=new TrimestreDAO();
                //trimestre=trimestredao.find(id_trimestre);
                              
                //Instancier une inscription
                //InscriptionDAO inscriptiondao=new InscriptionDAO();
                //inscription=inscriptiondao.find(id_inscription);
                
                //Instancier le bulletin à retourner
                cours=new Cours(id,nom);
            }
            
            
            
        } catch (SQLException ex) {  //catch (SQLException | ClassNotFoundException ex)
            Logger.getLogger(CoursDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cours;
        
    }

    @Override
    public Cours create(Cours cours) {
        Statement stmt;
        
        String nom = cours.getNom();
        int id = cours.getId();
       // int id_trimestre=bulletin.getTrimestre().getId_trimestre();
        
        try {
        	 System.out.println("Balise DAO/CoursDAO");
           // stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            stmt = con.createStatement();
            //PreparedStatement prepare=con.prepareStatement("INSERT INTO cours (id,nom) VALUES ("+id+","+nom+")");
            PreparedStatement prepare=con.prepareStatement("INSERT INTO cours (id,nom) VALUES (?,?)");
            
            
            prepare.setInt(1,id);
            prepare.setString(2, nom);
            
            prepare.executeUpdate();
            
            if(prepare!=null){
                System.out.println("Cours ajout� dans la base de donn�es.");
                
                //recuperer l'id
                rs=stmt.executeQuery("SELECT id FROM cours WHERE id="+id); //+" AND id_inscription="+id_inscription
                if(rs.first()){
                    int id1=rs.getInt("id");                
                    cours.setId(id1);
                }                
            }else{
                throw new SQLException();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CoursDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cours;
        
    }

    @Override
    public void delete(Cours cours) {
        try {
            stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            rs=stmt.executeQuery("DELETE cours WHERE id="+cours.getId());
            
            if(rs.first()){
                System.out.println("Le cours num�ro "+cours.getId()+cours+"a �t� supprim�.");
            }
            else
                throw new SQLException();
        } catch (SQLException ex) {
            Logger.getLogger(CoursDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override //One ne modifie que l'appréciation!!
    public Cours update(Cours cours) {
        
        try {
            Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            rss=stmt.executeUpdate("UPDATE cours SET nom='"+cours.getNom()+"' WHERE id= "+cours.getId());
            
            if(rss!=0){
                cours=this.find(cours.getId());
                
            }
        } catch (SQLException ex) {
            System.out.println("Aucune ligne affectée");
        }
        
        return cours;
    }
    
}
