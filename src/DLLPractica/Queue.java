/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DLLPractica;

/**
 *
 * @author val8a_000
 */
public class Queue<E> implements IQueue <E> {
    
    private LinkedList<E> fila;

    @Override
    public void offer(E e) {
        fila.addFirst(e);
        
    }

    @Override
    public E remove() {
        return fila.removeFirst();
    }

    @Override
    public E element() {
        return fila.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return fila.isEmpty();
    }

    @Override
    public void clear() {
        fila.clear();
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
       
       
}

