/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tunipharma.entities;

/**
 *
 * @author houssem_tmn
 */
public class Pharmacie2 {

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

    public int getId_adresse() {
        return id_adresse;
    }

    public void setId_adresse(int id_adresse) {
        this.id_adresse = id_adresse;
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

    public String getJgarde() {
        return jgarde;
    }

    public void setJgarde(String jgarde) {
        this.jgarde = jgarde;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public int getStatut() {
        return statut;
    }

    public void setStatut(int statut) {
        this.statut = statut;
    }

    public int getInfirmerie() {
        return infirmerie;
    }

    public void setInfirmerie(int infirmerie) {
        this.infirmerie = infirmerie;
    }

    public int getServDom() {
        return servDom;
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getId_service() {
        return id_service;
    }

    public void setId_service(int id_service) {
        this.id_service = id_service;
    }

    
    
    
    
    
    
    
     private  int id_pharmacie;
    public   String nom;
    private  int id_adresse;
    private   int tel;
    private   String type;
     private      String jgarde;
    private   int note;
    private   int statut;
    private    int infirmerie;
    private   int servDom;
     private   String matricule;
    private    String photo;
     private  int id_service;
    
}
