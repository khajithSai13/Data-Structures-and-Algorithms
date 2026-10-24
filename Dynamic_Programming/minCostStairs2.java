package Dynamic_Programming;

public class minCostStairs2 {
    public static int minimum(int[] stairs){
        int n = stairs.length;
        if(n ==0) return 0;
        int[] dp = new int[n+1];
        dp[0] = 0;dp[1] = 0;
        for(int i=2;i<=n;i++){
            dp[i] = Math.min(dp[i-2]+stairs[i-2],dp[i-1]+stairs[i-1]);
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int[] stairs = {10,15,20};
        System.out.println(minimum(stairs));
    }
}
