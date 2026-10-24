package Dynamic_Programming;

import java.util.Arrays;

public class DecodeWays {
    public static int decode(String s){
        int n = s.length();
        if(n ==1 && s.charAt(0) !='0') return 1;
        if(s.charAt(0) == '0') return 0;
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = 1;
        
    }
    public static void main(String[] args) {
        String s = "12";
        System.out.println(decode(s));
    }
}
