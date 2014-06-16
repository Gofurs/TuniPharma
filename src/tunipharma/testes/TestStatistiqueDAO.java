/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tunipharma.testes;
import static javax.swing.WindowConstants.HIDE_ON_CLOSE;
import org.jfree.ui.RefineryUtilities;
import tunipharma.DAO.StatistiqueDAO;
import tunipharma.statistique.BarChartJG;
import tunipharma.statistique.BarChartReg;
import tunipharma.statistique.PieChartJG;
/**
 *
 * @author imen
 */
public class TestStatistiqueDAO {
    public static void main(String[] args) {
        //StatistiqueDAO.nbPharmacie_Jour_Nuit();
//        int res[]=StatistiqueDAO.pharmacieParJourDeGarde();
//        for(int i=0;i<7;i++){
//            switch(i){
//                case 0 : System.out.println("Lundi : "+res[0]);break;
//                case 1 : System.out.println("Mardi : "+res[1]);break;
//                case 2 : System.out.println("Mercredi : "+res[2]);break;
//                case 3 : System.out.println("Jeudi : "+res[3]);break;
//                case 4 : System.out.println("Vendredi : "+res[4]);break;
//                case 5 : System.out.println("Samedi : "+res[5]);break;
//                case 6 : System.out.println("Dimanche : "+res[6]);break;
//                    
//           }
//        }
//        
//        
//        
//        PieChartJG demoP = new PieChartJG("Statistique Pharmacies Par Jour de Garde", "Statistique Pharmacies Par Jour de Garde");
//        demoP.pack();
//        demoP.setVisible(true);
//        demoP.setDefaultCloseOperation(HIDE_ON_CLOSE);
        
        
//        final BarChartJG demoB = new BarChartJG("Statistique Pharmacies Par Jour de Garde");
//        demoB.pack();
//        RefineryUtilities.centerFrameOnScreen(demoB);
//        demoB.setVisible(true);
//        demoB.setDefaultCloseOperation(HIDE_ON_CLOSE);
//        
//        int res[]=StatistiqueDAO.nbPharmacieParRegion();
//         
        
        //String ch[]=StatistiqueDAO.listRegion();
//         for (int i = 0; i < res.length; i++) {
//             
//             System.out.println(ch[i]+" : "+res[i]);
//         }
//       
//          System.out.println(StatistiqueDAO.indexRegion("Tunis"));
        
        
        final BarChartReg demoB = new BarChartReg("Statistique Pharmacies Par Region");
        demoB.pack();
        RefineryUtilities.centerFrameOnScreen(demoB);
        demoB.setVisible(true);
        demoB.setDefaultCloseOperation(HIDE_ON_CLOSE);
        
    }
    
}
