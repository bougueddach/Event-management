/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event.management;

import gui.*;
import java.sql.Date;
import javax.swing.JOptionPane;
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
        
        GUI G=new GUI();
        G.setSize(1300, 500);
        Authentify A=new Authentify();
        A.setSize(1300, 500);
        G.add(A);
        G.setVisible(true);


        

        
    }
    
}
