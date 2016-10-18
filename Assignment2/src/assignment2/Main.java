/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author Ludwig
 */
public class Main implements A2Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Main main = new Main();
        List<A2Item> inputs = main.readCSVFile("input.txt");
        
        main.printResults(main.compareAlgorithms(inputs));
        
        HashMap<A2Item, String> map = new HashMap<>();
        for(A2Item item : inputs){
            map.put(item, item.getPerformer());
        }
        for(A2Item item : map.keySet()){
            A2Item key = item;
            String value = map.get(key);
            System.out.println(key.getPerformer() + " " + value);
        }
        
    }
    
    public List<A2Item> readCSVFile(String filename){
        //TODO: implement
        List<A2Item> inputs = new ArrayList<A2Item>();
        try{
            File inputFile = new File(filename);
            Scanner in = new Scanner(inputFile);
            while(in.hasNextLine()){
                inputs.add(processLine(in.nextLine()));
            }
            in.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return inputs;
    }
    
    public A2Item processLine(String line){
        Scanner sc = new Scanner(line);
        sc.useDelimiter(",");
        //Dummy Item
        A2Item returnItem = new Item("", 0, "");
        if(sc.hasNext()){
            returnItem.setPerformer(sc.next());
            returnItem.setTransactionValue(Double.parseDouble(sc.next()));
            returnItem.setDate(sc.next());
        }
        else{
            System.out.println("Empty Line, check input");
        }
        sc.close();
        return returnItem;
    }
    
    public long bubbleSortByTransactionValue(List<A2Item> array){
        long startTime = System.nanoTime();
        int length = array.size();
        boolean swapped = true;
        while(swapped){
            swapped = false;
            for(int i = 0; i < length - 1; i++){
                if(array.get(i).getTransactionValue() > array.get(i + 1).getTransactionValue()){
                    A2Item item1 = array.get(i);
                    A2Item item2 = array.get(i + 1);
                    array.set(i, item2);
                    array.set(i + 1, item1);
                    swapped = true;
                }
            }
        }
        long StopTime = System.nanoTime();
        return StopTime - startTime;
    }
    
    public long quickSortByTransactionValue(List<A2Item> array){
        long startTime = System.nanoTime();
        quickSort(array, 0, array.size() - 1);
        long StopTime = System.nanoTime();
        return StopTime - startTime;
    }
    private void quickSort(List<A2Item> array, int low, int high){
        int i = low, j = high;
        A2Item pivot = array.get(low + (high - low) / 2);
        
        while(i <= j){
            
            while(array.get(i).getTransactionValue() < pivot.getTransactionValue()){
                i++;
            }
            while(array.get(j).getTransactionValue() > pivot.getTransactionValue()){
                j--;
            }
            if(i <= j){
                A2Item temp = array.get(i);
                array.set(i, array.get(j));
                array.set(j, temp);
                i++;
                j--;
            }
        }
        if(low < j){
            quickSort(array, low, j);
        }
        if(high > i){
            quickSort(array, i, high);
        }
    }
    
    public long heapSortByTransactionValue(List<A2Item> array){
        MyHeapSort myHeapSort = new MyHeapSort();
        long startTime = System.nanoTime();
        myHeapSort.sort(array, new MyItemComparator());
        long StopTime = System.nanoTime();
        return StopTime - startTime;
    }
    
    public TreeSet<Map.Entry<String, Long>> compareAlgorithms(List<A2Item> array){
        //TODO: implement
        List<A2Item> list1 = new ArrayList<A2Item>(array);
        List<A2Item> list2 = new ArrayList<A2Item>(array);
        List<A2Item> list3 = new ArrayList<A2Item>(array);
        
        TreeSet<Map.Entry<String, Long>> treeSet = new TreeSet<Map.Entry<String, Long>>(new MyEntryComparator());;
        Map.Entry<String, Long> entry1 = new AbstractMap.SimpleEntry<String, Long>("BubbleSort", bubbleSortByTransactionValue(list1));
        Map.Entry<String, Long> entry2 = new AbstractMap.SimpleEntry<String, Long>("QuickSort", quickSortByTransactionValue(list2));
        Map.Entry<String, Long> entry3 = new AbstractMap.SimpleEntry<String, Long>("HeapSort", heapSortByTransactionValue(list3));
        
        
        treeSet.add(entry3);
        treeSet.add(entry1);
        treeSet.add(entry2);
        
        return treeSet;
    }
    
    public void printResults(TreeSet<Map.Entry<String, Long>> results){
        for(Map.Entry<String, Long> entry : results){
            System.out.println("Sorting Algorithm: " + entry.getKey() + " Time: " + entry.getValue() + " nanoseconds");
        }
        
        //TODO: Implement
    }
    
    public class MyItemComparator implements Comparator<A2Item>{
        
        @Override
        public int compare(A2Item item1, A2Item item2){
            
            if(item1.getTransactionValue() == item2.getTransactionValue()){
                return 0;
            }
            
            else if(item1.getTransactionValue() > item2.getTransactionValue()){
                return 1;
            }
            
            else{
                return -1;
            }
        }
    }
    public class MyEntryComparator implements Comparator<Map.Entry<String, Long>>{
        
        @Override
        public int compare(Map.Entry<String, Long> entry1, Map.Entry<String, Long> entry2){
            if(entry1.getValue() == entry2.getValue()){
                return 0;
            }
            else if(entry1.getValue() > entry2.getValue()){
                return 1;
            }
            else{
                return -1;
            }
        }
    }
}
