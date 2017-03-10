package event.management;


import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import jdbc.Connexion;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Employe extends Connexion {

	private int idE;
	private String nom;
	private String prenom;
	private int mdpE;
        private Connection  Maconnexion;

	public int getIdE() {
		return this.idE;
	}

	public void setIdE(int idE) {
		this.idE = idE;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getMdpE() {
		return this.mdpE;
	}

	public void setMdpE(int mdpE) {
		this.mdpE = mdpE;
	}

	public Employe() {
		 Maconnexion = super.getMaconnexion() ;
	}

	
//	public void Organiser(String titre, String secteur, String theme, Date date, String lieu, String desc, String type, int IdOrg ) {
//            Statement St;
//            ResultSet Rs1 = null,Rs2 = null,Rs3 = null;
////            pas la meme date et lieu au meme temp
//            //pas le meme organisateur au meme date
//            //l'organisateur chef
//            try{
//                St=Maconnexion.createStatement();
//                Rs1=St.executeQuery("select poste from employe where id='"+IdOrg+"' ;");
//                if(Rs1==null)
//                    JOptionPane.showMessageDialog(null, "L'organisateur que vous avez choisi n'existe pas " ,"Attention !!" , JOptionPane.WARNING_MESSAGE );
//                Rs2=St.executeQuery("select * from event where dateEvent='"+date+"' and lieu='"+lieu+"';");
//                Rs3=St.executeQuery("select * from event where dateEvent='"+date+"' and IDorg='"+IdOrg+"';");
//                if(Rs2.next()){
//                    JOptionPane.showMessageDialog(null, "La salle est occupée pour cette date ! " ,"Attention !!" , JOptionPane.WARNING_MESSAGE );
//                }
//                if(Rs3.next()){
//                    JOptionPane.showMessageDialog(null, "Vous organiser un evenement au meme temps... comment vous allez faire débil ! " ,"Attention !!" , JOptionPane.WARNING_MESSAGE );
//                }else{
//                    St.executeUpdate("insert into event values ('"+titre+"' , '"+secteur+"' ,'"+theme+"', '"+date+"' , '"+lieu+"' , '"+desc+"' , '"+type+"' , "+IdOrg+" ); ");
//                }
//            }catch(SQLException ex){
//                 JOptionPane.showMessageDialog(null ,"Probléme de création d'évenement  !! "+ex.getMessage(),"Warning",JOptionPane.WARNING_MESSAGE);
//            }
//	}
        public void Organiser(String titre, String secteur, String theme, Date date, String lieu, String desc, String type, int IdOrg ) {
            Statement St;
            ResultSet Rs = null;
//            pas la meme date et lieu au meme temp
            //pas le meme organisateur au meme date
            //l'organisateur chef
            try{
                St=Maconnexion.createStatement();
                Rs=St.executeQuery("select Poste from employe where ID='"+IdOrg+"' ;");
                String P=Rs.getString("Poste");
                if(Rs==null){
                    JOptionPane.showMessageDialog(null, "L'organisateur que vous avez choisi n'existe pas " ,"Attention !!" , JOptionPane.WARNING_MESSAGE );
                }else if(P!="chef"){
                    JOptionPane.showMessageDialog(null, " Vous n'avez l'autorisation de créer un évenement ! " ,"Attention !!" , JOptionPane.WARNING_MESSAGE );
                }else{
                    Rs=St.executeQuery("select * from event where dateEvent='"+date+"' and lieu='"+lieu+"';");
                    if(Rs.next()){
                        JOptionPane.showMessageDialog(null, "La salle est occupée pour cette date ! " ,"Attention !!" , JOptionPane.WARNING_MESSAGE );
                    }else{
                        Rs=St.executeQuery("select * from event where dateEvent='"+date+"' and IDorg='"+IdOrg+"';");
                        if(Rs.next()){
                            JOptionPane.showMessageDialog(null, "Vous organiser un evenement au meme temps... comment vous allez faire débil ! " ,"Attention !!" , JOptionPane.WARNING_MESSAGE );
                        }else{
                        St.executeUpdate("insert into event values ('"+titre+"' , '"+secteur+"' ,'"+theme+"', '"+date+"' , '"+lieu+"' , '"+desc+"' , '"+type+"' , "+IdOrg+" ); ");
                        }
                    }
                } 
            }catch(SQLException ex){
                 JOptionPane.showMessageDialog(null ,"Probléme de création d'évenement  !! "+ex.getMessage(),"Warning",JOptionPane.WARNING_MESSAGE);
            }
	}

	public void Inscrire(int idE , int idEv) {
            
        Statement St;
        ResultSet Rs = null ;
        try{
            St=Maconnexion.createStatement();
            Rs=St.executeQuery("select * from  participations where IDEvent='"+idEv+"' and IDEmp='"+idE+"';");
            if(!Rs.first())
            {
                Rs=St.executeQuery("select * from eventdept Ev , employe E where Ev.IDDept = E.IDdept and E.ID='"+idE+"' and Ev.IDevent='"+idEv+"'");
                if(Rs!=null)
                {
                    Rs=null;
                    Rs=St.executeQuery("select * from participations where IDEmp='"+idE+"' and Date in (select DateEvent from event where IDEvent='"+idEv+"')");
                    if(!Rs.first())
                    {
                        Rs=St.executeQuery("select DateEvent from event where IDEvent='"+idEv+"'");
                        if(Rs.first())
                        {
                           St.executeUpdate("insert into participations values ('"+idEv+"','"+idE+"','"+Rs.getDate(1).toString()+"')");
                        }
                        
                    }
                    else
                    {JOptionPane.showMessageDialog(null ,"Vous ne pouvez pas paticiper simultanément a 2 événements  !! ","Warning",JOptionPane.WARNING_MESSAGE);}
                }
                else
                {JOptionPane.showMessageDialog(null ,"Cet événement ne concerne pas votre département!! ","Warning",JOptionPane.WARNING_MESSAGE);}
            }
            else{JOptionPane.showMessageDialog(null ,"Vous vous êtes déjà inscrit pour cet événement !! ","Warning",JOptionPane.WARNING_MESSAGE);}
        }
        catch(SQLException ex) {
            JOptionPane.showMessageDialog(null ,"Pb dans la requete d'inscription de l'employe !! "+ex.getMessage(),"Warning",JOptionPane.WARNING_MESSAGE);
        }
        
            
    }

	/**
	 * 
	 * @param E
	 */
	public void Desincrire(int idE , int idEv) {
           
                Statement St;
                ResultSet Rs = null ;
             try {    
                St=Maconnexion.createStatement();
                St.executeUpdate("delete from participations where IDEvent='"+idEv+"' and IDEmp='"+idE+"';");
             }
             catch (SQLException ex) {
                 JOptionPane.showMessageDialog(null ,"Pb dans la requete de desinscription de l'employe !! "+ex.getMessage(),"Warning",JOptionPane.WARNING_MESSAGE);
                
            }
            
		
            
	}

	/**
	 * 
	 * @param E
	 */
	public void Annuler(Event E) {
		// TODO - implement Employe.Annuler
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param E
	 */
	public void Modifier(Event E) {
		// TODO - implement Employe.Modifier
		throw new UnsupportedOperationException();
	}

}
