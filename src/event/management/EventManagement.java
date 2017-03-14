/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event.management;

import java.sql.Date;
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
        Employe E=new Employe();
        long time=System.currentTimeMillis();
        Admin A=new Admin();
//        A.AjouterE("agetb", "secretaire", "malek", "malek", 2);
//        A.AjouterE("ezga", "chef", "bao", "aziz", 1);
//        A.AjouterE("eth", "sadki", "ahmed", "malek", 2);
//        A.AjouterE("ryzj", "rabii", "said", "malek", 1);
        Dept D=new Dept();
        int id=D.getIDdept("Finance");
        System.out.print(id);
        

        
//        Date d=new Date(time);
//        System.out.print(d);
//        E.Organiser("gala 2016", "divertissement ", "nachat",d , "A3", "xxxxxxxxxx", "fete", 10);
//        E.Annuler(3, 1);
//        E.Modifier(3, "dkhds", "cdscsd", "sfcsfcs", "dss", "cscs", "cssds", d.toString(), 1);
        
    }
    
}
