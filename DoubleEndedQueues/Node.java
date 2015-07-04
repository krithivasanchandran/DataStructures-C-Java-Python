/*
 *  Implementation of Doubly Ended Queue using Double Linked Lists.
 */

public class Node<E> {
	private E data;
	private Node next;
    private Node prev;
	
	Node(E data){
		this.data = data;
		next = null;
		prev = null;
	}
	
	public E getData() {
		return data;
	}

	
	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node getPrev() {
		return prev;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}

}
