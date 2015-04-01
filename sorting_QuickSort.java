package sorting;

import java.io.*;

public class QuickSort {

    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
        System.out.println("enter the number of elements");
        int n = Integer.parseInt(br.readLine());
        System.out.println("enter the numbers with spaces");
        String[] z = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(z[i]);
        }
        for (int i = 0; i < n; i++) {
            pw.printf("%d ", arr[i]);
        }
        pw.println();
        //create a object of that class mergesort given below
        Quicksort sort = new Quicksort();
        sort.sort(arr);
        for (int i = 0; i < n; i++) {
            pw.printf("%d ", arr[i]);
        }
        pw.close();
    }
    static class Quicksort{
        public static void sort(int[] arr){

            sort(arr,0,arr.length-1);
        }
        public static void sort(int[] arr,int lo,int hi){
            if(hi<=lo) return;
            int j = partition(arr,lo,hi);
            sort(arr,lo,j-1);
            sort(arr,j+1,hi);
        }
        //this is to create a partition of the array so elements before the pivot are less and above are high than pivot
        public static int partition(int[] arr,int lo,int hi){
            int i = lo ;int j = hi+1;
            while(true){
                while(arr[++i]<arr[lo]){
                    if(i==hi) break;
                }
                while(arr[--j]>arr[lo]){
                    if(j==lo) break;
                }
                if(j<=i) break;
                swap(arr,i,j);
            }
            swap(arr,lo,j);
            return j;
        }
        public static void swap(int[] arr,int a,int b){
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
    }
}
