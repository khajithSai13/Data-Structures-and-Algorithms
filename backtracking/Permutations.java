import java.util.*;
class Permutations{
    public static List<List<Integer>> permutate(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums,new boolean[nums.length],new ArrayList<>(),result);
        return result;
    }
    private static void backtrack( int[] nums,boolean[] used,List<Integer> path,List<List<Integer>> result){
        if(path.size() == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]) continue;
            path.add(nums[i]);
            used[i] = true;
            backtrack(nums, used, path, result);
            path.remove(path.size()-1);
            used[i] = false;
        }
    }
    public static void main(String[] args) {
        int [] nums = {1,2,3};
        List<List<Integer>> result= permutate(nums);
        for( List<Integer> list : result) System.out.print(list);
    }
}