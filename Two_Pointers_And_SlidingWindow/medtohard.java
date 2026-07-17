import java.util.*;

public class medtohard {
    static List<List<Integer>> result = new ArrayList<>();

    public static void sum3(int[] a){
        int n = a.length;
        int l =0,r=n-1;
        int x=l+1;
        Arrays.sort(a);
        while(l<r &&x<n){
            int sum = a[l]+a[x]+a[r];
            if(sum ==0){
                result.add(Arrays.asList(a[l],a[x],a[r]));
            }else if(sum>0){
                r--;
            }else{
                l++;
            }
            x++;
        }
    }
    public static void main(String[] args) {
        int[] a= {-1,0,1,2,-1,-4};
        sum3(a);
        System.err.println(result);
    }
}
