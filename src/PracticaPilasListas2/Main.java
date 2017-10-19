/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PracticaPilasListas2;

import java.util.Arrays;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author val8a_000
 */

public class Main {
    public static void main(String[] args) {
        System.out.println(convertInfixToPostFix("( 2 + 4 ) / (7-6)"));
        System.out.println(convertInfixToPostFix("( 2 * 3 + 1 / 2) / 4 )"));
    }
    public static boolean hasHigherPrecedence(String stackTop, String operator) {
 return !((stackTop.equals("+") || stackTop.equals("-"))
 && (operator.equals("*") || operator.equals("/")));
 }
    public static String convertInfixToPostFix(String expr){
        Queue<String> queue=new LinkedList<String>();
        Stack stack=new Stack();
        
        
        for(int i=0;i<expr.length();i++){//FOR principal recorre cada caracter
          
            char current=expr.charAt(i);
            String javapls=Character.toString(current);
            
            if(Character.isDigit(current)||Character.isLetter(current)){
                queue.add(javapls);    
            }
            if(javapls.equals("(")){
                
                stack.push(current);
            }
            
            if(javapls.equals("+")||javapls.equals("-")||javapls.equals("*")||javapls.equals("/")){
                while(!(stack.empty())&&!stack.peek().toString().equals("(")){//NUNCA SE CUMPLE
                    
                    if(hasHigherPrecedence(stack.peek().toString(),javapls)){
                      
                        queue.add(stack.pop().toString());
                    }
                    else{break;}
                    
                }
                
                stack.push(javapls);
                System.out.println(stack.peek());
            }
            if(javapls.equals(")")){
                while(!(stack.empty())&&!stack.peek().equals("(")){
                    queue.add(stack.pop().toString());
                }
            if(!stack.empty()){
                   stack.pop();
                }
              
            }
          
           
        }
        if(!stack.empty()){
            while(!stack.empty()){
                queue.add(stack.pop().toString());
            }
        }
        
        return queue.toString();
    }
    
}