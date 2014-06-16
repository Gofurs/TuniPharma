/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tunipharma.entities;

/**
 *
 * @author Azza
 */
public class Pharmacien {
    private static int id_pharmacien;
    private static int id_pharmacie;
    private static String nom;
    private static String prenom;
    private static int statut;
    private static String tel;
    private static String email;
    private static String login;
    private static String pwd;
    private static String photo;

    public int getMatricule_pharmacie() {
        return matricule_pharmacie;
    }

    public void setMatricule_pharmacie(int matricule_pharmacie) {
        this.matricule_pharmacie = matricule_pharmacie;
    }
     private int matricule_pharmacie;
     
    

   
   public Pharmacien(){}
    public Pharmacien(int id_pharmacien, String nom, String prenom, String tel, String email, String login, String pwd, String photo, int statut, int id_pharmacie) {
        this.id_pharmacien = id_pharmacien;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.email = email;
        this.login = login;
        this.pwd = pwd;
        this.photo = photo;
        this.statut = statut;
        this.id_pharmacie = id_pharmacie;
    }
   
    

    public int getId_pharmacien() {
        return id_pharmacien;
    }

    public void setId_pharmacien(int id_pharmacien) {
        this.id_pharmacien = id_pharmacien;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    

    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getStatut() {
        return statut;
    }

    public void setStatut(int statut) {
        this.statut = statut;
    }

    public int getId_pharmacie() {
        return id_pharmacie;
    }

    public void setId_pharmacie(int id_pharmacie) {
        this.id_pharmacie = id_pharmacie;
    }
    
    
    
    
    public static String getText() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
