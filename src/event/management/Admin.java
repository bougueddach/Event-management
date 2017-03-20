package event.management;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import jdbc.Connexion;

public class Admin extends Connexion {

	private String idA;
	private String mdpA;
        private Connection  Maconnexion;

	public String getIdA() {
		return this.idA;
	}

	public void setIdA(String idA) {
		this.idA = idA;
	}

	public String getMdpA() {
		return this.mdpA;
	}

	public void setMdpA(String mdpA) {
		this.mdpA = mdpA;
	}

	public Admin() {
		
            Maconnexion = super.getMaconnexion() ;
            
	}
        
	public void AjouterE(String pwd,String poste, String nom, String prenom, String NomDept )
    {
    
        Statement St;
        ResultSet Rs = null ;
        try{
            St=Maconnexion.createStatement();
            Rs=St.executeQuery(" select IDdept from departement where NomDept='"+NomDept+"';");
            if(!Rs.first()){
                JOptionPane.showMessageDialog(null ,"Département inexistant  !! ","Warning",JOptionPane.WARNING_MESSAGE);
            }else{
                St.executeUpdate("insert into employe values (NULL , '"+pwd+"' , '"+poste+"' , '"+nom+"' , '"+prenom+"' , "+Rs.getInt(1)+" ); ");
                JOptionPane.showMessageDialog(null ,"Employé Ajouté avec succès  !! ");                
            }
        }
        catch(SQLException ex) {
            JOptionPane.showMessageDialog(null ,"Pb dans la requête d'ajout de l'employé !! "+ex.getMessage(),"Warning",JOptionPane.WARNING_MESSAGE);
        }
        
    }

	
	public void SupprimerE(int id)
    {
        int test = JOptionPane.showConfirmDialog(null ,"Etes-vous sûrs de vouloir supprimer cet utilisateur ? ","Warning",JOptionPane.YES_NO_OPTION);
        if(test==0){
            Statement St;
            ResultSet Rs = null ;
            try{
            St=Maconnexion.createStatement();
            Rs=St.executeQuery("select * from employe where ID='"+id+"';");
            if(Rs==null) {JOptionPane.showMessageDialog(null, "L'employé n'existe pas ! " ,"Attention !!" , JOptionPane.WARNING_MESSAGE );}
            else{
                St.executeUpdate("delete from employe where ID='"+id+"';");
                JOptionPane.showMessageDialog(null ,"Utilisateur supprimé avec succès ");
            }
            }
            catch(SQLException ex)
            {
                JOptionPane.showMessageDialog(null ,"Problème de suppression de l'employé  !! "+ex.getMessage(),"Warning",JOptionPane.WARNING_MESSAGE);
            }
        }
        
    }

	
	public void AjouterD(String Dept)
    {
    
        Statement St;
        ResultSet Rs = null ;
        try{
        St=Maconnexion.createStatement();
        Rs=St.executeQuery("select NomDept from departement where NomDept='"+Dept+"'");
        if(Rs.next()) {JOptionPane.showMessageDialog(null, "Le département existe déjà ! " ,"Attention !!" , JOptionPane.WARNING_MESSAGE );}
        else{
            St.executeUpdate("insert into departement values (NULL , '"+Dept+"');");
            JOptionPane.showMessageDialog(null, "Département Ajouté avec succès! " );
        }
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null ,"Pb dans la requête d'ajout de département !! "+ex.getMessage(),"Warning",JOptionPane.WARNING_MESSAGE);
        }
    }

	
	public void SupprimerD(int ID)
    {
        int test = JOptionPane.showConfirmDialog(null ,"Etes-vous sûrs de vouloir supprimer ce département ? ","Warning",JOptionPane.YES_NO_OPTION);
        if(test==0){
            Statement St;
            ResultSet Rs = null ;
            try{
                St=Maconnexion.createStatement();
                Rs=St.executeQuery("select * from departement where IDdept='"+ID+"'");
                if(Rs==null) {JOptionPane.showMessageDialog(null, "Le département n'existe pas ! " ,"Attention !!" , JOptionPane.WARNING_MESSAGE );}
            else{
                    St.executeUpdate("delete from departement where IDdept='"+ID+"';");
                    JOptionPane.showMessageDialog(null, "Département supprimé avec succès! " );
                }
            }
            catch(SQLException ex)
            {
            JOptionPane.showMessageDialog(null ,"Problème de suppression de département  !! "+ex.getMessage(),"Warning",JOptionPane.WARNING_MESSAGE);
            }
        }
    }

	
	public void ModifierE(int id , String poste , String N , String P , int idD)
    {
        Statement St;
        ResultSet Rs = null ;
        try{
        St=Maconnexion.createStatement(); 
           
            Rs=St.executeQuery("select * from employe where ID='"+id+"'");
            if(Rs==null) {JOptionPane.showMessageDialog(null, "L'employé n'existe pas ! " ,"Attention !!" , JOptionPane.WARNING_MESSAGE );}
            else{St.executeUpdate("update employe set Poste='"+poste+"' , Nom='"+N+"', Prenom='"+P+"', IDdept='"+idD+"' where ID='"+id+"';" );}} 
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null ,"Problème de modification de l'employé  !! "+ex.getMessage(),"Warning",JOptionPane.WARNING_MESSAGE);
        }
    }
    
}