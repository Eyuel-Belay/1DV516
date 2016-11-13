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
public class MyTree implements A1Tree {
    
    /*
    Variables
    */
    int size;
    MyTreeNode root;
    
    /*
    Constructor for my Tree. 
    */
    public MyTree(){
        root = null;
        size = 0;
    }
    
    /*
    A method that returns the root of the tree
    */
    public A1TreeNode root(){
        return root;
    }
    
    /*
    Adds children to our tree. If the parent is null its assumed that its the root we are adding. 
    */
    public void addChild(MyTreeNode parent, MyTreeNode child){
        if(parent == null){
            root = child;
        }
        else{
            parent.children.enqueue(child);
            child.parent = parent;
        }
        size++;
    }
    
    /*
    Returns the size of the Tree
    */
    public int size(){
        return size;
    }
    
    /*
    Simple our method to get the printing of the tree started. If it is only one element the root will be printed,
    if its more objects it should print the children. The last part is only there since its needed, it shouldnt be 
    possible to get there.
    */
    public void printTree(){
        if(root.hasChildren()){
            System.out.println(root.element);
            printChildren(root, 0);
            System.out.println("");
        }
        else if(!root.hasChildren()){
            System.out.println(root.element);
        }
        else{
            System.out.println("Tree is Empty");
        }
    }
    
    /*
    A method that does the hard work of trying to print the tree into some visually nice JSON format again. It does not work completely since
    Im stuck and dont know how to move forward, and the first simpler method that i had i dont feel was sufficient. It hasnt been tried on
    larger inputs than some objects and arrays, so i dont know if it will be looking weird on larger inputs, but i tried my best.
    It checks for many different cases and if it is supposed to have indentation or not and such. 
    In the course forum it was stated that we could change the interface to match our own treenodes, so i changed that, hopefully
    i did not take too much freedom in that. 
    */
    public void printChildren(MyTreeNode n, int indent){
        String indentation = "";
        for(int i = 0; i < indent; i++){
            indentation += "\t";
        }
        
        int length = n.getChildren().length;
        for(int i = 0; i < length; i++){
            MyTreeNode temp = (MyTreeNode)n.getChildren().dequeue();
            if(temp.hasChildren()){
                System.out.println( temp.element);
                printChildren(temp, indent += 1);
            }
            else{
                if(temp.element.equals(":")){
                    System.out.print(temp.element + " ");
                }
                else if(temp.parent.element.equals("{") && temp.element.equals(",")){
                    System.out.println(temp.element);
                }
                
                else if(temp.parent.element.equals("[") && temp.element.equals(",")){
                    if(temp.parent.hasChildren()){
                        MyTreeNode secTemp = (MyTreeNode)n.getChildren().peek();
                        if(secTemp.element.equals("[") || secTemp.element.equals("{")){
                            System.out.print(temp.element + " ");
                        }
                        else{
                            System.out.println(temp.element);
                        }
                    }
                    else{
                        System.out.println(temp.element);
                    }
                }
                
                else if(i == (length - 2) && temp.parent.element.equals("[")){
                    System.out.println(indentation + temp.element);
                }
                else if(i == (length - 2) && temp.parent.element.equals("{")){
                    System.out.println(temp.element);
                }
                        
                else if(temp.element.equals("}")){
                    System.out.print(indentation + temp.element);
                }
                else if(temp.element.equals("]")){
                    System.out.println(indentation + temp.element);
                }
                else{
                    System.out.print(indentation + temp.element);
                }
            }
        }
    }
}
