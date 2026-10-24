package Math;
import java.util.*;
public class MultiplyStrings {
    public static String addStrings(String num1, String num2) {
        int n = num1.length();
        int m = num2.length();
        if(n==0)return num2;
        if(m==0) return num1;
        StringBuilder sb = new StringBuilder();
        int i = n-1;
        int j = m-1;
        int carry = 0;
        while(i>=0 || j>=0||carry != 0){
            int l = (i>=0) ? num1.charAt(i--)-'0':0;
            int r = (j>=0) ? num2.charAt(j--)-'0':0;
            int number = l+r+carry;
            carry = number/10;
            number %= 10;
            sb.append(number);
        }
        return sb.reverse().toString();

    }
    public static String multiply(String a,String b){
        int n = a.length();
        int m = b.length();
        if(a.equals("0") || b.equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        List<String> list = new ArrayList<>();
        for(int i=m-1;i>=0;i--){
            sb.setLength(0);
            carry = 0;
            int j = n-1;
            int num = b.charAt(i)-'0';
            while(j>=0 || carry !=0){
                int v = (j>=0) ? a.charAt(j--)-'0':0;
                int imnum = v*num;
                imnum += carry;
                carry = imnum/10;
                imnum %= 10;
                sb.append(imnum);
            }
            sb.reverse();
            for(int k = m-1;k>i;k--){
                sb.append(0);
            }
            list.add(sb.toString());
        }
        //System.out.println(list);
        String result = "";
        for(String ss : list){
            result = addStrings(ss, result);
        }
        return result;
    }
    public static void main(String[] args) {
        String s = "123";
        String p = "0";
        System.out.println(multiply(s, p));
    }
}
