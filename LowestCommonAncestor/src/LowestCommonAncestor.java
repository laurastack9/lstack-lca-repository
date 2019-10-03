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

	public Key LCA(Node node, Key key1, Key key2) {
			return null;
	}
	
}