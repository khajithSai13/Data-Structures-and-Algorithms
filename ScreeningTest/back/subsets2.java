package ScreeningTest.back;
import java.util.*;
public class subsets2 {
    public static List<List<Integer>> subsets(int[] a){
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0,a,new ArrayList<>(),result);
        return result;
    }
    public static void backtrack(int idx,int[] a,List<Integer> curr,List<List<Integer>> result){
        if(idx == a.length){
            result.add(new ArrayList<>(curr));
            return;
        }
        for(int i = idx;i<a.length;i++){
            if(i>idx && a[i]==a[i-1]){
                curr.add(a[i]);
                backtrack(i, a, curr, result);
                curr.remove(curr.size()-1);
            }
        }
    }
    public static void main(String[] args) {
        int[] a = {1,2,3};
        List<List<Integer>> result = subsets(a);
        for(List<Integer> lsit : result){
            System.out.println(lsit);
        }
    }
}
