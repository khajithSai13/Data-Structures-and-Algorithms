import java.util.*;
public class palindromePartitioning {
    public static List<List<String>> partition(String s){
        List<List<String>> result = new ArrayList<>();
        backtrack(s,0,"",new ArrayList<String>(),result);
        return result;
        
    }
    static boolean pal(String s){
        if(s.length()==1) return true;
        int i=0,j=s.length()-1;
        while(i<j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;j--;
        }
        return true;
    }
    static void backtrack(String s,int idx,String temp,List<String> curr,List<List<String>> result){
        if(idx == s.length()){
            result.add(new ArrayList<>(curr));
            return;
        }
        for(int i=idx;i<s.length();i++){
            temp = s.substring(idx,i+1);
            if (pal(temp)) {
                curr.add(temp);
                backtrack(s, i+1, temp, curr, result);
                curr.remove(curr.size()-1);
            }
        }
    }
    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> result = partition(s);
        for(List<String> list : result){
            System.out.println(list);
        }
    }
}
