package DynamicProgramming;
public class knapsack01 {
    public static int knapsack(int[] wts,int[] values,int W){
        int n = wts.length;
        int[][] dp = new int[n+1][W+1];
        for(int i=1;i<=n;i++){
            for(int w = 0;w<=W;w++){
                if(wts[i-1]<=W){
                dp[i][w] = Math.max(dp[i-1][w],values[i-1]+dp[i-1][w -wts[i-1]]);
            }else{
                dp[i][w] = dp[i-1][w];
            }
        }
        }
        return dp[n][W];
    }
    public static void main(String[] args) {
        int[] wts = {1,3,4,5};
        int [] values = {1,4,5,7};
        System.out.println(knapsack(wts,values,7));
    }
}
