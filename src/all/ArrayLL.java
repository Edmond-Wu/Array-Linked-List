package all;

class Item 
{
	String name;
	int next;
	public Item(String name, int next) 
	{
		this.name = name;
		this.next = next;
	}
	public String toString() 
	{
		return "(" + name + "," + next + ")";
	}
}

public class ArrayLL 
{

	private Item[] all;
	private int numItems;
	private int front;
	private int[] avail;
	private int numAvail;

	// Constructor, initializes all data fields, to represent 
	// an empty Item array linked list of length maxItems
	public ArrayLL(int maxItems)
	{
		all = new Item[maxItems];
		avail = new int[maxItems];
		for (int n = 0; n < avail.length; n++)
		{
			avail[n] = n;
		}
		numAvail = maxItems;
		numItems = 0;
		front = -1;
	}

	// Adds a name to the front of this array linked list, in worst case O(1) time,
	// and returns true.
	// Returns false if the array is full, in O(1) time
	public boolean addFront(String name) 
	{
		if (numAvail == 0)
			return false;
		else
		{
			int old = front;
			front = avail[numAvail - 1];
			
			if (numItems == 0)
			{
				all[front] = new Item(name, -1);
			}
			
			all[front] = new Item(name, old);
			numAvail--;
			numItems++;
			return true;
		}
	}

	// Deletes the name that is at the front this array linked list, in worst case O(1) time,
	// and returns the deleted name
	// Returns null if the list is empty, in O(1) time
	public String deleteFront() 
	{
		int oldFront = front;
		
		if (numAvail == all.length)
		{
			return null;
		}
		
		avail[numAvail] = front;
		String deleted = all[front].name;
		front = all[front].next;
		
		all[oldFront] = null;
		numAvail++;
		numItems--;
		
		return deleted;
	}

	// Deletes the given name from this array linked list, and returns true.
	// Returns false if the name is not in the list.
	// Note: If there are n active items in the list, then this method must run in
	// worst case O(n) time, i.e. time must not depend on the length of the all array
	// (since the array might include available space not filled by active items)
	// Also, avail array should be accessed/updated in O(1) time
	public boolean delete(String name) 
	{
		if (numItems == 0)
		{
			return false;
		}
		
		int ptr = all[front].next;
		int prev = front;
		
		if (all[front].name.equals(name))
		{
			avail[numAvail] = front;
			all[prev] = null;
			front = ptr;
			numItems--;
			numAvail++;
			return true;
		}
		
		for (int n = 0; n < numItems - 1; n++)
		{
			if (all[ptr].name.equals(name))
			{
				avail[numAvail] = ptr;
				all[prev].next = all[ptr].next;
				all[ptr] = null;
				numItems--;
				numAvail++;
				return true;
			}
			prev = ptr;
			ptr = all[ptr].next;
		}
		return false;
	}

	// Checks if the given name is in this array linked list
	// Note: If there are n items in the list, then this method must run in
	// worst case O(n) time, i.e. time does not depend on the length of the all array.
	public boolean contains(String name) 
	{
		if (numItems == 0)
		{
			return false;
		}
		
		int ptr = front;
		for (int n = 0; n < numItems; n++)
		{
			if (all[ptr].name.equals(name))
				return true;
			ptr = all[ptr].next;
		}
		return false;
	}

	// Prints the items in this array linked list in sequence from first to last,
	// in worst case O(n) time where n is the number of items in the linked list
	// The list should be printed in a single line, separated by commas
	// Example: earth,mercury,venus
	// Make sure there aren't any extra commas in your output.
	// If the list is empty, you may print either nothing, or an empty string
	public void printList() 
	{
		int ptr = front;
		if (numItems == 0)
			return;
		for (int n = 0; n < numItems - 1; n++)
		{
			System.out.print(all[ptr].name + ",");
			ptr = all[ptr].next;
		}
		System.out.print(all[ptr].name);
	}
	
	public void printArray() 
	{
		
	}
	
	public void printAvailableSpots()
	{
		
	}
}
