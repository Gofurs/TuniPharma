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
import tunipharma.entities.Pharmacie;
import tunipharma.entities.Pharmacie2;
import tunipharma.entities.Pharmacien;
import tunipharma.gui.Admin_Connexion;
import tunipharma.util.ConnectionBD;

/**
 *
 * @author Azza
 */
public class PharmacieDAO {
    
    
    public List<Pharmacie2> DisplayPartiePharmacie (){

  
        List<Pharmacie2> listepharmacie = new ArrayList<>();

       String requete = "select *  from pharmacie where statut=1";
       
       try {
           Statement statement;
            statement = ConnectionBD.getInstance().createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while(resultat.next()){
                 Pharmacie2 pharmacie =new Pharmacie2();
              
                
               
                pharmacie.setId_pharmacie(resultat.getInt(1));
                pharmacie.setNom(resultat.getString(2));
                pharmacie.setId_adresse(resultat.getInt(3));
                pharmacie.setTel(resultat.getInt(4));
                pharmacie.setType(resultat.getString(5));
                pharmacie.setJgarde(resultat.getString(6));
                pharmacie.setNote(resultat.getInt(7));
                pharmacie.setStatut(resultat.getInt(8));
                pharmacie.setInfirmerie(resultat.getInt(9));
                pharmacie.setServDom(resultat.getInt(10));
                pharmacie.setMatricule(resultat.getString(11));
                pharmacie.setPhoto(resultat.getString(12));
                pharmacie.setId_service(resultat.getInt(13));
                
            

                listepharmacie.add(pharmacie);
              
               
                
            } 
           for (int i = 0; i < listepharmacie.size(); i++) {
            System.out.println(listepharmacie.get(i).getNom());
        }
            return listepharmacie;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des Pharmacie "+ex.getMessage());
            return null;
        }
    }
    
    
    public void updatePartiePharmacie(String row){
        String requete = "update pharmacie set statut=1 where matricule=?";
        //statut = 1 pharmacie acceptée
        try {
            PreparedStatement ps = ConnectionBD.getInstance().prepareStatement(requete);
            ps.setString(1, row);
            ps.executeUpdate();
            System.out.println("Pharmacie accéptée");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour des informations concernant la pharmacie "+ex.getMessage());
        }

    }
    //azza
     public void updatePharmacie(int row){
        String requete = "update pharmacie set statut=1 WHERE id_pharmacie=?";
        //statut = 1 pharmacie acceptée
        try {
            PreparedStatement ps = ConnectionBD.getInstance().prepareStatement(requete);
            ps.setInt(1, row);
            ps.executeUpdate();
            System.out.println("Pharmacie accéptée");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour des informations concernant la pharmacie "+ex.getMessage());
        }

    }
    
     public void deletePharmacie(int num){

          String requete = "delete from pharmacie where id_pharmacie=?";
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
     
     
     public void insertPharmacie(Pharmacie p) {

        String requete = "insert into Pharmacie(nom,type,tel,jgarde,infirmerie,servDom,matricule,id_adresse,photo) values (?,?,?,?,?,?,?,?,?)";
        // String requete = "insert into admin(login,pwd) values (?,?)";


    

        try {
            PreparedStatement ps = ConnectionBD.getInstance().prepareStatement(requete);
            ps.setString(1, p.getNom());
            ps.setString(2, p.getType());
            ps.setInt(3, p.getTel());
            ps.setString(4, p.getJgarde());
            ps.setInt(5,p.getInfirmerie());
            ps.setInt(6,p.getServDom());
            ps.setString(7,p.getMatricule());
            ps.setInt(8, p.getId_adresse());
            ps.setString(9,p.getPhoto());
            ps.executeUpdate();
            
            
              




        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion der pharmacie" + ex.getMessage());
        }
    }
     
     
     
     public int caculculerPharmacieJour() {
        String requete = "select count(*)  from pharmacie where  type=?";
        
      
        int id = 0;
        try {
            PreparedStatement ps = ConnectionBD.getInstance().prepareStatement(requete);
            ps.setString(1,"jour");
            ResultSet resultat_recherche = ps.executeQuery();

            while (resultat_recherche.next()) {

                id = resultat_recherche.getInt(1);
               // System.out.println(id);

                //}
            }
        }
 catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour des informations concernant la pharmacie " + ex.getMessage());
        }               
            
                return id;
            }
    
    
    
    public int caculculerPharmacieNuit() {
        String requete = "select count(*)  from pharmacie where  type=?";
        
      
        int id = 0;
        try {
            PreparedStatement ps = ConnectionBD.getInstance().prepareStatement(requete);
            ps.setString(1,"nuit");
            ResultSet resultat_recherche = ps.executeQuery();

            while (resultat_recherche.next()) {

                id = resultat_recherche.getInt(1);
               // System.out.println(id);

                //}
            }
        }
 catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour des informations concernant la pharmacie " + ex.getMessage());
        }               
            
                return id;
            }
    
    public  Pharmacien chercherPharmacien(String log ,String pwd)
    {
        
        Pharmacien p = new Pharmacien();
        
         String requete = "select *  from pharmacien where  login=? and pwd=?";
        
      
    
        try {
            PreparedStatement ps = ConnectionBD.getInstance().prepareStatement(requete);
            ps.setString(1,log);
             ps.setString(2,pwd);

            ResultSet resultat_recherche = ps.executeQuery();

            while (resultat_recherche.next()) {
                p.setLogin(resultat_recherche.getString(8));
                p.setEmail(resultat_recherche.getString(7));
                p.setPwd(resultat_recherche.getString(9));
                p.setNom(resultat_recherche.getString(3));
                p.setTel(resultat_recherche.getString(6));
                p.setPrenom(resultat_recherche.getString(4));
                p.setId_pharmacien(resultat_recherche.getInt(1));
                
            //    System.out.println("nom ="+p.getNom());

            

                //}
            }
        }
 catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour des informations concernant la pharmacie " + ex.getMessage());
        }               
            return p;
        
        
    }

}
