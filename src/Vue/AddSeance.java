package Vue;

import DAO.*;
import Modele.*;

//import static Vue.Classes.modelClass;
import static Vue.CoursVue.modelCours;

import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AddSeance extends javax.swing.JFrame{
	
	
	public AddSeance() {
		initComponents();	
	}
	
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField NomCours;
    private javax.swing.JTextField IdEnseignant;
    private javax.swing.JTextField Semaine;
    private javax.swing.JTextField Heure_Debut;
    private javax.swing.JTextField Heure_Fin;
    private javax.swing.JTextField IdSalle;
    private javax.swing.JTextField IdSite;
    private javax.swing.JButton quitter;
    private javax.swing.JButton Valider;   
    
	private void initComponents() {
		
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		
        jLabel1 = new javax.swing.JLabel();
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("Ajouter un cours");
		
		NomCours = new javax.swing.JTextField();
        NomCours.setText("Nom du cours");
        
        IdEnseignant = new javax.swing.JTextField();
        IdEnseignant.setText("Id de l'enseignant");  
        
        Semaine = new javax.swing.JTextField();
        Semaine.setText("Semaine");
        
        Heure_Debut = new javax.swing.JTextField();
        Heure_Debut.setText("Heure de d�but");
        
        Heure_Fin = new javax.swing.JTextField();
        Heure_Fin.setText("Heure de fin");
        
        IdSalle = new javax.swing.JTextField();
        IdSalle.setText("ID de la salle");
        
        IdSite = new javax.swing.JTextField();
        IdSite.setText("ID du site");
		
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
            .addComponent(NomCours, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(IdEnseignant, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(Semaine, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(Heure_Debut, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(Heure_Fin, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(IdSalle, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(IdSite, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(NomCours, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(IdEnseignant, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGap(40, 40, 40)
                .addComponent(Semaine, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(Heure_Debut, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(Heure_Fin, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(IdSalle, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(IdSite, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        	
        	//Seance seance = new Seance();
            Cours cours=new Cours();
            CoursDAO coursDAO=new CoursDAO();
            
            Seance seance = new Seance();
            SeanceDAO seanceDAO = new SeanceDAO();
            
            Seance_Salles seance_salle = new Seance_Salles();
            Seance_SallesDAO seance_salleDAO = new Seance_SallesDAO();
            
            Salle salle = new Salle();
            SalleDAO salleDAO = new SalleDAO();
            
            Site site = new Site();
            SiteDAO siteDAO = new SiteDAO();
            
            
            
            //AnneeScolaire annee=new AnneeScolaire();           
            //Ecole ecole=new Ecole();
            //Niveau niveau=new Niveau();
                       
            int id=0;  
            
            //On r�cup�re les champs
            String nom= NomCours.getText();
            int id_enseignant = Integer.parseInt(IdEnseignant.getText());
            int semaine = Integer.parseInt(Semaine.getText());
            int heure_debut = Integer.parseInt(Heure_Debut.getText());
            int heure_fin = Integer.parseInt(Heure_Fin.getText());
            int id_salle = Integer.parseInt(IdSalle.getText());
            int id_site = Integer.parseInt(IdSite.getText());
            int etat =0;
            int id_seance = 0;
            int id_cours = 0;
            int id_type = 0;
            Date date = new Date(01/01/2020);
               
            //On convertit l'annee choisie (type object) en String puis en int
            //int id_annee=Integer.parseInt((String)year.getSelectedItem());
            
            //ON instancie un objet ann�e à partir de son id en le cherchant dans l'arraylist
            //annee=Classes.findYear(id_annee);
            
            
            //String nom_ecole="ECE Paris";
            //ecole=new Ecole(1,nom_ecole);
       
            //On instancie un niveau en le cherchant dans l'arraylist récupéré depuis la bdd
            //String nom_niveau=(String)level.getSelectedItem();
            //niveau=Classes.findLevel(nom_niveau);
                           
            //Instancier la classe puis l'ajouter dans la bdd
            cours=new Cours(id,nom);
            cours=coursDAO.create(cours); 
            id_cours=cours.getId();//On recup�re l'id du conrs qu'on vient de cr�er
            
            
            seance = new Seance(id,semaine,date,heure_debut,heure_fin,etat,id_cours,id_type);
            seance=seanceDAO.create(seance); //Cr�ation de la s�ance associ�e
            id_seance=seance.getId();
            
           
            System.out.println(id_seance);
            seance_salle = new Seance_Salles(id_seance,id_salle);
            System.out.println(seance_salle.getId_seance());
            seance_salle=seance_salleDAO.create(seance_salle); //Cr�ation de la s�ance associ�e
            
            
            
            //L'afficher dans le tableau
            Object []cours1= {date,heure_debut,heure_fin,cours.getId(),cours.getNom()};
            modelCours.insertRow(modelCours.getRowCount(), cours1);
            
            //mettre � jour l'arraylist de classes
            CoursVue.cours1=CoursVue.coursDAO.all();
            
            
            //Créer aussi 3 trimestres pour l'année choisie
            
            //Message de confirmation
            System.out.println("La classe "+cours.getNom()+" a �t� ajout�e.");
            //JOptionPane.showMessageDialog(rootPane, "La classe "+cours.getNom()+" a �t� ajout�e.");

            dispose();          
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AddSeance.class.getName()).log(Level.SEVERE, null, ex);
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
            
            //On r�cup�re les champs
            //String nom=name.getText();
            String nom = "testCours"; 
               
            //On convertit l'annee choisie (type object) en String puis en int
            //int id_annee=Integer.parseInt((String)year.getSelectedItem());
            
            //ON instancie un objet ann�e à partir de son id en le cherchant dans l'arraylist
            //annee=Classes.findYear(id_annee);
            
            
            //String nom_ecole="ECE Paris";
            //ecole=new Ecole(1,nom_ecole);
       
            //On instancie un niveau en le cherchant dans l'arraylist récupéré depuis la bdd
            //String nom_niveau=(String)level.getSelectedItem();
            //niveau=Classes.findLevel(nom_niveau);
                           
            //Instancier la classe puis l'ajouter dans la bdd
            cours=new Cours(id,nom);
            cours=coursDAO.create(cours);
            
            //L'afficher dans le tableau
            Object []cours1= {cours.getId(),cours.getNom()};
            modelCours.insertRow(modelCours.getRowCount(), cours1);
            
            //mettre � jour l'arraylist de classes
            CoursVue.cours1=CoursVue.coursDAO.all();
            
            
            //Créer aussi 3 trimestres pour l'année choisie
            
            //Message de confirmation
            System.out.println("La classe "+cours.getNom()+" a �t� ajout�e.");
            //JOptionPane.showMessageDialog(rootPane, "La classe "+cours.getNom()+" a �t� ajout�e.");

            //dispose();          
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AddSeance.class.getName()).log(Level.SEVERE, null, ex);
        }
               
        
    }//GEN-LAST:event_createActionPerformed
    
    //Ajout d'un cours
    static void ajout(String nouveauNom) {//GEN-FIRST:event_createActionPerformed
        try {
            // TODO add your handling code here:
            
            Cours cours=new Cours();
            CoursDAO coursDAO=new CoursDAO();
                    
            int id=0;  
            
            //On r�cup�re les champs
            String nom = nouveauNom; 
               
            cours=new Cours(id,nom);
            cours=coursDAO.create(cours);
            
            //L'afficher dans le tableau
            Object []cours1= {cours.getId(),cours.getNom()};
            modelCours.insertRow(modelCours.getRowCount(), cours1);
            
            //mettre � jour l'arraylist de classes
            CoursVue.cours1=CoursVue.coursDAO.all();
            
            
            //Créer aussi 3 trimestres pour l'année choisie
            
            //Message de confirmation
            System.out.println("Cours "+cours.getNom()+" ajout�e.");

            //dispose();
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AddSeance.class.getName()).log(Level.SEVERE, null, ex);
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
