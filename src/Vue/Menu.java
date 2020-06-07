/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

import Modele.Cours;


public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    public Menu() {
        Start();
    }


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
 void Start() {

    
        quitter = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        jLabel1 = new javax.swing.JLabel();
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("Apllication emploi du temps");

        jLabel2 = new javax.swing.JLabel();
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vue/ece_logo.jpg"))); // NOI18N
      
        cours = new javax.swing.JButton();
        cours.setText("Emploi du temps"); 
        
        liste = new javax.swing.JButton();
        liste.setText("Liste des matières");
        
        enseignants = new javax.swing.JButton();
        enseignants.setText("Liste Enseignants"); 
        
        reporting = new javax.swing.JButton();
        reporting.setText("Statistiques");  
        
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
            .addComponent(cours, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel1)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
            .addComponent(quitter, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(reporting, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(liste, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(enseignants, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
            .addGap(38, 38, 38)
            .addComponent(jLabel2)))
            .addContainerGap(587, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(70, 70, 70)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addComponent(liste, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(enseignants, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(cours, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(reporting, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(quitter, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(142, Short.MAX_VALUE))
        );

        pack();
        
        
        cours.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {coursActionPerformed(evt);}
        });
        
        liste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listeActionPerformed(evt);
            }
        });
        
        enseignants.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enseignantsActionPerformed(evt);
            }
        });
        
        reporting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //reportingActionPerformed(evt);
            }
        });
        
        quitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {quitterActionPerformed(evt);}
        });
        
        
    }// </editor-fold>//GEN-END:initComponents

    
    //Afficher les cours
    private void coursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classesActionPerformed
        // TODO add your handling code here:
        CoursVue cours1=new CoursVue();
        cours1.setVisible(true);
        dispose();
    }//GEN-LAST:event_classesActionPerformed
    
    
    //Afficher la liste cours
    private void listeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classesActionPerformed
        // TODO add your handling code here:
        ListeCours listecours1=new ListeCours();
        listecours1.setVisible(true);
        dispose();
    }//GEN-LAST:event_classesActionPerformed

    /*Afficher les éleves
    private void coursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coursActionPerformed
        // TODO add your handling code here:
        Persons persons=new Persons("etudiant");
        persons.setVisible(true);
        dispose();
    }//GEN-LAST:event_coursActionPerformed
	*/
    
    
    //Afficher les enseignants
    private void enseignantsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enseignantsActionPerformed
        // TODO add your handling code here:
        ListeEnseignant listeenseign1=new ListeEnseignant();
        listeenseign1.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_enseignantsActionPerformed
	
    
    /*Afficher le reporting
    private void reportingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportingActionPerformed
        // TODO add your handling code here:
        Reporting r = new Reporting();
        r.setVisible(true);
        dispose();
    }//GEN-LAST:event_reportingActionPerformed
    */
    
    //Quitter
    private void quitterActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        dispose();//Ferme le menu
        System.exit(0);//Met fin au programme
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton connection;
    private javax.swing.JTextField database;
    private javax.swing.JButton exit;
    private javax.swing.JTextField identifiant;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPasswordField motdepasse;
    private javax.swing.JLabel pswforgot;
    // End of variables declaration//GEN-END:variables

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton liste;
    private javax.swing.JButton enseignants;
    private javax.swing.JButton cours;
    //private javax.swing.JLabel jLabel1;
    //private javax.swing.JLabel jLabel2;
    private javax.swing.JButton reporting;
    private javax.swing.JButton quitter;
    // End of variables declaration//GEN-END:variables
}
