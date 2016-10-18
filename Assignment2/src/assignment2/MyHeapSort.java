/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Ludwig
 */
public class MyHeapSort {
    
    public void sort(List<A2Item> array, Comparator<A2Item> comparator){
        int n = array.size() - 1;
        for(int i = (n - 1) / 2; i >= 0; i--){
            fixHeap(array, i, n, comparator);
        }
        while(n > 0){
            A2Item temp = array.get(0);
            array.set(0, array.get(n));
            array.set(n, temp);
            n--;
            fixHeap(array, 0, n, comparator);
        }
    }
    private static void fixHeap(List<A2Item> array, int rootIndex, int lastIndex, Comparator<A2Item> comparator){
        A2Item root = array.get(rootIndex);
        
        int index = rootIndex;
        boolean more = true;
        while(more){
            int childIndex = getLeftChildIndex(index);
            if(childIndex <= lastIndex){
                
                int rightChildIndex = getRightChildIndex(index);
                if(rightChildIndex <= lastIndex && comparator.compare(array.get(rightChildIndex), array.get(childIndex)) > 0){
                    childIndex = rightChildIndex;
                }
                
                if(comparator.compare(array.get(childIndex), root) > 0){
                    array.set(index, array.get(childIndex));
                    index = childIndex;
                }
                else{
                    more = false;
                }
            }
            else{
                more = false;
            }
        }
        array.set(index, root);
    }
    
    private static int getLeftChildIndex(int index){
        return 2 * index + 1;
    }
    
    private static int getRightChildIndex(int index){
        return 2 * index + 2;
    }
}
