/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Ludwig
 */
public class Main implements A1Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    public A1Queue<String> constructQueue(String jsonFilename){
        try{
            File inputFile = new File(jsonFilename);
            Scanner in = new Scanner(inputFile);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        A1Queue queue = new MyQueue();
        return queue;
    }
    
    public A1Tree<String> constructTree(A1Queue<String> jsonQueue){
        A1Tree<String> myTree = new MyTree<String>();
        while(jsonQueue.length() > 0){
            MyTreeNode<String> myNode = new MyTreeNode(jsonQueue.dequeue());
            if(myTree.root() == null){
                myTree.addChild(null, myNode);
            }
        }
        return myTree;
    }
    
    public void printTree(A1Tree<String> jsonTree){
        jsonTree.printTree();
    }
    
}
