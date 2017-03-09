package jdbc;


import java.sql.Connection;

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
    private Connection Maconnexion;
    public Connexion(){
        jdbc = new JDBC();
        jdbc.setURL("jdbc:mysql://localhost:3306/events");
        jdbc.setPilote("com.mysql.jdbc.Driver");
        jdbc.setLogin("root");
        jdbc.setPasswd("");
        jdbc.ToConnect();
        Maconnexion = jdbc.getConnexion();
        }
}
