import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LowestCommonAncestor_Test {

	
	@Test
	public void testDAGLCA() {
		//test to be written here for testing LCA for a DAG
		//to be updated
	}
	
	
	@Test
	public void testLCA() {
		
		LowestCommonAncestor<Integer, Integer> BST = new LowestCommonAncestor<Integer, Integer>();
		
		assertSame("Testing LCA for null root", null, BST.LCA(BST.root,  1,  2));
		
		
		BST.put(8, 8);   //        _8_
		BST.put(9, 9);   //      /     \
		BST.put(5, 5);   //    _5_      9
		BST.put(3, 3);   //  /     \
		BST.put(4, 4);   // 3       7
		BST.put(7, 7);   //  \     /
		BST.put(6, 6);   //   4   6    
		
		assertSame("Testing LCA left side", 5, BST.LCA(BST.root,4,7));
		assertSame("Testing LCA right side", 8, BST.LCA(BST.root,5,9));
		assertSame("Testing LCA where LCA is one of the nodes.", 8, BST.LCA(BST.root, 7,8));
		assertSame("Testing LCA where LCA is one of the nodes.", 5, BST.LCA(BST.root, 3,5));
	}
	
	@Test
	public void testPut() {
		LowestCommonAncestor<Integer, Integer> LCA = new LowestCommonAncestor<Integer, Integer>();
		LCA.put(1, null);
		LCA.put(10, 1);
		LCA.put(15,2);
		LCA.put(15, 15);	 

		assertEquals("Putting nodes", "(()10(()15()))", LCA.printKeysInOrder());
	}
	
	@Test
	public void testDelete() {
		LowestCommonAncestor<Integer, Integer> LCA = new LowestCommonAncestor<Integer, Integer>();
		LCA.delete(1);
		assertEquals("Deleting from empty tree", "()", LCA.printKeysInOrder());

		LCA.put(7, 7);   //        _7_
		LCA.put(8, 8);   //      /     \
		LCA.put(3, 3);   //    _3_      8
		LCA.put(1, 1);   //  /     \
		LCA.put(2, 2);   // 1       6
		LCA.put(6, 6);   //  \     /
		LCA.put(4, 4);   //   2   4
		LCA.put(5, 5);   //        \
		//                           5

		assertEquals("Checking order of constructed tree",
				"(((()1(()2()))3((()4(()5()))6()))7(()8()))", LCA.printKeysInOrder());

		LCA.delete(9);
		assertEquals("Deleting non-existent key",
				"(((()1(()2()))3((()4(()5()))6()))7(()8()))", LCA.printKeysInOrder());

		LCA.delete(8);
		assertEquals("Deleting leaf", "(((()1(()2()))3((()4(()5()))6()))7())", LCA.printKeysInOrder());

		LCA.delete(6);
		assertEquals("Deleting node with single child",
				"(((()1(()2()))3(()4(()5())))7())", LCA.printKeysInOrder());

		LCA.delete(3);
		assertEquals("Deleting node with two children",
				"(((()1())2(()4(()5())))7())", LCA.printKeysInOrder());
	}
	
	@Test
	public void testDAGContains(){
		DAG<Integer> dag = new DAG <Integer>();

		assertEquals("Checking contains() on empty dag.", false, dag.contains(10));

		dag.put(7, null, null); 		//        (7)
		dag.put(8, 7, null);   			//   	  (7) -> (8) -> 10
		for(int i = 0; i<1; i++) {
			System.out.println(dag.toString());
		}
		System.out.println(dag.size());
	//	assertEquals("Checking DAG contains() a particular Value.", true, dag.contains(8));
	}

	@Test
	public void testDAGEmpty() {
		DAG<Integer> dag = new DAG<Integer>();
		assertEquals("Checking isEmpty() on empty dag.", true, dag.isEmpty());
		dag.put(1, null, null);
		//add a value 1 with null to and from pointers (its the first value)
		System.out.println(dag.size());
		assertEquals("Checking isEmpty() on empty dag.", false, dag.isEmpty());
	}
	
	@Test 
	public void testContains() {
		
		//add test
	}
	
	@Test 
	public void testHeight() {
		
		//add test
	}
	
}
