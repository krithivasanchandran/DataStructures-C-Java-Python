import java.util.logging.Logger;

/********************************************************************
 * A queue-like data structure that supports insertion and deletion *
 * at both the front and the back of the queue. Such a structure is *
 * called a double Ended queue.                                     *
 ********************************************************************/

/******************************************************************
 * The sample example queue is restaurant wait queue
 ******************************************************************/

public class DoubleEndedQueue<E> {
	
	Node headptr = null;
	Node tailptr = null;
	int sizeOfList=0;
	public final static int QUEUE_SIZE = 10;
	
	/**********************************************
	*   Creating an Empty Node pointer            *
	***********************************************/
	
	DoubleEndedQueue(){
		headptr = new Node("Madhusudhan ----->");
		tailptr = headptr;
		sizeOfList++;
	}
	
	/**********************************************
	*        Inserting the Node at First		  *
	**********************************************/
	
	public void addFirst(E data){
	
		if(sizeOfList >= QUEUE_SIZE){
			Logger.getLogger(" Sorry the QUEUE is FULL ");
		}else{
			Node newNode = new Node(data);
			newNode.setNext(headptr);
			headptr.setPrev(newNode);
			headptr = newNode;
			sizeOfList++;
		}}
	
	/**********************************************
	 * Add the Node at Last                       *
	 **********************************************/
	
	public void addLast(E data){
		if(sizeOfList >= QUEUE_SIZE){
			Logger.getLogger(" Sorry the QUEUE is FULL ");
		}else{
			Node newnode = new Node(data);
	        tailptr.setNext(newnode);
			newnode.setPrev(tailptr);
			tailptr = tailptr.getNext();
		}
	}
	
	/**********************************************
	 *          Remove the first element          *
	 **********************************************/

	public E removeFirst(){

		if(sizeOfList == 0){
			Logger.getLogger(" Sorry the QUEUE is empty ");
			System.out.println(" Sorry the QUEUE is empty ");
		}else{
			  E element;
			  if(headptr == null){
				System.out.println(" The headpointer is null So please rerun the program ");  
				return null;
			  }
			  System.out.println(" The value in the data is " + headptr);
			  element = (E) headptr.getData();
		      sizeOfList--;
			  headptr = headptr.getNext();
			  return element;
	    }
		return null;
	}
	
	/**********************************************
	 *     Return and Remove the last element     *
	 **********************************************/
	
		public E removeLast(){
			if(sizeOfList == 0){
				Logger.getLogger(" Sorry the QUEUE is empty ");
				System.out.println(" Sorry the QUEUE is empty ");
			}else{
				E element;
				if(tailptr == null){
					System.out.println(" Sorry the tail pointer is null");
				}else{
					element = (E)tailptr.getData();
					if(tailptr.getPrev() != null){
					    tailptr = tailptr.getPrev();
					}
					return (E)element;
				}}return null;
		}
		
	/******************************************************
	*  The returned first element of the head is :::::::: * 
	*******************************************************/
		
     public void first(){
    	 if(sizeOfList == 0) System.out.println("The list empty");
    	 else System.out.println(" The first element is ==========> " + headptr.getData());
     }

     /******************************************************
 	*  The returned last element of the head is :::::::: * 
 	*******************************************************/
 		
      public void last(){
     	 if(sizeOfList == 0) System.out.println("The list empty");
     	 else System.out.println(" The last element is ==========> " + headptr.getData());
      }
    
     public boolean isEmpty(){
    	 if(sizeOfList == 0) return true;
    	 else return false;
     }
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	
	public String toString(){
		StringBuilder output = new StringBuilder();
		Node dummyHead = headptr;
		
		while(dummyHead != null){
			output.append(dummyHead.getData() + " , ");
			dummyHead = dummyHead.getNext();
		}
		output.delete(output.length() - 2, output.length());
		return output.toString();
	}
	
	public int size(){
		return sizeOfList;
	}
	
	
	public static void main(String args[]){
		
		DoubleEndedQueue queue = new DoubleEndedQueue<>();
		queue.addFirst(" second customer   ---> ");
		queue.addFirst(" third customer ----> ");
		queue.addFirst(" fourth customer ----> ");
		queue.addFirst(" fifth customer ----> ");
		queue.addFirst(" sixth customer ----> ");
		queue.addFirst(" seventh customer ----> ");
		
		System.out.println(queue.toString());
		
		queue.addLast("Eight Customer -------> ");
		
		System.out.println("------------------------- After Adding the last customer ( new customer )--------------------");
		
		System.out.println(queue.toString());
		
		System.out.println(" The removed first element is --------> " +queue.removeFirst());
		
		System.out.println("------------------------- After removing the first element (Got a table assigned to him) --------------------");
		
		System.out.println(queue.toString());
		
		System.out.println(" The removed last element is --------> " +queue.removeLast());
		
		System.out.println("------------------------- After removing the last customer from the queue (he lost patience) --------------------");
		
		System.out.println(queue.toString());
		
		queue.first();
		queue.last();
		
		System.out.println(" The size of the queue is " + queue.size());
		
		if(queue.isEmpty()){
			System.out.println(" The queue is empty ");
		}
		
	}

}
