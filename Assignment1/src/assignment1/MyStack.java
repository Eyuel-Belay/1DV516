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
public class MyStack<E> implements A1Stack<E> {
    int size;
    Node top;
    
    public MyStack(){
        size = 0;
        top = null;
    }
    
    public void push(E element){
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
    
    public E pop(){
        Node nodeToBeRemoved = top;
        top = top.previous;
        top.next = null;
        return nodeToBeRemoved.element;
    }
    
    public E peek(){
        return top.element;
    }
    
    public int size(){
        return size;
    }
    
    private class Node{
        
        E element;
        Node next;
        Node previous;
        
        public Node(E elem){
            element = elem;
            next = null;
            previous = null;
        }
    }
}
