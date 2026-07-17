package ScreeningTest.back;
import java.util.*;
public class combinations {
    public static List<List<Integer>> combination(int[] a,int k){
        if(k> a.length) return null;
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0,k,a,new ArrayList<>(),result);
        return result;
    }
    public static void backtrack(int idx,int k,int[] a,List<Integer> curr,List<List<Integer>> result){
        if( curr.size()== k){
            result.add(new ArrayList<>(curr));
            return;
        }
        for(int i=idx;i<a.length;i++){
            curr.add(a[i]);
            backtrack(i+1, k, a, curr, result);
            curr.remove(curr.size()-1);
        }
    }
    public static void main(String[] args) {
        int[] a = {1,2,3};
        List<List<Integer>> result = combination(a,4);
        for(List<Integer> lsit : result){
            System.out.println(lsit);
        }
    }
}
