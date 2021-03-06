/* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import DAO.CoursDAO;
import DAO.EnseignantDAO;
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
 *Affiche la liste de toutes les s�ances associ�es � un enseignant
 *
 */
public class ListeSeance extends javax.swing.JFrame {

    
    static ArrayList<Cours> cours1=new ArrayList();
    static CoursDAO coursDAO;
    static Cours cours =new Cours();
    AddCours addCours=new AddCours();
    
    static ArrayList<Enseignant> enseign1=new ArrayList();
    static ArrayList<Seance> seance1=new ArrayList();
    
    //static ArrayList<Niveau> allLevels=new ArrayList<Niveau>();
    //static ArrayList<AnneeScolaire>allYears=new ArrayList<AnneeScolaire>();
    
    static DefaultTableModel modelCours;

   
    /**
     * Creates new form 
     */
    public ListeSeance(int id){
    	
    	
        initComponents();          
        modelCours=(DefaultTableModel) jTable1.getModel();
        addCours=new AddCours(); //On r�cup�re les cours
        fillSeance(id);
        
        
    }
    
    /**
     * Remplit l'mploi du temps avec celles trouv�es dans la bdd, version graphique
     * @param idFind
     */
    public void fillSeance(int idFind){
        try { 	
        	System.out.println("Liste seance id:"+idFind);
            coursDAO= new CoursDAO();            
          
            EnseignantDAO enseignDAO= new EnseignantDAO();
            UtilisateurDAO utilDAO = new UtilisateurDAO();
            SeanceDAO seanceDAO = new SeanceDAO();
            Seance_SallesDAO seance_salleDAO = new Seance_SallesDAO();
            SalleDAO salleDAO = new SalleDAO();
            SiteDAO siteDAO = new SiteDAO();
            
            cours1=coursDAO.all(); //R�cup�re toutes les lignes de la table cours
            enseign1=enseignDAO.all();
            seance1 = seanceDAO.all();
              
           
            pack();
            
          

            
            //for(int i=0;i<enseign1.size();i++){
            //	int id_enseignant = enseign1.get(i).getId_utilisateur();
            //	int id_cours = enseign1.get(i).getId_cours(); 
           	//Id_cours de l'enseignant
            	
            int id_cours=enseign1.get(idFind-1).getId_cours();
            int id_enseignant = enseign1.get(idFind-1).getId_utilisateur();
            
            	for(int j=0;j<seance1.size();j++) {
            		
            		int id_coursseance= seance1.get(j).getId_cours(); //Id_cours de la s�ance
                    int id_seance = seance1.get(j).getId();
                    Date date = seance1.get(j).getDate();
                    int heure_debut= seance1.get(j).getHeure_debut();
                    int heure_fin = seance1.get(j).getHeure_fin();
                    int etat = seance1.get(j).getEtat();
                    System.out.println(id_cours);
                    if(id_cours == id_coursseance) {
                    	//System.out.println(Id_cours);
                    	
                    	String etatStr="";
                    	Utilisateur util = utilDAO.find(id_enseignant); //Trouve l'utilisateur associ� � cet enseignant
                        String nom_enseignant = util.getNom();		//r�cup�re le nom de cet enseigant
                        
                        cours= coursDAO.find(id_cours);
                        String nom = cours.getNom();
                        
                        Seance_Salles seance_salle = seance_salleDAO.find(id_seance);
                        int id_salle = seance_salle.getId_salle();
                        
                        Salle salle = salleDAO.find(id_salle);
                        String nom_salle = salle.getNom();
                        int capacite = salle.getCapacite();
                        int id_site = salle.getId_site();
                        
                        Site site = siteDAO.find(id_site);
                        String nom_site = site.getNom();

                        switch(etat){
                        	case 0: etatStr = "En cours de validation";
                        			break;
                        	case 1: etatStr = "Valid�";
                        			break;
                        	case 2: etatStr = "Annul�";
                        			break;
                        	default: etatStr = "Valid�";
                        }
                        
                      //Cree l'object � mettre dans le model
                        Object[]cls={date,heure_debut,heure_fin,id_cours,nom,nom_enseignant,nom_salle,nom_site,etatStr}; 
                        modelCours.insertRow(modelCours.getRowCount(), cls);   
  	
                    }
            	
               
                
            }
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Il semblerait qu'une erreur soit survenue.");
        }
    }
    
