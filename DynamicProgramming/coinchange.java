package DynamicProgramming;
import java.util.*;
public class coinchange {
    public static int change(int[] coins,int v){
        int[] dp = new int[v+1];
        Arrays.fill(dp,v+1);
        dp[0] = 0;
        for(int i=1;i<dp.length;i++){
        for(int coin : coins){
            if(coin <=i){
                dp[i] = Math.min(dp[i],1+dp[i-coin]);
            }
        }
    }
    return dp[v] == v+1? -1:dp[v];
    }
    public static int ways(int[] coins, int amount){
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int coin : coins){
            for(int i=coin ; i<=amount;i++){
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];
    }
    public static void main(String[] args) {
    int[] coins = {1,2,5};
    int v = 60;
    System.out.println(ways(coins,v));
}
}
