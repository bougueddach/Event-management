/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import jdbc.Connexion;

/**
 *
 * @author Sarah LOTFI
 */
public class Authentify extends javax.swing.JPanel {
   Connexion con = new Connexion();
   Connection Maconnexion;
    /**
     * Creates new form Authentify
     */
    public Authentify() {
        initComponents();
        Maconnexion = con.getMaconnexion();
        Admincon.setVisible(false);
        ConAdmin.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Authentify = new javax.swing.JPanel();
        AdminButton = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Idcon = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        Mdpcon = new javax.swing.JPasswordField();
        ConAdmin = new javax.swing.JButton();
        Admincon = new javax.swing.JPasswordField();

        AdminButton.setText("Administrateur");
        AdminButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdminButtonActionPerformed(evt);
            }
        });

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Identifiant");

        jLabel2.setText("Mot de passe");

        jButton2.setText("Connexion");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jButton2))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Idcon)
                            .addComponent(Mdpcon, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Idcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Mdpcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        ConAdmin.setText("Connexion");
        ConAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConAdminActionPerformed(evt);
            }
        });

        Admincon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdminconActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AuthentifyLayout = new javax.swing.GroupLayout(Authentify);
        Authentify.setLayout(AuthentifyLayout);
        AuthentifyLayout.setHorizontalGroup(
            AuthentifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AuthentifyLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(AuthentifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(AuthentifyLayout.createSequentialGroup()
                        .addComponent(AdminButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Admincon, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ConAdmin))
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        AuthentifyLayout.setVerticalGroup(
            AuthentifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AuthentifyLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(AuthentifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AdminButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ConAdmin)
                    .addComponent(Admincon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Authentify, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Authentify, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void AdminButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdminButtonActionPerformed
        // TODO add your handling code here:
        Admincon.setVisible(true);
        ConAdmin.setVisible(true);
    }//GEN-LAST:event_AdminButtonActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        ResultSet Rs = null, Rs1=null ;
        Statement St , St1;
        try {
            St=Maconnexion.createStatement();
            if(Idcon.getText().isEmpty() && Mdpcon.getText().isEmpty())
            {JOptionPane.showMessageDialog(null ," Veuillez remplir les champs !! ","Warning",JOptionPane.WARNING_MESSAGE);}
            else
            {if(!Idcon.getText().isEmpty())
                {
                    if(!Mdpcon.getText().isEmpty())
                    { Rs=St.executeQuery("select ID from employe where ID='"+Idcon.getText()+"' and Password='"+Mdpcon.getText()+"'");
                        if(Rs.first())
                        {
                            int id = Rs.getInt(1);
                            St1=Maconnexion.createStatement();
                            Rs1=St1.executeQuery("select Poste from employe where ID='"+id+"'");
                            if(Rs1.first()){
                            switch(Rs1.getString(1))
                            {
                                case "Chef" :
                                    SwingUtilities.getWindowAncestor(this).dispose();
                                    JOptionPane.showMessageDialog(null ,"Bienvenue Chef !! " );
                                    EspaceChef Ec = new EspaceChef();
                                    Ec.setSize(1300, 500);
                                    this.removeAll();
                                    this.add(Ec);
                                    this.setVisible(true);
                                    break;
                                case "Directeur":
                                    SwingUtilities.getWindowAncestor(this).dispose();
                                    JOptionPane.showMessageDialog(null ,"Bienvenidos Director !! " );
                                    EspaceDirecteur Ed =new EspaceDirecteur() ;
                                    Ed.setSize(1300, 500);
                                    this.removeAll();
                                    this.add(Ed);
                                    this.setVisible(true);
                                    break;
                                default : 
                                    SwingUtilities.getWindowAncestor(this).dispose();
                                    JOptionPane.showMessageDialog(null ,"Bienvenue !! " );
                                    EspaceEmploye Ee = new EspaceEmploye() ;
                                    Ee.setSize(1300, 500);
                                    this.removeAll();
                                    this.add(Ee);
                                    this.setVisible(true);
                                    break;
                            }
                            }
                        }
                        else
                        {JOptionPane.showMessageDialog(null ,"Id ou mdp incorrect !! " ,"Warning",JOptionPane.WARNING_MESSAGE);}
                    }
                    else
                    {JOptionPane.showMessageDialog(null ," Veuillez remplir le champ mot de passe  !! ","Warning",JOptionPane.WARNING_MESSAGE);}
                }
                else
                {JOptionPane.showMessageDialog(null ," Veuillez remplir le champ identifiant  !! ","Warning",JOptionPane.WARNING_MESSAGE);}
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null ,"Probléme dans le requete de connexion  !! "+ex.getMessage(),"Warning",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void ConAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConAdminActionPerformed
        
        if(!Admincon.getText().isEmpty())
        {
            if(Admincon.getText().equalsIgnoreCase("ADMIN") )
            {
                JOptionPane.showMessageDialog(null ,"Admin connectée avec succée !! " );
                SwingUtilities.getWindowAncestor(this).dispose();
                GUI G=new GUI();
                G.setSize(1000, 500);
                G.setVisible(true);
                EspaceAdmin Ea= new EspaceAdmin();
                Ea.setSize(1000, 500);
                G.add(Ea);
                
            }
            else
            {
                JOptionPane.showMessageDialog(null ,"Mot de passe incorrecte !! ","Warning",JOptionPane.WARNING_MESSAGE);
            }
        }
        else {JOptionPane.showMessageDialog(null ," Veuillez remplir le champ mot de passe  !! ","Warning",JOptionPane.WARNING_MESSAGE); }
    }//GEN-LAST:event_ConAdminActionPerformed

    private void AdminconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdminconActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AdminconActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AdminButton;
    private javax.swing.JPasswordField Admincon;
    private javax.swing.JPanel Authentify;
    private javax.swing.JButton ConAdmin;
    private javax.swing.JTextField Idcon;
    private javax.swing.JPasswordField Mdpcon;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel6;
    // End of variables declaration//GEN-END:variables
}
