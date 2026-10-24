package Dynamic_Programming;
import java.util.*;
class LIS{
    public static int Lis(int[] a){
        int n = a.length;
        if(n == 1)return 1;
        int max = 1;
        int[]  dp = new int[n];
        Arrays.fill(dp,1);
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(a[i] > a[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            max = Math.max(dp[i],max);
        }
        return max;
        
    }
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(Lis(nums));
    }
}