import java.util.*;
public class minOperations {
    public static int min(int[] a,int x){
        int n = a.length;
        if(n == 0 || x == 0) return 0;
        int l =0,r=n-1;
        int ops = 0;
        while(l<=r && x>0){
            if(a[l] <= x && a[r]<=x){
                
            }else if(a[r] <= x){
                x = x-a[r--];
            }else if(a[l] <= x){
                x = x-a[l++];
            }else{
                )
            }
            ops++;
            System.out.println(x+" "+a[l]+" "+a[r]);
        }
        return x==0 ? ops:-1;
    }
    public static void main(String[] args) {
        int[] a = {2, 100, 1, 1, 2};
        System.out.println(min(a,4));
        }
}
