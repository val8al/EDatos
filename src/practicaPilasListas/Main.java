/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaPilasListas;
import java.util.Stack;
import java.util.Queue;
/**
 *
 * @author val8a_000
 */
public class Main {
    public static void main(String[] args){ 
        /*System.out.println(checkForBalance("{}[]()"));
        System.out.println(checkForBalance("minecraft.jaqear(10)]={}"));
        System.out.println(checkForBalance("{[(=:=)]}"));*/
        
        System.out.println(postFixEval("435*+"));
        System.out.println(postFixEval("38+*9"));
        System.out.println(postFixEval("98+7"));
    }
    public static String checkForBalance(String expr){
        char[] chars=expr.toCharArray();
        Stack st = new Stack();
        
        
        for(int i=0;i<chars.length;i++){
            char current=chars[i];
            
            if(current=='{'||current=='('||current=='['){
                st.push(current);      
            }
            if(current=='}'||current==')'||current==']'){
                if(st.empty()){
                    return "Missing left for    "+current;
                }
                switch(current){
                    case'}':
                        if(!st.peek().equals('{')){
                            return "Missing left for "+current;
                        }
                        else{
                            st.pop();
                        }
                    break;
                    case')':
                        if(!st.peek().equals('(')){
                            return "Missing left for "+current;
                        }    
                        else{
                            st.pop();
                        }
                    break;
                    case']':
                        if(!st.peek().equals('[')){
                            return "Missing left for "+current;    
                        }
                    else{
                            st.pop();
                        }
                    break;
            }
        }
        
    }
    if(!st.empty()){
        return "Missing right for "+st.peek().toString();
        }    
    return "The code is balanced";
    }
    public static String postFixEval(String expr){
        char[] chars=expr.toCharArray();
        Stack st = new Stack();
        
        for(int i=0;i<chars.length;i++){
          
            char current=chars[i];
            if(Character.isDigit(current)){
                st.push(current);   
            }
            if((current=='+'||current=='-'||current=='*'||current=='-')){
                
                if(st.size()>=2){
                    String s=st.pop().toString();
                    String t=st.pop().toString();
                   
                    int x=Integer.parseInt(s);
                    int y=Integer.parseInt(t);
                    
                    switch(current){
                        case '+':
                            st.push(x+y);
                            
                            break;
                        case '-':
                            st.push(y-x);
                            break;
                        case '*':
                            st.push(x*y);
                            break;
                        case '/':
                            st.push(y/x);
                            break;
                }
                   
             
            }
            else{
                return "The expression has too many operators";
            }       
        }
        
     
    }
        
        if(st.size()>1){
            return "The expression has too many operands";
        }
         return st.pop().toString();
    }
    
    
    
    public class Printer {
	private Queue<String> printerSpool;
	
	public Printer() {
		 printerSpool =new Queue<String>();
	}
	
	public void printDocument(String name) {
            printerSpool.offer(name); 
		
	}	
	public void runPrinter() throws InterruptedException  {
           
           while(!printerSpool.isEmpty()){
               if (Thread.interrupted()){ 
                    throw new InterruptedException();
           }
               else{
                    Thread.sleep(5000);
                    String remove = printerSpool.remove();
                    System.out.println(remove);
                   
               }
   
           }
           System.out.println("Finished printing documents");
	}
        
}
  public static void fibonacci(int n) {
            Queue <Integer> fibonacci = new Queue <Integer>();
            fibonacci.offer(1);
            fibonacci.offer(1);
            for (int i = 0; i < n; i++){
                int a = fibonacci.remove();
                int b = fibonacci.remove();
                System.out.print(a + " ");
                fibonacci.offer(b);
                fibonacci.offer(a + b);
       
            }
		
	}  
}