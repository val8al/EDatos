/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ordenamientos;
import java.util.Arrays;

/**
 *
 * @author val8a_000
 */
public class Main {
    public static void main(String[] args){
        int[] arreglo={9,1,2,0,3,4,5,8,6,7};
        //System.out.println(Arrays.toString(shiftRight(arreglo,2,5)));
        //selectionSort(arreglo);
        //insertionSort(arreglo);
        //bubbleSort(arreglo);
        //makeHeap(arreglo);
        heapSort(arreglo);
        
    }
    public static int[] shiftRight(int[] arr, int start, int end){
       int[] newArr=new int[arr.length];
       for(int i=0;i<start;i++){
           newArr[i]=arr[i];
       }
       for(int i=start;i<end;i++){
           newArr[i+1]=arr[i];
       }
       for(int i=end+1;i<arr.length;i++){
           newArr[i]=arr[i];
       }
       return newArr;
    }
    public static void insertionSort(int[] arr){
        int tommy;
        for(int i=1;i<arr.length;i++){
            for(int j=0;j<i;j++){
                if(arr[i]<=arr[j]){
                    tommy=arr[i];
                    arr=shiftRight(arr,j,i);
                    arr[j]=tommy;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void selectionSort(int[] arr){
       
        
        for(int i=0;i<arr.length;i++){
          int current=arr[i];
          for(int j=i;j<arr.length;j++){
              if(arr[j]<=arr[i]){
                  arr[i]=arr[j];
                  arr[j]=current;
                  current=arr[i];
              }
          }
        }
        System.out.println(Arrays.toString(arr));
        
        
    }
    public static void bubbleSort(int[] arr){
        boolean not_sorted=true;
        int holder;
        while(not_sorted){
            for(int i=1;i<arr.length-1;i++){
                if(arr[i]<arr[i-1]){
                   holder=arr[i];
                   arr[i]=arr[i-1];
                   arr[i-1]=holder;
                   not_sorted=true;
                }
            }
            not_sorted=false;
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void makeHeap(int values[]){
        for (int i=0; i<values.length;i++){
            int index=i;
            while(index!=0){
                int parent=(index-1)/2;
                if(values[index]<=values[parent]){
                    break;
                }
               int temp=values[index];
               values[index]=values[parent];
               values[parent]=temp;
               
               index=parent;
            }
        }
        System.out.println("Heap Form: "+Arrays.toString(values));
    }
        public static int removeTopItem (int values[], int count){
        int result = values[0];
        values[0] = values [count - 1]; // ultimo elemento de nuestra lista
        
        int index = 0;
        while (true){
            int child1 = 2 * index + 1;
            int child2 = 2 * index + 2;
            
            if(child1 >= count){
                child1 = index;
            }
            
            if(child2 >= count){
                child2 = index;
            }
            
            if(values[index] >= values[child1] && values[index] >= values[child2]){
                break;
            }
            int swapChild = child1;
            if(values[child2] > values[child1]){
                swapChild = child2;
            }
            
            int temp = values[index];
            values[index] = values[swapChild];
            values[swapChild] = temp;
            
            index = swapChild;
            }
        return result;
        }
    public static void heapSort(int arr[]){
       
        makeHeap(arr);
        int x=arr[arr.length-1];       
        for(int i=arr.length-1;i>0;i--){
            
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
          
            removeTopItem(arr,i);
           
        }
        arr[1]=x;
        System.out.println(Arrays.toString(arr));
      
    }
    
    
    
}
