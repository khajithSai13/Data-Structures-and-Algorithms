package ScreeningTest;
import java.util.*;
class Greedy{
    //Activity Selection
    public static int Activities(int[] start,int[] end){
        int n = start.length;
        Integer[] idx = new Integer[n];
        for(int i=0;i<n;i++){
            idx[i] = i;
        }
        Arrays.sort(idx, (a,b) -> {
            if(end[a]!=end[b]){
                return end[a]-end[b];
            }
            return start[a]-start[b];
        });
        int lastEnd = end[idx[0]];
        int count = 1;
        for(int i=1;i<n;i++){
            if(start[idx[i]]>lastEnd){
                lastEnd = end[idx[i]];
                count++;
            }
        }
        return count;
    }
    public static int minPlatforms(int[] arr,int[]dep){//goneee
        int n = arr.length;
        Integer[] idx = new Integer[n];
        for(int i=0;i<n;i++){
            idx[i] = i;
        }
        Arrays.sort(idx,(a,b)-> Integer.compare(dep[a],dep[b]));
        int min = 1;
        int lastleft = dep[idx[0]];
        System.out.println(Arrays.toString(idx));
        for(int i=1;i<n;i++){
            if(arr[idx[i]] > lastleft){
                min--;
            }else{
                min+=1;
                lastleft = dep[idx[i]];
            }
        }
        return min;
    }
    public static int Platforms(int[] arr,int[]dep){
        int n = arr.length;
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i=0,j=0;
        int plats = 0;
        int maxPlats = 0;
        while(i<n &&j<n){
            if(arr[i]<=dep[j]){
                plats ++;
                maxPlats = Math.max(plats,maxPlats);
                i++;
            }else{
                plats --;
                j++;
            }
        }
        return maxPlats;
        
    }
    public static double fractionalKnapsack(double[] wts,double[] profits,int W){
        int n = wts.length;
        double Total = 0.0;
        double temp = W;
        Integer[] idx = new Integer[wts.length];
        for(int i=0;i<n;i++){
            idx[i] = i;
        }
        Arrays.sort(idx, (a,b) -> Double.compare((profits[b]/wts[b]),(profits[a]/wts[a])));
        for(int i=0;i<n;i++){
            if(temp > 0){
                double wt = wts[i];
                double profit = profits[i];
                if(wt <= temp){
                    Total += profit;
                    temp -= wt;
                }else{
                    double frac = temp *(profit/wt);
                    Total += frac;
                    temp =0;
                }
            }else{
                break;
            }
        }
        return Total;
    }
    public static int avail(int[] a,int k){
        int i =k;
        for(i = k;i>0;i--){
            if(a[i] != 1){
                return i;
            }
        }
        return -1;
    }
    public static void JobScheduling(int[] id,int[] deadline,int[] profits){
        int n = id.length;
        int jobsDone = 0;
        int profit = 0;
        int md = 0;
        for(int val : deadline) md = (val>md)?val:md;
        int[] slots = new int[md+1];
        Integer[] ids = new Integer[id.length];
        for(int i=0;i<n;i++){
            ids[i] = i;
        }
        Arrays.sort(ids, (a,b) ->{    return profits[b] - profits[a];
        });
        
        for(int i=0;i<n;i++){
            int d = deadline[ids[i]];
            int avl = avail(slots,d);
            if(avl != -1) {
                slots[avl] =1;
                profit += profits[ids[i]];
                jobsDone++;
        }
    }
        System.out.println(jobsDone);
        System.out.println(profit);
    }
    public static int Overlapping(int[] start,int[] end){
        int n = start.length;
        Integer idx[] = new Integer[n];
        for(int i=0;i<n;i++){
            idx[i] = i;
        }
        int kept = 1;
        Arrays.sort(idx, (a,b)-> end[a]-end[b]);
        int lastEnd = end[idx[0]];
        for(int i =1;i<n;i++){
            if(start[idx[i]] >= lastEnd){
                kept++;
                lastEnd = end[idx[i]];
            }
        }
        return n-kept;
    }
    public static int arrow(int[] st,int[] end){
        int n = st.length;
        Integer[] id = new Integer[n];
        for(int i=0;i<n;i++){
            id[i] = i;
        }
        Arrays.sort(id,(a,b) -> Integer.compare(end[a],end[b]));
        int arrows = 1;
        int lastEnd = end[id[0]];
        for(int i =1;i<n;i++){
            if(st[id[i]] >= lastEnd){
                lastEnd = end[id[i]];
                arrows++;
            }
        }
        return arrows;
    }
    // public static boolean jump(int[] a){
    //     int n = a.length;
    //     if(n == 0) return false;
    //     if(n==1 && a[0]>0) return true;
    //     int farthest = 0;
    //     for(int i=0;i<n;i++){
    //         far
    //     }

    //     return false;
    // }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        // double[] wts = {10,20,30};
        // double[] profits  = {60,100,120};
        // System.out.println(fractionalKnapsack(wts, profits,50));
        // int[] id = {1,2,3,4,5};
        // int[] deadlines = {2,1,2,1,3};
        // int[] profits = {100,19,27,25,15};
        // JobScheduling(id, deadlines, profits);
        // int[] start = {1,2,3,1};
        // int[] end = {2,3,4,3};
        // System.out.println(Overlapping(start, end));
        // int[] st = {10,2,1,7};
        // int[] end = {16,8,6,12};
        // System.out.println(arrow(st, end));

    }
}