    public void fillSeance2(int idFind){
        try { 
        	
        	
        	System.out.println("Liste seance id:"+idFind);
            coursDAO= new CoursDAO();
            cours1=coursDAO.all(); //R�cup�re toutes les lignes de la table cours
            
            EnseignantDAO enseignDAO= new EnseignantDAO();
            UtilisateurDAO utilDAO = new UtilisateurDAO();
            SeanceDAO seanceDAO = new SeanceDAO();
            Seance_SallesDAO seance_salleDAO = new Seance_SallesDAO();
            SalleDAO salleDAO = new SalleDAO();
            SiteDAO siteDAO = new SiteDAO();
            
            
           
            pack();
            System.out.println("fillcours");
            for(int i=0;i<cours1.size();i++){
            	
            	String etatStr="";
            	
                int id=cours1.get(i).getId();
                String nom=cours1.get(i).getNom();
                
                
                Enseignant enseign = enseignDAO.find(id);  //trouve l'enseignant associ� � ce cours
                int id_enseignant = enseign.getId_utilisateur(); //recup�re l'Id_utilisateur de cet enseignant.
                
                Utilisateur util = utilDAO.find(id_enseignant); //Trouve l'utilisateur associ� � cet enseignant
                String nom_enseignant = util.getNom();		//r�cup�re le nom de cet enseigant
                		
                Seance seance = seanceDAO.findId_Cours(id);
                int id_seance = seance.getId();
                Date date = seance.getDate();
                int heure_debut= seance.getHeure_debut();
                int heure_fin = seance.getHeure_fin();
                int etat = seance.getEtat();
                
                
                
                Seance_Salles seance_salle = seance_salleDAO.find(id_seance);
                int id_salle = seance_salle.getId_salle();
                
                Salle salle = salleDAO.find(id_salle);
                String nom_salle = salle.getNom();
                int capacite = salle.getCapacite();
                int id_site = salle.getId_site();
                
                Site site = siteDAO.find(id_site);
                String nom_site = site.getNom();
                
                
                switch(etat){
                	case 0: etatStr = "En cours de validation";
                			break;
                	case 1: etatStr = "Valid�";
                			break;
                	case 2: etatStr = "Annul�";
                			break;
                	default: etatStr = "Valid�";
                	
                }
                //if (date == )
                
                
                //Cree l'object � mettre dans le model
                Object[]cls={date,heure_debut,heure_fin,id,nom,nom_enseignant,nom_salle,nom_site,etatStr};
                
                
                modelCours.insertRow(modelCours.getRowCount(), cls);                
               cours1.get(i).afficher(); //affichage console                
                
            }
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Il semblerait qu'une erreur soit survenue.");
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
        jTable1.setModel(new javax.swing.table.DefaultTableModel(new Object [][] {}, new String [] {"Date","Heure de d�but","Heure de fin","Id", "Nom du cours", "Enseignant", "Salle", "Site" ,"Etat"}) 
        {boolean[] canEdit = new boolean [] {false,false,false,false, true, true, false, true, false};

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
       
        displayStudents = new javax.swing.JButton();
        displayStudents.setText("Afficher la classe");
        
        jButtonRetour = new javax.swing.JButton();
        jButtonRetour.setText("Retour");
      

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
                        .addComponent(displayStudents)))
                .addContainerGap(305, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRetour)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add)
                    .addComponent(delete)
                    .addComponent(update)
                    .addComponent(displayStudents))
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
                //updateActionPerformed(evt);
            }
        });
        
        displayStudents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //displayStudentsActionPerformed(evt);
            }
        });

    }// </editor-fold>//GEN-END:initComponents

    
        /**
     *Cherche une ann�e dans l'arraylist avec un id
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
        dispose();
    }//GEN-LAST:event_jButtonRetourActionPerformed

    
    
    //Ajouter un cours
    private void ajouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouterActionPerformed
        // TODO add your handling code here:
    	AddCours addcours = new AddCours();
        addcours.setVisible(true);
        
        //addCours.ajout("testbis");
        dispose(); //ferme et r�ouvre la page ce qui actualise la table
        ListeSeance cours1=new ListeSeance(1);
        cours1.setVisible(true);
    }//GEN-LAST:event_ajouterActionPerformed
    
    
    
    
    //Supprimer un cours
    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
         try {
             
            if(jTable1.getSelectedRow()==-1){//Si aucune ligne est selectionnee
                if(modelCours.getRowCount()==0){
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

                int id=(int) modelCours.getValueAt(currentRow,3);//R�cup�re l'Id de la ligne selectionn�
                
                System.out.println(id);
                cours=coursDAO.find(id); //Trouver la personne dans la bdd avec l'id

                
                //Demande de confirmation
                int confirm=JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment supprimer "+cours.getNom()+" d'ID: "+id+" ?");
                if(confirm==JOptionPane.YES_OPTION){                   
                    coursDAO.delete(cours); //Enlever de la bdd
                    coursDAO.deleteId(id); //Enlever de la bdd
                    modelCours.removeRow(currentRow); 
                    
                    cours1=coursDAO.all(); //On remet à jour l'arraylist 
                    JOptionPane.showMessageDialog(null, "Le cours "+cours.getNom()+" a �t� supprim�.");             
                }

            }
            
            
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Une erreur est survenue");
        }
    }//GEN-LAST:event_deleteActionPerformed

    
    
    
    /**
     *Instancie et retourne une classe en selectionnant sa ligne dans le tableau
     *
    public Classe selectClass(){
        
        Classe classe=new Classe();
        //On récup toutes la ligne puis instanciation à partir de l'arraylist.
            int currentRow=jTable1.getSelectedRow();
            
            int id=(int)modelClass.getValueAt(currentRow,0);           
            String nom=(String)modelClass.getValueAt(currentRow, 1);
            
            int id_annee =(int)modelClass.getValueAt(currentRow, 2);                      
            AnneeScolaire annee=new AnneeScolaire(id_annee);
                    
            String nom_ecole=(String)modelClass.getValueAt(currentRow, 3);
            Ecole ecole=new Ecole(1,nom_ecole);
            
            String nom_niveau=(String)modelClass.getValueAt(currentRow, 4);
            Niveau niveau=findLevel(nom_niveau);
            
            
            //Instanciation de la classe modifiée
            classe=new Classe(id,nom,annee,ecole,niveau);
            
            return classe;
        
    }
    
    //Modifier une classe
    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        try {
            // TODO add your handling code here:
            
            classe=new Classe();
            classeDAO=new ClasseDAO();
            
            //Si aucune ligne n'est sélectionnée...
            if(jTable1.getSelectedRow()==-1){
                if(modelClass.getRowCount()==0){
                    JOptionPane.showMessageDialog(rootPane, "Le tableau est vide.");
                }
                else{
                    JOptionPane.showMessageDialog(rootPane, "Sélectionner une ligne.");
                }
            }
            
            else{
                classe=selectClass();                     
                System.out.println("classe modifiee:");
                classe.afficher();
          
            
            if(classe.equals(classeDAO.update(classe))){           
                JOptionPane.showMessageDialog(rootPane, "Modification effectuée avec succès.");  
                classes=classeDAO.all(); //On remet à jour l'arraylist de classes depuis la bdd
            }
            else{
                System.out.println("oups");
            }
            
            
            
        }
            
            } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Il semblerait qu'une erreur soit survenue.");
        }
    }//GEN-LAST:event_updateActionPerformed

    
    //Afficher les infos de la classe sélectionnée
    private void displayStudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayStudentsActionPerformed
        // TODO add your handling code here:
        
        //Si aucune ligne n'est sélectionnée...
        if(jTable1.getSelectedRow()==-1){
            if(modelClass.getRowCount()==0){
                JOptionPane.showMessageDialog(rootPane, "Le tableau est vide.");
            }
            else{
                JOptionPane.showMessageDialog(rootPane, "Sélectionner une ligne.");
            }
        }
        else{
            classe=selectClass();
            OneClass oneclass=new OneClass();
            oneclass.setVisible(true);
        }
             
        
    }//GEN-LAST:event_displayStudentsActionPerformed

    */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton delete;
    private javax.swing.JButton displayStudents;
    private javax.swing.JButton jButtonRetour;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
      
     
     
}