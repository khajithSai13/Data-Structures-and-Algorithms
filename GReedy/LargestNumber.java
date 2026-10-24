import java.util.Arrays;

public class LargestNumber {
    static int getfirst(int n){
        while(n>10){
            n /=10;
        }
        return n;
    }
    public static String largestNumber(int[] nums) {
        Integer[] idx = new Integer[nums.length]; //failed
        for(int i=0;i<idx.length;i++) idx[i] = i;
        Arrays.sort(idx,(a,b) -> {
            int first = getfirst(nums[a]);
            int sec = getfirst(nums[b]);
            if(first != sec){
                return Integer.compare(sec,first);
            }
            return Integer.compare(nums[b], nums[a]);
        });
        StringBuilder sb = new StringBuilder();
        for(int i:idx){
            sb.append(nums[i]);
        }
        return sb.toString().trim();
    }
    public static String largestNum(int[] nums){
        //int n = nums.length;
        StringBuilder sb = new StringBuilder();
        Integer[] idx = new Integer[nums.length];
        for(int i=0;i<idx.length;i++) idx[i] = i;
        Arrays.sort(idx, (a, b) -> {
            String sa = String.valueOf(nums[a]);
            String sbt = String.valueOf(nums[b]);
            String ab = sa + sbt;
            String ba = sbt + sa;
            return ba.compareTo(ab);
        });
        for(int i: idx) sb.append(nums[i]);
        String res = sb.toString();
        if(res.length() > 0 && res.charAt(0) == '0') return "0";
        return res;
    }
    public static void main(String[] args){
        int[] a= {3,30,34,5,9}; //9534330
        System.out.println(largestNum(a));
    }   
}
