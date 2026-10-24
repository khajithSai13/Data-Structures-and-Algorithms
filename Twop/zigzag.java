import java.util.*;
public class zigzag {
    public static String zig(String s,int rows){
        int n = s.length();
        if(n == 0 || rows ==0) return "";
        StringBuilder sb = new StringBuilder();
        List<StringBuilder> list = new ArrayList<>();
        int x = 0;
        for(int i=0;i<rows;i++) list.add(new StringBuilder());
        boolean goingdown = false;
        for(char ch : s.toCharArray()){
            if(x == rows-1 || x == 0){
                goingdown = !goingdown;
            }
            list.get(x).append(ch);
            System.out.println(x+" "+goingdown);
            if(goingdown){
                x += 1;
            }else{
                x -=1;
            }
        }
        for(StringBuilder lis : list){
            sb.append(lis.toString());
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        System.out.println(zig(s,4));
    }
}
