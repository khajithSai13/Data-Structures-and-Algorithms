package Trees;
import java.util.*;
public class PathSum2 {
    public static List<List<Integer>> pathsum(Treenode root,int target){
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;
        recurse(root,new ArrayList<>(),list,target);
        return list;
    }
    public static void recurse(Treenode root,List<Integer> curr,List<List<Integer>> list,int target){
        if(root == null) return;
        target -= root.data;
        curr.add(root.data);
        System.out.println(curr);
        if(target == 0 && root.left == null && root.right ==null){
                list.add(new ArrayList<>(curr));
                curr.remove(curr.size()-1);
                return;
        }
        recurse(root.left, curr, list, target);
        //curr.remove(curr.size()-1);
        recurse(root.right,curr,list,target);
        curr.remove(curr.size()-1);
        
    }
    public static void main(String[] args) {
        Integer [] a = {5,4,8,11,null,13,4,7,2,null,null,5,1};
        Treenode root = Treenode.buildTree(a);
        System.out.println(pathsum(root,22));
    }
}
