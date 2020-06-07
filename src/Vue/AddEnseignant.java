package Vue;

import DAO.*;
import Modele.*;

//import static Vue.Classes.modelClass;
import static Vue.ListeEnseignant.modelListeEnseignant;

import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AddEnseignant extends javax.swing.JFrame{
	
	
	public AddEnseignant() {
		initComponents();	
	}
	
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField Nom;
    private javax.swing.JTextField IdEnseignant;
    private javax.swing.JTextField Prenom;
    private javax.swing.JTextField IdCours;
    private javax.swing.JTextField Mail;
    private javax.swing.JTextField Password;
    private javax.swing.JTextField Droit;
    private javax.swing.JButton quitter;
    private javax.swing.JButton Valider;   
    
	private void initComponents() {
		
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		
        jLabel1 = new javax.swing.JLabel();
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("Ajouter un Enseignant");
		
		Nom = new javax.swing.JTextField();
        Nom.setText("Nom");
        
        Prenom = new javax.swing.JTextField();
        Prenom.setText("Prenom");  
        
        Mail = new javax.swing.JTextField();
        Mail.setText("Mail"); 
        
        Password = new javax.swing.JTextField();
        Password.setText("Password"); 

        
        IdCours = new javax.swing.JTextField();
        IdCours.setText("Id du cours"); 
        
        Droit = new javax.swing.JTextField();
        Droit.setText("Droits"); 
	
		Valider = new javax.swing.JButton();
		Valider.setText("Valider");
		
		quitter = new javax.swing.JButton();
		quitter.setText("Quitter");
				
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
            .addGap(560, 560, 560)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Nom, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(Prenom, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(Mail, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(IdCours, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(Droit, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(Valider, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(quitter, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1)))
            .addGroup(layout.createSequentialGroup()
            .addGap(38, 38, 38)))
            .addContainerGap(587, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()             
                .addComponent(jLabel1)
                .addGap(50, 50, 50)
                .addComponent(Nom, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(Prenom, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(Mail, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(IdCours, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(Droit, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)  
                .addComponent(Valider, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(quitter, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(142, Short.MAX_VALUE))
        );

        pack();
		
		
		
        quitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {quitterActionPerformed(evt);}
        });
        
        Valider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {validerActionPerformed(evt);}
        });
		 
		 
	}
	
	
    //Quitter
    private void quitterActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        dispose();//Ferme le menu
    }
    
    private void validerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createActionPerformed
        try {
            // TODO add your handling code here:
       
            Enseignant enseign = new Enseignant();
            EnseignantDAO enseignDAO = new EnseignantDAO();
            
            Utilisateur util = new Utilisateur();
            UtilisateurDAO utilDAO = new UtilisateurDAO();
                     
            int id=0;  
            
            //On récupère les champs
            String nom = Nom.getText();
            String prenom= Prenom.getText();
            String mail = Mail.getText();
            String password = Password.getText();
         
           // int id_enseignant = Integer.parseInt(IdEnseignant.getText());
            int id_cours = Integer.parseInt(IdCours.getText());
            int droit = Integer.parseInt(Droit.getText());
            
            util = new Utilisateur(id,mail,password,nom,prenom,droit);
            util= utilDAO.create(util);
            int id_enseign = util.getId();
                           
            //Instancier la classe puis l'ajouter dans la bdd
            enseign=new Enseignant(id_enseign,id_cours);
            enseign= enseignDAO.create(enseign); 
            
            
         
            
            
            
            //L'afficher dans le tableau 
            Object []enseign1= {enseign.getId_utilisateur(),enseign.getId_cours()};
            modelListeEnseignant.insertRow(modelListeEnseignant.getRowCount(), enseign1);
            
            //mettre à  jour l'arraylist de classes
            ListeEnseignant.enseign1=ListeEnseignant.enseignDAO.all();
            
            
            //CrÃ©er aussi 3 trimestres pour l'année choisie
            
            //Message de confirmation
            System.out.println("Le cours"+enseign.getId_utilisateur()+" a été ajoutée.");
            //JOptionPane.showMessageDialog(rootPane, "La classe "+cours.getNom()+" a été ajoutée.");

            dispose();          
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AddEnseignant.class.getName()).log(Level.SEVERE, null, ex);
        }
               
        
    }//GEN-LAST:event_createActionPerformed
    
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
            modelListeEnseignant.insertRow(modelListeEnseignant.getRowCount(), cours1);
            
            //mettre à  jour l'arraylist de classes
            CoursVue.cours1=CoursVue.coursDAO.all();
            
            
            //CrÃ©er aussi 3 trimestres pour l'annÃ©e choisie
            
            //Message de confirmation
            System.out.println("La classe "+cours.getNom()+" a été ajoutée.");
            //JOptionPane.showMessageDialog(rootPane, "La classe "+cours.getNom()+" a été ajoutée.");

            //dispose();          
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AddEnseignant.class.getName()).log(Level.SEVERE, null, ex);
        }
               
        
    }//GEN-LAST:event_createActionPerformed
    
    //Ajout d'un cours
    static void ajout(String nouveauNom) {//GEN-FIRST:event_createActionPerformed
        try {
            // TODO add your handling code here:
            
            Cours cours=new Cours();
            CoursDAO coursDAO=new CoursDAO();
                    
            int id=0;  
            
            //On récupère les champs
            String nom = nouveauNom; 
               
            cours=new Cours(id,nom);
            cours=coursDAO.create(cours);
            
            //L'afficher dans le tableau
            Object []cours1= {cours.getId(),cours.getNom()};
            modelListeEnseignant.insertRow(modelListeEnseignant.getRowCount(), cours1);
            
            //mettre à  jour l'arraylist de classes
            CoursVue.cours1=CoursVue.coursDAO.all();
            
            
            //CrÃ©er aussi 3 trimestres pour l'annÃ©e choisie
            
            //Message de confirmation
            System.out.println("Cours "+cours.getNom()+" ajoutée.");

            //dispose();
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AddEnseignant.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }//GEN-LAST:event_createActionPerformed
    
    private javax.swing.JButton connection;
    private javax.swing.JTextField database;
    private javax.swing.JButton exit;
    private javax.swing.JTextField identifiant;
    private javax.swing.JComboBox<String> jComboBox1;

    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;    
    private javax.swing.JLabel pswforgot;
    // End of variables declaration//GEN-END:variables
    
 
    
    
    
}
