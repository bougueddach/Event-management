package gui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import event.management.Employe;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import jdbc.Connexion;

/**
 *
 * @author Nada
 */
public class Evenement extends javax.swing.JPanel {
    private int IdUser;
    /**
     * Creates new form Guiii
     */
    Connexion con = new Connexion();
    Connection Maconnexion;
    public Evenement(int Id, String X) {
        initComponents();
        Maconnexion = con.getMaconnexion();
        IdUser=Id;
         this.Plus.setName(X);
        this.setSize(576,180);
        Desc.setEditable(false);
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Titre = new javax.swing.JLabel();
        Date = new javax.swing.JLabel();
        Lieu = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Plus = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        Org = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Desc = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));
        setMaximumSize(new java.awt.Dimension(576, 210));
        setPreferredSize(new java.awt.Dimension(576, 190));
        setLayout(null);

        Titre.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        Titre.setText("Titre");
        add(Titre);
        Titre.setBounds(28, 27, 290, 20);

        Date.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        Date.setText("Date");
        add(Date);
        Date.setBounds(60, 60, 100, 14);

        Lieu.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        Lieu.setText("Lieu");
        add(Lieu);
        Lieu.setBounds(230, 60, 150, 14);

        jLabel4.setFont(new java.awt.Font("Georgia", 0, 10)); // NOI18N
        jLabel4.setText("Le : ");
        add(jLabel4);
        jLabel4.setBounds(30, 60, 30, 13);

        jLabel5.setFont(new java.awt.Font("Georgia", 0, 10)); // NOI18N
        jLabel5.setText("à : ");
        add(jLabel5);
        jLabel5.setBounds(190, 60, 20, 13);

        Plus.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        Plus.setText("+");
        Plus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlusActionPerformed(evt);
            }
        });
        add(Plus);
        Plus.setBounds(400, 150, 130, 30);

        jLabel7.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel7.setText("Organisé par : ");
        add(jLabel7);
        jLabel7.setBounds(30, 140, 89, 30);

        Org.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        Org.setText("Org");
        add(Org);
        Org.setBounds(160, 140, 220, 30);

        jScrollPane2.setMaximumSize(new java.awt.Dimension(400, 400));

        Desc.setColumns(17);
        Desc.setLineWrap(true);
        Desc.setRows(5);
        Desc.setBorder(null);
        Desc.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setViewportView(Desc);

        add(jScrollPane2);
        jScrollPane2.setBounds(28, 74, 506, 68);
    }// </editor-fold>//GEN-END:initComponents

    private void PlusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlusActionPerformed
        Employe E=new Employe();
        switch(Plus.getText())
        {
            case "+" :
                E.Inscrire(IdUser, Integer.parseInt(Plus.getName()));
//                EspaceDirecteur I=new EspaceDirecteur(IdUser);
//                SwingUtilities.getWindowAncestor(this).add(I);
//                this.add(I);
//                I.renitianliser();
//                SwingUtilities.getWindowAncestor(SwingUtilities.getWindowAncestor(SwingUtilities.getWindowAncestor(this))).add(I);
//                SwingUtilities.getWindowAncestor(SwingUtilities.getWindowAncestor(SwingUtilities.getWindowAncestor(this))).removeAll();
//                SwingUtilities.getWindowAncestor(SwingUtilities.getWindowAncestor(SwingUtilities.getWindowAncestor(this))).add(I);
//                SwingUtilities.getWindowAncestor(SwingUtilities.getWindowAncestor(SwingUtilities.getWindowAncestor(this))).setSize(500, 500);
                
                break ;
            case "-" :E.Desincrire(IdUser, Integer.parseInt(Plus.getName()));break;
            case "Modifier" : CreateEvent Ev = new CreateEvent(IdUser , Plus.getName());
            GUI G = new GUI();
            G. setSize(478, 650);
            Ev.setSize(478, 650);
;
            Ev.setButton("Modifier");
            Ev.setLabel("Modifier");
            Statement St ;
            ResultSet Rs =null ;
            try {
            St=Maconnexion.createStatement();          
            Rs=St.executeQuery("select * from event where IDEvent = '"+Plus.getName()+"'");
            if(Rs.first())
            {
                Ev.setTitre(Rs.getString(2));                
                Ev.setType(Rs.getString(8));
                Ev.setLieu(Rs.getString(6));
                Ev.setSecteur(Rs.getString(3));
                Ev.setTheme(Rs.getString(4));
                Ev.setDescription(Rs.getString(7));
                Ev.setDate(Rs.getDate(5));
                Ev.setDrop();
                Ev.setDeptPanel(Integer.parseInt(Plus.getName()));
                G.add(Ev);
                G.setVisible(true);                
            }                            
        
        } catch (SQLException ex) {
            Logger.getLogger(listeEvenement.class.getName()).log(Level.SEVERE, null, ex);
        }
            break;
            default :break;
        }
        
    }//GEN-LAST:event_PlusActionPerformed
    public void setName(String X)
    {
        Plus.setName(X);
    }
    public void setTitre(String X)
    {
        Titre.setText(X);
    }
    public void setDate(String X)
    {
        Date.setText(X);
    }
   public void setLieu(String X)
    {
        Lieu.setText(X);
    }
    public void setDesc(String X)
    {
        Desc.setText(X);
    }
    public void setOrg(String X)
    {
        Org.setText(X);
    }
    public void setMoins()
    {
        Plus.setText("-");
    }
    public void setPlus()
    {
        Plus.setText("+");
    }
    public void setModif()
    {
        Plus.setText("Modifier");
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Date;
    private javax.swing.JTextArea Desc;
    private javax.swing.JLabel Lieu;
    private javax.swing.JLabel Org;
    private javax.swing.JButton Plus;
    private javax.swing.JLabel Titre;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
