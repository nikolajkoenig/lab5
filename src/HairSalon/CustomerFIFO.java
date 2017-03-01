package HairSalon;

import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Vector;

public class FIFO implements Queue{

	private Vector<Customer>SalonQueue = new Vector<Customer>();
	
	private final int m=5;
	
	/**
	 * Returns the size of the vector
	 */
	public int size(){
		return SalonQueue.size();
	}
	
	
	/**
	 * Checks if the "vectorList" is empty. If its empty it returns true, otherwise it returns false.
	 */
	public boolean isEmpty(){
		if (SalonQueue.size() == 0)
			return true;
		
		return false;
	}
	
	/**
	 * Returns the first element in the vectorList, if it's empty it will throw an exception.
	 */
	public Customer nextCustomer(){
		if (!isEmpty()){
			Customer frst = SalonQueue.firstElement();
			removeFirst();
			return frst;
		}
		
		return null;
	}
	
//	/**
//	 * This method checks four criterias:
//	 *  1. If the objects are the same type
//	 *  2. If the objects have the same size
//	 *  3. If one list contains null the other must also have the null at the same position
//	 *  4. If it's a reference at the i position
//	 *  
//	 *  If all oh these statements are true, the method will return true, otherwise it eill return false.
//	 */
//	public boolean equals(Object f){
//		/**
//		 * Checks criteria 1
//		 */
//		if (this.getClass() != f.getClass())
//			throw new ClassCastException("The objects are not the same type");
//		/**
//		 * Checks criteria 2
//		 */
//		if(vectorList.size() != ((FIFO)f).vectorList.size())
//			return false;
//		
//		for(int i=0;i<vectorList.size();i++){
//			/**
//			 * Checks criteria 3
//			 */
//			if(vectorList.get(i) != null && ((FIFO)f).vectorList.get(i) != null){
//					if(!vectorList.get(i).equals(((FIFO)f).vectorList.get(i))){
//						return false;
//					}
//			}
//			/**
//			 * Checks criteria 4
//			 */
//			else if (vectorList.get(i) != ((FIFO)f).vectorList.get(i)){
//				return false;
//			}
//		}
//		return true;
//	}
	
	/**
	 * Takes all the objects one by one and add it to a string called text.
	 */
	public String toString(){
		String text="";
		
		for(int i=0;i<SalonQueue.size();i++){
			text = text + "(" + String.valueOf(SalonQueue.get(i)) + ") ";
		}
		return "Queue: " + text;
	}
	
	/**
	 * This method adds the object item to the end of the queue.
	 */
	public void add(Customer item){
		if(item.isDissatisfied() && SalonQueue.size()<m){
			for(int i=0;i<SalonQueue.size();i++){
				if(!SalonQueue.get(i).isDissatisfied()==true)
					SalonQueue.add(i, item);
			}
		}
		
		else if(item.isDissatisfied() && SalonQueue.size()==m){
			SalonQueue.remove(-1);
			for(int i=0;i<SalonQueue.size();i++){
				if(!SalonQueue.get(i).isDissatisfied()==true)
					SalonQueue.add(i, item);
			}	
		}
		
		else if(!item.isDissatisfied() && SalonQueue.size()<m){
			SalonQueue.add(item);
		}
	}
	
	/**
	 * This method removes the first object from the queue. If the queue is empty, a NoSuchElementException is thrown
	 */
	public void removeFirst(){
		if(SalonQueue.size() == 0)
			throw new NoSuchElementException("There's nobody in the queue");
		
		SalonQueue.remove(0);
	}
}
