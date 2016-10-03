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
public class MyQueue<E> implements A1Queue<E>{
    
    int length;
    Node first;
    Node last;
    
    public void MyQueue(){
        length = 0;
        first = null;
        last = null;
    }

    @Override
    public void enqueue(E element){
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
    public E dequeue(){
        Node toBeRemoved = first;
        if(first.next != null){
            first = first.next;
        }
        if(first.next == null){
            first = null;
            last = null;
        }
        length--;
        return toBeRemoved.getValue();
    }
    
    @Override
    public E peek(){
        return first.getValue();
    }
    
    @Override
    public int length(){
        return length;
    }
    
    public boolean isEmpty(){
        if(first == null){
            return true;
        }
        else
            return false;
    }
    
    private class Node{
        Node next;
        E elem;
        
        public Node(E element){
            elem = element;
        }
        public E getValue(){
            return elem;
        }
    }
}
