/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListasDoblementeLigadas;

/**
 *
 * @author val8a_000
 */
public class LinkedList<E> implements List<E> {
    private Node<E> header;
    private int size;
    
    public LinkedList(){
        header=new Node<E>();
        size=0;
        
    }
    
       /**
        *gets the node at the specified index
        *@return the node at the specified index
        *@param index of the index of the node to get
        *@throws IndexOutOfBoundsException if the index is out of range (index<0)}
        */
    private Node<E> node(int index){
        if(index<0||index>=size()){
            throw new IndexOutOfBoundsException();
    }
        if(index<(size>>1)){
            //el elemento está en la primera mitad de la lista
            Node<E> x= header.next;
            for (int i=0;i<index;i++){
                x=x.next;
            }
            return x;
        }
        else{
            //el elemento está en la segunda mitad
            Node<E> x= header.prev;
            for(int i=size-1; i>index;i--){
                x=x.prev;
                        
            }
            return x;
        }
    }    
    @Override 
    public void addFirst(E e){
        Node<E> newElement= new Node<E>(e);
        Node<E> firstElement=header.next;
        newElement.next=firstElement;
        firstElement.prev=newElement;
        
        newElement.prev=header;
        header.next=newElement;
        size++;
    }
    @Override
    public void add(int index,E element){
        if(index<0||index>size()){
            throw new IndexOutOfBoundsException();
        }
        Node<E> newNode=new Node<E>(element);
        Node<E> current=node(index);
        Node<E> previousNode=current.prev;
        
        newNode.prev=previousNode;
        previousNode.next=current;
        
        newNode.next=current;
        current.prev=newNode;
        
        size++;
    }
}
