import java.util.*;
public class PermutationInString {
    public static boolean permutation(String a,String s){ //mehhhh
        int n = a.length();
        if( n > s.length()) return false;
        HashSet<Character> set = new HashSet<>();
        HashSet<Character> window = new HashSet<>();
        for(int i=0;i<a.length();i++){
            set.add(a.charAt(i));
            if(set.contains(s.charAt(i))){
                window.add(s.charAt(i));
            }
        }
        if(set.size() == window.size()) return true;
        int l = 0;
        for(int r = a.length();r<s.length();r++){
            window.remove(s.charAt(l++));
            if(set.contains(s.charAt(r))) window.add(s.charAt(r));
            if(window.size() == set.size()) return true;
        }
        return false;
    }
    public static boolean permutation2(String a,String b){
        int n = a.length();
        int m = b.length();
        int[] frq = new int[26];
        int[] window = new int[26];
        for(int i=0;i<n;i++){
            char w = a.charAt(i);
            char ch = b.charAt(i);
            frq[w-'a']++;
            window[ch-'a']++;
        }
        if(Arrays.equals(frq, window)){
            return true;
        }
        int l = 0;
        for(int r = n;r<m;r++){
            window[b.charAt(l++)-'a']--;
            if(window[b.charAt(l-1)-'a']<0)window[b.charAt(l-1)-'a'] = 0;
            char ch = b.charAt(r);
            window[ch-'a']++;
            if(Arrays.equals(frq,window)){
                return true;
            }

        }
        return false;
    }
    public static void main(String[] args) {
        String a = "adc";
        String s = "dcda";
        System.out.println(permutation(a,s));
    }
}
