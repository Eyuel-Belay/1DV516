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
public class MyTreeNode<E> implements A1TreeNode<E> {
    
    E element;
    MyTreeNode<E> parent;
    String elementString;
    
    public MyTreeNode(E elem){
        element = elem;
        parent = null;
        elementString = element.toString();
    }
    
    public boolean isJsonObject(){
        if(elementString.equals("{") || elementString.equals("}")){
            return true;
        }
        else
            return false;
    }
    public boolean isJsonArray(){
        if(elementString.equals("[") || elementString.equals("]")){
            return true;
        }
        else
            return false;
    }
    public boolean isJsonPrimitive(){
        if(isJsonObject() || isJsonArray()){
            return false;
        }
        else
            return true;
    }
}
