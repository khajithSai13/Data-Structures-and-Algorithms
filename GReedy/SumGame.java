import java.util.*;
public class SumGame {
    public static boolean game(String s){
        int n = s.length();
        int mid = n/2;
        //boolean exist = false;
        StringBuilder sb = new StringBuilder(s);
        boolean turn = true;
        int lsum = 0,rsum = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            System.out.println(ch);
            if(ch =='?'){
                if(turn){
                    if(i<mid){
                        sb.setCharAt(i, '0');
                    }else{
                        sb.setCharAt(i, '9');
                    }
                    turn = !turn;
                }else{
                    System.out.println("23");
                     if(i<mid){
                        sb.setCharAt(i, '9');
                    }else{
                        sb.setCharAt(i, '0');
                    }
                    turn = !turn;
                }
            }
        }
        System.out.println(sb.toString());
        for(int i=0;i<sb.length();i++){
            if(i<mid){
                lsum += sb.charAt(i)-'0';
            }else{
                rsum += sb.charAt(i)-'0';
            }
        }
        return rsum != lsum;
    }
    public static boolean game2(String s){
        int n = s.length();
        int mid = n/2;
        int lsum = 0,rsum =0,lq=0,rq=0;
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(ch == '?'){
                if(i<mid){
                    lq++;
                }else{
                    rq++;
                }
            }else{
                if(i<mid){
                    lsum += ch-'0';
                }else{
                    rsum += ch-'0';
                }
            }
        }
        if(lq == rq){
            return lsum != rsum;
        }
        return lsum - rsum == 9 * (lq - rq) / 2;

    }
    public static void main(String[] args) {
        String s = "9?";
        System.out.println(game2(s));
    }
}
