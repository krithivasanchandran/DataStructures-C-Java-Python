
public class Node<E> {

	private E data;
	private Node node;
	
	Node(E e){
	 	if(e!=null ) this.data = e;
	 	node = null;
	}

	public Node getNext() {
		return node;
	}

	public void setNode(Node node) {
		this.node = node;
	
	}
	
	public E getData() {
		return data;
	}
	
}
