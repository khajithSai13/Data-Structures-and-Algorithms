import java.util.*;
public class phonenumbercomb {
    static String numbers[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public static List<List<Character>> numberCombinations(String s){
        List<List<Character>> result = new ArrayList<>();
        backtrack(s,0,new ArrayList<>(),result);
        return result;
    }
    private static void backtrack(String s,int sidx,List<Character> curr,List<List<Character>> result){
       if(sidx == s.length()){
        result.add(new ArrayList<>(curr));
        return;
       } 
       String t = numbers[s.charAt(sidx)-'0'];
       for(int i=0;i<t.length();i++){
            curr.add(t.charAt(i));
            backtrack(s, sidx+1, curr, result);
            curr.remove(curr.size()-1);
       }
    }
    public static void main(String[] args) {
        List<List<Character>> result = numberCombinations("23");
        for(List<Character> lis:result){
            System.out.println(lis);
        }
        }
}
