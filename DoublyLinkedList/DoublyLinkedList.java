import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Logger;

/*
 * 
 * Author : KRITHIVASAN CHANDRAN
 * 
 */
public class DoublyLinkedList<E> {
	Node head;
	public int listSize=0;
	
	// Create a one Node List 
	public DoublyLinkedList(E data) {
       head = new Node(data);
	}
	
	/*****************************************************************************/
	/* Appends the specified element to the end of the list - AUTHOR KRITHIVASAN */ 
	/*****************************************************************************/
	
	public void add(E e){
		Node node = new Node(e);
		Node curr = head;
		while(curr.getNext() != null){
			curr = curr.getNext();
		}
		curr.setNext(node);
		node.setPrev(curr);
		listSize++;
	}
	
	/*************************************************************************************************************
	 * Inserts the specified element at the specified position in this list. Shifts the element currently at that 
	 * 
	 * position (if any) and any subsequent elements to the right (adds one to their indices).
	 **************************************************************************************************************/
	
	public void add(int index,E e){
		if(index > listSize) Logger.getLogger(" The index size exceeds the LinkedList SIZE");
		else{
			Node to_insert = new Node(e);
			int l_count=0;
			Node c = head;
			while(c.getNext() != null){
				l_count++;
				if(l_count == index) break;
				c = c.getNext();
			}
			Node temp = c.getNext();
			c.setNext(to_insert);
			to_insert.setPrev(c);
			to_insert.setNext(temp);
			temp.setPrev(to_insert);
			listSize++;
		}
	}
	

	/*************************************************************************************************************
	 * Appends all of the elements in the specified collection to the end of this list, in the  
	 * 
	 * order that they are returned by the specified collection's iterator.
	 **************************************************************************************************************/
	
	public void add(Collection <? extends E> c){
		
		Node node = head;
		 
		while(node.getNext() != null){
			 node = node.getNext();
		}
		
		Iterator itr = c.iterator();
		
		for(;itr.hasNext(); node = node.getNext()){
			Node to_insert = new Node(itr.next());
			node.setNext(to_insert);
			to_insert.setPrev(to_insert);
			listSize++;
		}
	}
	
	/**************************************************************************************************************
	 * Inserts all of the elements in the specified collection into this list, starting at the specified position.*
	 **************************************************************************************************************/
	
	public void addAll(int index, Collection <? extends E> c){
		
		Node curr = head;
		if(index > listSize) Logger.getLogger(" The index size exceeds the LinkedList SIZE");
		else{
			int tracker_ = 0;
			while(curr.getNext() != null){
				curr = curr.getNext();
				tracker_++;
				if(tracker_ == index) break;
			}
			
			Iterator itr = c.iterator();
			
			for(;itr.hasNext(); curr = curr.getNext()){
				Node to_insert = new Node(itr.next());
				curr.setNext(to_insert);
				to_insert.setPrev(curr);
				listSize++;
			}
			
		}
		
	}
	
	/*****************************************************************************/
	/* Inserts the specified element at the beginning of this list. - AUTHOR KRITHIVASAN */ 
	/*****************************************************************************/
	
	public void addFirst(E e){
		Node curr = head;
		Node n = new Node(e);
		n.setNext(head);
		head.setPrev(n);
		head = n;
		listSize++;
	}
	
	
	/*******************************************************************************/
	/* Appends the specified element to the end of this list. - AUTHOR KRITHIVASAN */ 
	/*******************************************************************************/
	
	public void addLast(E e){
		Node curr = head;
		while(curr.getNext() != null){
			curr = curr.getNext();
		}
		
		Node n = new Node(e);
		curr.setNext(n);
		n.setPrev(curr);
		listSize++;
	}
	

	/*******************************************************************************/
	/* Removes all of the elements from this list. - AUTHOR KRITHIVASAN */ 
	/*******************************************************************************/
	
	public void clear(){
		head = null;
	}
	
	/*******************************************************************************/
	/* Returns a shallow copy of this LinkedList. - AUTHOR KRITHIVASAN */ 
	/*******************************************************************************/
	
	public Object clone(){
		Node header = head;
		return header;
	}
	
	/**********************************************************************************/
	/* Returns true if this list contains the specified element. - AUTHOR KRITHIVASAN */ 
	/**********************************************************************************/
	
	public boolean contains(E e){
		Node ptr = head;
		while(ptr.getNext() != null){
			ptr = ptr.getNext();
			if(ptr.getData().equals(e)) return true;
		}
		return false;
	}
	
	
	/**********************************************************************************************************/
	/* Returns an iterator over the elements in this deque in reverse sequential order. - AUTHOR KRITHIVASAN */ 
	/**********************************************************************************************************/
	
	public Iterator descendingIterator(){
		
		E[] e = (E[]) new Object[listSize];
		Node ptr = head;
		int top=-1;
		while(ptr.getNext() != null){
			e[top++] = (E) ptr.getData();
			ptr = ptr.getNext();
		}
		List<E> DescendingList = new ArrayList<>();
		while(top > 0){
		  DescendingList.add(e[top]);
		  top--;
		}
		e = null;
		return DescendingList.iterator();
	}
	
	/**********************************************************************************************************/
	/*Retrieves, but does not remove, the head (first element) of this list.- AUTHOR KRITHIVASAN */ 
	/**********************************************************************************************************/
	
