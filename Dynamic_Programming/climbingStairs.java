package Dynamic_Programming;

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
    public static int climb(int n){
        if(n <=2) return n;
        int p1= 1;
        int p2 = 2;
        n-= 2;
        while(n > 0){
            int t = p2;
            p2 = p1+p2;
            p1 = t;
            n--;
        }
        return p2;
    }
    public static void main(String[] args) {
        int n = 10;
        System.out.println(climb(n));
    }
}
