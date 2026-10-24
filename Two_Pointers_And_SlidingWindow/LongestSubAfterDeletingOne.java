public class LongestSubAfterDeletingOne {
    public static int afterDeletion(int[] a){
        int n = a.length;
        int l =0 ,r = 0,sum = 0;
        int maxLen = 0;
        for(r = 0;r<n;r++){
            sum += a[r];
            while(sum < r-l){
                sum -= a[l++];
            }
            maxLen = Math.max(maxLen, sum <(r-l+1) ? r-l:r-l+1);
        }
        return (maxLen == n)? n-1:maxLen;
    }
    public static void main(String fucks[]){
        int[] a = {1, 0, 1, 1, 1, 0, 1};
        System.out.println(afterDeletion(a));
    }
}
