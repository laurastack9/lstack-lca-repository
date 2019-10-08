import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LowestCommonAncestor_Test {

	
	@Test
	public void testLCA() {
		
		LowestCommonAncestor<Integer, Integer> BST = new LowestCommonAncestor<Integer, Integer>();
		BST.put(9, 9);   //        _9_
		BST.put(8, 8);   //      /     \
		BST.put(2, 2);   //    _2_      8
		BST.put(3, 3);   //  /     \
		BST.put(5, 5);   // 3       6
		BST.put(6, 6);   //  \     /
		BST.put(4, 4);   //   5   4
		BST.put(1, 1);   //        \
						 //         1
		
		assertEquals("Testing LCA left side", 2, BST.LCA(BST.root,5,6));
		assertEquals("Testing LCA right side", 9, BST.LCA(BST.root,8,2));
		assertEquals("Testing LCA left side", 3, BST.LCA(BST.root, 5,6).toString());
		assertEquals("Testing LCA right side", 7, BST.LCA(BST.root, 8,2).toString());
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
