/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

/**
 *
 * @author Ludwig
 */
public class Item implements A2Item {
    private String performer;
    private double transactionValue;
    private String date;
    
    public Item(String name, double value, String date){
        performer = name;
        transactionValue = value;
        this.date = date;
    }
    
    public String getPerformer(){
        return performer;
    }    
    
    public double getTransactionValue(){
        return transactionValue;
    }
    
    public String getDate(){
        return date;
    }
    
    public void setPerformer(String name){
        performer = name;
    }
    
    public void setTransactionValue(double value){
        transactionValue = value;
    }
    
    public void setDate(String date){
        this.date = date;
    }
    
    //Following the recomendation from "Josh Bloch's Effective Java" with some alteration
    public int hashCode(){
        int result = 1;
        int c = performer.hashCode();
        long doubleValue = Double.doubleToLongBits(transactionValue);
        c += (int)(doubleValue ^ (doubleValue >>> 32));
        c += date.hashCode();
        result = 37 * result + c;
        return result;
    }
    
    public boolean equals(Object obj){
        Item item = (Item) obj;
        if(this.performer.equals(item.performer) && Double.compare(this.transactionValue, item.transactionValue) == 0 && this.date.equals(item.date)){
            return true;
        }
        else
            return false;
    }
}
