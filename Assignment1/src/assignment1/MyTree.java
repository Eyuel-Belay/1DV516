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
public class MyTree<E> implements A1Tree<E> {
    
    int size;
    A1TreeNode root;
    
    public MyTree(){
        root = null;
        size = 0;
    }
    
    public A1TreeNode<E> root(){
        return root;
    }
    public void addChild(A1TreeNode<E> parent, A1TreeNode<E> child){
        if(parent == null){
            root = child;
        }
        if(parent.isJsonObject()){
            
        }
        
        if(parent.isJsonArray()){
            
        }
        
    }
    public int size(){
        return size;
    }
    
    public void printTree(){
        
    }
}
