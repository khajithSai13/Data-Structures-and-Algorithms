import java.util.ArrayList;
import java.util.List;

class BAsics{
    static List<List<Integer>> result = new ArrayList<>();
   public static void subsets(List<List<Integer>> result,int[] a,int idx,ArrayList<Integer> path){
    if(idx==a.length){
        result.add(new ArrayList<>(path));
        return;
    }
    subsets(result, a, idx+1, path);
    path.add(a[idx]);
    subsets(result, a, idx+1, path);
    System.out.println(path);
    path.remove(path.size()-1);
   }
    public static void main(String args[]){
        int sunbs[] = new int[]{1,2,3};
        result.clear();
        subsets(result,sunbs,0,new ArrayList<>());
        System.out.println(result);

    }
}