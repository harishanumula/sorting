package sorting;

import java.io.*;

public class MergeSort {

    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
        System.out.println("enter the number of elements");
        int n = Integer.parseInt(br.readLine());
        System.out.println("enter the numbers with spaces");
        String[] z = br.readLine().split(" ");
        int[] arr = new int[n];
        for(int i =0;i<n;i++){
            arr[i] = Integer.parseInt(z[i]);
        }
        for (int i = 0; i < n; i++) {
            pw.printf("%d ", arr[i]);
        }
        pw.println();
        //create a object of that class mergesort given below
        Mergesort sort = new Mergesort();
        sort.mergesort(arr);
        for (int i = 0; i < n; i++) {
            pw.printf("%d ", arr[i]);
        }
        pw.close();
    }

    //merge sort algo
    static class Mergesort {
        //implementtion of merge
        private  static void merge(int[] arr, int[] aux, int lo, int mid, int hi) {
            for(int i =lo;i<=hi;i++){
                aux[i] = arr[i];
            }
            int i=lo,j=mid+1;
            //merging
            for(int k = lo;k<=hi;k++){
                if(i>mid){
                    arr[k] = aux[j++];
                }
                else if(j>hi){
                    arr[k] = aux[i++];
                }
                else if(aux[i]<aux[j]){
                    arr[k] = aux[i++];
                }
                else{
                    arr[k] = aux[j++];
                }
            }

        }
        //taken from user as argument arr
        public static  void mergesort(int[] arr) {
            int[] aux = new int[arr.length];
            mergesort(arr, aux, 0, arr.length - 1);
        }
        //this to sort small parts when dividing the array into small parts
        public static void mergesort(int[] arr,int[] aux,int lo,int hi){
            if(hi<=lo) return;
            int mid = lo + (hi-lo)/2;
            mergesort(arr, aux, lo, mid); if(lo>hi)
            mergesort(arr,aux,mid+1,hi);
            //to see if it is already sorted before  merging
            if(arr[mid]<arr[mid+1]){
                return;
            }
            merge(arr,aux,lo,mid,hi);
        }
    }
}
