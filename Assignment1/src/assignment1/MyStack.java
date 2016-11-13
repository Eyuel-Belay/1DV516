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
    int size;
    Node top;
    
    public MyStack(){
        size = 0;
        top = null;
    }
    
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
    
    public Object pop(){
        Node nodeToBeRemoved = top;
        top = top.previous;
        if(top != null){
            top.next = null;
        }
        return nodeToBeRemoved.element;
    }
    
    public Object peek(){
        return top.element;
    }
    
    public int size(){
        return size;
    }
    
    private class Node{
        
        Object element;
        Node next;
        Node previous;
        
        public Node(Object elem){
            element = elem;
            next = null;
            previous = null;
        }
    }
}
