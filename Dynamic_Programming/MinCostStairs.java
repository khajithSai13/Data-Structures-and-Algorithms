package Dynamic_Programming;

public class MinCostStairs {
    public static int minCost(int [] a){
        int n = a.length;
        int minCost = 0;
        if(n == 1) return a[0];
        if(n ==2) return Math.min(a[0],a[1]);
        int[] dp = new int[n];
        dp[0] = a[0];
        dp[1] = Math.min(dp[0],a[1]);
        for(int i=2;i<n;i++){
            dp[i] = Math.min(dp[i-2],dp[i-1]+a[i]);
        }
        return dp[n-1];
        


    }
    public static void main(String[] args) {
        int[] cost = {10,15,20};
        System.out.println(minCost(cost));
    }
}
