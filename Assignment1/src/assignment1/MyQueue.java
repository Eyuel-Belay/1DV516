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
    
    /*
    Variables
    */
    int length;
    Node first;
    Node last;
    
    /*
    Constructor for MyQueue
    */
    public void MyQueue(){
        length = 0;
        first = null;
        last = null;
    }

    /*
    A method which puts and object at the end of the queue
    */
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
   
    /*
    A method which removes the first value in the queue, makes sure thata the first 
    Object becomes the next in the queue and  then returns the value of the removed
    Object.
    */
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
    
    /*
    A method that returns the value of the first Object in the Queue without removing it
    */
    @Override
    public Object peek(){
        return first.getValue();
    }
    
    /*
    A method that returns the length of the Queue
    */
    @Override
    public int length(){
        return length;
    }
    
    /*
    A method that checks if the queue is empty, returns true if it is,
    otherwise false
    */
    public boolean isEmpty(){
        return first == null;
    }
    
    /*
    Our private Node class that structures the Queue
    */
    private class Node{
        /*
        Variables
        */
        Node next;
        Object elem;
        
        /*
        Constructor for the node Object
        */
        public Node(Object element){
            elem = element;
            next = null;
        }
        /*
        A method that returns the value in the Node
        */
        public Object getValue(){
            return elem;
        }
    }
}
