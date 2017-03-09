package jdbc;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nada
 */
public class Connexion {
    private JDBC jdbc;
    private Connection Maconnexion ; 
    
    public Connexion(){
        jdbc = new JDBC();
        jdbc.setURL("jdbc:mysql://localhost:3306/events");
        jdbc.setPilote("com.mysql.jdbc.Driver");
        jdbc.setLogin("root");
        jdbc.setPasswd("");
        jdbc.ToConnect();
        Maconnexion = jdbc.getConnexion();
        }
    
    public void AddDept(String Dept)
    {
    
        Statement St;
        ResultSet Rs = null ;
        try{
        St=Maconnexion.createStatement();
        Rs=St.executeQuery("select NomDept from departement where NomDept='"+Dept+"'");
        if(Rs.next()) {JOptionPane.showMessageDialog(null, "Le département existe déjà ! " ,"Attention !!" , JOptionPane.WARNING_MESSAGE );}
        else{St.executeUpdate("insert into departement values (NULL , '"+Dept+"');");}
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null ,"Pb dans la requete d'ajout Filiere !! "+ex.getMessage(),"Warning",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    
}
