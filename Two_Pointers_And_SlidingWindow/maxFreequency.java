import java.util.*;
public class maxFreequency {
    public static int freq(int[] a, int k){
        int n = a.length;
        if(n ==0 )return 0;
        int maxLen = 1;
        Arrays.sort(a);
        int r = n-1,l=n-2; ///////////////////////////////Well tried but a bit ooff logic
        int temp = k;
        while(l<=r && r>=0){
            int diff = a[r]-a[l];
            if(diff <= temp){
                temp -= diff;
            }
            maxLen = Math.max(maxLen,r-l+1);
            if(diff > temp ||temp  ==0){
                r--;
                temp = k;
            }else{
                l++;
            }
            
        }
        return maxLen;
    }
    public static int maxFreq(int[] a ,int k){               ///greedy+sorting+slidingWindow
        int n = a.length;
        long sum = 0,cost=0;
        int l =0;
        Arrays.sort(a);
        int maxLen = 1;
        for(int r =0;r<n;r++){
            sum += a[r];
            cost = (long)a[r] * (r-l+1) - sum;
            while(cost > k){
                sum -= a[l];
                l++;
                cost = (long)a[r]*(r-l+1) - sum;
            }
            maxLen = Math.max(r-l+1,maxLen);
        }
        return maxLen;

    }
    public static void main(String[] args) {
        int[] a = {1,4,8,13};
        System.out.println(maxFreq(a,5));
    }
}