import java.util.NoSuchElementException;

public class LowestCommonAncestor<Key extends Comparable<Key>, Value> {

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


// I used this BST constructor code last year in CS2010 Assignment 3 - used Sedgewick and Wayne book as a help source

// Used source: www.geeksforgeeks.org
// To help write the function
	public Key LCA(Node node, Key key1, Key key2) {
		if (node == null)
            return null;
		if (node.key == key1) {
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