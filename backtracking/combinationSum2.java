import java.util.*;
public class combinationSum2 {
    public static List<List<Integer>> combsum2(int[] nums,int k){
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums,k,0,0,new ArrayList<>(),result);
        return result;
    }
    static void backtrack(int[] nums,int k,int idx,int temp,List<Integer> curr,List<List<Integer>> result){
        if(temp==k){
            result.add(new ArrayList<>(curr));
            return;
        }
        if(temp>k)return;
        for(int i=idx;i<nums.length;i++){
            if(i>idx&&nums[i] == nums[i-1]){
                continue;
            }
            if(temp+nums[i]>k){
                break;}else{
                curr.add(nums[i]);
                backtrack(nums, k, i+1, temp+nums[i], curr, result);
                curr.remove(curr.size()-1);
            }
        }
    }
    public static void main(String[] args) {
        int[] nums = {10,1,2,7,6,7,1};
        int k = 8;
        List<List<Integer>> result = combsum2(nums,k);
        for(List<Integer> res : result){
            System.out.println(res);
        }
    }
}
