import java.util.*;
public class RepeatedDnaSequence {
    public static List<String> dna(String s){
        List<String> list = new ArrayList<>();
        int n = s.length();
        if(n < 10) return list;
        //StringBuilder sb = new StringBuilder();
        HashMap<String,Integer> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        int l = 0;
        for(int r = 9;r<n;r++){
            String ss = s.substring(l,r+1);
            System.out.println(ss);
            map.put(ss,map.getOrDefault(ss,0)+1);
            l++;
        }l=0;
        System.out.println(map);
        for(int r=9;r<n;r++){
            String sss= s.substring(l,r+1);
            System.out.println(sss + " -> " + map.get(sss));
            if(map.get(sss) > 1){
                set.add(sss);
            }
            l++;
        }
        list.addAll(set);
        return list;
    }
    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println(dna(s));
    }
}
