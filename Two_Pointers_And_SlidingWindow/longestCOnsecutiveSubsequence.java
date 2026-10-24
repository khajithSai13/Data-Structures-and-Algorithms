import java.util.*;
class longestCOnsecutiveSubsequence{
    public static int longestSeq(int[] a){
        int n = a.length;
        if(n ==0) return 0;
        int l = 0;
        Arrays.sort(a);
        int equal = 0;
        int maxLen = 1;
        for(int r=1;r<n;r++){
            if(a[r] -a[r-1] ==0){
                equal++;
            }
            else if(a[r]-a[r-1] != 1){
                l=r;
                equal = 0;
            }
            maxLen = Math.max(maxLen,r-l+1-equal);
        }
        return maxLen;
    }
    public static void main(String args[]){
        int [] a = {1,0,1,2};
        System.out.println(longestSeq(a));
    }
}