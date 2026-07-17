import java.util.*;

//import java.util.Arrays;

public class slowAndFast {
    public static int removedup(int[] a){
        int slow = 0;
        for(int fast = 1;fast<a.length;fast++){
            if(a[slow]!=a[fast]){
                slow++;
                a[slow]=a[fast];
            }
        }
        return slow+1;
    }
    public static int removeduplicates2(int[] a,int k){
        Arrays.sort(a);
        int n = a.length;
        int slow = k;
        for(int fast = k;fast<n;fast++){
            if(a[fast]!=a[slow-k]){
                a[slow] = a[fast];
                slow++;
            }             
        }
        return slow+1;
    }
    public static void moveZeros(int[] nums){
        int n = nums.length;
        int slow =0;
        for(int fast =0;fast<n;fast++){
            if(nums[fast]!=0){
                nums[slow++]=nums[fast];
            }
        }
        while(slow<n){
            nums[slow++]=0;
        }
    }
    public static void swap(int[] a,int l,int r){
        int temp = a[l];
        a[l]=a[r];
        a[r]=temp;
    }
    public static void sortbyParity(int [] a){
        int n = a.length;
        int slow =0;
        for(int fast = 0;fast<n;fast++){
            if(a[fast]%2==0){
                swap(a, slow, fast);
                slow++;
            }
        }
    }
    public static void main(String[] args) {
        int[]a = {2,3,4,5};
       // int aflength = removeduplicates2(a,2);
       // System.out.println(aflength);
       sortbyParity(a);
        for(int val:a){
            System.out.print(val+" ");
        }
    }
}
