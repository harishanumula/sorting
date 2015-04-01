package sorting;

import java.util.*;
import java.lang.*;
import java.io.*;



public class Shellsort
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
        int h = 1;
        // to get h in format of 3h+1 1,4,13 etc
        while(h<n/3){
            h = 3*h+1;
        }
        while(h>=1) {
            for (int i = h; i < n; i+=1) {
                int d = i;
                while (d > h-1 && arr[d] < arr[d - h]) {
                    int temp = arr[d];
                    arr[d] = arr[d - h];
                    arr[d - h] = temp;
                    d-=h;
                }
            }
            h = h/3;
        }
        for(int i = 0;i<n;i++){
            pw.printf("%d ",arr[i]);
        }
        pw.println();
        pw.close();
    }
}