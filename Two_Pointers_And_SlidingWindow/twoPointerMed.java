import java.util.*;
public class twoPointerMed {
    public static void sortSquares(int[] a){
        int n = a.length;
        int l =0,r=n-1,idx=n-1;
        int[] result = new int[n];
        while(l<=r){
            if((a[l]*a[l])<=a[r]*a[r]){
                result[idx--]=a[r--];
            }else{
                result[idx--]=a[l++];
            }
        }
    }
    //medium
     static List<List<Integer>> result = new ArrayList<>();
    public static List<List<Integer>> twosum(int[] a,int k){
        int n = a.length;
        int i =0,j=n-1;
        Arrays.sort(a);
        while(i<j){
            int sum = a[i]+a[j];
            if(sum==k){
                result.add(Arrays.asList(a[i],a[j]));
                j--;
            }
            if(sum<k){
                i++;
            }else{
                j--;
            }
        }
        return result;
    }
    public static int removedup(int[] a){
        int n = a.length;
        int slow = 0;
        for(int fast =1;fast<n;fast++){
            if(a[fast]!=a[slow]){
                slow++;
                a[slow] = a[fast];

            }
        }
        return slow+1;
    }

    public static void main(String[] args) {
        int[]a = {5,4,3,2,1};
        /*List<List<Integer>> result = twosum(a, 5);
        for(List<Integer> lsit : result){
            System.out.println(lsit);*/
            sortSquares(a);
            for(int val:a){
                System.out.print(val+" ");
            }
        }
        

    }

