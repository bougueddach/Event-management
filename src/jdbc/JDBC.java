package jdbc;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.*;

/**
 *
 * @author Nada
 */
public class JDBC {
    private String Pilote ;
    private String URL;
    private String Login;
    private String Passwd;
    private Connection Connexion ;
    public void ToConnect()
    {
        try{
            Class.forName(Pilote);
            System.out.println("Pilote OK ..");
            Connexion = DriverManager.getConnection(URL, Login, Passwd);
            System.out.println("Connexion etablie");
            }
        catch (ClassNotFoundException ex)
        {
            System.out.println("Pb de chargement de pilote");
        }
        catch(SQLException ex)
        {
            System.out.println("Pb de connexion URL , LOGIN , PASSWD !!!");
        }
    }

    public Connection getConnexion() {
        return Connexion;
    }

    public void setPilote(String Pilote) {
        this.Pilote = Pilote;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public void setPasswd(String Passwd) {
        this.Passwd = Passwd;
    }
    
    
    
}
