/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event.management;

import jdbc.Connexion;
/**
 *
 * @author macbook
 */
public class EventManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Connexion con  = new Connexion (); 
//        con.AddDept("Finance");
//        con.AddDept("RH");
//        con.AddDept("RH");
        con.AddEmploye("uygerzh56" , "lotfi", "sara", "omar", 2);
    }
    
}
