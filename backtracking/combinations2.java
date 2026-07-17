import java.util.ArrayList;
import java.util.List;

public class combinations2 {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> sol = new ArrayList<>();
        backtrack(n,1,k,new ArrayList<>(),sol);
        return sol;
    }
    static void backtrack(int n,int idx,int k,List<Integer> sub,List<List<Integer>> result){
        if(sub.size()==k){
            result.add(new ArrayList<>(sub));
            return;
        }
        for(int i=idx;i<=n;i++){
            sub.add(i);
            backtrack(n,i+1,k,sub,result);
            sub.remove(sub.size()-1);
        }
    }
    public static void main(String[] args) {
        List<List<Integer>> list = combine(4,2);
        for(List<Integer> lis : list){
            System.out.println(lis);
        }
    }
}
