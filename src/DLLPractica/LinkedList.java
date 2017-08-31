/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DLLPractica;

import java.util.Arrays;

/**
 *
 * VALENTIN OCHOA 
 * GERARDO LOPEZ 
 */
public class LinkedList<E> implements List<E> {
	private Node<E> header;
	private int size;
	
	public LinkedList() {
		header = new Node<E>();
		size = 0;
	}
	
	/**
	 * Gets the node at the specified index.
	 * @param index the index of the node to get
	 * @return the node at the specified position
	 * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
	 */
	private Node<E> node(int index) {
		if(index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		
		if (index < (size >> 1)) {
            Node<E> x = header.next;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<E> x = header.prev;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
	}

	@Override
	public void addFirst(E e) {
		// TODO Auto-generated method stub
        Node<E> newElement= new Node<E>(e);
        Node<E> firstElement=header.next;
        newElement.next=firstElement;
        firstElement.prev=newElement;
        
        newElement.prev=header;
        header.next=newElement;
        size++;
	}

	@Override
	public void addLast(E e) {
		// TODO Auto-generated method stub
            Node<E> newElement=new Node<E>(e);
            Node<E> lastElement=header.prev;
            newElement.prev=lastElement; 
            lastElement.next=newElement;
            
            header.prev=newElement; 
            newElement.next=header;
            size++;
            
		
	}

	@Override
	public void add(int index, E element) {
		// TODO Auto-generated method stub
            if(index<0||index>size()){
                throw new IndexOutOfBoundsException();
             }
            
            Node<E> newElement=new Node<E>(element);
            
            Node<E> current=header;
            for(int i=0;i<index;i++){
                current=current.next;
            }
        current.next.prev=newElement;  //El elemento siguiente apunta hacia atrás al nuevo elemento
        newElement.next=current.next;
        newElement.prev=current;
        current.next=newElement;
        size++;
	}

	@Override
	public E removeFirst() {
		// TODO Auto-generated method stub
            header.next=header.next.next; //el segundo nodo se convierte en header.next
            header.next.prev=header;
            size--;
		return null;
	}

	@Override
	public E removeLast() {
		// TODO Auto-generated method stub
            header.prev=header.prev.prev; // el penúltimo nodo se convierte en header.prev
            header.prev.next=header;
            size--;
		return null;
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
            
            if(index<0||index>size()){
            throw new IndexOutOfBoundsException();
            }
            Node<E> current=header;
            for(int i=0;i<index;i++){
               current=current.next; 
            }
            current.next=current.next.next; //misma técnica usada en remove anterior
            current.next.prev=current;
            size--;
            
            
            return current.value;
	}

	@Override
	public boolean remove(Object o) {
            int index = indexOf(o);
		          
		if(index >= 0 && index < this.size()) { 
			this.remove(index);
		return true;
		}
            return false;
	}

	@Override
	public E getFirst() {
		// TODO Auto-generated method stub
            if(size()!=0){
                return header.next.value;
                
            }
		return null;
	}

	@Override
	public E getLast() {
		// TODO Auto-generated method stub
            if(size()!=0){
                return header.prev.value;
                
            }
		return null;
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
            if(index<0||index>size()){//validar índice
                throw new IndexOutOfBoundsException();
            }
            Node<E> current=header.next;
            for(int i=0;i<index;i++){
                current=current.next;
            }
		return current.value;
	}

	@Override
	public E set(int index, E element) {
		if(index<0||index>size()){
                throw new IndexOutOfBoundsException();
            }
            Node<E> current=header.next;
            for(int i=0;i<index-1;i++){ 
                current=current.next;
            }
                current.value=element;
		return current.value;
		
	}

	@Override
	public boolean contains(E e) {
		// TODO Auto-generated method stub
            
            Node<E> current=header.next;
            for(int i=0;i<size();i++){
                if(current.value==e){
                    return true;
                }
                current=current.next;
            }
		
		return false;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
            
            Node<E> current=header.next;
            if(o == null) { //para evitar o.equals(null)
                        int index=0;
			for(Node<E> x = header.next; x != null; x = x.next) {
				if(x.value == null){
					return index;}
				index++;
                        }
            }                    
            for(int i=0;i<size();i++){
                if(o.equals(current.value)){
                    return i;
                }
                current=current.next;
            }
		return -1;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
            
            header.next=header;
            header.prev=header;
            size=0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
            if(!this.isEmpty()){
                return this.size;
            }
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
            if(header.next==header&&header.prev==header){
		return true;
            }
            return false;
	}

	@Override
	public Object[] toArray() {
		
                Object[] returnArray = new Object[size];		
 		int i = 0;
 		for(Node<E> x = header.next; x != header; x = x.next){
                    if(x.value!=null){
 			returnArray[i++] = x.value;
                        
                    }
 		}
 		return returnArray;            		
	}
	
	@Override
	public String toString() {
            String s="";
            s=Arrays.toString(this.toArray()); //metodo de la clase sArrays convierte tal cual un arreglo a string
            
		return s;
	}
}
