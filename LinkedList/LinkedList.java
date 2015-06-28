import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class LinkedList<E> {
	
	private Node head;
	private int count=0;
    
	LinkedList(){
		head = new Node("first");
	}
	
	private void insert(String data){
		Node node = new Node(data);
		Node current = head;
		while(current.getNext() != null){
			current = current.getNext();
		}
		current.setNode(node);
		count++;
	}
	
	private void addAll(Collection<? extends E> c){
		Node current = head;
		while(current.getNext() != null){
			current = current.getNext();
		}
		for(E e: c){
			Node node = new Node(e);
			current.setNode(node);
			current = current.getNext();
		}	
	}
	
	private boolean addAll(int index,Collection<? extends E> c){
		if(count < index) return false;
		else{
			int t=0;
			Node current = head;
			while(current.getNext() != null){
				current = current.getNext();
				t++;
				if(t==index){
					Node temp = current.getNext();
					Node temper = null;
					for(E e: c){
						Node node = new Node(e);
						current.setNode(node);
						current = current.getNext();
					    temper = node;
					}
					if(temper != null) temper.setNode(temp);
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean add(int index,String data){
		if(count < index) return false;
		else{
			int t=0;
			Node current = head;
			while(current.getNext() != null){
				current = current.getNext();
				t++;
				if(t==index){
					Node newnode = new Node(data);
					Node temp = current.getNext();
					current.setNode(newnode);
					newnode.setNode(temp);
					return true;
				}
			}
		}
		return false;
	}
	
	private void addFirst(E e){
		Node current = head;
	    Node node = new Node(e);
	    current.setNode(node);
	    head = node;
	}
	
	private void addLast(E e){
		Node current = head;
		while(current.getNext() != null){
			current = current.getNext();
		}
		Node node = new Node(e);
		current.setNode(node);
	}
	
	private void clear(){
		this.head=null;
	}
	
	private boolean contains(Object o){
		Node current = head;
		while(current != null){
			current = current.getNext();
			if(current.equals(o)){
				return true;
			}
		}
		return false;
	}
	
	public Iterator<?> descendingIterator(){
		Node current = head;
		List<Node> list = new ArrayList<>();
		while(current != null){	
			current = current.getNext();
			list.add(current);
		}
		Iterator<Node> itr = list.iterator();
		return itr;
	}
	
	public E element(){
		Node current = head;
		return (E) head.getData();
	}
	
	public E get(int index){
	     if(count < index) return null;
	     else{
	    	 Node current = head;
	    	 int t=0;
	    	 while(current != null){
	    		 current = current.getNext();
	    		 t++;
	    		 if(t == index) return (E)current.getData();
	    	 }
	     }
	     return null;
	}
	
	public E getFirst(){
	 if(head != null) return (E)head.getData();
	 else return null;
	}
	
	public E getLast(){
		Node current = head;
		while(current != null){
			current = current.getNext();
		}
		return (E) current.getData();
	}
	
	public int indexOf(Object o){
		if(o instanceof Node){
			Node current = head;
			int indexer=0;
			while(current != null){
				current = current.getNext();
				indexer++;
				if(current.getData().equals(o)) return indexer;
			}
		}
		return -1;
	}
	
	public E poll(){
			Node current = head;
			head = current.getNext();
			return (E)current.getData();		
	}
	
	public boolean offer(E e){
		Node current = head;
		while(current != null){
			current = current.getNext();
		}
		Node node = new Node(e);
		current.setNode(node);
		return true;
	}
	
	public boolean offerFirst(E e){
		Node current = head;
		if(current != null){
			Node n = new Node(e);
			current.setNode(n);
			head = current;
			return true;
		}
		return false;
	}
		
	public boolean offerLast(E e){
		Node current = head;
		while(current != null){
			current = current.getNext();
		}
		Node n = new Node(e);
		current.setNode(n);
		return true;
	}
	
	public E getLastOccurence(Object o){
		if(o instanceof Node){
			Node current = head;
			int lastIndexOccurence = 0;
			int stepCounter=0;
			while(current != null){
				current = current.getNext();
				if(current.equals(o)){
					lastIndexOccurence = stepCounter;
				}
				stepCounter++;
			}
			return (E) get(lastIndexOccurence);
		}
		return null;
	}
	
	public ListIterator<E> listIterator(int index){
		if(count < index) return null;
		else{
			Node current = head;
			List<E> cloner = new ArrayList<E>();
			int t=0;
			while(current != null){
				current = current.getNext();
				t++;
				if(t >= index) cloner.add((E)current); 
			}
			return (cloner.size() > 0 && !cloner.isEmpty()) ? cloner.listIterator() : null; 
		}
	}
	
	public Object[] toArrays(){
		
		List<E> cloner = new ArrayList<E>();
		Node current = head;
		
		while(current != null){
			current = current.getNext();
			cloner.add((E) current);
		}
		return cloner.toArray();
	}
	
	
	
	public String toString(){
		String output="";
		Node current = head;
		output += " [ "+ current.getData() + " , ";
		while(current.getNext() != null){
			current = current.getNext();
			output += current.getData() + " , ";
		}
		output += " ] ";
		return output;
	}
	
	
	
	public static void main(String args[]){
		
       LinkedList linked = new LinkedList();
       
       linked.insert("second");
       linked.insert("third");
       linked.insert("fourth");
       linked.insert("fifth");
       linked.insert("sixth");
	  
       boolean status = linked.add(2, "inbetween");
       if(status) System.out.println(" Successfull added in the index");
       System.out.println(linked.toString());
	}
	
}
