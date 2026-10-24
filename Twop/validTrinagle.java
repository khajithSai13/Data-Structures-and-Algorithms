package Twop;
import java.util.*;
class validTrinagle{
    public static int valid(int [] a){ //BruteForce
        int count = 0;
        if(a.length==0) return count;
        int n = a.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k = j+1;k<n;k++){
                    if(a[i]+a[j] > a[k] || a[j]+a[k] > a[i] || a[i]+a[k] > a[j]){
                        count++;
                        System.out.println(a[i]+" "+a[j]+" "+a[k]);
                    }
                }
            }
        }
        return count;
    }
    public static int validtriangles(int[] a){
        int count = 0;
        int n = a.length;
        if(n ==0) return count;
        Arrays.sort(a);
        for(int k = n-1;k>=2;k--){
            int i =0;
            int j = k-1;
            while(i<j){
                if(a[i]+a[j] > a[k]){
                    count +=j-i;
                    j--;
                }else{
                    i++;
                }
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
        int a[] = {1,2,3,4,5};
        System.out.println(validtriangles(a));
    }
}