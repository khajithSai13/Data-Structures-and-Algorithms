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
    
    static int preIndex = 0;
            public static Treenode buildTree(int[] preorder, int[] inorder) {
            preIndex = 0;
            return build(preorder, inorder, 0, inorder.length - 1);
        }

    public static Treenode build(int[] preorder, int[] inorder, int inStart, int inEnd) {
        if (inStart > inEnd) {
        return null;
        }

    // First unused preorder value is the root
        int rootValue = preorder[preIndex++];
        Treenode root = new Treenode(rootValue);

    // Find the root in inorder
        int index = inStart;
        while (inorder[index] != rootValue) {
            index++;
            }

    // Everything before root = left subtree
        root.left = build(preorder, inorder, inStart, index - 1);

    // Everything after root = right subtree
        root.right = build(preorder, inorder, index + 1, inEnd);

        return root;
    }
    public static String serialize(Treenode root){
        if(root == null) return "";
        Queue<Treenode> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        q.add(root);
        while(!q.isEmpty()){
            Treenode curr = q.poll();
            sb.append(","+curr.data);
            if(curr.left == null){
                sb.append(",null");
            }else{
                q.add(curr.left);
            }
            if(curr.right == null){
                sb.append(",null");
            }else{
                q.add(curr.right);
            }
        }
        return sb.substring(1);

    }
    public static Treenode Deserialize(String s){
        if(s.length() == 0) return null;
        String [] arr = s.split(",");
        Integer[] tree = new Integer[arr.length];
        for(int i=0;i<tree.length;i++){
            if(arr[i].equals("null")){
                tree[i] = null;
            }else{
                tree[i] = Integer.parseInt(arr[i]);
            }
        }
        Treenode root = new Treenode(tree[0]);
        int idx = 1;
        Queue<Treenode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty() && idx<tree.length){
            //System.out.println(idx);
            Treenode curr = q.poll();
            if(tree[idx] != null){
                curr.left = new Treenode(tree[idx]);
                q.add(curr.left);
            }idx++;
            if(tree[idx] != null){
                curr.right = new Treenode(tree[idx]);
                q.add(curr.right);
            }idx++;
        }
        return root;
    }
    static int cameras = 0;
    public static int cameras(Treenode root){
        if(root == null) return 0;
        int h = helper(root);
        return (h==0)?cameras+1:cameras;
    }
    public static int helper(Treenode root){
        if(root == null )return -1;
        if(root.left == null && root.right == null) return 0;
        int l = helper(root.left);
        int r = helper(root.right);
        int help = 0;
        if(l ==-1 &&  r==-1){
            return 0;
        }
        int min = 0;
        if(l==-1 || r==-1){
            min = Math.max(l,r);
        }
        else{
            min = Math.min(l,r);
        }
        if(min == 0) {
            cameras++;
            help = 1;
        }else if (min == 1){
            help = 2;
        }else{
            help = 0;
        }
        return help;
    }
    public static void main(String[] args) {
        Integer[] a = {0,0,0,null,0,0,null,null,0,null,null,0,0};
        Treenode root = Treenode.buildTree(a);
        System.out.println(cameras(root));
        // Treenode.bfs(root);
        // System.out.println();
        // String s = serialize(root);
        // System.out.println(s);
        // Treenode root2 = Deserialize(s);
        // Treenode.bfs(root2);

    }
}
