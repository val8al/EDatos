/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DLLPractica;
public class Main {

	public static void main(String[] args) {
		System.out.println("** TEST JOSEPHUS() **");
		
		LinkedList<Integer> iList = new LinkedList<Integer>();
		
		
		System.out.println(iList);
		for(int i = 0; i < 10; i++) {
			iList.addFirst(i);
		}
                System.out.println(iList);
                System.out.println(iList.josephus(2));
		
	}
}
