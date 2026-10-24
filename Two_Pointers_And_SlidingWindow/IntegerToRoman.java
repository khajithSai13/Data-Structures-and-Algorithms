import java.util.*;
public class IntegerToRoman {
    public static String inttoRome(int n,HashMap<Integer,String> map){
        StringBuilder sb = new StringBuilder();
        int[] v = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        int temp = n;
        for(int val : v){
            int k = temp/val;
            while(k>0){
                sb.append(map.get(val));
                k--;
            }
            temp %= val;
        }
        return sb.toString().trim();
    }
    public static void main(String[] args) {
        HashMap<Integer,String> map = new HashMap<>();
        map.put(1000,"M");
        map.put(900,"CM");
        map.put(500,"D");
        map.put(400,"CD");
        map.put(90,"XC");
        map.put(100,"C");
        map.put(50,"L");
        map.put(40,"XL");
        map.put(10,"X");
        map.put(9,"IX");
        map.put(5,"V");
        map.put(4,"IV");
        map.put(1,"I");
        System.out.println(inttoRome(999,map));
        //can simply use string array instead of the map
    }
}
