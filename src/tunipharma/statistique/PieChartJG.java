/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tunipharma.statistique;

/**
 *
 * @author Imen
 */
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;
import tunipharma.DAO.StatistiqueDAO;



public class PieChartJG extends JFrame {

  private static final long serialVersionUID = 1L;

  public PieChartJG(String applicationTitle, String chartTitle) {
        
        super(applicationTitle);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        // This will create the dataset 
        PieDataset dataset = createDataset();
        // based on the dataset we create the chart
        JFreeChart chart = createChart(dataset, chartTitle);
        // we put the chart into a panel
        ChartPanel chartPanel = new ChartPanel(chart);
        // default size
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        // add it to our application
        setContentPane(chartPanel);

    }
    
    private  PieDataset createDataset() {
        DefaultPieDataset result = new DefaultPieDataset();
        int res[]=StatistiqueDAO.pharmacieParJourDeGarde();
        for(int i=0;i<7;i++){
            switch(i){
                case 0 : {if(res[i]!=0){result.setValue("Lundi : ",res[0]);};break;}
                case 1 : {if(res[i]!=0){result.setValue("Mardi : ",res[1]);};break;}
                case 2 : {if(res[i]!=0){result.setValue("Mercredi : ",res[2]);};break;}
                case 3 : {if(res[i]!=0){result.setValue("Jeudi : ",res[3]);};break;}
                case 4 : {if(res[i]!=0){result.setValue("Vendredi : ",res[4]);};break;}
                case 5 : {if(res[i]!=0){result.setValue("Samedi : ",res[5]);};break;}
                case 6 : {if(res[i]!=0){result.setValue("Dimanche : ",res[6]);};break;}
                    
           }
        }
        return result;
        
    }
    
    private JFreeChart createChart(PieDataset dataset, String title) {
        
        JFreeChart chart = ChartFactory.createPieChart3D(title,          // chart title
            dataset,                // data
            true,                   // include legend
            true,
            false);

        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setStartAngle(290);
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setForegroundAlpha(0.5f);
        return chart;
        
    }
    
} 