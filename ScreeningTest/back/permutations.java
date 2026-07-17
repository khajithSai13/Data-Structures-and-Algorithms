package ScreeningTest.back;
import java.util.*;
public class permutations {
    public static List<List<Integer>> permutate(int[] a){
        List<List<Integer>> result = new ArrayList<>();
        backtrack(a,new boolean[a.length],new ArrayList<>(),result);
        return result;
    }
    public static void backtrack(int[] a,boolean[] used,List<Integer> curr,List<List<Integer>> result){
        if(curr.size() == a.length){
            result.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0;i<a.length;i++){
            if(used[i]){
                continue;
            }
            curr.add(a[i]);
            used[i] = true;
            backtrack(a, used, curr, result);
            curr.remove(curr.size()-1);
            used[i] = false;
        }
    }
    public static void main(String[] args) {
        int[] a = {1,2,3};
        List<List<Integer>> result = permutate(a);
        for(List<Integer> lsit : result){
            System.out.println(lsit);
        }
    }
}
