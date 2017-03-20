package event.management;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import jdbc.Connexion;

public class Dept {

	private int idD;
	private String nomD;
        Connexion con = new Connexion();
        private Connection  Maconnexion;

	public int getIdD() {
		return this.idD;
	}

	public void setIdD(int idD) {
		this.idD = idD;
	}

	public String getNomD() {
		return this.nomD;
	}

	public void setNomD(String nomD) {
		this.nomD = nomD;
	}

	public Dept() {
            Maconnexion = con.getMaconnexion();
	}
        public int getIDdept(String NomDept){
            Statement St;
            ResultSet Rs;
            try{
                St=Maconnexion.createStatement();
                Rs=St.executeQuery(" select IDdept from departement where NomDept='"+NomDept+"';");
                if(!Rs.first()){
                    JOptionPane.showMessageDialog(null ,"departement inexistant!! ");
                }else{
                    return Rs.getInt("IDdept");
                }
            }
            catch(SQLException ex) {
                JOptionPane.showMessageDialog(null ,"Pb dans la selection de departement!! "+ex.getMessage(),"Warning",JOptionPane.WARNING_MESSAGE);
            }
            return -1;
        }
        public boolean getChef(String dept){
        Statement St;
        ResultSet Rs=null;
        try{
            St=Maconnexion.createStatement();
            Rs=St.executeQuery("select * from Employe where IDdept="+getIDdept(dept) +" and Poste='Chef' ");
            if(Rs.next()){
                JOptionPane.showMessageDialog(null, "Ce departement à déja un chef");
            }else{
                return true;
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null ,"Probléme dans la selection des departements dans ComboBox!! "+ex.getMessage(),"Warning",JOptionPane.WARNING_MESSAGE);            
        }
        return false;
        }
        public boolean isEmpty(int Id){
            Statement St;
        ResultSet Rs=null;
        try{
            St=Maconnexion.createStatement();
            Rs=St.executeQuery("select * from Employe where IDdept="+Id +" ");
            if(Rs.first()){
                int test = JOptionPane.showConfirmDialog(null ,"Attention !! Ce département contient des employés, êtes-vous sûrs de vouloir continuer ? ","Warning",JOptionPane.YES_NO_OPTION);
                if(test!=0){
                    return false;
                }
            }else{
                return true;
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null ,"Problème dans la sélection des départements dans ComboBox!! "+ex.getMessage(),"Warning",JOptionPane.WARNING_MESSAGE);            
        }
        return false;
        }

}