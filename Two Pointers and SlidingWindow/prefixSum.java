public class prefixSum {
    public static int subarraySumIsK(int[] a,int k){
        int n = a.length;
        int[] prefix = new int[n];
        int count=0;
        prefix[0]=a[0];
        for(int i=1;i<n;i++){
            prefix[i] = prefix[i-1]+a[i];
        }
        int l=0,r=0;
        while(r<n){
            if(prefix[r]-prefix[l]==k){
                count++;
            }
            else if(prefix[r]-prefix[l]>k){
                while(prefix[r]-prefix[l]>k){
                    l++;
                }
            }
                r++;
            }
            return count;
        }

    public static void main(String[] args) {
        int[] a = {1,2,3,6,8};
        System.out.println(subarraySumIsK(a, 6));
    }
}
