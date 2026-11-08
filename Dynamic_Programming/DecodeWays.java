package Dynamic_Programming;

import java.util.Arrays;

public class DecodeWays {
    public static int decode(String s){
        int n = s.length();
        if(n ==1 && s.charAt(0) !='0') return 1;
        if(s.charAt(0) == '0') return 0;
        int[] dp = new int[n]; // still in progress
        dp[0] = 1;
        boolean flag = false;
        if( s.charAt(1) !='0'){
            if(((s.charAt(0)-'0')*10 + s.charAt(1)-'0') <27 &&(s.charAt(0)-'0')*10 + (s.charAt(1)-'0') >0){
                dp[1] = 2;
            }else{
                dp[1] = 1;
            }
        } else{
            if(((s.charAt(0)-'0')*10 + s.charAt(1)-'0') <27 &&(s.charAt(0)-'0')*10 + (s.charAt(1)-'0') >0){

            dp[1] = 1;
            }else{
                return 0;
            }
    }
        for(int i=2;i<n;i++){
            if(s.charAt(i) == '0'){
                if(s.charAt(i-1) == '0'){ return 0;}else{flag = true;}
            }
            int num = (s.charAt(i-1)-'0')*10+(s.charAt(i)-'0');
            if(num >0 && num < 27){
                if(flag) {
                    dp[i] = dp[i-1];
                }else{
                    dp[i] = dp[i-1]+dp[i-2];
                }
                }else{
                    return 0;
                }
            flag = false;
        }
        return dp[n-1];
    }
    public static void main(String[] args) {
        String s = "11101";
        System.out.println(decode(s));
    }
}
