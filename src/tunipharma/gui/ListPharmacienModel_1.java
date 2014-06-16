/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tunipharma.gui;

import java.util.ArrayList;
import java.util.List;
import javax.swing.event.TableModelListener;
import tunipharma.entities.Pharmacien;
import javax.swing.table.AbstractTableModel;
import tunipharma.DAO.PharmacieDAO;
import tunipharma.DAO.PharmacienDAO;
/**
 *
 * @author Azza
 */
public class ListPharmacienModel_1 extends AbstractTableModel{
    
    String[] headers = {"Id Pharmacien","Matricule Pharmacie", "Nom", "Prénom","Statut Ajout", "Telephone","E-Mail","login", "pwd","photo"}; 
    public List<Pharmacien> listSt = new ArrayList<>();
    PharmacienDAO stdao ;
    public ListPharmacienModel_1() {
         stdao = new PharmacienDAO();
    //    listSt = stdao.DisplayPartiePharmacien();
    }
 //@Override
   // public int getRowCount() {
   //         return listSt.size();
    //}
 @Override
    public int getColumnCount() {
        return headers.length;
    }

    @Override
    public  void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        PharmacienDAO pharmacienDAO = new PharmacienDAO();
        PharmacieDAO pharmacieDAO = new PharmacieDAO();
        Pharmacien pharmacien = listSt.get(rowIndex);
        //pharmacien.setStatut(1);
       
        /*pharmacienDAO.updatePartiePharmacien(pharmacien);
        pharmacieDAO.updatePartiePharmacie(pharmacien);
        listSt = stdao.DisplayPartiePharmacien();
        fireTableRowsUpdated(rowIndex, rowIndex);
        fireTableDataChanged();*/
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        super.removeTableModelListener(l); //To change body of generated methods, choose Tools | Templates.
    }
 public void remove_pharmacien(int rowIndex){
     PharmacienDAO pharmacienDAO = new PharmacienDAO();
     pharmacienDAO.deletePharmacien(listSt.get(rowIndex).getId_pharmacien());
     listSt.remove(rowIndex);
     fireTableRowsDeleted(rowIndex, rowIndex);
 }
 public void remove_pharmacien_ligne(int rowIndex){
     PharmacienDAO pharmacienDAO = new PharmacienDAO();
     
     listSt.remove(rowIndex);
     fireTableRowsDeleted(rowIndex, rowIndex);
 }
 
 @Override
    public Object getValueAt(int rowIndex, int ColumnIndex) {
        switch (ColumnIndex) {
            case 0:
                return listSt.get(rowIndex).getId_pharmacien();
            case 1:
                return listSt.get(rowIndex).getMatricule_pharmacie();
            case 2:
                return listSt.get(rowIndex).getNom();
            case 3:
                return listSt.get(rowIndex).getPrenom();
            /*case 4:
                return listSt.get(rowIndex).getStatut();*/
            case 5:
                return listSt.get(rowIndex).getTel();
            case 6:
                return listSt.get(rowIndex).getEmail();
            case 7:
                return listSt.get(rowIndex).getLogin();
            case 8:
                return listSt.get(rowIndex).getPwd();
            case 9:
                return listSt.get(rowIndex).getPhoto();
           
            default:
                return null;
        }
    }
 @Override
        public String getColumnName(int i) {
        return headers[i];
    }

   // @Override
   // public int getRowCount() {
        
    //}

    @Override
    public int getRowCount() {
       return listSt.size();
    }
}
