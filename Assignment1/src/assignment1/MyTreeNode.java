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
public class MyTreeNode implements A1TreeNode {
    
    
    /*
    Variables 
    */
    Object element;
    MyQueue<MyTreeNode> children;
    MyTreeNode parent;
    
    /*
    Constructor for my TreeNode
    */
    public MyTreeNode(Object elem){
        element = elem;
        children = new MyQueue<>();
    }
    
    /*
    A method that checks if the value is a JSONObject and returns true if it is, otherwise false
    */
    @Override
    public boolean isJsonObject(){
        return element.equals("{");
    }
    
    /*
    A method that checks if the the value is a JSONArray and returns true if it is, otherwise false
    */
    @Override
    public boolean isJsonArray(){
        return element.equals("[");
    }
    
    /*
    Checks if the node is a JSONobject or JSONarray or not, and if it not it can only be primitive
    */
    @Override
    public boolean isJsonPrimitive(){
        return !(isJsonObject() || isJsonArray());
    }
    
    /*
    A method that returns the queue with children treenodes
    */
    public MyQueue<MyTreeNode> getChildren(){
        return children;
    }
    
    /*
    A method that checks if the node has a queue with children. If it does it returns true,
    otherwise false
    */
    public boolean hasChildren(){
        return !children.isEmpty();
    }
}
