package Math;

public class AddStrings {
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
    public static void main(String[] args) {
        String s1 = "999999";
        String s2 = "999999";
        System.out.println(addStrings(s1, s2));
    }
}
