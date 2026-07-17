import java.util.*;
public class StacksProblems {
    public static boolean isValid(String s){
    HashMap<Character,Character> brackets = new HashMap<>();
    brackets.put('(',')');
    brackets.put('{', '}');
    brackets.put('[',']');
    int n = s.length();
    Stack<Character> stack = new Stack<>();
    for(int i = 0;i<s.length();i++){
        char c = s.charAt(i);
        if(c=='('||c=='{'||c=='['){
            stack.push(c);
        }else if(c=='}'||c==']'||c==')'){
            if(stack.isEmpty())return false;
            char top = stack.peek();
            if(brackets.get(top)==c){
                stack.pop();
            }else{
                return false;
            }
        }
    }
    return stack.isEmpty();
//refer leetcode for better approach
    }
    public static int[] dailyTemp(int[] temparature){
        int n =temparature.length;
        if(n==0)return new int[0];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int[] ans = new int[n];
        for(int i=1;i<n;i++){
                while(!stack.isEmpty()&&temparature[i]>temparature[stack.peek()]){
                    int top = stack.peek();
                    ans[top]=i-top;
                    stack.pop();
                }
                stack.push(i);
        }
        return ans;
    }
    public static int ValidParentheses(String s) {//failed approach
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        int valid =0;
        for(int i=0;i<s.length();i++){
             char ch = s.charAt(i);
            if(ch =='('||ch=='{'||ch=='['){
                stack.push(ch);
            }else{
                if(!stack.isEmpty()){
                char top = stack.peek();
                if((ch =='}'&&top=='{')||(ch==']'&&top=='[')||(ch==')'&&top=='(')){
                    stack.pop();
                    valid+=2;
                }
                }
            }
            
        }return valid;
    }
    public static int LongestVal(String s){
        int n = s.length();
        int[] dp = new int[0];

        return 0;
    }
     public static int[] nextGreater(int[] nums1,int[] nums2){
        Stack<Integer> stack = new Stack<>();
        int ans[] = new int[nums1.length];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num:nums2){
            while(!stack.isEmpty()&&num>stack.peek()){
                map.put(stack.pop(),num);
            }
            stack.push(num);
        }
        while(!stack.isEmpty()){
            map.put(stack.pop(),-1);
        }
        for(int i=0;i<nums1.length;i++){
            ans[i]=map.get(nums1[i]);
        }
        return ans;
     }
    public static int[] nextGreater(int[] a){
        int n = a.length;
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            while(!stack.isEmpty()&& a[i]>a[stack.peek()]){
                ans[stack.pop()] = a[i];
            }
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        int[] ans = nextGreater(nums1,nums2);
        for(int va:ans){
            System.out.println(va+" ");
        }
    }
}
