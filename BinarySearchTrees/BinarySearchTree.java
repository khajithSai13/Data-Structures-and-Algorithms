package BinarySearchTrees;
import java.util.*;
public class BinarySearchTree {
    static class Treenode{
        Integer data;
        Treenode left;
        Treenode right;
        public Treenode(Integer data){
            this.data = data;
        }
    }
    public static Treenode BuildTree(Integer[] a){
        int n = a.length;
        if(n==0) return null;
        Treenode root  = new Treenode(a[0]);
        for(int i=1;i<n;i++){
            insert(root, a[i]);
        }
        return root;
    }
    public static void bfs(Treenode root){
        if(root == null) return;
        Queue<Treenode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Treenode curr = q.poll();
            System.out.print(curr.data+" ");
            if(curr.left !=null) q.add(curr.left);
            if(curr.right != null) q.add(curr.right);
        }
    }
    public static void insert(Treenode root, int val){
        if(root == null) return;
        if(val < root.data){
            if(root.left != null){
                insert(root.left, val);
            }else{
                root.left = new Treenode(val);
            }
        }else{
            if(root.right != null){
                insert(root.right,val);
            }else{
                root.right = new Treenode(val);
            }
        }
    }
    public static Treenode search(Treenode root,int val){
        if(root == null) return null;
        if(val == root.data) return root;
        if(val <root.data){
            return search(root.left,val);
        }else{
            return search(root.right,val);
        }
    }
    static Treenode r = null;
    public static boolean validate(Treenode root){
        if(root == null) return true;
        r= root;
        return helper(root.left,true) && helper(root.right,false);
    }
    public static boolean helper(Treenode root,boolean left){
        if(root == null) return true;
        if(root.left != null) if(root.data< root.left.data) return false;
        if(root.right != null) if(root.data>root.right.data) return false;
        if(left){
            if(root.data > r.data)return false;
        }else{
            if(root.data <r.data) return false;
        }
        return helper(root.left,left) && helper(root.right, left);

    }
    // public static Treenode BSTLCA(Treenode root,Treenode p,Treenode q){
    //     if(root == null) return null;
    //     if(root.data <p.data && root.data <q.data){
    //         return helpLCA(root.right, p, q);
    //     }else if(root.data >p.data && root.data >q.data){
    //         return helpLCA(root.left, p, q);
    //     }
    //     return root;
    // }
    public static Treenode helpLCA(Treenode root, Treenode p,Treenode q){
        if(root== null || root==p || root == q) return root;
        if(root.data < p.data && root.data < q.data){
            return helpLCA(root.right, p, q);
        }else if(root.data > p.data && root.data > q.data){
            return helpLCA(root.left, p, q);
        }
        Treenode left = helpLCA(root.left, p, q);
        Treenode right = helpLCA(root.right, p, q);
        if(left != null && right !=null) return root;
        return (left != null) ?left:right;
    }
    public static void dfs(Treenode root){
        if(root == null) return;
        if(root.left != null) dfs(root.left);
        System.out.println(root.data);
        if(root.right !=null) dfs(root.right);
    }
    static int k = 0;
    public static int kthSmallest(Treenode root,int val){
        if(root == null) return 0;
        int l = kthSmallest(root.left,val);
        if(l != 0) return l;
        //System.out.println(l+" "+k);
        k++;
        if(k == val) return root.data;
        int r = kthSmallest(root.right, val);
        //System.out.println(r+" "+k);
        if(r!=0 )return r;
        return 0;
    }
    public static Treenode findSuccessor(Treenode root,boolean left){
        if(root == null) return null;
        if(root.left == null && root.right == null){
            return root;
        }
        return left ? findSuccessor(root.left,left) : findSuccessor(root.right, left);
    }
    public static Treenode remove(Treenode root,int val){
        if(root == null) return null;
        if(val<root.data){
            root.left = remove(root.left, val);
        }else if(val>root.data){
            root.right = remove(root.right,val);
        }else{
            if(root.left == null)return root.right;
            if(root.right == null) return root.left;
            Treenode successor = findSuccessor(root.right, true);
            if(successor != null){
                root.data = successor.data;
                root.right = remove(root.right,successor.data);
            }
        }
        return root;
           
    }
    public static Treenode buildFromSortedArray(Integer[] a){
        int n = a.length;
        if(n==0) return null;
        int r = n/2;
        Treenode root = new Treenode(a[r]);
        int i = r-1,j=r+1;
        Treenode r1=root,r2=root;
        while(i>=0 || j<n){
            if(i>=0 && a[i] != null){
                r1.left = new Treenode(a[i]);
                r1 = r1.left;
            }i--;
            if(j<n && a[j]!=null){
                r2.right = new Treenode(a[j]);
                r2 = r2.right;
            }j++;
        }
        return root;

    }
    public static void bfs2(Treenode root){
        if(root == null) return;
        Queue<Treenode> q = new LinkedList<>();
        q.add(root);
        int currLevel = 1;
        while(!q.isEmpty()){
            Treenode curr = q.poll();
            currLevel--;
            System.out.print(curr.data+ " ");
            if(curr.left != null) q.add(curr.left);
            if(curr.right!=null)q.add(curr.right);
            if(currLevel ==0){
                System.out.println();
                currLevel = q.size();
            }
        }
    }

    public static void main(String args[]){
        Integer[] a = {1,2,3,4,5,6};
        Treenode root = buildFromSortedArray(a);
    }
}
