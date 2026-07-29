import java.util.*;
class subsetsII{
    public static List<List<Integer>> subsets2(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums,0,new ArrayList<>(),result);
        return result;
    }
    private static void backtrack(int[] nums,int idx,List<Integer> path,List<List<Integer>> result){
        result.add(new ArrayList<>(path));
        for(int i=idx;i<nums.length;i++){
            if(i>idx && nums[i]==nums[i-1]) continue;
            path.add(nums[i]);
            backtrack(nums, i+1, path, result);
            path.remove(path.size()-1);
    }
}
    public static void main(String[] args) {
        int[] a = {1,2,2};
        List<List<Integer>> list = subsets2(a);
        for(List<Integer> lis:list){
            System.out.println(lis);
        }

    }
}
