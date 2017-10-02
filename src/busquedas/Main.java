/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busquedas;

/**
 *
 * @author val8a_000
 */
public class Main {
    public static void main(String[] args) {
       int[] arreglo={1,2,5,8,33,66,420,421};
       
       System.out.println(linearSearch(arreglo,420));
       System.out.println(binarySearch(arreglo,420));
       System.out.println(binarySearch(arreglo,11));
    }
    public static int linearSearch(int[] list,int target){
        for(int i=0;i<list.length;i++){
            if(list[i]==target){
                return 1;
            }
            if(list[i]>target){
                return -1;
            }
        }
    return -1;

    }
    
    public static int binarySearch(int [] arr,int target){
        int min=0;
        int max=arr.length-1;
        
        while(min<=max){
            int mid=(min+max)/2;
            if(target>arr[mid]){
                max=mid-1;
            }
            if(target>arr[mid]){
                min=mid+1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }
}