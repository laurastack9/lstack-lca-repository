import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testDAGLCA {

	@Test
	public void testForDirectedGraph(){
		DAG test = new DAG(10);
		test.addEdge(1, 2);
		test.addEdge(1, 3);
		test.addEdge(3, 4);
		test.addEdge(4, 5);
		test.addEdge(4, 6);

		assertEquals("", 1, test.indegree(4));
		assertEquals("", 2, test.outdegree(4));
		assertEquals("", 5, test.E());
		assertEquals("", 10, test.V());
		String ans = "[5, 6]";
		assertEquals("",ans, test.adj(4).toString());
	}


	@Test
	public void testAddEdge(){
		DAG test4 = new DAG(5);
		test4.addEdge(3, 9);
		test4.addEdge(-2, -5);	
	}

	@Test
	public void testinDegree(){
		DAG test5 = new DAG(5);
		assertEquals("", -1, test5.indegree(-3));
	}

	@Test
	public void testOutDegree(){
		DAG test6 = new DAG(5);
		assertEquals("", -1, test6.outdegree(8));	
	}



	//Directed graph isnt necessary directed acyclic graph, so will need to ensure it is a DAG.
	@Test
	public void testsForCycle(){
		DAG cyclic = new DAG(20);
		cyclic.addEdge(0, 1);
		cyclic.addEdge(1, 2);
		cyclic.addEdge(2, 0);

		//Parameter is first vertex
		cyclic.findCycle(0);

		//Cycle from 0 - 1 - 2 - 0, should return true.
		assertTrue(cyclic.hasCycle());

		DAG acyclic = new DAG(20);
		acyclic.addEdge(0, 1);
		acyclic.addEdge(1, 3);
		acyclic.addEdge(2, 4);
		//Parameter is first vertex
		acyclic.findCycle(0);
		//No Cycle,return false
		assertFalse(acyclic.hasCycle());
	}


}
