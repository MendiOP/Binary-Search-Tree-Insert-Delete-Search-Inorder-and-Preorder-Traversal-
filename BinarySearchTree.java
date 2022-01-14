package Offlines;

import java.util.Scanner;

class  Node{
    int key;
    Node leftChild;
    Node rightChild;

    public Node(int key){
        this.key = key;
        leftChild = null;
        rightChild = null;
    }
}

public class BinarySearchTree {
    Node root;

    BinarySearchTree(){
        root = null;
    }


    void insertElement(int key){
        root = recursivelyInsert(root,key);
    }

    //Inserting an element in the tree recursively.
    Node recursivelyInsert(Node root,int key){
        if(root == null)
            return new Node(key);

        if(key < root.key)
            root.leftChild = recursivelyInsert(root.leftChild , key);
        else if(key > root.key)
            root.rightChild  = recursivelyInsert(root.rightChild , key);

        return root;
    }

    boolean Search(int key){
        root = recursivelySearch(root , key);
        if(root != null)
            return true;
        return false;
    }

    //Searching an element in the tree.
    Node recursivelySearch(Node root, int key){
        if(root == null || root.key == key){
            return root;
        }

        if(key < root.key){
            return recursivelySearch(root.leftChild , key);
        }
        else{
            return recursivelySearch(root.rightChild , key);
        }
    }

    void deleteElement(int key){
        root = recursivelyDelete(root,key);
    }

    Node recursivelyDelete(Node root, int key){
        //if no tree or no child
        if(root == null){
            return root;
        }

        if(key < root.key){
            root.leftChild = recursivelyDelete(root.leftChild , key);
        }
        else if(key > root.key){
            root.rightChild = recursivelyDelete(root.rightChild , key);
        }
        else {
            //one child
            if(root.leftChild == null){
                return root.rightChild;
            }
            else if(root.rightChild == null){
                return root.leftChild;
            }

            //two child
            root.key = rightChildMin(root.rightChild);

            root.rightChild = recursivelyDelete(root.rightChild , root.key);
        }

        return root;

    }
    //finding the minimum in the right subtree
    int rightChildMin(Node root){
        int minKey = root.key;
        while (root.leftChild != null)
        {
            minKey = root.leftChild.key;
            root = root.leftChild;
        }
        return minKey;
    }

    void Inordertravers(){
        recursivelyInordertravers(root);
    }

    void recursivelyInordertravers(Node root){
        if(root != null){
            recursivelyInordertravers(root.leftChild);
            System.out.println(root.key);
            recursivelyInordertravers(root.rightChild);
        }
    }

    void Preordertraverse(){
        recursivelyPreordertravers(root);
    }

    void recursivelyPreordertravers(Node root){
        if(root != null){
            System.out.println(root.key);
            recursivelyPreordertravers(root.leftChild);
            recursivelyPreordertravers(root.rightChild);
        }
    }

    public static void main(String [] args){
            /*
              50
           /     \
          30      70
         /  \    /  \
        20   40  60   80
        /        /     \
       10       55    120 */
        Scanner scan = new Scanner(System.in);
        int s;

        BinarySearchTree bst = new BinarySearchTree();
        bst.insertElement(50);
        bst.insertElement(70);
        bst.insertElement(30);
        bst.insertElement(20);
        bst.insertElement(40);
        bst.insertElement(60);
        bst.insertElement(80);
        bst.insertElement(10);
        bst.insertElement(55);
        bst.insertElement(120);

        System.out.println("");
        System.out.println("------------------- Inorder Traversal Below ------------------------");
        System.out.println("");

        System.out.println(
                "Inorder traversal of the given tree");
        bst.Inordertravers();

        System.out.println("\nDelete 20");
        bst.deleteElement(20);
        System.out.println(
                "Inorder traversal of the modified tree");
        bst.Inordertravers();

        System.out.println("\nDelete 30");
        bst.deleteElement(30);
        System.out.println(
                "Inorder traversal of the modified tree");
        bst.Inordertravers();

        System.out.println("\nDelete 50");
        bst.deleteElement(50);
        System.out.println(
                "Inorder traversal of the modified tree");
        bst.Inordertravers();

        //searching the element in the tree.
        System.out.print("Give the element for Search : ");
        s = scan.nextInt();
        if(bst.Search(s))
            System.out.println("The search element " + s + " in the tree found.");
        else
            System.out.println("The search element " + s + " in the tree not found.");

        System.out.println("");
        System.out.println("------------------- Preorder Traversal Below ------------------------");
        System.out.println("");

        //Preorder Traversal below.

        /*
              50
           /     \
          30      70
         /  \    /  \
        20   40  60   80
        /        /     \
       10       55    120 */


        BinarySearchTree bst1 = new BinarySearchTree();
        bst1.insertElement(50);
        bst1.insertElement(70);
        bst1.insertElement(30);
        bst1.insertElement(20);
        bst1.insertElement(40);
        bst1.insertElement(60);
        bst1.insertElement(80);
        bst1.insertElement(10);
        bst1.insertElement(55);
        bst1.insertElement(120);


        System.out.println(
                "Preorder traversal of the given tree");
        bst1.Preordertraverse();

        System.out.println("\nDelete 20");
        bst1.deleteElement(20);
        System.out.println(
                "Preorder traversal of the modified tree");
        bst1.Preordertraverse();

        System.out.println("\nDelete 30");
        bst1.deleteElement(30);
        System.out.println(
                "Preorder traversal of the modified tree");
        bst1.Preordertraverse();

        System.out.println("\nDelete 50");
        bst1.deleteElement(50);
        System.out.println(
                "Preorder traversal of the modified tree");
        bst1.Preordertraverse();

    }
}

