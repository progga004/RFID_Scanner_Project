//Name:Progga Paromita Dutta
// Id: 114751436
//Recitation Section-5
/**
 * This class creates one ItemInfo object as well as two reference objects
 * @author Progga Paromita Dutta
 */
public class ItemInfoNode {
   private ItemInfo info;
   private ItemInfoNode prev;
   private ItemInfoNode next;
 /**
  * This is an argument constructor to create a node object 
  * @param info-the information about a particular item that has been given by user
  */
  public ItemInfoNode(ItemInfo info)
  {
	  this.info=info;
	  this.prev=null;
	  this.next=null;
  }
  /**
   * This setter method sets the information of a particular item
   * @param info-the information that has to be set
   */
  public void setInfo(ItemInfo info)
  {
	  this.info=info;
  }
  /**
   * This setter method sets the previous node 
   * @param prev-the node that has to be set
   */
  public void setPrev(ItemInfoNode prev)
  {
	  this.prev=prev;
  }
  /**
   * This setter method sets the next node
   * @param next-the node that has to be set
   */
  public void setNext(ItemInfoNode next)
  {
	  this.next=next;
  }
  /**
   * @return the information of the specific item
   */
  public ItemInfo getInfo()
  {
	  return info;
  }
  /**
   * @return the previous node
   */
  public ItemInfoNode getPrev()
  {
	  return prev;
  }
  /**
   * @return the next node
   */
  public ItemInfoNode getNext()
  {
	  return this.next;
  }
  
}
