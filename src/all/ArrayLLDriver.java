package all;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArrayLLDriver {

	static BufferedReader br;
	static ArrayLL myALL;
	
	public static void add() 
	throws IOException {
		System.out.print("Enter name => ");
		String name = br.readLine();
		if (!myALL.addFront(name)) {
			System.out.println("Could not add " + name + ", array is full");
		} else {
			System.out.println("Added " + name + " to front of list");
		}
	}
	
	public static void delete() {
		String name = myALL.deleteFront();
		if (name != null) {
			System.out.println("\tDeleted " + name + " from front of list");
		} else {
			System.out.println("Could not delete, list is empty");
		}
	}
	
	public static void searchName() 
	throws IOException {
		System.out.print("Enter name => ");
		String name = br.readLine();
		if (myALL.contains(name)) {
			System.out.println(name + " found in list");
		} else {
			System.out.println(name + " not found in list");
		}
	}
	
	public static void deleteName() 
	throws IOException {
		System.out.print("Enter name => ");
		String name = br.readLine();
		if (myALL.delete(name)) {
			System.out.println("\tDeleted " + name + " from list");
		} else {
			System.out.println("Name " + name + " not in list");
		}
		
	}
	
	public static int getChoice()
	throws IOException {
		System.out.println();
		System.out.println("1. Add front");
		System.out.println("2. Delete front");
		System.out.println("3. Delete name");
		System.out.println("4. Search name");
		System.out.println("5. Print List");
		System.out.println("6. Print Array");
		System.out.println("7. Print Available Spots");
		System.out.println("8. Quit");
		System.out.print("\tEnter Choice => ");
		Integer n = Integer.parseInt(br.readLine());
		while (n < 1 || n > 8) {
			System.out.print("\tYour choice must be between 1 and 7, reenter => ");
		}
		System.out.println();
		return n;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	throws IOException {
		myALL = new ArrayLL(10);
		br = new BufferedReader(new InputStreamReader(System.in));
		int choice;
		while ((choice = getChoice()) != 8) {
			switch(choice) {
			case 1: add(); break;
			case 2: delete(); break;
			case 3: deleteName(); break;
			case 4: searchName(); break;
			case 5: myALL.printList(); break;
			case 6: myALL.printArray(); break;
			case 7: myALL.printAvailableSpots(); break;
			}
		}

	}
}
