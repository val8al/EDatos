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
    
public interface IQueue <E> {
    

    public void offer(E e);//Inserta un elemento a la fila
    
    public E remove();//Quita y regresa el primer elemento en la fila (head). Si la fila está vacía arroja NoSuchElementException
    
    public E element();//Obtiene el primer elemento formado en la fila sin removerlo. Arroja NoSuchElement si la fila está vacía
    
    public boolean isEmpty();
    
    public void clear();
    
    public int size();
    
    public Object[] toArray();
    
    
}
    

