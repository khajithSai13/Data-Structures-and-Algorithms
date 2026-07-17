import java.util.Arrays;
public class CoinChange {
    public static int change(int[] coins,int amount){
        int n = coins.length;
        if(n==0) return -1;
        if(amount ==0)return 0;
        Integer[] idx = new Integer[n];
        for(int i=0;i<n;i++){
            idx[i]=i;
        }
        Arrays.sort(idx,(a,b) ->Integer.compare(coins[b],coins[a]));
        int rem = amount;
        int coin = 0;
        int l = 0;
        while(l<n) {
            int val = coins[idx[l]];
            int currcoin = 0;
            if(val<=rem){
            currcoin += rem/val;
            rem -= currcoin*val;
        }
        coin += currcoin;
        if(rem<=0) break;
         l++;
    }
        return (rem==0)? coin:-1;
        
    }
    public static void main(String[] args) {
        int coins[] = {1,3,4};
        int amount = 6;
        System.out.println(change(coins,amount));
    }
}
