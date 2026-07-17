package Algorithms;

public class Kadane {
    static int kadanealg(int[] a){
        int n = a.length;
        int maxEnd = a[0];
        int res = a[0];
        for(int i=1;i<n;i++){
            maxEnd = Math.max(maxEnd+a[i],a[i]);
            res = Math.max(maxEnd, res);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] a = {-5, -2, -8};
        System.out.println(kadanealg(a));
    }
}
