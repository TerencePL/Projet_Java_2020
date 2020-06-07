/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import DAO.CoursDAO;
import DAO.EnseignantDAO;
//import DAO.PersonneDAO;
import DAO.SalleDAO;
import DAO.SeanceDAO;
import DAO.Seance_SallesDAO;
import DAO.SiteDAO;
import DAO.UtilisateurDAO;
import Modele.Cours;
import Modele.Enseignant;
import Modele.Salle;
import Modele.Seance;
import Modele.Seance_Salles;
import Modele.Site;
import Modele.Utilisateur;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *Affiche la liste de toutes les classes

 */
public class ListeCours extends javax.swing.JFrame {

    
    static ArrayList<Cours> cours1=new ArrayList();
    static CoursDAO coursDAO;
    static Cours cours =new Cours();
    AddCoursV2 addCoursV2=new AddCoursV2();
    
    //static ArrayList<Niveau> allLevels=new ArrayList<Niveau>();
    //static ArrayList<AnneeScolaire>allYears=new ArrayList<AnneeScolaire>();
    
    static DefaultTableModel modelListeCours;

    
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//fillCours2();
	}
	
    /**
     * Creates new form 
     */
    public ListeCours(){
        initComponents();          
        modelListeCours=(DefaultTableModel) jTable1.getModel();
        addCoursV2=new AddCoursV2(); //On récupère les cours
        fillCours();
        
        
    }
    
    /**
     * Remplit l'emploi du temps avec celles trouvées dans la bdd, version graphique
     */
    public void fillCours(){
        try {          
        	
            coursDAO= new CoursDAO();
            
            EnseignantDAO enseignDAO= new EnseignantDAO();
            UtilisateurDAO utilDAO = new UtilisateurDAO();
            SeanceDAO seanceDAO = new SeanceDAO();
            Seance_SallesDAO seance_salleDAO = new Seance_SallesDAO();
            SalleDAO salleDAO = new SalleDAO();
            SiteDAO siteDAO = new SiteDAO();
            
            cours1=coursDAO.all(); //Récupère toutes les lignes de la table cours
           
            pack();
            System.out.println("fillcours");
            for(int i=0;i<cours1.size();i++){
            	
            	String etatStr="";
            	
                int id=cours1.get(i).getId();
                String nom=cours1.get(i).getNom();

                
                
                //Cree l'object à mettre dans le model
                Object[]cls={id,nom};
                
               modelListeCours.insertRow(modelListeCours.getRowCount(), cls);                
               cours1.get(i).afficher(); //affichage console                
                
            }
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Il semblerait qu'une erreur soit survenue.");
        }
    }
    
    /**
     * Cherche une personne dans l'arraylist avec l'id
     * @param find
     */
    public void findCours(String find){
        try {          
            coursDAO = new CoursDAO();           
            //On recupere tout le monde
            cours1=coursDAO.all();        
            pack();
            int findI = 0;
            //Boucle de recherche
            for(int j=0;j<cours1.size();j++){
                String nom = cours1.get(j).getNom();
                if(nom.equals(find))
                {findI=j; // findi enregistre le j de la personne ayant l'ID recherchï¿½
                }       
            }            

            if(findI!=0) {
                int id=cours1.get(findI).getId();
                String nom=cours1.get(findI).getNom();
              
                Object[] pers={id,nom}; //Creation de l'objet
                modelListeCours.insertRow(jTable1.getRowCount(), pers); //Ajout en fin de tableau
            }
            else
            {
            	JOptionPane.showConfirmDialog(rootPane,"ID inconnu.");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Il semblerait qu'une erreur soit survenue.");
        } 
    }
        
    
    /**
     * Remplit le tableau de classes avec celles trouvées dans la bdd, version consolle
     */
    public static void fillCours2(){
        try {          
            coursDAO= new CoursDAO();
            
            cours1=coursDAO.all(); //On rÃ©cupÃ¨re toutes les lignes de la table classe
            
            System.out.println("balise debug2");
            for(int i=0;i<cours1.size();i++){
                int id=cours1.get(i).getId();
                String nom=cours1.get(i).getNom();
                
                //String niveau=classes.get(i).getNiveau().getNom();
                //int annee=classes.get(i).getAnnee().getId_anneeScolaire();
                //String ecole=classes.get(i).getEcole().getNom();
                
                //Cree l'object Ã  mettre dans le model
                Object[]cls={id,nom};
                
                //System.out.println(""+nom);
                //modelListeCours.insertRow(modelListeCours.getRowCount(), cls);                
                cours1.get(i).afficher();
                
                
                
            }
        } catch (ClassNotFoundException | SQLException ex) {
        	System.out.println( "Il semblerait qu'une erreur soit survenue.");
        }
    }

    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     * ===========================================================================
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
       
        
        
            
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextField1 = new javax.swing.JTextField();
        jTextField1.setText("Rechercher");

        jTable1 = new javax.swing.JTable();
        jTable1.setAutoCreateRowSorter(true);
        jTable1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(new Object [][] {}, new String [] {"Id","nom"}) 
        {boolean[] canEdit = new boolean [] {false,true};

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(30);
        
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane1.setViewportView(jTable1);

        add = new javax.swing.JButton();
        add.setText("Ajouter");
      
        delete = new javax.swing.JButton();
        delete.setText("Supprimer");
        
        update = new javax.swing.JButton();
        update.setText("Modifier");
       
        displaySeances = new javax.swing.JButton();
        displaySeances.setText("Afficher les séances");
        
        jButtonRetour = new javax.swing.JButton();
        jButtonRetour.setText("Retour");
      
        jButton5 = new javax.swing.JButton();
        jButton5.setText("Rechercher");


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)     
                        .addComponent(jButtonRetour)
                        .addGap(262, 262, 262)
                        .addComponent(jButton5)	
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE))
                    	
                    .addGroup(layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1070, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(205, 205, 205)
                        .addComponent(add)
                        .addGap(152, 152, 152)
                        .addComponent(delete)
                        .addGap(175, 175, 175)
                        .addComponent(update)
                        .addGap(150, 150, 150)
                        .addComponent(displaySeances)))
                .addContainerGap(305, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRetour)
                    .addComponent(jButton5) 
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add)
                    .addComponent(delete)
                    .addComponent(update)
                    .addComponent(displaySeances))
                .addContainerGap(227, Short.MAX_VALUE))
        );

        pack();
        
        
        
        jButtonRetour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRetourActionPerformed(evt);
            }
        });
        
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterActionPerformed(evt);
            }
        });
        
        
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        
        jButton5.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {

                jButton5ActionPerformed(evt);

            }

        });
        
        displaySeances.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displaySeancesActionPerformed(evt);
            }
        });

    }// </editor-fold>//GEN-END:initComponents

    
        /**
     *Cherche une année dans l'arraylist avec un id
     * @param id_annee
     * @return
     *
    public static AnneeScolaire findYear(int id_annee){
        AnneeScolaire annee=new AnneeScolaire();
        for(int i=0;i<allYears.size();i++){
                if(allYears.get(i).getId_anneeScolaire()==id_annee)
                    annee=new AnneeScolaire(allYears.get(i).getId_anneeScolaire());
            }
        return annee; 
    } */
    
    /**
     *Cherche un niveau dans l'arraylist avec un nom de niveau
     * @param nom_niveau
     * @return
     *
    public static Niveau findLevel(String nom_niveau){
        
        Niveau niveau=new Niveau();
        for(int i=0;i<allLevels.size();i++){
                if(allLevels.get(i).getNom().equals(nom_niveau)){
                   
                    niveau=new Niveau(allLevels.get(i).getId_niveau(),allLevels.get(i).getNom());
                }
                
            } 
        
        return niveau;
    }
    */
    
    
    
    


 
    //Retour
    private void jButtonRetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRetourActionPerformed
        // TODO add your handling code here:
        Menu menu=new Menu();
        menu.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonRetourActionPerformed

    
    
    //Ajouter un cours
    private void ajouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouterActionPerformed
        // TODO add your handling code here:
    	AddCoursV2 addcoursV2 = new AddCoursV2();
        addcoursV2.setVisible(true);
        
        //addCours.ajout("testbis");
        dispose(); //ferme et réouvre la page ce qui actualise la table
        ListeCours listecours1=new ListeCours();
        listecours1.setVisible(true);
    }//GEN-LAST:event_ajouterActionPerformed
    
    
    
    
    //Supprimer un cours
    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
         try {
             
            if(jTable1.getSelectedRow()==-1){//Si aucune ligne est selectionnee
                if(modelListeCours.getRowCount()==0){
                    JOptionPane.showMessageDialog(rootPane, "Le tableau est vide.");                  
                }
                else{
                    JOptionPane.showMessageDialog(rootPane, "Selectionner une ligne.");
                }  
            }
            else{
               
                cours=new Cours();
                coursDAO=new CoursDAO();

                int currentRow=jTable1.getSelectedRow();

                int id=(int) modelListeCours.getValueAt(currentRow,0);//Récupère l'Id de la ligne selectionné
                
                System.out.println(id);
                cours=coursDAO.find(id); //Trouver la personne dans la bdd avec l'id

                
                //Demande de confirmation
                int confirm=JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment supprimer "+cours.getNom()+" d'ID: "+id+" ?");
                if(confirm==JOptionPane.YES_OPTION){                   
                    coursDAO.delete(cours); //Enlever de la bdd
                    coursDAO.deleteId(id); //Enlever de la bdd
                    modelListeCours.removeRow(currentRow); 
                    
                    cours1=coursDAO.all(); //On remet Ã  jour l'arraylist 
                    JOptionPane.showMessageDialog(null, "Le cours "+cours.getNom()+" a été supprimé.");             
                }
            }         
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Une erreur est survenue");
        }
    }//GEN-LAST:event_deleteActionPerformed

    
    
    
    /**
     *Instancie et retourne une classe en selectionnant sa ligne dans le tableau
     */
    public Cours selectCours(){
        
        Cours cours=new Cours();
        //On rÃ©cup toutes la ligne puis instanciation Ã  partir de l'arraylist.
            int currentRow=jTable1.getSelectedRow();
            
            int id=(int)modelListeCours.getValueAt(currentRow,0);           
            String nom=(String)modelListeCours.getValueAt(currentRow, 1);

            //Instanciation de la classe modifiÃ©e
           cours=new Cours(id,nom);
            
            return cours;
        
    }
    
    //Modifier une classe
    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        try {
            // TODO add your handling code here:
            
            cours=new Cours();
            coursDAO=new CoursDAO();
            
            //Si aucune ligne n'est sÃ©lectionnÃ©e...
            if(jTable1.getSelectedRow()==-1){
                if(modelListeCours.getRowCount()==0){
                    JOptionPane.showMessageDialog(rootPane, "Le tableau est vide.");
                }
                else{
                    JOptionPane.showMessageDialog(rootPane, "Sélectionner une ligne.");
                }
            }
            
            else{
                cours=selectCours();                     
                System.out.println("Cours modifiee:");
                cours.afficher();
          
            
            if(cours.equals(coursDAO.update(cours))){           
                JOptionPane.showMessageDialog(rootPane, "Modification effectuée avec succès.");  
                cours1=coursDAO.all(); //On remet Ã  jour l'arraylist de classes depuis la bdd
            }
            else{
                System.out.println("oups");
            }
            
            
            
        }
            
            } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Il semblerait qu'une erreur soit survenue.");
        }
    }//GEN-LAST:event_updateActionPerformed
    
    //Recherche les etudiants par id
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        // TODO add your handling code here:
		for (int i =jTable1.getRowCount()-1;i>=0;i--) 

		{
		modelListeCours.removeRow(i);   		
		}

		String rechercheStr = jTextField1.getText(); //recuperation depuis la boite Jtextfield 

		if( rechercheStr != "") {
		System.out.println("Recherche "+rechercheStr);
		findCours(rechercheStr);
		}
		
		else {
			System.out.println("Inconnu");
		}

    }


    //Afficher les infos de la classe sÃ©lectionnÃ©e
    private void displaySeancesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displaySeancesActionPerformed
        // TODO add your handling code here:
        
        //Si aucune ligne n'est sélectionnée...
        if(jTable1.getSelectedRow()==-1){
            if(modelListeCours.getRowCount()==0){
                JOptionPane.showMessageDialog(rootPane, "Le tableau est vide.");
            }
            else{
                JOptionPane.showMessageDialog(rootPane, "Sélectionner une ligne.");
            }
        }
        else{
           	cours = selectCours();
           	
            //ListeSeance listeseance=new ListeSeance();
            //listeseance.setVisible(true);
        }
             
        
    }//GEN-LAST:event_displaySeancesActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton delete;
    private javax.swing.JButton displaySeances;
    private javax.swing.JButton jButtonRetour;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton update;
    private javax.swing.JButton jButton5;
    // End of variables declaration//GEN-END:variables
      
     
     
}