/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author LudeersBärbara
 */
public class MyList<E> {
    
    Node first;
    Node last;
    int length;
    
    public void MyList(){
        length = 0;
        first = null;
    }
    public void add(E element){
        if(first == null){
            first = new Node(element);
            last = first;
        }
        else{
            last.next = new Node(element);
            last = last.next;
        }
    }
    
    public int length(){
        return length;
    }
    private class Node{
        
        Node next;
        E element;
        
        public Node(E elem){
            element = elem;
            next = null;
        }
    }
    private class MyIterator implements Iterator<Node>{
       
        Node cursor;
        
        public MyIterator(){
            if(first == null){
                System.out.println("First item in list is null");
            }
            cursor = first;
        }
        
        public Node next(){
            if(hasNext()){
                Node current = cursor;
                cursor = cursor.next;
                return current;
            }
            throw new NoSuchElementException();
        }
        public boolean hasNext(){
            if(cursor.next != null){
                return true;
            }
            else
                return false;
        }
    }
}
