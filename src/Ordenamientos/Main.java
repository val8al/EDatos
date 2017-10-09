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
        int[] arreglo={2,7,8,9,420,15,11,14};
        //System.out.println(Arrays.toString(shiftRight(arreglo,2,5)));
        selectionSort(arreglo);
        insertionSort(arreglo);
        bubbleSort(arreglo);
        
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
    
    
    
}
