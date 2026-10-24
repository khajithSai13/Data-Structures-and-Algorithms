package Dynamic_Programming;

public class HouseRobber {
    public static int rob(int[] houses){
        int n = houses.length;
        int[] dp = new int[n];
        dp[0] = houses[0];
        dp[1] = Math.max(dp[0],houses[1]);
        for(int i=2;i<n;i++){
            dp[i] = Math.max(dp[i-2]+houses[i] , dp[i-1]);
        }
        return dp[n-1];
    }
    public static int rob2(int[] money){ // space optimised
        int n =money.length;
        int p1 = money[0];
        int p2 = Math.max(p1,money[1]);
        for(int i=2;i<n;i++){
            int temp = p2;
            p2 = Math.max(p2,p1+money[i]);
            p1 = temp;
        }
        return p2;
    }
    public static void main(String[] args) {
        int[] houses = {2,7,9,3,1};
        System.out.println(rob2(houses));
    }
}
