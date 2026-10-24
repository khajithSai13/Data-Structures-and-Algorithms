package Dynamic_Programming;
//import java.util.*;
public class Rober {
    public static void rob(int houses[]){
        int n = houses.length;
        int[] dp  = new int[n];
        dp[0] = houses[0];
        dp[1] = Math.max(houses[1],houses[0]);
        for(int i=2;i<n;i++){
            dp[i] = Math.max(dp[i-1],houses[i]+dp[i-2]);
        }
        System.out.println(dp[n-1]);
    }
    public static void rob2(int[] houses){
    int n = houses.length;
    if(n == 1){
        System.out.println(houses[0]);
        return;
    }

    int[] dp1 = new int[n-1];
    int[] dp2 = new int[n-1];

    // case 1: 0 → n-2
    dp1[0] = houses[0];
    dp1[1] = Math.max(houses[0], houses[1]);
    for(int i = 2; i < n-1; i++){
        dp1[i] = Math.max(dp1[i-1], houses[i] + dp1[i-2]);
    }

    // case 2: 1 → n-1
    dp2[0] = houses[1];
    dp2[1] = Math.max(houses[1], houses[2]);
    for(int i = 2; i < n-1; i++){
        dp2[i] = Math.max(dp2[i-1], houses[i+1] + dp2[i-2]);
    }

    System.out.println(Math.max(dp1[n-2], dp2[n-2]));
}
}
