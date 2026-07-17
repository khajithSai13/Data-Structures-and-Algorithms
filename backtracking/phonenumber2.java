import java.util.*;
public class phonenumber2 {
    static String numbers[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public static List<String> numberCombinations(String s){
        List<String> result = new ArrayList<>();
        backtrack(s,0,new StringBuilder(),result);
        return result;
    }
    private static void backtrack(String s,int sidx,StringBuilder sb,List<String> result){
       if(sidx == s.length()){
        result.add(sb.toString());
        return;
       } 
       String t = numbers[s.charAt(sidx)-'0'];
       for(int i=0;i<t.length();i++){
            sb.append(t.charAt(i));
            backtrack(s, sidx+1, sb, result);
            sb.deleteCharAt(sb.length()-1);
       }
    }
    public static void main(String[] args) {
        List<String> result = numberCombinations("23");
        System.out.println(result);
        }
}
