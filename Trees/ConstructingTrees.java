package Trees;

import java.util.*;

public class ConstructingTrees {
    public static Treenode preBuild(Integer[] pre){
        if(pre.length == 0) return null;
        int n = pre.length;
        Queue<Treenode> q = new LinkedList<>();
        Treenode root = new Treenode(pre[0]);
        q.add(root);
        int i = 1;
        while(i<n &&!q.isEmpty()){
            Treenode curr = q.poll();
            if(i<n && pre[i] != null){
                curr.left = new Treenode(pre[i]);
                q.add(curr.left);
            }
            i++;
            if(i<n && pre[i] != null){
                curr.right = new Treenode(pre[i]);
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }
    // public static Treenode inBuild(Integer[] in,int rt){
    //     Treenode root = new Treenode(rt);
    // }
    public static void main(String[] args) {
        Integer[] pre = {3,9,20,15,7};
        Integer[] in = {9,3,15,20,7};
        Treenode PreorderedRoot = preBuild(pre);
        //Treenode inRoot = inBuild(in,pre[0]);

        Treenode.bfs(PreorderedRoot);
    }
}
