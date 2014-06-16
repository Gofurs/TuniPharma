/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tunipharma.gui;

import java.util.ArrayList;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import tunipharma.DAO.PharmacieDAO;
import tunipharma.DAO.PharmacienDAO;


import tunipharma.entities.Pharmacie;
import tunipharma.entities.Pharmacie2;


/**
 *
 * @author Azza
 */
public class ListPharmacieModel extends AbstractTableModel{
    String[] headers = {"Id","Nom","Id Add","Tel","Type","Jgarde","Note","Statut","Infi","Ser à Dom","Matricule","photo","idserv"}; //adresse 
    List<Pharmacie2> listpp = new ArrayList<Pharmacie2>();
    PharmacieDAO stdao ;
    
    public ListPharmacieModel() {
        
        stdao = new PharmacieDAO();
       listpp.addAll(stdao.DisplayPartiePharmacie() );
       
      
    }

     public ListPharmacieModel(List<Pharmacie> listpp2) {
        
       /* stdao = new PharmacieDAO();
       listpp2 = stdao.DisplayPartiePharmacie();
        listpp.addAll(listpp2);*/
        
        
    }
//nbre total des phramacie
    public int getRowCount() {
            return listpp.size();
    }
//
    public int getColumnCount() {
        return headers.length;
    }

    
     public void accept_pharmacie(int rowIndex)
     {
         stdao.updatePartiePharmacie(listpp.get(rowIndex).getMatricule());
         listpp.remove(rowIndex);
         fireTableRowsDeleted(rowIndex, rowIndex);
     }
        @Override
    public void removeTableModelListener(TableModelListener l) {
        super.removeTableModelListener(l); //To change body of generated methods, choose Tools | Templates.
    }
    
        
        public void remove_pharmacie(int rowIndex){
     PharmacieDAO pharmacieDAO = new PharmacieDAO();
     pharmacieDAO.deletePharmacie(listpp.get(rowIndex).getId_pharmacie());
     listpp.remove(rowIndex);
     fireTableRowsDeleted(rowIndex, rowIndex);
     fireTableDataChanged();
 }
    
    @Override
    public Object getValueAt(int rowIndex, int ColumnIndex) {
        switch (ColumnIndex) {
            case 0:
                return listpp.get(rowIndex).getId_pharmacie();
            case 1:
                return listpp.get(rowIndex).getNom();
            case 2:
                return listpp.get(rowIndex).getId_adresse();
            case 3:
                return listpp.get(rowIndex).getTel();
            case 4:
                return listpp.get(rowIndex).getType();
            case 5:
                return listpp.get(rowIndex).getJgarde();
            case 6:
                return listpp.get(rowIndex).getNote();
            case 7:
                return listpp.get(rowIndex).getStatut();
            case 8:
                return listpp.get(rowIndex).getInfirmerie();
            case 9:
                return listpp.get(rowIndex).getServDom();
            case 10:
                return listpp.get(rowIndex).getMatricule();
                case 11:
                return listpp.get(rowIndex).getPhoto();
            case 12:
                return listpp.get(rowIndex).getId_service();
           
           
            default:
                return null;
        }
    }

    @Override
        public String getColumnName(int i) {
        return headers[i];
    }
}
