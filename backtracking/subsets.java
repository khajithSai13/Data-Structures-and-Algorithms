import java.util.*;
public class subsets {
    static List<List<Integer>> result = new ArrayList<>();
    public static List<List<Integer>> subsets2(int[] nums){
        backtrack(nums,0,new ArrayList<Integer>(),result);
        return result;
    }
    static void backtrack(int[] nums,int idx,List<Integer> curr,List<List<Integer>> result){
        if(idx == nums.length){
            result.add(new ArrayList<>(curr));
            return;
        }
        backtrack(nums, idx+1, curr, result);
        curr.add(nums[idx]);
        backtrack(nums,idx+1,curr,result);
        curr.remove(curr.size()-1);
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        result = subsets2(nums);
        for(List<Integer> lis : result){
            System.out.print(lis);
        }
    }
}
