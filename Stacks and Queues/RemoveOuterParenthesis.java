import java.util.Stack;

public class RemoveOuterParenthesis {
    public static String removeOuter(String s){
        int n = s.length();
        if(n ==0) return "";
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(ch == '('){
                if(!stack.isEmpty()){
                sb.append(ch);
            }
                stack.push(ch);
            }else if(!stack.isEmpty() && ch == ')'){
                stack.pop();
                if(!stack.isEmpty()){
                sb.append(ch);
            }
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String s = "(()())(())(()(()))";
        System.out.println(removeOuter(s));
    }
}
