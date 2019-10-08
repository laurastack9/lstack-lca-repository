import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LowestCommonAncestor_Test {

	
	@Test
	public void testLCA() {
		
		LowestCommonAncestor<Integer, Integer> LCA = new LowestCommonAncestor<Integer, Integer>();
		LCA.put(9, 9);   //        _9_
		LCA.put(8, 8);   //      /     \
		LCA.put(2, 2);   //    _2_      8
		LCA.put(3, 3);   //  /     \
		LCA.put(5, 5);   // 3       6
		LCA.put(6, 6);   //  \     /
		LCA.put(4, 4);   //   5   4
		LCA.put(1, 1);   //        \
						 //         1
		
		assertEquals("Testing LCA left side", 2, LCA.LCA(LCA.root,5,6));
		assertEquals("Testing LCA right side", 9, LCA.LCA(LCA.root,8,2));
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
