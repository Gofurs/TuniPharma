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
import javax.print.DocFlavor;
import tunipharma.entities.Adresse;
import tunipharma.util.ConnectionBD;

/**
 *
 * @author houssem_tmn
 */
public class AddresseDAO {

    public List<String> DisplayAllGouvernorat() {

        List<String> listeGouv = new ArrayList<String>();

        String requete = "select * from gouvernorat";
        try {
            Statement statement = ConnectionBD.getInstance()
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            String gouv = "";
            while (resultat.next()) {

                gouv = resultat.getString(2);
                listeGouv.add(gouv);

            }
            return listeGouv;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des depots " + ex.getMessage());
            return null;
        }
    }

    public List<String> chercherDelegation(String gouv1) {
        List<String> listeDeleg = new ArrayList<String>();
        System.out.println(gouv1);
        String requete = "select * from gouvernorat where nom_gouv = ? ";
        try {

            PreparedStatement statement = ConnectionBD.getInstance().prepareStatement(requete);
            statement.setString(1, gouv1);
            ResultSet resultat = statement.executeQuery();

            String gouv = "";
            while (resultat.next()) {

                int id = resultat.getInt(1);
                

                String requete2 = "select * from  delegation where id_deleg_gouv = ? ";
                PreparedStatement statement2 = ConnectionBD.getInstance().prepareStatement(requete2);
                statement2.setInt(1, id);
                ResultSet resultat2 = statement2.executeQuery();

                while (resultat2.next()) {
                    listeDeleg.add(resultat2.getString(2));

                }

            }
            return listeDeleg;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des depots " + ex.getMessage());
            return null;
        }

    }

    public int insertAddresse(Adresse a) {
        String requete = "insert into  adresse (delegation,gouvernerat,rue,numero,code_postal) values (?,?,?,?,?)";
        try {
            PreparedStatement ps = ConnectionBD.getInstance().prepareStatement(requete);
            ps.setString(1, a.getDelegation());
            ps.setString(2, a.getGouvernorat());
            ps.setString(3, a.getRue());
            ps.setInt(4, a.getNumero());
            ps.setString(5, a.getCodePostal());

            ps.executeUpdate();
////recuperation de l'entier de l'adAdressejout"
            ResultSet getKeyRs = ps.executeQuery("SELECT LAST_INSERT_ID()");
            if (getKeyRs != null) {
                if (getKeyRs.next()) {
                    int lastInsertedId = getKeyRs.getInt(1);
                    System.out.println(lastInsertedId);
                    return lastInsertedId;
                }
                getKeyRs.close();
            }

        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du l'insertion de l'addresse " + ex.getMessage());

        }
        return 0;

    }
}
