//import java.util.*;
class TrappingRainWater{
    public static int max(int [] a){
        int water = 0;
        int lmax = Integer.MIN_VALUE;
        int rmax = Integer.MIN_VALUE;
        int l = 0,r=a.length-1;
        while(l<r){
            lmax = (lmax>a[l])?lmax:a[l];
            rmax = (rmax > a[r]?rmax:a[r]);
            int min = Math.min(lmax,rmax);
            if(min == lmax){
                water += (min-a[l++]);
            }else{
                water += (min-a[r--]);
            }
        }
        return water;
    }
    public static void main(String[] args) {
        int[] a = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(max(a));
    }
}