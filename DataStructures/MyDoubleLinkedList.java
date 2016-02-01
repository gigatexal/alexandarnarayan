/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sandbox;

/**
 *
 * @author gigatexal
 */
public class MyDoubleLinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;
    
    public MyDoubleLinkedList() {
        this.head = new Node<E>(null);
        this.tail = new Node<E>(null);
        this.size = 0;
        head.next = tail;
        head.prev = head;

    }
    
    //Node
    class Node<E> {
        Node<E> prev = null;
        Node<E> next = null;
        E data;
    
    
    public Node(){
        
        this.prev = null;
        this.next = null;
        data = null;
        }
    
    public Node(E d){
        this.data = d;
        this.next = null;
        this.prev = null;
        }
    
    public void to_s(){
        System.out.println("Node.prev :" + this.prev + " Node.next " + this.next + " Node.data " + this.data);
        }
    }
    //methods
    public void add(E d){
        
        Node<E> n = new Node<E>(d);
        //n.to_s();
        n.next = head.next;
        n.prev = n.next.prev;
        n.next.prev = n;
        head.next = n;
        
        size++;
        //print("n.next.next " + n.next.next);
        //n.to_s();
    }
    
    public void getAll(){ //forward
        Node<E> n = head.next;
        Node<E> t = this.tail;
        while (n.next != t){
            System.out.println(n.data);
            n = n.next;
        }
    }
    
    public void getTail(){
        Node<E> n = tail.prev;
        Node<E> h = head.next;
        while (n != head){
            System.out.println(h + " " + n + " " + n.data);
            n = n.prev;
        }
        
    }
    
    
    
    
    private void print(Object item){
        System.out.println(item);
    }
    }


