import java.util.ArrayList;

/**
 * FibonacciHeap
 *
 * An implementation of Fibonacci heap over positive integers.
 *
 */
public class FibonacciHeap
{
	public HeapNode min;
	public int size;
	public int totalLinks;
	public int totalCuts;
	public int numTrees;
	public int c;
	
	/**
	 *
	 * Constructor to initialize an empty heap.
	 * pre: c >= 2.
	 *
	 */
	public FibonacciHeap(int c)
	{
		this.min = null;
		this.size = 0;
		this.totalCuts = 0;
		this.totalLinks = 0;
		this.numTrees = 0;
		this.c = c;
	}

	// utility function for insert
	public void insertAfter(HeapNode node1, HeapNode node2)
	{
		node2.next = node1.next;
		node1.next.prev = node2;
		node1.next = node2;
		node2.prev = node1;
	}

	/**
	 * 
	 * pre: key > 0
	 *
	 * Insert (key,info) into the heap and return the newly generated HeapNode.
	 *
	 */
	public HeapNode insert(int key, String info) 
	{    
		if (min == null) {
			this.size ++;
			this.numTrees ++;
		}
		
		HeapNode node = new HeapNode(key,info);

		if (this.min == null) {
			this.min = node;
			node.next = node;
			node.prev = node;
		}
		else{
			insertAfter(this.min, node);

			if (this.min.key > key){
				this.min = node;
			}
		}
	
		return node; 
	}

	/**
	 * 
	 * Return the minimal HeapNode, null if empty.
	 *
	 */
	public HeapNode findMin()
	{
		return null; // should be replaced by student code
	}

	/**
	 * 
	 * Delete the minimal item.
	 * Return the number of links.
	 *
	 */
	public HeapNode pull(HeapNode node) //take out node from linkedList, returns its prev
	{
		HeapNode before = node.prev;
		HeapNode after = node.next;

		before.next = after;
		after.prev = before;

		return before;
	}
	
	public ArrayList<Integer> addZeroUpTo(ArrayList<Integer> list, int to)
	{		
		while (list.size() <= to){
			list.add(0);
		}
		list.add(1);

		return list;
	}
	
	public void toBucket(HeapNode x)
	{
		ArrayList<Integer> B = new ArrayList<>();

		x.prev.next = null;

		while(x != null)
		{
			HeapNode y = x;
			x = x.next;
			int Brank = y.rank;

			if (B.size() >= Brank)
				while ( B[Brank]!= null ){

			}
		}
	}

	public int consolidate(){
		return 0;
	}
	
	
	public int deleteMin()
	{
		java.util.ArrayList<Object> buckets = new java.util.ArrayList<>();

		if (this.size == 0) //empty tree
			return 0;

		size --; 

		if (this.size == 1) //one node tree
		{
			this.min = null;
			this.numTrees --;
			return 0;
		}
		
		//else
		HeapNode childList = this.min.child ;  // can be null 
		this.min = pull(this.min); //pulls out min from listOfTrees, replaces min with its prev

		if (childList != null) // meld two lists
		{
			childList.parent = null;
			meldByTwoNodes(this.min, childList); 
		}

		//total links += consolidating

		
		return 46; // should be replaced by student code

	}

	/**
	 * 
	 * pre: 0<diff<x.key
	 * 
	 * Decrease the key of x by diff and fix the heap.
	 * Return the number of cuts.
	 * 
	 */
	public int decreaseKey(HeapNode x, int diff) 
	{    
		return 46; // should be replaced by student code
	}

	/**
	 * 
	 * Delete the x from the heap.
	 * Return the number of links.
	 *
	 */
	public int delete(HeapNode x) 
	{    
		return 46; // should be replaced by student code
	}


	/**
	 * 
	 * Return the total number of links.
	 * 
	 */
	public int totalLinks()
	{
		return this.totalLinks;
	}


	/**
	 * 
	 * Return the total number of cuts.
	 * 
	 */
	public int totalCuts()
	{
		return this.totalCuts; 
	}



	public void meldByTwoNodes(HeapNode x, HeapNode y){

		HeapNode nextX = x.next;
		HeapNode prevY = y.prev;

		x.next = y;
		y.prev = x;

		nextX.prev = prevY; 
		prevY.next = nextX;
	}
	/**
	 * 
	 * Meld the heap with heap2
	 *
	 */
	public void meld(FibonacciHeap heap2)
	{
		meldByTwoNodes(this.min, heap2.min); 
		
		if(heap2.min.key < this.min.key)
			this.min = heap2.min;
		
	}

	/**
	 * 
	 * Return the number of elements in the heap
	 *   
	 */
	public int size()
	{
		return this.size; 
	}


	/**
	 * 
	 * Return the number of trees in the heap.
	 * 
	 */
	public int numTrees()
	{
		return this.numTrees; 
	}

	/**
	 * Class implementing a node in a Fibonacci Heap.
	 *  
	 */
	public static class HeapNode{
		public int key;
		public String info;
		public HeapNode child;
		public HeapNode next;
		public HeapNode prev;
		public HeapNode parent;
		public int rank;
		public int mark;

		public HeapNode(int key, String info){
			this.key = key;
			this.info = info;
			this.rank = 0;
			this.mark = 0;
		}
	}
}
