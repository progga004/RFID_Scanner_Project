//Name : Progga Paromita Dutta
//Id :114751436
//Recitation section-5

/**
 * This class stores all the data about a particular item of the lists
 * @author Progga Paromita Dutta
 *
 */
public class ItemInfo {
   private String name;
   private double price;
   private String rfId;
   private String originalLocation;
   private String currentLocation;
   // This is a no argument constructor for creating an item object
   public ItemInfo()
   {
	   
   }
   /**
    * @return the name of the item
    */
   public String getName()
   {
	   return name;
   }
   /**
    * @return the rfId tag of a particular item
    */
   public String getrfId()
   {
	   return rfId;
   }
   /**
    * @return the originalLocation where the item is originally at which shelf position
    */
   public String getOriginalLocation()
   {
	   return originalLocation;
   }
   /**
    * @return the currentLocation which represents the current position of the item 
    */
   public String getCurrentLocation()
   {
	   return currentLocation;
   }
   /** 
    * @return the price of a particular item
    */
   public double getPrice()
   {
	   return price;
   }
   /**
    * This is a mutator method which sets the name of a specific item
    * @param name-the name that has to be set
    */
   public void setName(String name)
   {
	   this.name=name;
	   
   }
   /**
    * This method implements to check whether the input string originalLocation or currentLocation is decimal or not 
    * @param input-the input that is given by the user
    * @return the result true or false whether the string is a representation of decimal or not
    */
   public static boolean isDecimal( String input){
	   boolean p=true;
	   try{
	   Long.parseLong(input, 10);// checking the input
	   return true;// return result
	   }
	   //if exception happens from the condition
	   catch(NumberFormatException e){
	   if(input.charAt(0)=='s')// checking the condition
	   {
	   System.out.println("The original location should be followed by 5 digits after s.");
	   p=false;
	   }
	   else if(input.charAt(0)=='c')
	   {
		   System.out.println("The current location should be followed by 3 digits after c.");
		   p=false;
	   }
	   }
	   //return the result
	   return p;}
   /**
    * This method specifies whether an input rfId tag number is a representation of hexadecimal or not
    * @param input-the input that is given by user to check
    * @return the result true or false whether the input is a representation of hexadecimal or not
    */
   public static boolean isHexaDecimal( String input){
	   try{
	   Long.parseLong(input, 16);//checking the condition
	   return true;
	   }
	   // if exception happens
	   catch(NumberFormatException e){
	   System.out.println("The RFID Tag number has to be an hexadecimal number");
	   return false;// return result
	   }
	   }
   /**
    * This setter method sets the rfId tag number to a particular item
    * @param rfId-the tag number that has to be set
    * @throws IllegalArgumentException when the tag number is not at correct length
    */
   public void setrfId(String rfId)throws IllegalArgumentException
   {
	// checking the condition whether the length is right or not
	   try {
		     if(rfId.length()!=9)
			   {
				   throw new IllegalArgumentException("The rfId tag number is not right");//throw exception
				    }
			   
	   }
	   catch(IllegalArgumentException e)
	   {
		 System.out.println(e.getMessage()) ;
	   }
	   //the length and the hexadecimal condition is being checked
	   if(rfId.length()==9&& isHexaDecimal(rfId))
	   {
		   this.rfId=rfId;
	   }
   }
   /**
    * This setter method sets the shelf position of a specific item 
    * @param originalLocation-the location where it should be originally
    * @throws IlegalArgumentException when the self position is not correct
    */
   public void setOriginalLocation(String originalLocation )throws IllegalArgumentException
   {
	   try {
		   if(originalLocation.charAt(0)!='s'||originalLocation.length()!=6)
		   {
			   throw new IllegalArgumentException("The original location is not correct in length or it hasn't started with s.");//throw exception
		   }
	   }
	   catch(IllegalArgumentException e)
	   {
		   System.out.println(e.getMessage());
	   }
	   //is the originalLocation starts with 's' and the length is fixed at 6 along with 5 digits followed after s
	   if(originalLocation.charAt(0)=='s'&& originalLocation.length()==6 && isDecimal(originalLocation.substring(1, 6)))
	   
	   { this.originalLocation=originalLocation;
	   }
	   
   }
   /**
    * This setter method sets the currentLocation of the particular item where the item is right now
    * @param currentLocation-the location where it is to be kept at present
    * @throws IllegalArgumentException when the currentLocation is not right
    */
   public void setCurrentLocation(String currentLocation)
   {
	   
	      try {
		 
		   if((currentLocation.charAt(0)!='s'&& currentLocation.length()!=6)&&(currentLocation.length()!=4&& (currentLocation.charAt(0)!='c')&& currentLocation.compareTo("out")!=0)){

		   {
			   throw new IllegalArgumentException("The current location is not a right cart number");//throw exception
		   }
	   }}
	   catch(IllegalArgumentException e)
	   {
		   System.out.println(e.getMessage());
	   }
	   //does the item's current location is an encoding of a cart number or it has been checked out by a customer
	   if(currentLocation.length()==4 && currentLocation.charAt(0)=='c'&&isDecimal(currentLocation.substring(1,4))|| currentLocation.equalsIgnoreCase("out")||currentLocation.charAt(0)=='s'&& currentLocation.length()==6&&isDecimal(currentLocation.substring(1,6)))
	   {
		   
	         this.currentLocation=currentLocation;}
	   
   }
   /**
    * This setter method sets the price of a particular item
    * @param price-the price to be set
    * @throws IllegalrgumentException when the price is not positve 
    */
   public void setPrice(double price)
   {
	   try {
		if(price<=0)
		{
			throw new IllegalArgumentException("The price is negative.");//throw exception
		}
	}
	catch(IllegalArgumentException e)
	{
		System.out.println(e.getMessage());
	
	}
	//checking whether the price is positive or not
	if(price>0)
	{
		this.price=price;
	}
	   
	}
   /**
    * This is a method which prints a detailed information about a particular item in the list
    * @return the item specification
    */
   public String toString()
   {
	   return String.format("%-20s%-12s%-12s%-12s%-5.2f",name, rfId, originalLocation,currentLocation,price);
   }
}
