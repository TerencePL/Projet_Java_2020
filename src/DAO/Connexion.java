package DAO;

//import Vue.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
*Classe permettant de se connecter ‡† la BD
*/
public class Connexion {
  private static Connection con=null;
  public static Statement stmt=null;
  public static ResultSet rs=null;
  public static int rss=0; //Permet de dÈtecter si une ligne d'une table a √©t√© mise √† jour ou pas
  
  private static String serveur;
  private static String bdd="javabdd";
  private static String username="root";
  private static String password="";  
     
  /**
   **Cree une connection avec un objet de la classe Connection
   */
  static public Connection Connexion(){
                    
      
          try {  
        	  
        	  System.out.println("Balise DAO/connexion");
        	  
              //Class.forName("com.mysql.jdbc.Driver");
        	  Class.forName("com.mysql.jdbc.Driver");
        	  
              //con=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+bdd+"?autoReconnect=true&useSSL=false", username, password);       	  
             // con=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+"javabdd"+"?autoReconnect=true&useSSL=false","root","");
              
        	  String urlDatabase="jdbc:mysql://localhost:3306/javabdd";
        	  
               //cr√©ation d'une connexion JDBC √† la base 
               con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javabdd", "root", "");
               stmt = con.createStatement();
              
              if(con!=null){
              	
                  System.out.println("Connexion ‡† la base "+bdd);                     
              } 
              else{
              	
                  throw new ClassNotFoundException();
              }
              
          } catch (SQLException e) {
              System.out.println("Connection fail");
          } catch (ClassNotFoundException ex) {
          Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
      }
          
          finally{
          if(con!=null){
              try{
                  //Fermer la connexion
                  con.close();
              }
              catch(SQLException e){
                  
              }
              
          }
      }
  return con;
                        
      }   
  
  //Getter setters
  public static Connection getCon() {
      return con;
  }

  public static void setCon(Connection con) {
      Connexion.con = con;
  }

  public static String getServeur() {
      return serveur;
  }

  public static void setServeur(String serveur) {
      Connexion.serveur = serveur;
  }

  public static String getBdd() {
      return bdd;
  }

  public static void setBdd(String bdd) {
      Connexion.bdd = bdd;
  }

  public static String getUsername() {
      return username;
  }

  public static void setUsername(String username) {
      Connexion.username = username;
  }

  public static String getPassword() {
      return password;
  }

  public static void setPassword(String password) {
      Connexion.password = password;
  }  

  public static Statement getStmt() {
      return stmt;
  }

  public static void setStmt(Statement stmt) {
      Connexion.stmt = stmt;
  }

  public static ResultSet getRs() {
      return rs;
  }

  public static void setRs(ResultSet rs) {
      Connexion.rs = rs;
  }

  public static int getRss() {
      return rss;
  }

  public static void setRss(int rss) {
      Connexion.rss = rss;
  }
  
  
}