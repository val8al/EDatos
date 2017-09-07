/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExamenPractico1;

import java.util.Arrays;


/**
 *
 * @author Valentín Ochoa
 */
public class ArrayList<E> implements List<E> {
	public Object[] top;
	private int size;
	private int initialCapacity = 5;
	private int extraCapacity = 5;
	
	/**
	 * Creates a new ArrayList instance with the default initial capacity.
	 */
	public ArrayList() {
		top = new Object[initialCapacity];
		size = 0;
	}
	
	/**
	 * Increases the capacity of this ArrayList instance so that it 
	 * can hold at least extraCapacity elements more.
	 * This method allocates a new array with greater capacity than the
	 * current one (top.length + extraCapacity) and copies all elements
	 * from top to the newly allocated array. The reference top is then
	 * updated to point to the new array. 
	 * @param extraCapacity increase the capacity of this ArrayList by this amount
	 */
	private void reserveExtraCapacity(int extraCapacity) {
            Object[] newTop = new Object[top.length+extraCapacity];
            for(int i=0;i<top.length;i++){
                newTop[i]=top[i];
            }
            top=newTop;
	}
	
	/**
	 * Increases the capacity of this list if its size equals the length of the array
	 * where the data is stored. This method calls reserveExtraCapacity when (size() >= top.length).
	 * reserveExtraCapacity is called using the instance variable extraCapacity.
	 */
	private void ensureCapacity() {
            if (this.size()>=top.length){
                this.reserveExtraCapacity(extraCapacity);
            }
	}
	
	/**
	 * Shifts elements in the array (top) to the right, starting at the given position.
	 * @param index the position in which the shift will begin
	 * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index > size())
	 */
	private void shiftContentsRight(int index) {
            
            if(index<0||index>size()){
                throw new IndexOutOfBoundsException();
            }
            
             Object[] newTop = new Object[top.length+1];
            for(int i=index;i<size;i++){
                newTop[i+1]=top[i];
            }
            
            for(int i=0;i<index;i++){
                newTop[i]=top[i];
            }
            top=newTop;
            
	}
	
	@Override
	public void addFirst(E e) {
            Object first=top[0];
            this.shiftContentsRight(0);
            top[0]=e;
            size++;
	}

	@Override
	public void addLast(E e) {
            this.reserveExtraCapacity(1);
            top[this.size()]=e;
            size++;
	}

	@Override
        
	public void add(int index, E element) {
            if(index<0||index>size()){
                throw new IndexOutOfBoundsException();
            }
            this.shiftContentsRight(index);
            for(int i=0;i<this.size();i++){
                if(top[i]==null){
                    top[i]=element;
                }
            }
            size++;
	}

	@Override
	public E getFirst() {
            if (this.size==0){
		return null;
            }
            else {return null;
            }
	}

	
	@Override
	public E getLast() {
		return null;
	}

	
	@Override
	public E get(int index) {
		return null;
	}

	@Override
	public E set(int index, E element) {
		return null;
	}

	@Override
	public void clear() {
            Object[] newTop={};
            top=newTop;
            size=0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size==0;
	}

	@Override
	public String toString() {
            String s="[";
            for(int i=0;i<this.size();i++){
                s+=top[i]+", ";
            }
            return s+"]";
        }
}
