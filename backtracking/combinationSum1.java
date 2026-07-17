import java.util.*;

public class combinationSum1 {
    public static void combsum(int[] nums,int val){
        List<List<Integer>> result = new ArrayList<>();
        int temp = 0;
        backtrack(nums,val,0,temp,new ArrayList<>(),result);
        for(List<Integer> list : result){
            System.out.println(list);
        }
    }
    private static void backtrack(int[] nums,int k,int idx,int temp,List<Integer> curr,List<List<Integer>> result){
        if(temp == k){
            result.add(new ArrayList<>(curr));
            temp = 0;
            return;
        }
        if(temp>k) return;
        for(int i=idx;i<nums.length;i++){
            if(temp+nums[i]<=k){
                curr.add(nums[i]);
                backtrack(nums, k, i, temp+nums[i], curr, result);
                curr.remove(curr.size()-1);
            }
        }
    }
    public static void main(String[] args) {
        int[] nums= {2,3,5};
        int val = 8;
        combsum(nums,val);
    }
}
