import java.util.NoSuchElementException;
import java.util.*;
import java.lang.*;

public class LowestCommonAncestor<Key extends Comparable<Key>, Value> {

	public LinkedHashSet<Key> keySet = new LinkedHashSet<Key>();	// all nodes in graph
	private LinkedHashSet<Key> orphanSet = new LinkedHashSet<Key>();	// all nodes with no requirement nodes
	
	Node root;
	
	/**
	 * Private node class.
	 */
	private class Node {
		private Key key;           // sorted by key
		private Value val;         // associated data
		private Node left, right;  // left and right subtrees
		private int N;             // number of nodes in subtree

		public Node(Key key, Value val, int N) {
			this.key = key;
			this.val = val;
			this.N = N;
		}
	}
	
	//Constructor for DAG
			public Object DirAcycGraph () {
				Object directAcyclicGraph = new Object();
				return directAcyclicGraph;
			}
	
	/**
	 *  Insert key-value pair into BST.
	 *  If key already exists, update with new value.
	 *
	 *  @param key the key to insert
	 *  @param val the value associated with key
	 */
	
	public void put(Key key, Value val) {
		if (val == null) { delete(key); return; }
		root = put(root, key, val);
	}

	private Node put(Node node, Key key, Value val) {
		if (node == null) return new Node(key, val, 1); //new bst
		int cmp = key.compareTo(node.key);
		if      (cmp < 0) node.left  = put(node.left,  key, val);
		else if (cmp > 0) node.right = put(node.right, key, val);
		else              node.val   = val; //updating value
		node.N = 1 + size(node.left) + size(node.right); // value child1 + value child2 + 1
		return node;
	}
	
	public boolean isEmpty() { 
		return size() == 0; 
	}
	
	// return number of key-value pairs in BST
		public int size() { 
			return size(root); 
		}

		public Node max(Node node)
		   {
		     if(node.right!=null) {
		       return max(node.right);
		     }
		     return node;
		   }
		
		// return number of key-value pairs in BST rooted at x
		private int size(Node x) {
			//BST is empty
			if (x == null) return 0;

			//N is number of nodes
			else return x.N;
		}
		
		/**
		 * Deletes a key from a tree (if the key is in the tree).
		 * Note that this method works symmetrically from the Hibbard deletion:
		 * If the node to be deleted has two child nodes, then it needs to be
		 * replaced with its predecessor (not its successor) node.
		 *
		 * @param key the key to delete
		 */
		public void delete(Key key) {
			root = delete(root, key);	
		}
		
		private Node delete (Node node, Key key) {
			if (node == null) { 
				return null;
			}
			
	        int compare = key.compareTo(node.key);
	        
	        if   (compare > 0) {
	        	node.right = delete(node.right, key);
	        	node.left  = delete(node.left,  key);
	        }
	        else if (compare < 0) {
	        	node.left  = delete(node.left,  key);
	        }
	        else {
	        	if (node.right == null) {
	        		return node.left;
	        	}
	            if (node.left  == null) {
	            	return node.right;
	            }
	            Node temp = node;
	            node = max(temp.left);                              
	            node.left = deleteMax(temp.left);                 
	            node.right = temp.right; 
	        }
	        
	        node.N = size(node.left) + size(node.right) + 1;
	        return node;
			
		}
		
		private Node deleteMax(Node node) 
	    {
	        if (node.right == null) return node.left;
	        node.right = deleteMax(node.right);
	        node.N = size(node.left) + size(node.right) + 1;                                 
	        return node;
	    }

		/**
		 * Print all keys of the tree in a sequence, in-order.
		 * That is, for each node, the keys in the left subtree should appear before the key in the node.
		 * Also, for each node, the keys in the right subtree should appear before the key in the node.
		 * For each subtree, its keys should appear within a parenthesis.
		 *
		 * Example 1: Empty tree -- output: "()"
		 * Example 2: Tree containing only "A" -- output: "(()A())"
		 * Example 3: Tree:
		 *   B
		 *  / \
		 * A   C
		 *      \
		 *       D
		 *
		 * output: "((()A())B(()C(()D())))"
		 *
		 * output of example in the assignment: (((()A(()C()))E((()H(()M()))R()))S(()X()))
		 *
		 * @return a String with all keys in the tree, in order, parenthesized.
		 */
		public String printKeysInOrder() {
			String res= "";
			if (isEmpty()){
				return res += "()";
			}
			else {
				return res = printKeysInOrder(root);
			}
		
		}
		
		 private String printKeysInOrder(Node node) {
			 String res = "";
			 if (node == null) {
				 return res += "()";
			 }
			 
			 else {
				return res += ("(" + printKeysInOrder(node.left) + node.key.toString() + printKeysInOrder(node.right) + ")");
			 }
			 
		 }
		
// I used this Binary Tree code last year in CS2010 Assignment 3 - used Sedgewick and Wayne book as a help source

// Used source: www.geeksforgeeks.org
// To help write the function
	public Key LCA(Node node, Key key1, Key key2) {
		if (node == null)
            return null;
		if (node == key1) {
			return node.key;
		}
		if (node.key == key2) {
			return node.key;
		}
		int compare1 = node.key.compareTo(key1);
		int compare2 = node.key.compareTo(key2);
		
        if (compare1 >= 0 && compare2 >= 0)
            return LCA(node.left, key1, key2);
  
        if (compare1 <= 0 && compare2 <= 0)
            return LCA(node.right, key1, key2);
  
        return node.key;
	}
	
}