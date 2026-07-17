import java.util.*;
public class Combinations {
    public static List<List<Integer>> cominations(int[] nums,int k){
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums,0,k,new ArrayList<>(),result);
        return result;
    }
    public static void backtrack(int[] nums,int idx,int k,List<Integer> com,List<List<Integer>> result){
        if(com.size() == k){
            result.add(new ArrayList<>(com));
            return;
        }
        for(int i =idx;i<nums.length;i++){
            com.add(nums[i]);
            backtrack(nums, i+1, k, com, result);
            com.remove(com.size()-1);
        }
    }
    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        List<List<Integer>> res = cominations(a,2);
        for(List<Integer> list : res){
            System.out.println(list);
        }
    }
}
