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
        Main main = new Main();
        MyQueue queue = (MyQueue)main.constructQueue("json.txt");
        MyTree tree = (MyTree)main.constructTree(queue);
        main.printTree(tree);
    }
    
    public A1Queue<String> constructQueue(String jsonFilename){
        A1Queue queue = new MyQueue();
        
        try{
            File inputFile = new File(jsonFilename);
            Scanner in = new Scanner(inputFile);
            while(in.hasNextLine()){
                queue.enqueue(in.nextLine().toString().trim());
            }
            in.close();
        }
        
        catch(Exception e){
            e.printStackTrace();
        }
        return queue;
    }
    
    public A1Tree<String> constructTree(A1Queue<String> jsonQueue){
        MyTree myTree = new MyTree();
        MyTreeNode root = new MyTreeNode(jsonQueue.dequeue());
        MyTreeNode child;
        MyStack<MyTreeNode> parentsStack = new MyStack<>();
        
        if(root.isJsonObject()){
            parentsStack.push(root);
            myTree.addChild(null, (MyTreeNode)parentsStack.peek());
        }
        else{
            System.out.println("Systax Error in JSON file");
        }
        
        
        while(!(jsonQueue.length() == 0)){
            
            MyTreeNode temp = new MyTreeNode(jsonQueue.peek());
            
            if(temp.isJsonObject() || temp.isJsonArray()){
                child = new MyTreeNode(jsonQueue.dequeue());
                myTree.addChild((MyTreeNode)parentsStack.peek(), child);
                parentsStack.push(child);
            }
            
            else if(temp.element.equals("}") || temp.element.equals("]")){
                child = new MyTreeNode(jsonQueue.dequeue());
                myTree.addChild((MyTreeNode)parentsStack.pop(), child);
            }
            
            else{
                child = new MyTreeNode(jsonQueue.dequeue());
                myTree.addChild((MyTreeNode)parentsStack.peek(), child);
            }
        }
        return myTree;
    }
    
    public void printTree(A1Tree<String> jsonTree){
        jsonTree.printTree();
    }
    
}
