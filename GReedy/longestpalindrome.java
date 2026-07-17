import java.util.HashMap;
import java.util.Map;

class longestpalindrome{
    public static int longpal(String s){
        int n = s.length();
        if(n <=1){
            return n;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c, 0)+1);
        }
        int one =0;
        int len = 0;
        for(Map.Entry<Character,Integer> entry: map.entrySet()){
            int v = entry.getValue();
            if(v %2==0){
                len += v;
            }else{
                one =1;
                len+=(v-1);
            }
        }
        return (one ==0) ? len:len+1;
    }
    public static void main(String[] args) {
        String s ="avababab";
        System.out.println(longpal(s));
    }
}