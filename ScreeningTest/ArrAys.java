package ScreeningTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ArrAys{
    public static int[] productexceptself(int[] a){
        int n = a.length;
        int[] b = new int[n];
        int pro = 1;
        for(int i=0;i<n;i++){
            pro = 1;
            for(int j=0;j<n;j++){
                if(i==j) continue;
                pro *= a[j];
            }
            b[i] = pro;
        }
        return b;
    }
    public static void movezeors(int[] a){
        int n = a.length;
        int slow = 0,fast = 0;
        for(fast =0;fast<n;fast++){
            if(a[fast]!=0){
                swap(a,slow,fast);
                slow++;
            }
            
        }
    }
    static void swap(int[] a,int l,int r){
        int emp = a[l];
        a[l]=a[r];
        a[r] = emp;
    }
    public static int majority(int [] a){
        int n = a.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int val = -1;
        for(int i=0;i<n;i++){
            map.put(a[i],map.getOrDefault(a[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int k = entry.getValue();
            if(k>=n/2){
                val = k;
            }
        }
        return val;
    }
    public static int[] twos(int[] a,int k){//sorted
        int l =0,r=a.length-1;
        while(l<r){
            if(a[l]+a[r]==k){
                return new int[]{l,r};
            }
            else if(a[l]+a[r]<k){
                l++;
            }else{
                r--;
            }
        }
        return new int[]{-1,-1};
        
    }
    public static int bestTimeToBuyAndSell(int[] prices){
        int minpr = prices[0];
        int profit=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]<minpr){
                minpr = prices[i];
            }else{
                int maxpr = prices[i]-minpr;
                profit = Math.max(maxpr,profit);
            }
        }
        return profit;
    }
    public static int maxConsecutiveSequence(int[] a){//godd but can be better
        int n = a.length;
        int len = 1;
        HashSet<Integer> set = new HashSet<>();
        for(int val:a) set.add(val);
        for(int i=0;i<n;i++){
            int j = -1;
            int pre = 0;
            while(set.contains(a[i]+j)){
                pre += 1;
                j++;
            }
            len = Math.max(len, pre);
        }
        return len;
    }
    public static int maxconsec(int [] a){ // best
        int n =a.length;
        HashSet<Integer> set = new HashSet<>();
        for(int val : a) set.add(val);
        int maxlen = 0;
        for(int val : set){
            if(!set.contains(val-1)){
                int currnum = val;
                int currlen = 1;
            
            while(set.contains(currnum+1)){
                currnum++;
                currlen++;
            }
            maxlen = Math.max(currlen,maxlen);
            }
        }
        return maxlen;
    }
    public static boolean subarrayWithSumK(int[]a,int k){
        int n = a.length;
        int l = 0,r=0,sum=0;
        for(r=0;r<n;r++){
            sum += a[r];
            
            while(sum>k && l<=r){
                sum -=a[l];
                l++;
            }
            if(sum == k ) return true;
        }
        return false;
    }
    public static void sort012(int[] a){
        int n = a.length;
        int l=0,m=0,r=n-1;
        while(m<r){
            if(a[m]==0){
                swap(a, l, m);
                l++;m++;
            }else if(a[m]==1){
                m++;
            }else{
                swap(a, m, r);
                m++;r--;
            }
        }

    }
    static void printarr(int[] a){
        for(int v : a) System.out.print(v+" ");
    }
    public static void main(String[] args) {
        int[] a = {2,0,2,1,1,0};
    
        sort012(a);
        printarr(a);
    }
}
