/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

import assignment1.A1Queue;

/**
 *
 * @author Ludwig
 */
public class MyQueue<E> implements A1Queue{
    
    int length;
    Node first;
    Node last;
    
    public void MyQueue(){
        length = 0;
        first = null;
        last = null;
    }

    @Override
    public void enqueue(Object element){
        if(first == null){
            first = new Node(element);
            last = first;
        }
        else{
            last.next = new Node(element);
            last = last.next;
        }
        length++;
    }
   
    @Override
    public Object dequeue(){
        Node toBeRemoved = first;
        first = first.next;
        length--;
        if(first == null){
            first = null;
        }
        return toBeRemoved.getValue();
    }
    
    @Override
    public Object peek(){
        return first.getValue();
    }
    
    @Override
    public int length(){
        return length;
    }
    
    public boolean isEmpty(){
        return first == null;
    }
    
    private class Node{
        Node next;
        Object elem;
        
        public Node(Object element){
            elem = element;
            next = null;
        }
        public Object getValue(){
            return elem;
        }
    }
}
