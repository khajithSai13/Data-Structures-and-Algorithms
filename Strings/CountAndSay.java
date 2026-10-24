import java.util.*;
class CountAndSay{
    public static String countNsay(int n){
        if(n == 1){
            return "1";
        }
        return helper(countNsay(n-1));

    }
    public static String helper(String s){
        int n = s.length();
        int i =0;
        StringBuilder sb = new StringBuilder();
        while(i< n){
            int j = i;
            int count = 0;
            while(j<n && s.charAt(i) == s.charAt(j)){
                j++;
            }
            count = j-i;
            sb.append(count);
            sb.append(s.charAt(i));
            i= j;
        }
        return sb.toString();
    }
    public static void main(String args[]){
        int n = 4;
        System.out.println(countNsay(n));
       // System.out.println(helper("1111212222333"));
    }
}