package ScreeningTest.back;
import java.util.*;
public class combinationSum {
    public static List<List<Integer>> combinationum(int[] a,int k){
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0,0,k,a,new ArrayList<>(),result);
        return result;
    }
    public static void backtrack(int idx,int sum,int k,int[] a,List<Integer> curr,List<List<Integer>> result){
        if( sum== k){
            result.add(new ArrayList<>(curr));
            return;
        }if(sum >k) return;
        for(int i=idx;i<a.length;i++){
            if(sum + a[i]<=k){
            curr.add(a[i]);
            backtrack(i,sum+a[i], k, a, curr, result);
            curr.remove(curr.size()-1);
            }
        }
    }
    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        List<List<Integer>> result = combinationum(a,3);
        for(List<Integer> lsit : result){
            System.out.println(lsit);
        }
    }
}
