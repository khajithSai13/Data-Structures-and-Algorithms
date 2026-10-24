package Trees;
import java.util.*;
class LevelOrder2{
    static List<List<Integer>> result = new ArrayList<>();
    public static List<List<Integer>> levelOrder2(Treenode root){
        result.clear();
        if(root == null) return result;
        int height = height(root);
        for(int i=0;i<height;i++) result.add(new ArrayList<>());
        helper(root,1);
        return result;
    }
    public static void helper(Treenode root,int level){
        if(root == null) return;
        result.get(result.size()-level).add(root.data);
        helper(root.left, level+1);
        helper(root.right,level+1);
    }
    public static int height(Treenode root){
        if( root == null) return 0;
        return 1+ Math.max(height(root.left),height(root.right));
    }
    public static void main(String[] args) {
        Integer[] a = {3,9,20,null,null,15,7};
        Treenode root = Treenode.buildTree(a);
        System.out.println(levelOrder2(root));
    }
}