package Recursion;

import java.util.Scanner;
import java.util.Stack;

public class MiddleElement {
    public static void Middle(int[] a){
        recurse(a,new Stack<>(),0,a.length%2);
    }
    static void recurse(int[] a,Stack<Integer> stack,int idx, int val){
    
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] a = {1,2,3,4,5,6};
        Middle(a);
        sc.close();
    }
}
