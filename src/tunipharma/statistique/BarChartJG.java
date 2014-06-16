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

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import tunipharma.DAO.StatistiqueDAO;

public class BarChartJG extends ApplicationFrame {

    
    public BarChartJG(final String title) {

        super(title);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        final CategoryDataset dataset = createDataset();
        final JFreeChart chart = createChart(dataset);
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(chartPanel);

    }


    private CategoryDataset createDataset() {
        
        // row keys...
        final String series2 = "Jour de Garde";
     

        // column keys...
        final String ch1 = "Lundi";
        final String ch2 = "Mardi";
        final String ch3 = "Mercredi";
        final String ch4 = "Jeudi";
        final String ch5 = "Vendredi";
        final String ch6 = "Samedi";
        final String ch7 = "Dimanche";

        // create the dataset...
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        int res[]=StatistiqueDAO.pharmacieParJourDeGarde();
        for(int i=0;i<7;i++){
            switch(i){
                case 0 : {dataset.addValue(res[0],series2,ch1);break;}
                case 1 : {dataset.addValue(res[1],series2,ch2);break;}
                case 2 : {dataset.addValue(res[2],series2,ch3);break;}
                case 3 : {dataset.addValue(res[3],series2,ch4);break;}
                case 4 : {dataset.addValue(res[4],series2,ch5);break;}
                case 5 : {dataset.addValue(res[5],series2,ch6);break;}
                case 6 : {dataset.addValue(res[6],series2,ch7);break;}
                    
           }
        }       
        return dataset;
        
    }
    
    /**
     * Creates a sample chart.
     * 
     * @param dataset  the dataset.
     * 
     * @return The chart.
     */
    private JFreeChart createChart(final CategoryDataset dataset) {
        
        // create the chart...
        final JFreeChart chart = ChartFactory.createBarChart(
            "Jour de Garde ",         // chart title
            "Jour",               // domain axis label
            "Nombre",                  // range axis label
            dataset,                  // data
            PlotOrientation.VERTICAL, // orientation
            true,                     // include legend
            true,                     // tooltips?
            false                     // URLs?
        );

        // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...

        // set the background color for the chart...
        chart.setBackgroundPaint(Color.white);

        // get a reference to the plot for further customisation...
        final CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);

        // set the range axis to display integers only...
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        // disable bar outlines...
        final BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setDrawBarOutline(false);
        
        // set up gradient paints for series...
        final GradientPaint gp0 = new GradientPaint(
            0.0f, 0.0f, Color.blue, 
            0.0f, 0.0f, Color.lightGray
        );
        final GradientPaint gp1 = new GradientPaint(
            0.0f, 0.0f, Color.green, 
            0.0f, 0.0f, Color.lightGray
        );
        final GradientPaint gp2 = new GradientPaint(
            0.0f, 0.0f, Color.red, 
            0.0f, 0.0f, Color.lightGray
        );
        renderer.setSeriesPaint(0, gp0);
        renderer.setSeriesPaint(1, gp1);
        renderer.setSeriesPaint(2, gp2);

        final CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(
            CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 6.0)
        );
        // OPTIONAL CUSTOMISATION COMPLETED.
        
        return chart;
        
    }
}