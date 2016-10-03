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
    
    public MyTreeNode(E elem){
        this.element = elem;
    }
    
    public boolean isJsonObject(){
        //TODO: implement
        return true;
    }
    public boolean isJsonArray(){
        //TODO: implement
        return true;
    }
    public boolean isJsonPrimitive(){
        return true;
        //TODO: implement
    }
}
