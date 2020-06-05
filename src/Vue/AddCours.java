package Vue;

import DAO.*;
import Modele.*;

//import static Vue.Classes.modelClass;
import static Vue.CoursVue.modelCours;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AddCours {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		createActionPerformed();
	}

    //Ajout d'une classe
    private static void createActionPerformed() {//GEN-FIRST:event_createActionPerformed
        try {
            // TODO add your handling code here:
            
            Cours cours=new Cours();
            CoursDAO coursDAO=new CoursDAO();
            
            //AnneeScolaire annee=new AnneeScolaire();           
            //Ecole ecole=new Ecole();
            //Niveau niveau=new Niveau();
                       
            int id=0;  
            
            //On récupère les champs
            //String nom=name.getText();
            String nom = "testCours"; 
               
            //On convertit l'annee choisie (type object) en String puis en int
            //int id_annee=Integer.parseInt((String)year.getSelectedItem());
            
            //ON instancie un objet année Ã  partir de son id en le cherchant dans l'arraylist
            //annee=Classes.findYear(id_annee);
            
            
            //String nom_ecole="ECE Paris";
            //ecole=new Ecole(1,nom_ecole);
       
            //On instancie un niveau en le cherchant dans l'arraylist rÃ©cupÃ©rÃ© depuis la bdd
            //String nom_niveau=(String)level.getSelectedItem();
            //niveau=Classes.findLevel(nom_niveau);
                           
            //Instancier la classe puis l'ajouter dans la bdd
            cours=new Cours(id,nom);
            cours=coursDAO.create(cours);
            
            //L'afficher dans le tableau
            Object []cours1= {cours.getId(),cours.getNom()};
            modelCours.insertRow(modelCours.getRowCount(), cours1);
            
            //mettre à  jour l'arraylist de classes
            CoursVue.cours1=CoursVue.coursDAO.all();
            
            
            //CrÃ©er aussi 3 trimestres pour l'annÃ©e choisie
            
            //Message de confirmation
            System.out.println("La classe "+cours.getNom()+" a été ajoutée.");
            //JOptionPane.showMessageDialog(rootPane, "La classe "+cours.getNom()+" a été ajoutée.");

            //dispose();
        
            
            
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AddCours.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }//GEN-LAST:event_createActionPerformed
}
