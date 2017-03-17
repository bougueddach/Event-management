/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Component;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import jdbc.Connexion;

/**
 *
 * @author macbook
 */
public class CreateEvent extends javax.swing.JPanel {
    Connexion con = new Connexion();
    Connection Maconnexion;
    String IDEv;
    int IDUser;
    /**
     * Creates new form CreateEvent
     */
    public CreateEvent(int id , String ide)
    {
        this(id);
        IDEv = ide;
    }
    public CreateEvent(int id) {
        initComponents();
        Maconnexion = con.getMaconnexion();
        DeptPanel.setEnabled(true);
        initComponents();
        IDEv=null;
        IDUser=id;
        Maconnexion = con.getMaconnexion();
         Statement St;
        ResultSet Rs1=null;
        try {
            St=this.Maconnexion.createStatement();
            Rs1=St.executeQuery("select * from departement");  
            DeptPanel.setLayout(new GridLayout(0,4));
            if(Rs1.first())
            {
                do{
                JCheckBox D ;
                D = new JCheckBox(Rs1.getString(2));
                D.setActionCommand(Rs1.getString(1));
                D.setSize(100,20);
                DeptPanel.add(D);          
                }
                while(Rs1.next());
                DeptPanel.setSize(300,80);
                DeptPanel.setVisible(true);
                this.add(DeptPanel);
            }
            else
            {
               JOptionPane.showMessageDialog(null ,"Aucun departement a afficher " ,"Warning",JOptionPane.WARNING_MESSAGE);            
            }
            
            
        
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null ,"Erreur ComboBox Dept " ,"Warning",JOptionPane.WARNING_MESSAGE);            
        }
    }
    public void setLabel(String L)
    {
        Label.setText(L);
    }
    public void setButton(String S)
    {
        Valider.setText(S);
    }
    public void setTitre(String S)
    {
        Titre.setText(S);
    }
    public void setLieu(String S)
    {
        Lieu.setText(S);
    }
    public void setSecteur(String S)
    {
        Secteur.setText(S);
    }
    public void setTheme(String S)
    {
        Theme.setText(S);
    }
    public void setDescription(String S)
    {
        Desc.setText(S);
    }
    public void setDate(Date D)
    {
        Date.setDate(D);
    }
    public void setType(String T)
    {
        switch(T)
        {
            case "Privée" : Privee.setSelected(true);break ;
            case "Public" : Public.setSelected(true); break ;
            default: break;
        }        
    }
    public void setDeptPanel(int idEv )
    {
        Statement St ;
        ResultSet Rs=null;
        try {
            St=Maconnexion.createStatement();
            Rs=St.executeQuery("select E.IDDept , NomDept from departement D , eventDept E where E.IDDept = D.IDdept and E.IDEvent='"+idEv+"'");
            if(Rs.first())
            {
                
                Component[] Dept=DeptPanel.getComponents();
                for(int i=0 ; i<Dept.length ; i++)
                    {
                        if(((JCheckBox)Dept[i]).getText().equalsIgnoreCase(Rs.getString(2)) )
                           ((JCheckBox)Dept[i]).setSelected(true);
                    }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CreateEvent.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TypeGroup = new javax.swing.ButtonGroup();
        jTextField4 = new javax.swing.JTextField();
        Titre = new javax.swing.JTextField();
        Lieu = new javax.swing.JTextField();
        Secteur = new javax.swing.JTextField();
        Date = new com.toedter.calendar.JDateChooser();
        Privee = new javax.swing.JRadioButton();
        Public = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Theme = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        DescPanel = new javax.swing.JScrollPane();
        Desc = new javax.swing.JTextArea();
        DescLabel = new javax.swing.JLabel();
        Label = new javax.swing.JLabel();
        Valider = new javax.swing.JButton();
        DeptPanel = new java.awt.Panel();

        jTextField4.setText("jTextField4");
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        Titre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TitreActionPerformed(evt);
            }
        });

        TypeGroup.add(Privee);
        Privee.setText("Privée");
        Privee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PriveeMouseClicked(evt);
            }
        });
        Privee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PriveeActionPerformed(evt);
            }
        });

        TypeGroup.add(Public);
        Public.setText("Public");
        Public.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PublicMouseClicked(evt);
            }
        });

        jLabel1.setText("Titre :");

        jLabel2.setText("Date :");

        jLabel3.setText("Lieu :");

        jLabel4.setText("Type :");

        jLabel5.setText("Secteur");

        jLabel6.setText("Thème");

        Desc.setColumns(20);
        Desc.setRows(5);
        DescPanel.setViewportView(Desc);

        DescLabel.setText("Description");

        Label.setText("Créer votre événement");

        Valider.setText("Valider");
        Valider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ValiderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DeptPanelLayout = new javax.swing.GroupLayout(DeptPanel);
        DeptPanel.setLayout(DeptPanelLayout);
        DeptPanelLayout.setHorizontalGroup(
            DeptPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 375, Short.MAX_VALUE)
        );
        DeptPanelLayout.setVerticalGroup(
            DeptPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 190, Short.MAX_VALUE)
                .addComponent(Label, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(Valider))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(DescLabel)
                            .addComponent(DeptPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Titre))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel3))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(Privee)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel5))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(Public)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel6)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Secteur, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                                    .addComponent(Lieu)
                                    .addComponent(Theme)))
                            .addComponent(DescPanel))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Label, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Titre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(Lieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(1, 1, 1))
                    .addComponent(Date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Privee)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Public))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Secteur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Theme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(DeptPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DescLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DescPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Valider)
                .addContainerGap(12, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void TitreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TitreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TitreActionPerformed

    private void PriveeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PriveeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PriveeActionPerformed

    private void PriveeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PriveeMouseClicked
        DeptPanel.setEnabled(true);
        
    }//GEN-LAST:event_PriveeMouseClicked

    private void PublicMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PublicMouseClicked
        DeptPanel.setEnabled(false);
    }//GEN-LAST:event_PublicMouseClicked

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void ValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ValiderActionPerformed
        Statement St , St1 , St2 ;
        ResultSet Rs=null , Rs1=null , Rs2=null;
        
        try {
            St=St1=St2=Maconnexion.createStatement(); 
            java.sql.Date date = new java.sql.Date(Date.getDate().getTime());
            switch(Valider.getText())
                {
                    case "Valider" : St.executeUpdate("insert into event values ('"+Titre.getText()+"' , '"+Secteur.getText()+"' ,'"+Theme.getText()+"', '"+date+"' , '"+Lieu.getText()+"' , '"+Desc.getText()+"' , '"+((Public.isSelected()== true) ? "Public" : "Privée" )+"' , "+IDUser+" );");break;
                    case "Modifier" :
                        
                        St.executeUpdate("UPDATE event SET  Titre='"+Titre.getText()+"', Secteur='"+Secteur.getText()+"' , Thème = '"+Theme.getText()+"', DateEvent= '"+date+"', Lieu='"+Lieu.getText()+"', Description ='"+Desc.getText()+"', Type= '"+((Public.isSelected()== true) ? "Public" : "Privée" )+"' WHERE IDEvent ='"+IDEv+"'");
                        Component[] Dept=DeptPanel.getComponents();
                        for(int i=0 ; i<Dept.length ; i++)
                        {                                
                            if(((JCheckBox)Dept[i]).isSelected())
                            {      
                                Rs=St.executeQuery("select * from eventdept where IDEvent = '"+IDEv+"' and IDDept in (select IDdept from departement where NomDept='"+((JCheckBox)Dept[i]).getText()+"')");
                                if(!Rs.first())
                                {                                  
                                    Rs1=St1.executeQuery("select IDdept from departement where NomDept='"+((JCheckBox)Dept[i]).getText()+"'");
                                    if(Rs1.first())
                                    St1.executeUpdate("insert into eventdept values ('"+IDEv+"' , '"+Rs1.getString(1)+"')");
                                }    
                            }
                            else
                                {                                  
                                    Rs2=St2.executeQuery("select IDdept from departement where NomDept='"+((JCheckBox)Dept[i]).getText()+"'");
                                    if(Rs2.first())
                                    St2.executeUpdate("delete from eventdept where IDEvent='"+IDEv+"' and IDDept= '"+Rs2.getString(1)+"'");
                                 }
                            
                        }                                  
                        break;              
                    default : break ;
                }  
        }
        catch (SQLException ex) {
            Logger.getLogger(CreateEvent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ValiderActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser Date;
    private java.awt.Panel DeptPanel;
    private javax.swing.JTextArea Desc;
    private javax.swing.JLabel DescLabel;
    private javax.swing.JScrollPane DescPanel;
    private javax.swing.JLabel Label;
    private javax.swing.JTextField Lieu;
    private javax.swing.JRadioButton Privee;
    private javax.swing.JRadioButton Public;
    private javax.swing.JTextField Secteur;
    private javax.swing.JTextField Theme;
    private javax.swing.JTextField Titre;
    private javax.swing.ButtonGroup TypeGroup;
    private javax.swing.JButton Valider;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
