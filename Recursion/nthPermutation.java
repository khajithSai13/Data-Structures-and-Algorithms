package Recursion;
import java.util.*;
class nthPermutation{
    public static String permutation(int n,int k){
        if(n ==0 || k==0) return "";
        String numbers = "123456789";
        List<String> list = new ArrayList<>();
        permutate(numbers.substring(0,n),new HashSet<>(),new StringBuilder(),list);
        System.out.println(list.size() );
        return list.get(k-1);

    }
    public static void permutate(String s,HashSet<Character> set,StringBuilder sb,List<String> list){
        if(sb.length() == s.length()){
            list.add(sb.toString());
            return;
        }
        for(char ch : s.toCharArray()){
            if(!set.contains(ch)){
                set.add(ch);
                sb.append(ch);
                permutate(s, set, sb, list);
                sb.setLength(sb.length()-1);
                set.remove(ch);
            }
        }
    }
    public static int fact(int n){
        if(n ==0 ||n==1) return 1;
        return n*fact(n-1);
    }
    static int acc = 0;
    static String result = "";
    public static String permutation2(int n,int k){
        if(n ==0 || k==0) return "";
        //if(k > fact(n)) return "";
        acc = 0;
        String numbers = "123456789";
        result = "";
        permutate2(numbers.substring(0,n),k,new HashSet<Character>(),new StringBuilder());
        return result;

    }
    public static void permutate2(String s,int k,HashSet<Character> set,StringBuilder sb){
        if(acc >=k) return;
        if(sb.length() == s.length()){
            acc++;
            if(acc == k){
                result = sb.toString();
            }
            return;
        }
        for(char ch : s.toCharArray()){
            if(!set.contains(ch)){
                set.add(ch);
                sb.append(ch);
                permutate2(s,k, set, sb);
                sb.setLength(sb.length()-1);
                set.remove(ch);
            }
            if(acc >= k) return;
        }
    }
    public static void main(String[] args) {
        int n = 3;
        int k = 3;
        System.out.println(permutation2(8,40320));
    }
}