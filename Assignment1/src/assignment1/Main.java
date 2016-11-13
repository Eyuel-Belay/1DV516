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
    /*
    Sets up and tries the methods in main
    */
    public static void main(String[] args) {
        // TODO code application logic here
        Main main = new Main();
        MyQueue queue = (MyQueue)main.constructQueue("json.txt");
        MyTree tree = (MyTree)main.constructTree(queue);
        main.printTree(tree);
    }
    
    /*
    Takes a file and reads it content and then adds it to our Queue and then returns the filled queue
    */
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
    
    /*
    A method which populates a Tree and the returns it
    */
    public A1Tree<String> constructTree(A1Queue<String> jsonQueue){
        /*
        Sets up variables we will be using and adds to the root
        */
        MyTree myTree = new MyTree();
        MyTreeNode root = new MyTreeNode(jsonQueue.dequeue());
        MyTreeNode child;
        MyStack<MyTreeNode> parentsStack = new MyStack<>();
        
        /*
        Json files must start with an array or object, so we make sure thats the case,
        by setting the root, and if its not we simply print that its not starting right
        */
        if(root.isJsonObject() || root.isJsonArray()){
            parentsStack.push(root);
            myTree.addChild(null, (MyTreeNode)parentsStack.peek());
        }
        else{
            System.out.println("Systax Error in JSON file");
        }
        
        /*
        A while loop that populates the tree. We basically have three different cases,
        the first case where the treenode we are adding is a JSONArray or JSONObject,
        and if thats the case we need to keep track of it so we take it out of our queue,
        add it to our tree and pushes it to the top of our stack keeping track of the parents.
        Then the second case where we are closing our JSONArray or JSONObject where we take
        out the object from the queue, add it to the tree while popping it off the parentstack.
        Then we have the last case where it is simply a primitive value, and we add it to the
        tree by adding it to the parent that is currently on top of the parentstack. We then
        return the filled tree.
        */
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
    
    /*
    A method that prints the tree by calling our A1Tree printTree method
    */
    public void printTree(A1Tree<String> jsonTree){
        jsonTree.printTree();
    }
    
}
