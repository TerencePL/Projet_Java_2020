/*
 * To change this license header, choose License Headers in Project Properties.
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
 *Affiche la liste de toutes les classes

 */
public class CoursVue extends javax.swing.JFrame {

    
    static ArrayList<Cours> cours1=new ArrayList();
    static CoursDAO coursDAO;
    static Cours cours =new Cours();
    AddCours addCours=new AddCours();
    
    //static ArrayList<Niveau> allLevels=new ArrayList<Niveau>();
    //static ArrayList<AnneeScolaire>allYears=new ArrayList<AnneeScolaire>();
    
    static DefaultTableModel modelCours;

    
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//fillCours2();
	}
	
    /**
     * Creates new form Classes
     */
    public CoursVue(){
        initComponents();          
        modelCours=(DefaultTableModel) jTable1.getModel();
        addCours=new AddCours(); //On récupère les cours
        fillCours();
        
        
    }
    
    /**
     * Remplit l'mploi du temps avec celles trouvées dans la bdd, version graphique
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
                
                
                Enseignant enseign = enseignDAO.find(id);  //trouve l'enseignant associé à ce cours
                int id_enseignant = enseign.getId_utilisateur(); //recupère l'Id_utilisateur de cet enseignant.
                
                Utilisateur util = utilDAO.find(id_enseignant); //Trouve l'utilisateur associé à cet enseignant
                String nom_enseignant = util.getNom();		//récupère le nom de cet enseigant
                		
                Seance seance = seanceDAO.find(id);
                int id_seance = seance.getId();
                Date date = seance.getDate();
                int heure_debut= seance.getHeure_debut();
                int heure_fin = seance.getHeure_fin();
                int etat = seance.getEtat();
                
                Seance_Salles seance_salle = seance_salleDAO.find(id_seance);
                int id_salle = seance_salle.getId_seance();
                
                Salle salle = salleDAO.find(id_salle);
                String nom_salle = salle.getNom();
                int capacite = salle.getCapacite();
                int id_site = salle.getId_site();
                
                Site site = siteDAO.find(id_site);
                String nom_site = site.getNom();
                
                
                switch(etat){
                	case 0: etatStr = "En cours de validation";
                			break;
                	case 1: etatStr = "Validé";
                			break;
                	case 2: etatStr = "Annulé";
                			break;
                	default: etatStr = "Validé";
                	
                }
                //if (date == )
                
                
                //Cree l'object à mettre dans le model
                Object[]cls={date,heure_debut,heure_fin,id,nom,nom_enseignant,nom_salle,nom_site,etatStr};
                
               modelCours.insertRow(modelCours.getRowCount(), cls);                
               cours1.get(i).afficher(); //affichage console                
                
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
                //modelCours.insertRow(modelCours.getRowCount(), cls);                
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
        jTable1.setModel(new javax.swing.table.DefaultTableModel(new Object [][] {}, new String [] {"Date","Heure de début","Heure de fin","Id", "Nom du cours", "Enseignant", "Salle", "Site" ,"Etat"}) 
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
                //deleteActionPerformed(evt);
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
        //addCours.setVisible(true);
        addCours.ajout("testbis");
        dispose(); //ferme et réouvre la page ce qui actualise la table
        CoursVue cours1=new CoursVue();
        cours1.setVisible(true);
    }//GEN-LAST:event_ajouterActionPerformed
    
    /*
    //Supprimer une classe
    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
         try {
             
            if(jTable1.getSelectedRow()==-1){//Si aucune ligne est selectionnee
                if(modelClass.getRowCount()==0){
                    JOptionPane.showMessageDialog(rootPane, "Le tableau est vide.");                  
                }
                else{
                    JOptionPane.showMessageDialog(rootPane, "Selectionner une ligne.");
                }
                
            }
            else{
                
                // TODO add your handling code here:
                classeDAO=new ClasseDAO();
                classe=new Classe();

                int currentRow=jTable1.getSelectedRow();

                int id=(int) modelClass.getValueAt(currentRow,0);//RÃ©cupÃ¨rer l'id de la case sÃ©lectionnÃ©e
                
                System.out.println(id);
                classe=classeDAO.find(id); //Trouver la personne dans la bdd avec l'id

                
                //Demande de confirmation
                int confirm=JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment supprimer "+classe.getNom()+" "+classe.getNiveau().getNom()+" ?");
                if(confirm==JOptionPane.YES_OPTION){                   
                    classeDAO.delete(classe); //Enlever de la bdd
                    modelClass.removeRow(currentRow); 
                    
                    classes=classeDAO.all(); //On remet Ã  jour l'arraylist de classes
                    JOptionPane.showConfirmDialog(null, "La classe "+classe.getNom()+" "+classe.getNiveau().getNom()+" a Ã©tÃ© supprimÃ©.");
                    
                }

            }
            
            
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Une erreur est survenue");
        }
    }//GEN-LAST:event_deleteActionPerformed
*/
    
    
    
    /**
     *Instancie et retourne une classe en selectionnant sa ligne dans le tableau
     *
    public Classe selectClass(){
        
        Classe classe=new Classe();
        //On rÃ©cup toutes la ligne puis instanciation Ã  partir de l'arraylist.
            int currentRow=jTable1.getSelectedRow();
            
            int id=(int)modelClass.getValueAt(currentRow,0);           
            String nom=(String)modelClass.getValueAt(currentRow, 1);
            
            int id_annee =(int)modelClass.getValueAt(currentRow, 2);                      
            AnneeScolaire annee=new AnneeScolaire(id_annee);
                    
            String nom_ecole=(String)modelClass.getValueAt(currentRow, 3);
            Ecole ecole=new Ecole(1,nom_ecole);
            
            String nom_niveau=(String)modelClass.getValueAt(currentRow, 4);
            Niveau niveau=findLevel(nom_niveau);
            
            
            //Instanciation de la classe modifiÃ©e
            classe=new Classe(id,nom,annee,ecole,niveau);
            
            return classe;
        
    }
    
    //Modifier une classe
    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        try {
            // TODO add your handling code here:
            
            classe=new Classe();
            classeDAO=new ClasseDAO();
            
            //Si aucune ligne n'est sÃ©lectionnÃ©e...
            if(jTable1.getSelectedRow()==-1){
                if(modelClass.getRowCount()==0){
                    JOptionPane.showMessageDialog(rootPane, "Le tableau est vide.");
                }
                else{
                    JOptionPane.showMessageDialog(rootPane, "SÃ©lectionner une ligne.");
                }
            }
            
            else{
                classe=selectClass();                     
                System.out.println("classe modifiee:");
                classe.afficher();
          
            
            if(classe.equals(classeDAO.update(classe))){           
                JOptionPane.showMessageDialog(rootPane, "Modification effectuÃ©e avec succÃ¨s.");  
                classes=classeDAO.all(); //On remet Ã  jour l'arraylist de classes depuis la bdd
            }
            else{
                System.out.println("oups");
            }
            
            
            
        }
            
            } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Il semblerait qu'une erreur soit survenue.");
        }
    }//GEN-LAST:event_updateActionPerformed

    
    //Afficher les infos de la classe sÃ©lectionnÃ©e
    private void displayStudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayStudentsActionPerformed
        // TODO add your handling code here:
        
        //Si aucune ligne n'est sÃ©lectionnÃ©e...
        if(jTable1.getSelectedRow()==-1){
            if(modelClass.getRowCount()==0){
                JOptionPane.showMessageDialog(rootPane, "Le tableau est vide.");
            }
            else{
                JOptionPane.showMessageDialog(rootPane, "SÃ©lectionner une ligne.");
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