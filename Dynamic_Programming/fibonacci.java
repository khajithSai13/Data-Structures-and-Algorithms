package Dynamic_Programming;
//import java.util.*;
public class fibonacci {
    public static void fib(int n){
        int dp[] = new int[n];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        } 
        System.out.println(dp[n-1]);
    }
    public static int fib2(int n){
        if(n==0) return 0;
        if(n ==1)return 1;
        return fib2(n-1)+fib2(n-2);
    }
    public static void main(String[] args) {
        int n = 10;
        System.out.println(fib2(10));
    }
}
