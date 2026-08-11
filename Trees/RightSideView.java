package Trees;
import java.util.*;
class RightSideView{
    public static List<Integer> RSV(Treenode root){
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Queue<Treenode> q = new LinkedList<>();
        q.add(root);
        int currLevel = 1;
        while(!q.isEmpty()){
            Treenode curr = q.poll();
            currLevel--;
            if(curr.left != null) q.add(curr.left);
            if(curr.right != null) q.add(curr.right);
            if(currLevel ==0){
                list.add(curr.data);
                currLevel = q.size();
            }
        }
        return list;

    }
    public static List<List<Integer>> zigZag(Treenode root){
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;
        int level = 0;
        Queue<Treenode> q = new LinkedList<>();
        q.add(root);
        List<Integer> current = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int currLevel = 1;
        while(!q.isEmpty()){
            for(Treenode val : q) System.out.print(val.data+" ");
            System.out.println();
            Treenode curr = q.poll();
            if(curr.left != null) q.add(curr.left);
            if(curr.right != null) q.add(curr.right);
            currLevel--;
            if(level%2 == 0){
                current.add(curr.data);
            }else{
                stack.push(curr.data);
            }
            if(currLevel == 0){
                if(level %2 !=0){
                    while(!stack.isEmpty()){
                        current.add(stack.pop());
                    }
                }
                list.add(new ArrayList<>(current));
                current.clear();
                currLevel = q.size();
                level++;
            }
        }
        return list;
    }
    public static Treenode LCA(Treenode root,Treenode p, Treenode q){
        if(root == null||root==p||root==q) return root;
        Treenode left = LCA(root.left, p, q);
        Treenode right = LCA(root.right,p,q);
        if(left != null && right !=null){
            return root;
        }
        return(left !=null)?left:right;
    }
    
    public static void main(String[] args) {
        Integer[] a= {1,2,3,4,null,null,5};
        Treenode root = Treenode.buildTree(a);
        System.out.println(zigZag(root));
    }
}