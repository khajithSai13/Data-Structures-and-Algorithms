package Trees;

import java.util.*;
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
            //System.out.println();
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
    public static int depth(Treenode root){
        if(root == null)return 0;
        int m1 = 1+depth(root.left);
        int m2 = 1+depth(root.right);
        return Math.max(m1,m2);
    }
    public static boolean isBalanced(Treenode root){ // complexity is a bit high but the approach is valid
        if(root == null) return true;
        if(Math.abs(depth(root.left)-depth(root.right))<=1){
            if((!isBalanced(root.left)) || (!isBalanced(root.right))){
                return false;
            }
        }else{
            return false;
        }
        return true;
    }
    public static boolean Balanced(Treenode root){
        
        return helper(root) != -1;
    }
    public static int helper(Treenode root){
        if(root == null) return 0;
        int left = helper(root.left);
        if(left == -1) return -1;
        int right = helper(root.right);
        if(right == -1) return -1;
        return 1+Math.max(left,right);
    }
    public static List<Integer> maximumAtLevel(Treenode root){
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<Treenode> q = new LinkedList<>();
        q.add(root);
        int max = Integer.MIN_VALUE;
        int currlevel = 1;
        while(!q.isEmpty()){
            Treenode curr = q.poll();
            if(curr.left != null) q.add(curr.left);
            if(curr.right !=null) q.add(curr.right);
            currlevel--;
            max = Math.max(max,curr.data);
            if(currlevel ==0){
                currlevel = q.size();
                ans.add(max);
                max = Integer.MIN_VALUE;
            }
        }
        return ans;
    }
    public static List<Integer> rightSideview(Treenode root){
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<Treenode> q = new LinkedList<>();
        q.add(root);
        int nodesInLevel = 1;
        while(!q.isEmpty()){
            Treenode curr = q.poll();
            if(nodesInLevel == 1) ans.add(curr.data);
            if(curr.left != null) q.add(curr.left);
            if(curr.right !=null) q.add(curr.right);
            nodesInLevel--;
            if(nodesInLevel ==0){
                nodesInLevel = q.size();
            }
        }
        return ans;
    }
    public static boolean hasPathSum(Treenode root,int target,int curr){
        if(root == null ) return false;
        curr += root.data;
        if(root.left == null && root.right == null && curr== target){
            return true;
        }
        if(hasPathSum(root.left, target, curr))    return true;
        if(hasPathSum(root.right, target, curr)) return true;
        return false;
}
    public static int diameterFunc(Treenode root){
        int max = 0;
        Queue<Treenode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Treenode curr = q.poll();
            if(curr.left != null) q.add(curr.left);
            if(curr.right != null) q.add(curr.right);
            max = Math.max(diameter(curr),max);
        }
        return max;
    }
    public static int diameter(Treenode root){
        if(root == null)return 0;
        int left = (root.left != null)? 1+rec(root.left, 0):0;
        int right = (root.right !=null) ? 1+rec(root.right, 1):0;
        return left +right;
    }
    public static int rec(Treenode root,int direction){

        if(root == null ||(root.left == null && root.right == null) )return 0;
        if(direction == 0){
            return 1+((root.left !=null)?rec(root.left, direction):rec(root.right,direction));
        }else{
            return 1+((root.left !=null)?rec(root.left, direction):rec(root.right,direction));
        }
    }
    static int maxDiameter = 0;
    public static int Diameter3(Treenode root){
        if(root == null) return 0;
        //if(root.left == null && root.right == null ) return 1;
        int l = Diameter3(root.left);
        int r = Diameter3(root.right);
        maxDiameter = Math.max(maxDiameter,l+r);
        return 1+Math.max(l,r);
    }
    public static void invert(Treenode root){
        if(root == null) return;
        Treenode temp = root.right;
        root.right = root.left;
        root.left = temp;
        invert(root.left);
        invert(root.right);
    }
    public static Treenode findNode(Treenode root,int data){
        if(root == null ) return null;
        if(root.data == data) return root;
        Treenode l = findNode(root.left, data);
        Treenode r = findNode(root.right, data);
        if(l == null && r == null) return null;
        return (l==null)?r:l;
    }
    public static Treenode LCA(Treenode root,Treenode p,Treenode q){
        if(root == null) return null;
        if((root.left == p&&root.right== q)||(root.left == q && root.right == p)){
            return root;
        }
        Treenode node = null;
        boolean pf = false;
        boolean qf = false;
        if(root == p){
            pf = true;
            node = root;
        }else if(root == q){
            qf = true;
            node = root;
        }
        Treenode left = lcaHelper(root.left, p, q, pf, qf,node);
        Treenode right = lcaHelper(root.right, p, q, pf, qf,node);
        //System.out.println(left.data+" "+ right.data);
        if(left == null && right == null) return null;
        return (left == null)?right:left;

    }
    public static Treenode lcaHelper(Treenode root,Treenode p,Treenode q, boolean pf,boolean qf,Treenode node){
        if(root == null) return null;
        if((root.left == p&&root.right== q)||(root.left == q && root.right == p)){
            return root;
        }
        if(root == p || root == q){
            if(root == p)
                pf = true;
            else 
                qf = true;
            if( node == null)
                node = root;
        }
        
        if(pf && qf) return node;
        Treenode l = lcaHelper(root.left, p, q, pf, qf, node);
        Treenode r = lcaHelper(root.right, p, q, pf, qf, node);
        if(l == null && r == null) return null;
        return l==null ? r:l;

    }

    public static void main(String[] args) {
        Integer[] a = { 10,5,15,3,7,12,20,1,4,6,8,null,null,18,25,
    null,null,null,null,null,9};
        Treenode root = buildTree(a);
        bfs(LCA(root, findNode(root,4), findNode(root, 18)));
     }
}

