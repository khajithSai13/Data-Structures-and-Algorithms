package Trees;

import java.util.*;
class test{
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static Node buildTree(Integer[] nums){
        int n = nums.length;
        if(nums[0]==0 || n==0) return null;
        Queue<Node> q = new LinkedList<>();
        Node root = new Node(nums[0]);
        q.add(root);
        int i=1;
        while(!q.isEmpty() && i<n){
            Node curr = q.poll();
            if(i<n && nums[i]!=null){
                curr.left = new Node(nums[i]);
                q.add(curr.left);
            }
            i++;
            if(i<n&&nums[i]!=null){
                curr.right = new Node(nums[i]);
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }
    public static void traversal(Node root){
        if(root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node curr = q.poll();
            System.out.print(curr.data+" ");
            if(curr.left!=null)q.add(curr.left);
            if(curr.right !=null)q.add(curr.right);
        }
    }
    public static void preorder(Node root){
        if(root == null) return;
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void inorder(Node root){
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // List<Integer> list = new ArrayList<>();
        // String s = sc.nextLine().trim();
        // String[] ss = s.split(" ");
        // for(String a : ss){
        //     list.add(Integer.parseInt(a));
        // }
        // Integer nums[] = new Integer[list.size()];
        // for(int i=0;i<nums.length;i++){
        //     nums[i] = list.get(i);
        // }
        Integer nums[] = new Integer[]{1,2,3,4,6,7};
        Node root = buildTree(nums);
        System.out.println("preorder : ");
        preorder(root);
        System.out.println("inorder : ");
        inorder(root);
        System.out.println("Traversal : ");
     
        traversal(root);
    }
}