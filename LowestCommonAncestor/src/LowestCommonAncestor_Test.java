import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LowestCommonAncestor_Test {

	
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
	public void testContains() {
		
		//add test
	}
	
	@Test 
	public void testHeight() {
		
		//add test
	}
	
}
