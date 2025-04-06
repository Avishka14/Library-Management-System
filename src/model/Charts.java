
package model;

import java.util.HashMap;
import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;

/**
 *
 * @author Avishka Chamod
 */
public class Charts {
    
    HashMap dataMap;
    
    public Charts(HashMap map){
        this.dataMap = map;
    }
    
     public XChartPanel createRegBarChart(){
             
       int[] janData = {Integer.valueOf((int) dataMap.get("January"))};
       int[] fbData = {Integer.valueOf((int) dataMap.get("February"))};
       int[] marData = {Integer.valueOf((int) dataMap.get("March"))};
       int[] aprData = {Integer.valueOf((int) dataMap.get("April"))};
       int[] mayData = {Integer.valueOf((int) dataMap.get("May"))};
       int[] juneData = {Integer.valueOf((int) dataMap.get("June"))};
       int[] julData = {Integer.valueOf((int) dataMap.get("July"))};
       int[] augData = {Integer.valueOf((int) dataMap.get("August"))};
       int[] sepData = {Integer.valueOf((int) dataMap.get("September"))};
       int[] octData = {Integer.valueOf((int) dataMap.get("October"))};
       int[] novData = {Integer.valueOf((int) dataMap.get("November"))};
       int[] decData = {Integer.valueOf((int) dataMap.get("December"))};
       
       
       CategoryChart chart = new CategoryChartBuilder().width(600).height(400).title("Bar Chart").build();  
       
       
       chart.addSeries("January", new int[] {0} , janData);
       chart.addSeries("Febraury", new int[] {0} , fbData);
       chart.addSeries("March", new int[] {0} , marData);
       chart.addSeries("April", new int[] {0} , aprData);
       chart.addSeries("May", new int[] {0} , mayData);
       chart.addSeries("June", new int[] {0} , juneData);
       chart.addSeries("July", new int[] {0} , julData);
       chart.addSeries("August", new int[] {0} , augData);
       chart.addSeries("September", new int[] {0} , sepData);
       chart.addSeries("Octomber", new int[] {0} , octData);
       chart.addSeries("November", new int[] {0} , novData);
       chart.addSeries("December", new int[] {0} , decData);
     
       return new XChartPanel<>(chart);
   } 
   
   
   public XChartPanel createThisYearLineChart(String year){
       
     
       
      int jan =  Integer.valueOf((int) dataMap.get("January"));
      int feb = Integer.valueOf((int) dataMap.get("February"));
      int mar = Integer.valueOf((int) dataMap.get("March"));
      int apr =  Integer.valueOf((int) dataMap.get("April"));
      int may = Integer.valueOf((int) dataMap.get("May"));
      int jun =  Integer.valueOf((int) dataMap.get("June"));
      int jul = Integer.valueOf((int) dataMap.get("July"));
      int aug = Integer.valueOf((int) dataMap.get("August"));
      int sep = Integer.valueOf((int) dataMap.get("September"));
      int oct = Integer.valueOf((int) dataMap.get("October"));
      int nov = Integer.valueOf((int) dataMap.get("November"));
      int dec = Integer.valueOf((int) dataMap.get("December"));
       
       int[] months ={1,2,3,4,5,6,7,8,9,10,11,12};
       int[] regs = {jan,feb,mar,apr,may,jun,jul,aug,sep,oct,nov,dec};
       
       final XYChart chart = new XYChartBuilder().width(400).height(100).title("Line Chart").xAxisTitle("Month").yAxisTitle("Reg Count").build();
       chart.addSeries(year, months, regs);
      
     
       
       return new XChartPanel<>(chart);
   }
    
    
}
