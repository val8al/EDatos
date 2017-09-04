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
public class DraftList {
    private LinkedList<String> daList;
    
    public void addPlayer(String name){
        daList.addLast(name);
        
    }
    public void removePlayer(String name){
        daList.remove(name);
    }
    public void increaseRank(String name, int rank){
        if(daList.contains(name)){
            daList.remove(name);
            daList.add(rank-1, name);
        }
    }
    public void shiftRank(String player1, String player2){
        if(daList.contains(player1)&&daList.contains(player2)){
            int IndexPlayer1=daList.indexOf(player1);
            int IndexPlayer2=daList.indexOf(player2);
            
            daList.set(IndexPlayer1, player2);
            daList.set(IndexPlayer2, player1);
            
        }
    }
    public String toString(){
        if(daList.isEmpty()){
            return "Da draft list is empty";
        }
        String returnValue="";
        for(int i=0; i<daList.size();i++){
        return "swag";
        }
        return "swog";
    }
    
}
