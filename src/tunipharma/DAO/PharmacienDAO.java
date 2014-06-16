/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tunipharma.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tunipharma.entities.Pharmacie;
import tunipharma.entities.Pharmacien;
import tunipharma.entities.Pharmacien2;
import tunipharma.util.ConnectionBD;

/**
 *
 * @author Emna
 */
public class PharmacienDAO {
    
    public void InscriptionPharmacien()
            
    {
        
    }
    
    public void EnvoyerSMS(int numero,Pharmacien pharmacien, Pharmacie pharmacie)
    {
        
    }

    
    public List<Pharmacien2> DisplayPartiePharmacien (){


        List<Pharmacien2> listepharmacien = new ArrayList<Pharmacien2>();

       String requete = "select * from pharmacien where statut=0 ";
        try {
            Statement statement;
            statement = ConnectionBD.getInstance().createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while(resultat.next()){
                Pharmacien2 pharmacien =new Pharmacien2();
                
                
                pharmacien.setId_pharmacien(resultat.getInt(1));
                pharmacien.setId_pharmacie(resultat.getInt(2));
                pharmacien.setNom(resultat.getString(3));
                pharmacien.setPrenom(resultat.getString(4));
                pharmacien.setStatut(resultat.getInt(5));
                pharmacien.setTel(resultat.getString(6));
                pharmacien.setEmail(resultat.getString(7));
                pharmacien.setLogin(resultat.getString(8));
                pharmacien.setPwd(resultat.getString(9));
                pharmacien.setPhoto(resultat.getString(10));
               
               

                listepharmacien.add(pharmacien);
            }
            return listepharmacien;
        } catch (SQLException ex) {
           
            System.out.println("erreur lors du chargement des Pharmacien "+ex.getMessage());
            return null;
        }
    
}
    
    
    public void updatePartiePharmacien(Pharmacien2 st){
        String requete = "update pharmacien set statut=1 where id_pharmacien=?";
        try {
            PreparedStatement ps = ConnectionBD.getInstance().prepareStatement(requete);
           
            ps.setInt(1, st.getId_pharmacien());
          
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour "+ex.getMessage());
        }

    }
    
    
     public void deletePharmacien(int num){

          String requete = "delete from pharmacien where id_pharmacie=?";
        try {
            PreparedStatement ps = ConnectionBD.getInstance().prepareStatement(requete);
            ps.setInt(1, num);
            ps.executeUpdate();
            System.out.println("Suppression effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression "+ex.getMessage());
        }
    }
     
     
    public void insertPharmacien(Pharmacien p, String matricule) {
     
        
        String requete_recherche = "select * from pharmacie where matricule=?";
      
        int id = 0;
        try {
            PreparedStatement ps = ConnectionBD.getInstance().prepareStatement(requete_recherche);
            ps.setString(1, matricule);
            ResultSet resultat_recherche = ps.executeQuery();

            while (resultat_recherche.next()) {

                id = resultat_recherche.getInt(1);

                //}
            }
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche " + ex.getMessage());
        }



        String requete = "insert into pharmacien (id_pharmacie,nom,prenom,tel,email,login,pwd,photo) values (?,?,?,?,?,?,?,?)";
        try {
            Statement statement;
            statement = ConnectionBD.getInstance().createStatement();

            PreparedStatement ps = ConnectionBD.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ps.setString(2, p.getNom());
            ps.setString(3, p.getPrenom());
            ps.setString(4, p.getTel());
            ps.setString(5, p.getEmail());
            ps.setString(6, p.getLogin());
            ps.setString(7, p.getPwd());
            ps.setString(8,p.getPhoto());
            // ps.setString(10, p.get;


            ps.executeUpdate();
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion " + ex.getMessage());
        }
    }
      
    
    public void ModifierPharmacien(Pharmacien a)
      {
          try {
              System.out.println("id= "+a.getId_pharmacien());
              String req = "update pharmacien set nom=?,prenom=?,tel=?,email=?,login=?,pwd=?  where id_pharmacien=?";
              PreparedStatement ps = ConnectionBD.getInstance().prepareStatement(req);
              ps.setString(5 , a.getLogin());
              ps.setString(6, a.getPwd());
              ps.setString(4, a.getEmail());
              ps.setString(1, a.getNom());
              ps.setString(2, a.getPrenom());
              ps.setString(3, a.getTel());
              ps.setInt(7, a.getId_pharmacien());
            //  ps.setString(7, a.getPhoto());
             
              ps.executeUpdate();
              System.out.println("Update successfull");
          } catch (SQLException ex) {
              Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
    
    
    public void rechPharmacien()
    {
        System.out.println("bonjjour");       
       
        
    }
    
    

}
