import java.util.Stack;

public class Balanced_Parenthesis {
    public static boolean balanced(String s){
        if(s.length() == 0) return true;
        Stack<Character> stack = new Stack<>();
        for(char c:s.toCharArray()){
            if(c =='[' || c=='{' || c=='('){
                stack.push(c);
            }else if((c == '}' && stack.peek()=='{')|| (c==']' && stack.peek() == '[') || (c==')' && stack.peek()=='(')){
                stack.pop();
            }else{
                return false;
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        String s = "({[}]])";
        System.out.println(balanced(s));
    }
}
