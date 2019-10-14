
public class DAG <Value>{

	private class Node {

		private Value val;					// Value stored in Node
		private Node[] successors;			// Array of nodes' successors

		public Node(Value val) {
			this.val = val;
		}
		
		private Node[] nodeList = new DAG.Node[0];
		
		
		public int size() { 
			return nodeList.length;  //returns number of nodes the DAG
		}
		
		public boolean isEmpty() { //method to check if the DAG is empty
			if (size()==0) {
				return true;
			}
			else {
				return false;
			}
		}
	}
}