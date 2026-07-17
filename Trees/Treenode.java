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
    public static void main(String[] args) {
        Integer[] a = {1,2,3,4,6};
        Treenode root = buildTree(a);
        System.out.println(CountNodes(root));
     }
}
