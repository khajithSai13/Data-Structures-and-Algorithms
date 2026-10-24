package BinarySearchTrees;
import Trees.Treenode;
import java.util.LinkedList;
import java.util.Queue;

public class BuildTreeSortedArray {
    static class Treenode{
        Integer data;
        Treenode left;
        Treenode right;
        public Treenode(Integer data){
            this.data = data;
        }
    }
    public static void bfs(Treenode root){
        if(root == null) return;
        Queue<Treenode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Treenode curr = q.poll();
            System.out.print(curr.data+ " ");
            if(curr.left != null) q.add(curr.left);
            if(curr.right!=null)q.add(curr.right);
            // if(currLevel ==0){
            //     System.out.println();
            //     currLevel = q.size();
            // }
        }
    }
    public static Treenode buildFromSorted(Integer[] a,int l,int r){
        if(l>r){
            return null;
        }
        if(l>=r){
            return new Treenode(a[l]);
        }
        int mid = (r+l)/2;
        //System.out.println(a[l]+" "+a[mid]+" "+a[r]);
        Treenode root = new Treenode(a[mid]);
        root.left = buildFromSorted(a, l, mid-1);
        root.right = buildFromSorted(a, mid+1, r);
        return root;
    }
    public static void main(String args[]){
        Integer a[] = {1,2,3,4,5,6};
        Treenode root = buildFromSorted(a,0,a.length-1);
        bfs(root);
    }
}
