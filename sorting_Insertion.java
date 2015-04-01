package sorting;

import java.util.*;
import java.lang.*;
import java.io.*;



public class Insertion
{
    public static void main (String[] args) throws java.lang.Exception
    {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
        System.out.println("enter the number of elements");
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        for(int i = 1;i<n;i++){
            int d = i;
            while(d>0 && arr[d]<arr[d-1]){
                int temp = arr[d];
                arr[d] = arr[d-1];
                arr[d-1]= temp;
                d--;
            }
        }
        for(int i = 0;i<n;i++){
            pw.printf("%d ", arr[i]);
        }
        pw.println();
        pw.close();
    }
}