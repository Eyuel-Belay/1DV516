/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

/**
 *
 * @author LudeersBärbara
 */
public class MyStack<E> implements A1Stack {
    /*
    Variables
    */
    int size;
    Node top;
    
    /*
    Constructor for MyStack
    */
    public MyStack(){
        size = 0;
        top = null;
    }
    
    /*
    A method that pushes an Object to the top of the stack
    */
    public void push(Object element){
        if(top == null){
            top = new Node(element);
        }
        else{
            top.next = new Node(element);
            Node oldNode = top;
            top = top.next;
            top.previous = oldNode;
        }
        size++;
    }
    
    /*
    A method which removes the Object from the top and returns it
    */
    public Object pop(){
        Node nodeToBeRemoved = top;
        top = top.previous;
        if(top != null){
            top.next = null;
        }
        return nodeToBeRemoved.element;
    }
    
    /*
    A method which returns the value of the top Object, without removing it
    */
    public Object peek(){
        return top.element;
    }
    
    /*
    A method which returns the size of the Stack
    */
    public int size(){
        return size;
    }
    
    /*
    Our private class of Nodes, used to structure the Stack
    */
    private class Node{
        
        /*
        Variables
        */
        Object element;
        Node next;
        Node previous;
        
        /*
        Constructor of our private Node
        */
        public Node(Object elem){
            element = elem;
            next = null;
            previous = null;
        }
    }
}
