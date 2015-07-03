/**
 * 
 * @author KRITHIVASAN CHANDRAN
 *
 * @param <T>
 */

public class CircularLinkedList<T> {
   
	private Node head;
	private Node tail;
	
	CircularLinkedList(){
		// Creating the empty head pointer with default input reference
		head = new Node("MediaPlayer",System.currentTimeMillis());
	}
	
	public void insert(String data,long time){
		Node n = new Node(data,time);
		Node current = head;
		
		while(current.getNext() != null){
			current = current.getNext();
		}
		current.setNext(n);
	}
	
	public void addFirst(String data,long time){
		Node n = new Node(data,time);
		Node current = tail.getNext();
		Node temp = current.getNext();
			
			if(temp.getNext() != null){
				current.setNext(n);
				n.setNext(temp);
			}else{
				System.out.println(" This is a null pointer exception please handle it");
			}
	}
	
	public void rotate(){
		Node tail = head;
		
		while(tail.getNext() != null){
			tail = tail.getNext();
		}
		
		tail.setNext(head);
	}
	
	public String toString(){
		StringBuilder builder = new StringBuilder();
		Node current = head.getNext();
		builder.append(" [ ");
		while(current != null && builder.length() < 100){
			builder.append(current.getData() + " , ");
			current = current.getNext();
		}
		builder.delete(builder.length()-2, builder.length());
		builder.append(" ] ");
		return builder.toString();
	}
	
	
	
		public static void main(String args[]){
		
		CircularLinkedList linkedList = new CircularLinkedList();
		
		// Inserting the process 
		
		linkedList.insert("Notepad",System.currentTimeMillis());
		linkedList.insert("killbill",System.currentTimeMillis());
		linkedList.insert("KeyBoard",System.currentTimeMillis());
		linkedList.insert("Victor",System.currentTimeMillis());
		linkedList.insert("Mouse",System.currentTimeMillis());
		linkedList.insert("Trackpad",System.currentTimeMillis());
		
		linkedList.rotate();
		
		System.out.println(linkedList.toString());
		
//		// Perform the Rotate Function
//		linkedList.rotate();
// 
//		System.out.println(" After rotation the linkedlist is ");
//		
//		System.out.println(linkedList.toString());
	   
		
	}
	
}
