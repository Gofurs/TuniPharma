/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tunipharma.entities;

/**
 *
 * @author Azza
 */
public class Pharmacie {
    
    private static int id_pharmacie;
    public  static String nom;
    private static int id_adresse;
    private  static int tel;
    private  static String type;
     private  static    String jgarde;
    private  static int note;
    private  static int statut;
    private  static  int infirmerie;
    private  static int servDom;
     private static  String matricule;
    private   static String photo;
     private static int id_service;
    
    public Pharmacie() {
    }
    public Pharmacie(int id_pharmacie, String nom, int tel, String type, String jgarde, int note, int statut, int infirmerie, int servDom, String matricule, int id_adresse,String photo,int id_service) {
        this.id_pharmacie = id_pharmacie;
        this.nom = nom;
        this.tel = tel;
        this.type = type;
        this.jgarde = jgarde;
        this.note = note;
        this.statut = statut;
        this.infirmerie = infirmerie;
        this.servDom = servDom;
        this.matricule = matricule;
        this.id_adresse = id_adresse;
        this.photo = photo;
        this.id_service=id_service;
        
    }
    public int getId_service() {
        return id_service;
    }
 
    public void setId_service(int id_service) {
        this.id_service = id_service;
   }
//    public void setId_adresse(int id_adresse) {
//        this.id_adresse = id_adresse;
//    }
//     public int getId_adresse() {
//        return id_adresse;
//    }

    public  String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
    
    
    public int getInfirmerie() {
        return infirmerie;
    }

    public int getServDom() {
        return servDom;
    }
    

    public void setInfirmerie(int infirmerie) {
        this.infirmerie = infirmerie;
    }

    public void setServDom(int servDom) {
        this.servDom = servDom;
    }
    

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }
    

    public String getJgarde() {
        return jgarde;
    }

    public void setJgarde(String jgarde) {
        this.jgarde = jgarde;
    }
    


  public int getId_adresse() {
       return id_adresse;
    }

    public void setId_adresse(int id_adresse) {
        this.id_adresse = id_adresse;
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

    

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    

    

  
    
    
    
    
    
    public static String getText() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    public void setId_adresse(Object selectedItem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    public void setTel(float aFloat) {
//       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}
