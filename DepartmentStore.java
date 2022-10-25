//Name: Progga Paromita Dutta
// Id: 114751436
// Recitation section-5
/**
 * This is the class where all the operations on lists will be performed
 * @author Progga Paromita Dutta
 */

import java.util.Scanner;
public class DepartmentStore {
/** 
 * This is the main method which makes use of all of the classes
 * @param args unused
 */
	public static void main(String[] args) {
		System.out.println("Welcome!");
		System.out.println("C - Clean Store");
		System.out.println("I - Insert an item into the list");
		System.out.println("L - List by location");
		System.out.println("M - Move an item in the store");
		System.out.println("O - Checkout");
		System.out.println("P -Print all items in store");
		System.out.println("R - Print by RFID tag number");
		System.out.println("U - Update inventory system");
		System.out.println("Q - Exit the program");
		char ch,ch1;
		ItemList a=new ItemList();// create a new Itemlist object
		do {
			System.out.println("Please select an option:");
			Scanner input=new Scanner(System.in);
			ch=input.next().charAt(0);
			ch1=Character.toUpperCase(ch);
			switch(ch1)
			{
			case 'I':
			{
				System.out.println("Enter the name:");
				input.nextLine();
				String s1=input.nextLine();
				System.out.println("Enter the RFID:");
				String s2=input.nextLine();
				System.out.println("Enter the original location:");
				String s3=input.nextLine();
				System.out.println("Enter the price:");
				double price=input.nextDouble();
				a.insertInfo(s1, s2, price, s3);// call the insert method to insert information
				break;
			}
			case 'P':
			{
				a.printAll();// calling printAll method to print the informations
				break;
			}
			case 'M':
			{
				System.out.println("Enter the RFID:");
				input.nextLine();
				String s1=input.nextLine();
				System.out.println("Enter the original location:");
				String s2=input.nextLine();
				System.out.println("Enter the new location:");
				String s3=input.nextLine();
				a.moveItem(s1, s2, s3);// calling the method to move the item from source to destined location
				break;
				
			}
			case 'O':
			{
				System.out.println("Enter the cart number:");
				input.nextLine();
				String s1=input.nextLine();
				double p=a.checkOut(s1);// calling the method to print out the checked item
				System.out.println("The total cost for all merchandise in cart " +s1.substring(1,4)+" was $"+p);
				break;
				
			}
			case 'L':
			{
				System.out.println("Enter the location:");
				input.nextLine();
				String s1=input.nextLine();
				a.printByLocation(s1);// calling the method to print the items with currentlocation given
				break;
			}
			case 'C':
			{
				System.out.println("The following item(s) have been moved back to their original locations:");
				a.cleanStore();// calling the method to restore the original position
				break;
			}
			case 'U':
			{
				System.out.println("The following item(s) have removed from the system:");
				a.removeAllPurchased();// calling the method to removing the purchased items
				break;
			}
			case'R':
			{
				System.out.println("Enter the tag number:");
				input.nextLine();
				String s1=input.nextLine();
				a.printTagNumber(s1);//calling the method to print the items in given tag number
				break;
			}
			case 'Q':
			{
				//Quitting the program
				System.out.println("Goodbye!");
				break;
			}
			}
		}while(ch1!='Q');
		

	}

}
