package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	 LLNode<E> head;
	 LLNode<E> tail;
	 int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		this.size = 0;
		this.head = null;
		this.tail = null;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
			
		LLNode<E> tmp = new LLNode<E>(element,null,tail);
		System.out.println("head :" + this.head);
		System.out.println("tail :" + this.tail);
		System.out.println("Temp.prev :" + tmp.prev);
		System.out.println("Temp.next :" + tmp.next);
		
		
		if(tail != null) {tail.next = tmp;}

        tail = tmp;

        if(head == null) { head = tmp;}

        size++;
        System.out.println("head :" + this.head);
		System.out.println("tail :" + this.tail);
		System.out.println("Temp.prev :" + tmp.prev);
		System.out.println("Temp.next :" + tmp.next);
		
        return true;
		
		
		
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		if (this.size < index | index < 0) {
			throw 
				new IndexOutOfBoundsException("the element @ index not found");
		}
		int count = 0;
		// TODO: Implement this method.
		LLNode<E> n = head;
		while (n != null && count <= index){
			count++;
			n = n.next;
		}
		
		return n.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
	}


	/** Return the size of the list */
	public int size() 
	{
		int listSize = 0;
		LLNode<E> n = head;
		while (n != null){
			listSize++;
			n = n.next;
		}
		// TODO: Implement this method
		return listSize;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		return null;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		return null;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}
	
	public LLNode(E e, LLNode<E> head, LLNode<E> tail){
		this.data = e;
		this.prev = head;
		this.next = tail;
	}

}
