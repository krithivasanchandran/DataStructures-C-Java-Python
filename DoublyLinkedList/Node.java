
public class Node<E> {

	private E data;
	private Node next;
	private Node prev;
	
	Node(E data){
		this.data = data;
		this.next = null;
		this.prev = null;
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
	
	public E getData() {
		return data;
	}
	
	public void setData(E data) {
		this.data = data;
	}

}
