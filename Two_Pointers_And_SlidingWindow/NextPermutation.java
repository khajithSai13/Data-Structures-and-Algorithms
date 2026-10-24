import java.util.Arrays;

public class NextPermutation {
    static void swap(int[] a,int l,int r){
        int t = a[r];
        a[r]=a[l];
        a[l]=t;
    }
    public static void nextPermutation1(int[]a ){//xlose but its not it
        int n = a.length;
        //int x = 0;
        boolean sw = false;
        for(int i=n-2;i>=0;i--){
            if(a[i]<a[i+1]){
                swap(a,i,i+1);
                sw = true;
                break;
            }
        }
        if(sw){
            for(int val : a)System.out.print(val+" ");
        }else{
            Arrays.sort(a);
            for(int val : a)System.out.print(val+" ");
        }
    }
    public static void nextPermutation2(int[]a ){//xlose but its not it
        int n = a.length;
        int idx = -1;
        //boolean sw = false;
        for(int i=n-2;i>=0;i--){
            if(a[i]<a[i+1]){
                idx = i;
                break;
            }
        }
        if(idx == -1){
            Arrays.sort(a);
            return;
        }
        for(int i = n-1;i>idx;i--){
            if(a[i]>a[idx]){
                swap(a, idx, i);
                break;
            }
        }
        int l = idx+1;int r = n-1;
        while(l<r){
            swap(a,l++,r--);
        }
    }
    public static void main(String[] args) {
        int [] a = {1,3,2};
        nextPermutation2(a);
        for(int v:a) System.out.print(v+" ");
    }
}
