package stacks;
import java.util.*;
public class Practice {
    public static void newxtGreat(int[] a){
        int n = a.length;
        int [] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && a[i]>a[stack.peek()]){
                res[stack.pop()] = a[i];
            }
            stack.push(i);
        }
        System.out.println(Arrays.toString(res));
    }
    public static boolean validpar(String s){
        HashMap<Character,Character> map = new HashMap<>();
        map.put('{','}');
        map.put('[',']');
        map.put('(',')');
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c= s.charAt(i);
            if(!stack.isEmpty()){
                if(c =='{'||c=='('||c=='['){
                    stack.push(c);
                }else{
                    if(stack.isEmpty() || map.get(stack.pop())!= c){
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
    public static boolean parenthesis(String s){
        HashMap<Character,Character> map = new HashMap<>();
        map.put('{','}');
        map.put('[',']');
        map.put('(',')');
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(map.containsKey(c)){
                stack.push(c);
            }else {
                if(!stack.isEmpty() && map.get(stack.peek())!=c){
                    return false;
            }else{
                stack.pop();
            }
        }
    }
        return stack.isEmpty();
    }
    public static void dailyTemp(int[] a){
        int n = a.length;
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[a.length];
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && a[i]>a[stack.peek()]){
                res[stack.peek()] = i- stack.pop();
            }
            stack.push(i);
        }
        System.out.println(Arrays.toString(res));
        }
    public static int largestRectangle(int[] a){
        Stack<Integer> stack  = new Stack<>();
        int max = Integer.MIN_VALUE;
        int [] res = new int[a.length];
        for(int i=0;i<a.length;i++){
            while(!stack.isEmpty() && a[i]>a[stack.peek()]){
                res[stack.peek()] = a[i]-a[stack.pop()];
            }
            stack.push(i);
        }
        System.out.println(Arrays.toString(res));
        return stack.peek();
    }
    public static int maxRec(int[] a){
        int n = a.length;
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && a[stack.peek()]>a[i]){
                int top = stack.pop();
                int h = a[top];
                int left = stack.isEmpty()?-1:stack.peek();
                int w = n-left-1;
                max = Math.max(max,h*w);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int top = stack.pop();
            int h =a[top];
            int lef = stack.isEmpty()?-1:stack.peek();
            int w = n-lef-1;
            max = Math.max(max,w*h);
        }
        return max;
    }
    public static void main(String[] args) {
        int[] a = {73, 74, 75, 71, 69, 72, 76, 73};

        System.out.println(maxRec(a));
    }
}
