package DynamicProgramming;

public class climbingStairs {
    public static int stairs(int n){
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 2;
        for(int i =2;i<dp.length;i++){
            dp[i] = dp[i-2]+dp[i-1];
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n = 10;
        System.out.println(stairs(n));
    }
}