	public E element(){
		return (E)head.getData();
	}
	
	/**********************************************************************************************************/
	/*Returns the element at the specified position in this list. - AUTHOR KRITHIVASAN */ 
	/**********************************************************************************************************/
	
	public E get(int index){
		Node pointer = head;
		int cnt=0;
		while(pointer.getNext() != null){
			pointer = pointer.getNext();
			cnt++;
			if(cnt == index) return (E)pointer.getData();
		}
	return null;
	}
	
	/**********************************************************************************************************/
	/*Returns the first , last element in the list - AUTHOR KRITHIVASAN */ 
	/**********************************************************************************************************/
	
	public E getFirst(){
		Node p = head;
		return (E) p.getData();
	}
	
	public E getLast(){
		Node ptr = head;
		while(ptr.getNext() != null){
			ptr = ptr.getNext();
		}
	return (E) ptr.getData();
	}
	
	/**********************************************************************************************************/
	/*Returns the index of the first occurrence of the specified element in this list, or -1 if this list 
	 * does not contain the element.
	 */
	/**********************************************************************************************************/
	
	public int indexOf(Object o){
		int index=0;
		Node ptr = head;
		while(ptr.getNext() != null){
			ptr = ptr.getNext();
			if(ptr.getData().equals(o)) return index;
			index++;
		}
		return -1;
	}
	
	/**********************************************************************************************************/
	/*Returns the index of the last occurrence of the specified element in this list, or -1 if this list 
	 * does not contain the element.
	 */
	/**********************************************************************************************************/
	
	public int lastIndexOf(Object o){
		int index=0;
		int temp=-1;
		Node ptr = head;
		while(ptr.getNext() != null){
			ptr = ptr.getNext();
			if(ptr.getData().equals(o)) temp = index;
			index++;
		}
		return temp;
	}
	
	/**********************************************************************************************************/
	/*Returns a list-iterator of the elements in this list (in proper sequence), starting at the specified 
	 * position in the list.
	 */
	/**********************************************************************************************************/
	
	public ListIterator<E> listIterator(int index){
		int temp=0;
		Node ptr = head;
		while(ptr.getNext() != null){
			ptr = ptr.getNext();
			if(temp == index) break;
				temp++;
		}
		List<E> elements = new ArrayList<>();
		
		while(ptr.getNext() != null){
			elements.add((E) ptr.getData());
			ptr = ptr.getNext();
		}
		return elements.listIterator();
	}
	
	
	
	/*************************************************************************************************************
	 * Removes the element at the specified position in this list. Shifts any subsequent elements to the left 
	 * 
	 * (subtracts one from their indices). Returns the element that was removed from the list (OR) Returns NULL if
	 * 
	 * it is not found.
	 **************************************************************************************************************/
	
	public E remove(int index){
		if(index > listSize) Logger.getLogger(" The index size exceeds the LinkedList SIZE");
		else{
			int top=0;
			Node curr = head;
			while(curr.getNext() != null){
				curr = curr.getNext();
				top++;
			    if(top == index) break;	
			}
			Node temp = head;
			head = head.getNext();
			listSize--;
			return (E) temp.getData();
		}
		return null;
	}
	
	
	/*************************************************************************************************************
	 * Removes and returns the first element from this list.
	 **************************************************************************************************************/
	
	public E removeFirst(){
		Node header = head;
		head = header.getNext();
		listSize--;
	return (E)header.getData();
	}
	
	/*************************************************************************************************************
	 * Removes and returns the first element from this list.
	 **************************************************************************************************************/
	
	public boolean removeFirstOccurrence(Object o){
		Node ptr = head;
		while(ptr.getNext() != null){
			if(ptr.getData().equals(o)) break;
			ptr = ptr.getNext();
		}
		ptr.setNext(ptr.getNext().getNext());
		ptr.getNext().setNext(ptr);
		listSize--;
		return true;
	}
	
	/*************************************************************************************************************
	 * Removes and returns the last element from this list.
	 **************************************************************************************************************/
	
	public E removeLast(){
		Node ptr = head;
		while(ptr.getNext() != null){
			ptr = ptr.getNext();
		}
		listSize--;
	    Node temp = head;
	    head = head.getPrev();
		return (E) temp.getData();
	}
	
	/*************************************************************************************************************
	 * Replaces the element at the specified position in this list with the specified element.
	 **************************************************************************************************************/
	
	public E set(int index, E element){
	   
	   Node ptr = head;
	   int counter = 0;
	   
	   while(ptr.getNext() != null){
		   counter++;
		   if(index == counter) break;
		   ptr = ptr.getNext();
	   }
	   	   E elements = (E) ptr.getData();
	       ptr.setData(element);
	  return elements;
	}
	
	/*************************************************************************************************************
	 * Returns an array containing all of the elements in this list in proper sequence (from first to last element).
	 **************************************************************************************************************/
	
	public Object[] toArray(){
		Object[] obj = new Object[listSize];
		Node ptr = head;
		int i=0;
		while(ptr.getNext() != null){
			obj[i] = ptr.getData();i++;
			ptr = ptr.getNext();
		}
	return obj;
	}
	
	/*************************************************************************************************************
	 * Returns the number of elements in this list.
	 **************************************************************************************************************/
	
	public int size(){
		return listSize;
	}
	
}
