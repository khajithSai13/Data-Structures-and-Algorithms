package Trees;

public class LowestCommonAncestor{
    static Treenode node = null;
    // public static Treenode LCA(Treenode root , Treenode p,Treenode q){
    //     int l = helper(root.left,p,q,0);
    //     if(l == 3){
    //         return node;
    //     }else if(l==2 || l==1){
    //         node = null;
    //     }
    //     int r = helper(root.right,p,q,0);
    //     if(r==3){
    //         return node;
    //     }else if(r==1 || r==2){
    //         node = null;
    //     }
    //     return (l+r==3) ? root:null;
    // }
    // public static int helper(Treenode root,Treenode p,Treenode q,int num){
    //     if(num == 3) return num;
    //     if(root == null) return num;
    //     if(root == p || root == q){
    //         if(num == 0){
    //             num = root==p?1:2;
    //             node = root;
    //         }else if(num ==1){
    //             num = (root==q)? 3:1;
    //             node = root;
    //         }else if(num ==2){
    //             num = (root==p) ? 3:2;
    //             node = root;
    //         } overComplicated
    //     }
    //     int l = helper(root.left,p,q,num);
    //     if(l == 3){
    //         return num;
    //     }
    //     int r = helper(root.right,p,q,num);
    //     if(r==3){
    //         return num;
    //     }
    //     return l+r;
        
    // }
    public static Treenode LCA(Treenode root,Treenode p,Treenode q){
        if(root == null || root == p|| root ==q){
            return root;
        }
        Treenode left = LCA(root.left, p, q);
        Treenode right = LCA(root.right, p, q);
        if(left !=null && right != null){
            return root;
        }
        return(left != null) ? left:right;
    }
    static int max = 0;
    public static int Diameter(Treenode root){
        if(root == null) return 0;
        int left = Diameter(root.left);
        int right = Diameter(root.right);
        max = Math.max(max,left+right);
        return 1+Math.max(left,right);
    }
    static int maximum = Integer.MIN_VALUE;
    public static int maxPathSum(Treenode root){
        if(root == null)return 0;
        int maxSum = 0;
        maximum = root.data;
        int l = sumhelper(root.left);
        int r = sumhelper(root.right);
        //System.out.println(l+" "+r);
        int mx = Math.max(l,r);
        maxSum = Math.max(l+r,mx);
        return Math.max(maximum,root.data+maxSum);
    }
    public static int sumhelper(Treenode root){
        if(root == null) return 0;
        int l = sumhelper(root.left);
        int r = sumhelper(root.right);
        maximum = Math.max(root.data+l+r,maximum);
        //System.out.println(maximum);
        int mm = Math.max(root.data+l,root.data+r);
        return Math.max(mm,root.data);
    }
    public static void main(String[] args) {
        Integer[] a = {10,5,-20,null,null,3,4};
        Treenode root = Treenode.buildTree(a);
        // Treenode curr = LCA(root, Treenode.findNode(root, 2), Treenode.findNode(root, 1));
        // Treenode.bfs(curr);
        System.out.println(maxPathSum(root));
    }
}
