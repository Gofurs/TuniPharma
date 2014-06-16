
package tunipharma.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import tunipharma.util.ConnectionBD;

/**
 *
 * @author imen
 */
public class StatistiqueDAO {
    
    
    public static String[] listRegion(){
        String ch[]=new String[22];
        String requete =" SELECT * FROM gouvernorat g where id_gouv<>-1";
        int i=0;
        try {
            PreparedStatement ps = ConnectionBD.getInstance().prepareStatement(requete);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                ch[i]=rs.getString(2);
                i++;
            }

        } catch (SQLException ex) {
            Logger.getLogger(StatistiqueDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ch;
    }
    
    public static int indexRegion(String reg){
        int index=-1;
        String ch[]=listRegion();
        for(int i=0;i<ch.length;i++){
            if(ch[i].equals(reg)){
            return i;
            }
        }
        
        return index;
    }
    
    public static int[] nbPharmacieParRegion() {

        int[] res =new int[22];
        int index=-1;

        String requete = "select gouvernerat,count(*) from pi_dev1.adresse t1  group by gouvernerat";
        
        try {
            
                PreparedStatement ps = ConnectionBD.getInstance().prepareStatement(requete);
                ResultSet x = ps.executeQuery(requete);
                while (x.next()) {
                    index=indexRegion(x.getString(1));
                    if(index!=-1){
                        res[index] = x.getInt(2);
                    }
                }
            
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la recherche \n" + ex.getMessage());
        }

        return res;
    }

    public static int[] nbPharmacie_Jour_Nuit() {
        int[] res = {0, 0};

        String requete = "Select count(*) as 'Pharmacies Jour/Nuit' from pi_dev1.pharmacie where type='jour' union Select count(*) from pi_dev1.pharmacie where type='nuit'";
        try {
            PreparedStatement ps = ConnectionBD.getInstance().prepareStatement(requete);
            ResultSet x = ps.executeQuery();
            int i = 0;
            while (x.next()) {
                res[i] = x.getInt(1);
                i++;
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de l'execution de requete : \n" + ex.getMessage());
        }

        return res;
    }

    public static int[] pharmacieParJourDeGarde() {
        int[] res = new int[7];
        String requete = "Select jgarde ,count(*) from pi_dev1.pharmacie group by jgarde";
        try {
            PreparedStatement ps = ConnectionBD.getInstance().prepareStatement(requete);
            ResultSet x = ps.executeQuery();
            int i = 0;
            while (x.next()) {
                switch (x.getString(1)) {
                    case "Lundi":
                        res[0] = x.getInt(2);
                        break;
                    case "Mardi":
                        res[1] = x.getInt(2);
                        break;
                    case "Mercredi":
                        res[2] = x.getInt(2);
                        break;
                    case "Jeudi":
                        res[3] = x.getInt(2);
                        break;
                    case "Vendredi":
                        res[4] = x.getInt(2);
                        break;
                    case "Samedi":
                        res[5] = x.getInt(2);
                        break;
                    case "Dimanche":
                        res[6] = x.getInt(2);
                        break;
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de l'execution de requete : \n" + ex.getMessage());
        }
        return res;
    }
}
