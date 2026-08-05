package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Treenode {
    int data;
    Treenode left;
    Treenode right;
    public Treenode(int data){
        this.data = data;
    }
    public static Treenode buildTree(Integer[] a){
        if(a.length==0 || a[0] == null) return null;
        Queue<Treenode> que = new LinkedList<>();
        Treenode root = new Treenode(a[0]);
        int i =1;
        que.add(root);
        while(!que.isEmpty() && i<a.length){
            Treenode curr = que.poll();
            //left
            if(i<a.length && a[i]!=null){
                curr.left = new Treenode(a[i]);
                que.add(curr.left);
            }
            i++;
            //right
            if(i<a.length && a[i]!=null){
                curr.right = new Treenode(a[i]);
                que.add(curr.right);
            }
            i++;

        }
        return root;

    }
    public static void inorder(Treenode root){
        if(root == null){
            return ;
        }
        inorder(root.left);
        System.out.print(root.data +" ");
        inorder(root.right);
    }
    public static void printTree(Treenode root, int level) {
    if (root == null) return;

    printTree(root.right, level + 1);

    for (int i = 0; i < level; i++) {
        System.out.print("    ");
    }

    System.out.println(root.data);

    printTree(root.left, level + 1);
}
public static void preorder(Treenode root){
    if(root == null) return;
    System.out.print(root.data+" ");
    preorder(root.left);
    preorder(root.right);
}
public static void postorder(Treenode root){
    if(root == null) return;
    preorder(root.left);
    preorder(root.right);
    System.out.print(root.data+" ");
    
}
    public static void bfs(Treenode root){
        if(root == null) return;
        Queue<Treenode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Treenode curr = q.poll();
            System.out.print(curr.data+" ");
            if(curr.left !=null){
                q.add(curr.left);
            }
            if(curr.right !=null){
                q.add(curr.right);
            }
            System.out.println();
        }
        
        }
        public static void dfs(Treenode root){
            if(root == null ) return;
            Stack<Treenode> stack = new Stack<>();
            stack.push(root);
            while(!stack.isEmpty()){
                Treenode curr = stack.pop();
                System.out.print(curr.data+" ");
                if(curr.left !=null)stack.push(curr.left);
                if(curr.right!=null)stack.push(curr.right);
                System.out.println();
            }
        }
    public static int maxWidth(Treenode root){
        if(root == null) return 0;
        int max = 0;
        Queue<Treenode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Treenode curr = q.poll();
            max+=1;
            if(curr.left !=null){
                q.add(curr.left);
            }
            if(curr.right !=null){
                q.add(curr.right);
            }
        }
        return max;
    }
    public static int CountNodes(Treenode root){
        if(root == null) return 0;
        Queue<Treenode> q = new LinkedList<>();
        q.add(root);
        int c = 0;
        while(!q.isEmpty()){
            Treenode curr = q.poll();
            c++;
            if(curr.left !=null){
                q.add(curr.left);
            }
            if(curr.right !=null) q.add(curr.right);
        }
        return c;
    }
    public static boolean isSymmetric(Treenode root){
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;
        Queue<Treenode> q1 = new LinkedList<>();
        Queue<Treenode> q2 = new LinkedList<>();
        q1.add(root.left);
        q2.add(root.right);
        while(!q1.isEmpty() && !q2.isEmpty()){
            Treenode c1 = q1.poll();
            Treenode c2 = q2.poll();
            if(c1 !=null && c2!= null){
                if(c1.data != c2.data) return false;
            }else if((c1 == null && c2 != null) || (c1!=null && c2 == null)){
                return false;
            }else{
                continue;
            }
                q1.add(c1.left);
                q1.add(c1.right);
                q2.add(c2.right);
                q2.add(c2.left);
        }
        if(!q1.isEmpty() || !q2.isEmpty()) return false;
        return true;
        
    }
    public static boolean isSametree(Treenode n1,Treenode n2){
        if(n1 != null && n2 != null){
            if(n1.data != n2.data){
            return false;
            }
        }else if((n1 == null && n2!=null)||(n1!=null && n2==null )){
            return false;
        }else{
            return true;
        }
        if(! isSametree(n1.left, n2.left)){
            return false;
        }
        if(!isSametree(n1.right, n2.right)){
            return false;
        }
        return true;
    }
    public static int maxDepth(Treenode root,int maxDepth){ // everything is perfect and just gonna try a new approach
        if(root == null) return maxDepth;
        maxDepth++;
        int maxDepth1 = Math.max(maxDepth,maxDepth(root.left,maxDepth));
        int maxDepth2 = Math.max(maxDepth,maxDepth(root.right,maxDepth));
        return Math.max(maxDepth1,maxDepth2);
    }
    public static int maxDepth2(Treenode root){
        if(root == null)return 0;
        int m1 = 1+maxDepth2(root.left);
        int m2 = 1+maxDepth2(root.right);
        return Math.max(m1,m2);
    }
    public static void main(String[] args) {
        Integer[] a = {1,2,5,3,6,7,8,9};
        //Integer[] b = {1,2,null,5};
        System.out.println(maxDepth2(buildTree(a)));
     }
}
