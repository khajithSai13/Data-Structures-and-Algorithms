import java.util.*;
class MaximumSubarrayWithKFreq{
    public static int maxFreqSub(int [] a,int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = a.length;
        if(n==0) return 0;
        if(k<0) return 0;
        //int max = 0;
        int maxLen = 0;
        int l=0,r=0;
        while(r<n){
            int val = a[r];
            map.put(val,map.getOrDefault(val, 0)+1);
           // max = Math.max(max,map.get(val));
            while(map.get(a[r]) >k){
               map.put(a[l],map.get(a[l])-1);
                l++;
            }   
            maxLen = Math.max(maxLen,r-l+1);
            //System.out.println(maxLen);
            r++;
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int[] a = {1,2,2,1,3};
        System.out.println(maxFreqSub(a,1));
    }
}