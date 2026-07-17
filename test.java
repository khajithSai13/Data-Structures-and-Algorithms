import java.util.*;
class test{
    public static void main(String[] args) {
        String s = "ababbbsbababbea";
        String pat = "ab";
        List<Integer> result = new ArrayList<>();
        int index = s.indexOf(pat);
        while(index!= -1){
            result.add(index);
            index = s.indexOf(pat,index+1);
        }
        System.out.println(result);   
    }
}