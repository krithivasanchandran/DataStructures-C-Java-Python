public class Node<T>{
		
		private T data;
		private long time;
		private Node next;
		
		Node(T data, long currTime){
			this.data = data;
			time = currTime;
			next = null;
		}
		
		public T getData() {
			return data;
		}
		public void setData(T data) {
			this.data = data;
		}
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}
	}