//Name: Progga Paromita Dutta
//Id:114751436
//Recitation section-5

import java.util.NoSuchElementException;
/**
 * This class contains references to the head and tail of a list of ItemInfo nodes.
 * @author Progga Paromita Dutta
 *
 */
public class ItemList{
	ItemInfoNode head;
	ItemInfoNode tail;
	private int size;
/**
 * The default constructor for the list which sets its head and tail to null
 */
public ItemList()
{  
  head=tail=null;
  size=0;
}
public int getSize()
{
	return size;
}
/**
 * This method inserts info  into the list in its current position based on its rfId tag number
 * @param name-the name that is to be set
 * @param rfidTag- the tag number that is to be set
 * @param price-the price that has to be set
 * @param initPosition-the original position where the item will be at shelf
 * The order complexity for this method is O(size)=O(N)+the size of the list
 * As there is a while loop which iterates through the size of the elements if an item has to be added at last
 */ 
public void insertInfo(String name, String rfidTag, double price, String initPosition) {
	ItemInfo p=new ItemInfo();
	// setting the name, tag, position of an item
	p.setName(name);
	p.setrfId(rfidTag);
	p.setPrice(price);
	p.setOriginalLocation(initPosition);
	p.setCurrentLocation(initPosition);
	ItemInfoNode newNode=new ItemInfoNode(p);
	
	//start the current node from head
	ItemInfoNode current=head;
	// if the list is empty
	if(head==null)
	{
		if(newNode.getInfo().getrfId()!=null&&newNode.getInfo().getOriginalLocation()!=null&&newNode.getInfo().getCurrentLocation()!=null&& newNode.getInfo().getPrice()!=0) {
		  head=newNode;
		  tail=newNode;
		  size++; // increase the size
		
		
	}}
	
	//checks  whether the current tag number is less than the given tag number in order or not
	else if (newNode.getInfo().getrfId()!=null&&newNode.getInfo().getOriginalLocation()!=null&&newNode.getInfo().getCurrentLocation()!=null&& newNode.getInfo().getPrice()!=0) {
	      if(current.getInfo().getrfId().compareTo(rfidTag)<=0)
	{   

		
			while(current.getNext()!=null)
		    {
				
				//checks whether the tag number is between two nodes or not
			       if(current.getNext().getInfo().getrfId().compareTo(rfidTag)>0)
			 {
				 newNode.setNext(current.getNext());
				 current.getNext().setPrev(newNode);
				 size++;
				 break;
				 
			 }
			 
			 current=current.getNext();
			}
			// adding the current node to the last
			if(current.getNext()==null) {
				current.setNext(newNode);
			    newNode.setPrev(current);
			    tail=newNode;
			    size++;
			    
			}
			else
			{
				current.setNext(newNode);
			    newNode.setPrev(current);
			}}}
	
	 
	 else 
	// checking whether the current node's tag number is at before head's tag number or not
		{ ItemInfoNode current1=head;
		 if(newNode.getInfo().getrfId()!=null&&newNode.getInfo().getOriginalLocation()!=null&&newNode.getInfo().getCurrentLocation()!=null&& newNode.getInfo().getPrice()!=0)  {
		   if (current1.getInfo().getrfId().compareTo(rfidTag)>=0) {
			newNode.setNext(head);
			head.setPrev(newNode);
			newNode.setPrev(null);
			head=newNode;
			size++;
			
		}}}}
	
/**
 * This method removes the purchased items which have listed as out from the list 		
 * @throws NoSuchElementException when the list is empty
 * The order complexity for this method is O(size)=O(N)=the size of the list
 * as there is a while loop which will be iterated through the size and removes the specific node
 */
public void removeAllPurchased()throws NoSuchElementException
{
	System.out.format("%40s%12s", "Original","Current");
	System.out.println();
	System.out.format("%-20s%-12s%-12s%-12s%-5s","Item Name","RFID","Location","Location","Price");
	System.out.println();
	System.out.format("%-20s%-12s%-12s%-12s%-5s", "---------","-----","--------","--------","------");
	System.out.println();
	//current node will be starting from head
	ItemInfoNode current=head;

	try {
		//if the list is empty
		if(head==null||tail==null)
		{
			throw new NoSuchElementException("There is no such element");//throw exception
		}
		
	}
	catch(NoSuchElementException e)
	{
		System.out.println(e.getMessage());
	}
	//iterates through the size of the loop
	while(current!=null) {
	  if(current.getInfo().getCurrentLocation().compareTo("out")==0 && current==head)
	{
		  //if there is one item
		  if(head.getNext()==null)
		  {
			  head=null;
		  }
		  else {
			     System.out.println(current.getInfo().toString());
		         head=current.getNext();
		         head.setPrev(null);
		         current.setNext(null);
		         size--;
		         }
	}
	  //if the out is at tail node
	 else if(current.getInfo().getCurrentLocation().compareTo("out")==0 && current==tail)
	  { if(tail.getPrev()==null)
	   {
		  tail=null;
	   }
		 
		 System.out.println(current.getInfo().toString());
		  tail.getPrev().setNext(null);
		  tail=tail.getPrev();
		  current.setPrev(null);
		  size--;
		
		  
	  }
	  
	  else {
		 // if the out string is between the head and tail nodes
		  if(current.getInfo().getCurrentLocation().compareTo("out")==0 && current!=tail) {
		  System.out.println(current.getInfo().toString());
			 ItemInfoNode next=current.getNext();
			 ItemInfoNode previous=current.getPrev();
			 previous.setNext(next);
			 next.setPrev(previous);
			 size--;
			 
		 }}
	  current=current.getNext();}}
/**
 * This method moves the item with a given rfId tag number from source location to destined location
 * @param rfidTag-the tag number that has to be set
 * @param source-the location from where it will be changing
 * @param dest-the location where it will be kept
 * @return the result true or false whether the item has moved or not 
 * @throws IllegalArgumentException when the destination is in invalid format and the source is in out 
 * The order complexity for this method is O(size)=O(N)=the size of the list 
 * as it will be iterating through the list to find out the tag number
 */
public boolean moveItem(String rfidTag, String source, String dest)throws IllegalArgumentException {
boolean p=false;
boolean q=false;
try {
	if(source.equalsIgnoreCase("out")||dest.charAt(0)!='s'&& dest.length()!=6 && dest.charAt(0)!='c'&& dest.length()!=4 )
	{
		throw new IllegalArgumentException("The position is not valid");//throw exception
	}
}
catch(IllegalArgumentException e)
{
	System.out.println(e.getMessage());
	
}
//if the list is empty
if(head==null||tail==null)
{
	p=false;
}
else {
	ItemInfoNode current=tail;
	while(current!=null) {
	if(current.getInfo().getrfId().equalsIgnoreCase(rfidTag)&& current.getInfo().getCurrentLocation().equalsIgnoreCase(source)) {
		    current.getInfo().setCurrentLocation(dest);
			p=true;
			break;
		
	}
	else
	{
		current=current.getPrev();
		
	}
}
	
	}

if(p)
{
	q=true;
}
else
{
	q=false;
}
return q;}

/**
 * This method prints all the information in a tabular form
 * @throws NoSuchElementException when there is no element or the list is empty
 * The order of complexity for this method is O(size)=O(N)=the size of the list
 * as it will be iterating through the whole list to print the informations
 */

public void printAll() throws NoSuchElementException
{

ItemInfoNode current=head;
try {
	//if the list is empty
	if(head==null||tail==null)
	{
		throw new NoSuchElementException("There is no element to print");//throw exception
	}
	
}
catch(NoSuchElementException e)
{
	System.out.println(e.getMessage());
}
System.out.format("%40s%12s", "Original","Current");
System.out.println();
System.out.format("%-20s%-12s%-12s%-12s%-5s","Item Name","RFID","Location","Location","Price");
System.out.println();
System.out.format("%-20s%-12s%-12s%-12s%-5s", "---------","-----","--------","--------","------");
System.out.println();

while(current!=null)
{
	 
		System.out.println(current.getInfo().toString());
	
	
    current=current.getNext();
}


}
/**
 * This method prints the items in the specified current location in tabular form
 * @param location-the location that has to be set
 * @throws NoSuchElementException when the list is empty
 * The order complexity for this method is O(size)=O(N)-the size of the list
 * as it will be iterating through the list to find out the particular location
 */
public void printByLocation(String location) {
	ItemInfoNode current=head;
	try {
		//if the list is empty
		if(head==null||tail==null)
		{
			throw new NoSuchElementException("There is no element to print");//throw exception
		}
		
	}
	catch(NoSuchElementException e)
	{
		System.out.println(e.getMessage());
	}
	
	System.out.format("%40s%12s", "Original","Current");
	System.out.println();
	System.out.format("%-20s%-12s%-12s%-12s%-5s","Item Name","RFID","Location","Location","Price");
	System.out.println();
	System.out.format("%-20s%-12s%-12s%-12s%-5s", "---------","-----","--------","--------","------");
	System.out.println();
	while(current!=null)
	{
		if(current.getInfo().getCurrentLocation().equalsIgnoreCase(location))
		{
			System.out.println(current.getInfo().toString());
		}	
		current=current.getNext();
	}
}
//optional one
/**
 * This method is implemented to place back the item where it belongs in the original shelf
 * @throws NoSuchElementException if the list is empty
 * The order complexity for this method is O(size)=O(N)=N=the size of the list
 * It will be going through every item to check whether the current location is eqaul to original location or not,otherewise it will be placed back to its original position
 */
public void cleanStore()
{	ItemInfoNode current=head;
	try {
		if(head==null||tail==null)
		{
			throw new NoSuchElementException("There is no element to print");//throw exception
		}
		
	}
	catch(NoSuchElementException e)
	{
		System.out.println(e.getMessage());
	}
	
	System.out.format("%40s%12s", "Original","Current");
	System.out.println();
	System.out.format("%-20s%-12s%-12s%-12s%-5s","Item Name","RFID","Location","Location","Price");
	System.out.println();
	System.out.format("%-20s%-12s%-12s%-12s%-5s", "---------","-----","--------","--------","------");
	System.out.println();
	while(current!=null)
	{
		//checking the condition
		if(current.getInfo().getCurrentLocation()!=current.getInfo().getOriginalLocation()&& current.getInfo().getCurrentLocation().compareTo("out")!=0 && (current.getInfo().getCurrentLocation().charAt(0)!='c'&& current.getInfo().getCurrentLocation().length()!=4))
		{
			System.out.println(current.getInfo().toString());
			current.getInfo().setCurrentLocation(current.getInfo().getOriginalLocation());
		}
		current=current.getNext();
	}
}
/**
 * This method is implemented to print out the checked item and changes its location to be out
 * @param cartNumber-the cart number that has to be set
 * @return the total cost for the items that have been checked
 * @throws IllegalArgumentException if the list is empty
 * The order complexity for this method is O(size)=O(N)=N=size of the list.
 * it will go through every elements to print out the items that have been checked
 */
public double checkOut(String cartNumber) {
	
	ItemInfoNode current=head;
	double sum=0;
	try {
		// checking the condition
		if(cartNumber.charAt(0)!='c'&& cartNumber.length()!=4)
		{
			throw new IllegalArgumentException("The cartNumber is not valid");
		}
	}
	catch(IllegalArgumentException e)
	{
		System.out.println(e.getMessage());
	}
	try {
		//if the list is empty
		if(head==null||tail==null)
		{
			throw new NoSuchElementException("There is no element to print");
		}
		
	}
	catch(NoSuchElementException e)
	{
		System.out.println(e.getMessage());
	}
	System.out.format("%40s%12s", "Original","Current");
	System.out.println();
	System.out.format("%-20s%-12s%-12s%-12s%-5s","Item Name","RFID","Location","Location","Price");
	System.out.println();
	System.out.format("%-20s%-12s%-12s%-12s%-5s", "---------","-----","--------","--------","------");
	System.out.println();
	
	while(current!=null)
	{
		if(current.getInfo().getCurrentLocation().equalsIgnoreCase(cartNumber))
		{
			sum=sum+current.getInfo().getPrice();
		
			System.out.println(current.getInfo().toString());
			current.getInfo().setCurrentLocation("out");
			
			
		}
		current=current.getNext();
	}
	
	return sum;
}
/**
 * This method prints the rfId tag number that has been given.
 * @param tagNumber-the number that has to be set
 * @throws NoSuchElementException when the list is empty
 */
public void printTagNumber(String tagNumber)
{
ItemInfoNode current=head;
try {
	//if the list is empty
	if(head==null||tail==null)
	{
		throw new NoSuchElementException("There is no element to print");//throw exception
	}
	
}
catch(NoSuchElementException e)
{
	System.out.println(e.getMessage());
}

System.out.format("%40s%12s", "Original","Current");
System.out.println();
System.out.format("%-20s%-12s%-12s%-12s%-5s","Item Name","RFID","Location","Location","Price");
System.out.println();
System.out.format("%-20s%-12s%-12s%-12s%-5s", "---------","-----","--------","--------","------");
System.out.println();
while(current!=null)
{
	if(current.getInfo().getrfId().equalsIgnoreCase(tagNumber))
	{
		System.out.println(current.getInfo().toString());
	}	
	current=current.getNext();
}
}
}







	  

	


