/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author val8a_000
 */

public class integerLinkedList {
    public integerNode top=null;
    public integerLinkedList(){
        top=new integerNode();
    }
    public void addFirst(int element){
        integerNode newNode = new integerNode(element);
        newNode.next=top.next;
        top.next=newNode;
    }
    public String toString(){
        if(top.next==null){
            return "[]";
            integerNode current=top.next;
            String returnValue= "["+current.value;
            
            while(current.next !=null){
                current=current.next;
                returnValue+=", "+current.value;
            }
            returnValue+="]";
            return returnValue;
        }
        
    }
}
