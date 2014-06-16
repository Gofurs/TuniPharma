package tunipharma.entities;

import java.sql.SQLException;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
public class PieChart extends JFrame{
    DefaultPieDataset dataset;//Dataset qui va contenir les Données
    JFreeChart graphe;        //Graphe
    ChartPanel cp;            //Panel
    public PieChart( int j  ,int n) {
        dataset = new DefaultPieDataset();
//Statique
        
        dataset.setValue("Pharmacie du jour",j );
        dataset.setValue("pharmacie de nuit",n );
       
graphe = ChartFactory.createPieChart3D("Les types des pharmacies", dataset,true ,true ,false);
        cp = new ChartPanel(graphe);
        this.add(cp);
    }
	 
        

    
}

