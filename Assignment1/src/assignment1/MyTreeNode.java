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
    
    Object element;
    MyQueue<MyTreeNode> children;
    MyTreeNode parent;
    
    public MyTreeNode(Object elem){
        element = elem;
        children = new MyQueue<>();
    }
    
    @Override
    public boolean isJsonObject(){
        return element.equals("{");
    }
    
    @Override
    public boolean isJsonArray(){
        return element.equals("[");
    }
    
    @Override
    public boolean isJsonPrimitive(){
        return !(isJsonObject() || isJsonArray());
    }
    
    public MyQueue<MyTreeNode> getChildren(){
        return children;
    }
    
    public boolean hasChildren(){
        return !children.isEmpty();
    }
}
