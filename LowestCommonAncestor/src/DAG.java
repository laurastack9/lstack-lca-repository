
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

		public boolean isEmpty() {  //method to check if the DAG is empty
			if (size()==0) {
				return true;
			}
			else {
				return false;
			}
		}

		// Converts value to a Node by taking a value and returning associated Node. 
		public Node retrieveNodefromValue (Value v){
			Node nodeToRetrieve = new Node(null); 				
			for (int i=0; i<nodeList.length; i++){
				if (nodeList[i].val == v){
					nodeToRetrieve = nodeList[i];
					break;			
				}	
			}
			return nodeToRetrieve;
		}

		public void put(Value v, Value fromVal, Value toVal) {	
			Node n = new Node(v);
			Node from = retrieveNodefromValue(fromVal);
			Node to = retrieveNodefromValue(toVal);

			if (fromVal != null) {
				from.successors = extendArray(from.successors); 
				from.successors[from.successors.length-1] = n;
				if (from.val == null) {
					// If 'from' Node is not already in the graph? To be updated
				}
			}

			if (toVal != null) {
				//where does this get connected to?
			}
		}

		// To extend the array 
		@SuppressWarnings("unchecked")
		public Node[] extendArray(Node[] originalArray) {
			Node[] newArray = new DAG.Node[originalArray.length+1];
			System.arraycopy(originalArray, 0, newArray, 0, originalArray.length);
			return newArray;
		}

	}





}
