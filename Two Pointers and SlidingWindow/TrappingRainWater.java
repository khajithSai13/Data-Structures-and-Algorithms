//import java.util.*;
public class TrappingRainWater {
    //first try not too off from the idea but its nearly 60% correct so going for second try after some corrections
    public static int trap(int[] a){
        int n = a.length;
        int water = 0;int left =0;
       while(left<n-1){
            int right = left+1;
            if(a[left]<=a[right]){
                int min = (a[left]<a[right])? a[left]:a[right];
                for(int x=left+1;x<right;x++){
                    water += a[min]-a[x];
                }
                left++;
            }else if(a[left]>a[right]){
                while(a[left]>a[right] && right<n){
                    right++;}
                    int min = (a[left]<a[right])? a[left]:a[right];

                    for(int x=left+1;x<right;x++){

                    water += a[min]-a[x];
                }
                left++;
    
            }
        }
        return water;
    }
    // we fuced up totally off i was optimizing the code without any correct logic lol!!!!!
    public static int trap2(int[] a){
        int n = a.length;
        int water=0;
        int l=0;int r = l+1;
        while(l<n-1&&r<n){
            if(a[l]==0) while(a[l]!=0&&l<n-1)l++;
            if(a[r]==0) while(a[r]!=0&&r<n)r++;
            if(l==r+1){
                r++;
            }
            int min = (a[l]<a[r])?a[l]:a[r];
            for(int x=l+1;x<r;x++){
                water += a[min]-a[x];
            }
            min++;
            System.out.println(0);
        }
        return water;
    }
    public static int trap3(int [] a){
        int n = a.length;
        int water = 0;
        int l =0,r=n-1;
        int lmax = Integer.MIN_VALUE;
        int rmax = Integer.MIN_VALUE;
        while(l<r){
            lmax = a[l]>lmax?a[l]:lmax;
            rmax = a[r]>rmax?a[r]:rmax;
            int min = Math.min(lmax,rmax);
            if(min==lmax){
                water += min-a[l];
                l++;
            }else{
                water += min-a[r];
                r--;
            }
        }
        return water;
    }
    public static void main(String[] args) {
        int[] a = {4,2,0,3,2,5,10,1};
        System.out.println(trap3(a));
    }
}
