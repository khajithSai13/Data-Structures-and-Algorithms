public class JumpGame {
    public static boolean jump1(int[] nums){
        int n = nums.length;
        if(n==0) return false;
        int fartharest =0;
        for(int i=0;i<n;i++){
            fartharest = Math.max(fartharest,i+nums[i]);
            if(fartharest == n-1) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(jump1(nums));
    }
}
