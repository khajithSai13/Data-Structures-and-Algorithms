import java.util.*;
public class HardStack {
    public static int[] nextGreaterII(int[] nums){//Bummer
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] ans = new int[n];
        for(int i=0;i<2*n;i++){
            if(!map.containsKey(nums[i])){
                while(!stack.isEmpty()&& nums[i%n]>stack.peek()){
                    map.put(stack.pop(),nums[i%n]);
                }
                stack.push(nums[i%n]);
            }
        }while(!stack.isEmpty()){
            map.put(stack.pop(),-1);
        }
        for(int i=0;i<ans.length;i++){
            ans[i] = map.get(nums[i]);
        }
        return ans;
    }
    public static int LargestRectangle(int[] heights){
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for(int i=0;i<n;i++){
            while(!stack.isEmpty()&&heights[stack.peek()]>heights[i]){
                int top = stack.pop();
                if(stack.isEmpty()) break;
                int ht = heights[top];
                int wd = i-stack.peek()-1;
                System.out.println(ht+" "+wd);
                max = Math.max(max,ht*wd);
            }
            stack.push(i);
        }
        if(!stack.isEmpty()){
            int rb = n-1;
        while(!stack.isEmpty()){
           int top = stack.peek();
           int h = heights[stack.pop()];
           if(stack.isEmpty()) {
             int w = rb-top+1;
             max = Math.max(w*h,max);
             break;
           }
           int w = rb-stack.peek()+1;
           max = Math.max(h*w,max);
        }
    }
        return max;
    }
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        System.out.println(LargestRectangle(a));
    }
}
