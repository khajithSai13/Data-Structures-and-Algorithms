import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
//import java.util.Scanner;

public class QueueProbs {
    public static void nonrep(char[] a){
        Queue<Character> q = new LinkedList<>();
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<a.length;i++){
            char c = a[i];
            map.put(c,map.getOrDefault(c,0)+1);
            if(map.get(c)==1) q.offer(c);
            if(!q.isEmpty()) if(c==q.peek()&&map.get(c)>1) q.poll();
            System.out.println(q.isEmpty()?-1:q.peek());
        }
    }
    public static void main(String[] args) {
      //  Scanner sc = new Scanner(System.in);
       char [] c ={'a','a','b','b'};
       nonrep(c);
        
    }
}
