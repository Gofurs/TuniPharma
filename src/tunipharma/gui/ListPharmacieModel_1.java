/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tunipharma.gui;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import tunipharma.DAO.PharmacieDAO;
import tunipharma.entities.Adresse;
//import tunipharma.DAO.PharmacienDAO;


import tunipharma.entities.Pharmacie;
import tunipharma.entities.Services;
import tunipharma.util.ConnectionBD;



public class ListPharmacieModel_1 extends AbstractTableModel{
    String[] headers = {"Matricule","Nom","Adresse Complète","Tel","Type","Jours de garde","Service"/*,"Statut"*/}; 
    List<Pharmacie> listpp = new ArrayList<>();
    PharmacieDAO stdao;
    
    public ListPharmacieModel_1(List<Pharmacie> listpp2) {
        
        stdao = new PharmacieDAO();
       //listpp = stdao.DisplayPartiePharmacie();
        listpp.addAll(listpp2);
    }
//nbre total des phramacie

    /**
     *
     * @return
     */
        @Override
    public int getRowCount() {
            //System.out.println(listpp.size());
            return listpp.size();
    }
//
    @Override
    public int getColumnCount() {
        return headers.length;
    }

        @Override
    public void removeTableModelListener(TableModelListener l) {
        super.removeTableModelListener(l); //To change body of generated methods, choose Tools | Templates.
    }
    
        
     public void remove_pharmacie(int rowIndex){
     //PharmacienDAO pharmacienDAO = new PharmacienDAO();
     //pharmacienDAO.deletePharmacien(listpp.get(rowIndex).getMatricule());
     //stdao.deletePharmacie(listpp.get(rowIndex).getMatricule());
     listpp.remove(rowIndex);
     fireTableRowsDeleted(rowIndex, rowIndex);
 }
    /* public void accept_pharmacie(int rowIndex)
     {
         stdao.updatePartiePharmacie(listpp.get(rowIndex).getMatricule());
         listpp.remove(rowIndex);
         fireTableRowsDeleted(rowIndex, rowIndex);
     }*/
    
    @Override
    public Object getValueAt(int rowIndex, int ColumnIndex) {
        switch (ColumnIndex) {
            case 0:
                return listpp.get(rowIndex).getMatricule();
            case 1:
                return listpp.get(rowIndex).getNom();
            case 2:
              int id_adresse = listpp.get(rowIndex).getId_adresse();
               String requete = "select * from adresse where id_adresse ="+id_adresse;
                  try {
            PreparedStatement ps = ConnectionBD.getInstance().prepareStatement(requete);
            ResultSet resultat = ps.executeQuery(requete);
            Adresse adresse= new Adresse();
            while(resultat.next()){
                
                adresse.setDelegation(resultat.getString(2));
                adresse.setGouvernorat(resultat.getString(3));
                adresse.setRue(resultat.getString(4));
                adresse.setNumero(resultat.getInt(5));
                adresse.setCodePostal(resultat.getString(6));
            }
                      
            return adresse.toString();
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement de l'adresse :  "+ex.getMessage());
            return null;
        }
               
            case 3:
                return listpp.get(rowIndex).getTel();
            case 4:
                return listpp.get(rowIndex).getType();
            case 5:
                return listpp.get(rowIndex).getJgarde().toString();
                
            case 6:
                int id_service = listpp.get(rowIndex).getId_service();
                String requete2 = "select * from services where id_service ="+id_service;
                  try {
            PreparedStatement pst = ConnectionBD.getInstance().prepareStatement(requete2);
            ResultSet resultat = pst.executeQuery(requete2);
            Services service = new Services();
            while(resultat.next()){
                
                service.setNom_service(resultat.getString(2));
            }
                      
            return service.toString();
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement du service :  "+ex.getMessage());
            return null;
        }
            case 7:
                //return listpp.get(rowIndex).getStatut();
            case 8:
                //return listpp.get(rowIndex).getInfirmerie();
            case 9:
               // return listpp.get(rowIndex).getServDom();
           
            default:
                return null;
        }
    }

    @Override
        public String getColumnName(int i) {
        return headers[i];
    }
}
