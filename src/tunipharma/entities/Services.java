/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tunipharma.entities;

/**
 *
 * @author sicateur
 */
public class Services {
    private int id_service;
    private String nom_service;

    public Services() {
    }

    public Services(int id_service, String nom_service) {
        this.id_service = id_service;
        this.nom_service = nom_service;
    }

    public int getId_service() {
        return id_service;
    }

    public void setId_service(int id_service) {
        this.id_service = id_service;
    }

    public String getNom_service() {
        return nom_service;
    }

    public void setNom_service(String nom_service) {
        this.nom_service = nom_service;
    }

    @Override
    public String toString() {
        return nom_service ;
    }
    
}
