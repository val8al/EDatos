package Practica2;
import java.util.*;
import java.util.NoSuchElementException;

public class SLinkedList<E> implements List<E> {
	private SNode<E> top;
	private int size;
	
	public SLinkedList() {
		top = new SNode<E>();
		size = 0;
	}
	
	@Override
	public void addFirst(E e) {
		SNode<E> newNode = new SNode<E>(e);
		newNode.next = top.next;
		top.next = newNode;
		size++;
	}
	
	@Override
	public void addLast(E e) {
		SNode<E> newNode = new SNode<E>(e);
		
		SNode<E> current = top;
		while(current.next != null)
			current = current.next;
		
		current.next = newNode;
		size++;
	}
	
	@Override
	public void add(int index, E element) {
		if(index < 0 || index > size()) {
			throw new IndexOutOfBoundsException();
		}
		
		SNode<E> newNode = new SNode<E>(element);
		
		SNode<E> current = top;
		for(int i = 0; i < index; i++)
			current = current.next;
		
		newNode.next = current.next;
		current.next = newNode;
		size++;
	}
	
	@Override
	public E removeFirst() {
		if(top.next == null) {
			throw new NoSuchElementException();
		}
		
		SNode<E> nodeToRemove = top.next;
		top.next = nodeToRemove.next;
		nodeToRemove.next = null;
		size--;
		
		return nodeToRemove.value;
	}
	
	@Override
	public E removeLast() {
		if(top.next == null) {
			throw new NoSuchElementException();
		}
		
		SNode<E> current = top;
		while(current.next.next != null)
			current = current.next;
		
		SNode<E> nodeToRemove = current.next;
		current.next = null;
		size--;
		return nodeToRemove.value;
	}
	
	@Override
	public E remove(int index) {
		if(index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		
		SNode<E> current = top;
		for(int i = 0; i < index; i++)
			current = current.next;
		
		SNode<E> nodeToRemove = current.next;
		current.next = nodeToRemove.next;
		nodeToRemove.next = null;
		size--;
		
		return nodeToRemove.value;
	}

	@Override
	public boolean remove(Object o) {
		int index = indexOf(o);
		
		if(index >= 0 && index < size()) {
			remove(index);
			return true;
		}
		
		return false;
	}
	
	@Override
	public E getFirst() {
		if(top.next == null) {
			throw new NoSuchElementException();
		}
		
		return top.next.value;
	}
	
	@Override
	public E getLast() {
		if(top.next == null) {
			throw new NoSuchElementException();
		}
		
		SNode<E> current = top.next;
		while(current.next != null)
			current = current.next;
		
		return current.value;
	}
	
	@Override
	public E get(int index) {
		if(index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		
		SNode<E> current = top.next;
		for(int i = 0; i < index; i++)
			current = current.next;
		
		return current.value;
	}

	@Override
	public E set(int index, E element) {
		if(index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		
		SNode<E> current = top.next;
		for(int i = 0; i < index; i++)
			current = current.next;
		
		E previousValue = current.value;
		current.value = element;
		
		return previousValue;
	}

	@Override
	public boolean contains(E e) {
		SNode<E> current = top.next;
		while(current != null) {
			if(current.value == e)
				return true;
			current = current.next;
		}
		
		return false;
	}
	
	@Override
	public int indexOf(Object o) {
		int index = 0;
		
		if(o == null) {
			for(SNode<E> x = top.next; x != null; x = x.next) {
				if(x.value == null)
					return index;
				index++;
			}
		}
		else {
			for(SNode<E> x = top.next; x != null; x = x.next) {
				if(o.equals(x.value))
					return index;
				index++;
			}
		}
		return -1;
	}
	
	@Override
	public void clear() {
		top.next = null;
		size = 0;
	}
	
	@Override
	public int size() {
		return size;
	}
	
	@Override
	public boolean isEmpty() {
		return size() == 0;
	}
	
	@Override
	public Object[] toArray() {
		Object[] returnArray = new Object[size];
		
		int i = 0;
		for(SNode<E> x = top.next; x != null; x = x.next)
			returnArray[i++] = x.value;
		
		return returnArray;
	}
	
	@Override
	public String toString() {
		if(top.next == null)
			return "[]";
		
		SNode<E> current = top.next;
		String returnValue = "[" + current.value;
		while(current.next != null) {
			current = current.next;
			returnValue += ", " + current.value;
		}
		
		returnValue += "]";
		return returnValue;
	}
}