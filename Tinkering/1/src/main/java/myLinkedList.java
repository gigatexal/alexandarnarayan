


public class myLinkedList<E> {
	private Node next;
	private Node previous;
	private int size;
	
	
	public myLinkedList() {
		// TODO Auto-generated constructor stub
	}
	
	class Node {
		Node n;
		Node p;
		E data;
	}
	
	public void add(E d){
		Node temp = new Node();
		temp.data = d;
		this.previous = this.next;
		this.next = temp;
		temp.n = this.next;
		size++;
	}
	
	public Node getNext(){
		return this.next;
	}
	
	

}
