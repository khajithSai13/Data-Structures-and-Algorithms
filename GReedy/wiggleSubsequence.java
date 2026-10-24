import java.util.*;
@SuppressWarnings("unused")
class wiggleSubsequence{
    public static int maxWigglesubseq(int[] a){
        int n = a.length;
        if(n <=1) return 1;
        int max = 1;
        int l = 0;
        boolean up = true;
        for(int i=1;i<n;i++){
            int diff = a[i]-a[l];
            if(up){
                if(diff> 0){
                    
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
       //Scanner sc = new Scanner(System.in);
        int[] a = {1,17,5,10,13,15,10,5,16,8};
        System.out.println(maxWigglesubseq(a));
    }
}