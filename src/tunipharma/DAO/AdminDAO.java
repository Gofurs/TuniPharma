/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tunipharma.DAO;

import java.awt.Component;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import tunipharma.Controllers.SendRecoveryEmail;
import tunipharma.entities.Admin;
import tunipharma.gui.Admin_LostPwd;
import tunipharma.gui.Admin_Accueil;
import tunipharma.util.ConnectionBD;
/**
 *
 * @author sicateur
 */
public class AdminDAO {
    private Component Admin_Connexion;
   
    
    public int Admin_Authentification (Admin admin){
        int TypeUser = -1;
      //  String requete = "select * from admin where login=? and pwd=?";
      //String requete = "select * from admin where login='"+admin.getLogin()+"' and pwd='"+admin.getPwd()+"'";
        String requete =  "SELECT login, pwd, email, 1 as admin FROM admin where login = '"+admin.getLogin()+"'and pwd='"+admin.getPwd()+"'"
                + "UNION ALL SELECT login,pwd,email, 0 FROM pharmacien where login ='"+admin.getLogin()+"'and pwd='"+admin.getPwd()+"'";  
        try {
               PreparedStatement ps = ConnectionBD.getInstance().prepareStatement(requete);
               //ps.setString(1, admin.getLogin());
              // ps.setString(2, admin.getPwd());
               ResultSet res = ps.executeQuery(requete);
                 
                     if (res.next()){ JOptionPane.showMessageDialog(Admin_Connexion, "Authentification effectuée avec succès");
                          System.out.println("Authentification effectuée avec succès. "+admin.getPwd());  
                          TypeUser = res.getInt(4);
                          }
                    else{ 
                         JOptionPane.showMessageDialog(Admin_Connexion, "Erreur lors de Authentification. Vérifier vos identifiants!");
                         System.out.println("Erreur lors de l'authentification. "+admin.getPwd());
                          
                      }
                     ps.close();
             }catch (SQLException ex) {
           JOptionPane.showMessageDialog(Admin_Connexion, "Erreur lors de Connexion");
            System.out.println("Erreur lors de Connexion "+ex.getMessage());
        }
       return TypeUser;
    }
    public void Admin_Recovery_Password (Admin admin){
        //String requete = "SELECT `pwd` FROM  `admin` WHERE  `email` =  '"+admin.getEmail()+"'";
        String requete = "SELECT pwd  FROM admin where email = '"+admin.getEmail()+"'" 
                + "UNION ALL "
                + "SELECT pwd FROM pharmacien where email ='"+admin.getEmail()+"'";
        try {
               PreparedStatement ps = ConnectionBD.getInstance().prepareStatement(requete);
              
               ResultSet res = ps.executeQuery(requete);
                 
                     if(res.next()){ 
                         admin.setPwd(res.getString(1));
                         //SendRecoveryEmail sre = new SendRecoveryEmail();
                          try {
                                SendRecoveryEmail.SendRecoveryEmail(admin.getEmail(),res.getString(1));
                            } catch (Exception ex) {
                                Logger.getLogger(Admin_LostPwd.class.getName()).log(Level.SEVERE, null, ex);
                                System.out.println("Erreur lors de Connexion_Vérifiez votre @Mail "+res.getString(1)+" "+ex.getMessage());
                            }
                         JOptionPane.showMessageDialog(Admin_Connexion, "Vérifier votre courrier afin de récupérer votre mot de passe. ");
                         System.out.println("Mail recovery sent to : "+res.getString(1));
                          
                          }
                     //else { System.out.println("erreur requete");}
                     ps.close();
             }catch (SQLException ex) {
           JOptionPane.showMessageDialog(Admin_Connexion, "Erreur lors de Connexion_Vérifiez votre @Mail");
           System.out.println("Erreur lors de Connexion_Vérifiez votre @Mail"+ex.getMessage());
    }
    }
    
    
    
    
    
    
       
          public List<Admin> GetAllAdmin()
    {
        String requette = "select * from admin";
        List<Admin> Admins = new ArrayList<Admin>();
        try {
            Statement s = ConnectionBD.getInstance().createStatement();
            ResultSet res = s.executeQuery(requette);
            
            while(res.next())
            {
                Admin d =  new Admin();
                d.setId_Admin(res.getInt(1));
                d.setLogin(res.getString(2));
                d.setPwd(res.getString(3));
                d.setEmail(res.getString(4));
                
                
                Admins.add(d);
                
            }
            
        } catch (SQLException ex) {
            System.out.println("kjbkjmn");
        }
        return Admins;
    }
          
      
      
      
      public void ModifierAdmin(Admin a)
      {
          try {
              String req = "update admin set login=?,pwd=?,email=? where id_admin=?";
              PreparedStatement ps = ConnectionBD.getInstance().prepareStatement(req);
              ps.setString(1 , a.getLogin());
              ps.setString(2, a.getPwd());
              ps.setString(3, a.getEmail());
              ps.setInt(4, a.getId_Admin());
              ps.executeUpdate();
              System.out.println("Update successfull");
          } catch (SQLException ex) {
              Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
}

