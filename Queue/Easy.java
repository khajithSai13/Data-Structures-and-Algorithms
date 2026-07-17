package Queue;
import java.util.*;
public class Easy {
    public static void binaryGeneration(int n){
        Queue<String> que = new LinkedList<>();
        que.add("1");
        for(int i=0;i<n;i++){
            String curr = que.poll();
            System.out.print(curr+" ");
            que.add(curr+"0");
            que.add(curr+"1");
        }

    }
    public static void reverseq(Queue<Integer> q){
        Stack<Integer> stack = new Stack<>();
        while(!q.isEmpty()){
            stack.push(q.poll());
        }
        while(!stack.isEmpty()){
            q.add(stack.pop());
        }
    }
    public static void solve(String s){ ///wrong
        Queue<Character> que = new LinkedList<>();
        for(char c: s.toCharArray()) que.add(c);
        char non = que.poll();
        int val = 1;
        System.out.print(non+" ");
        while(!que.isEmpty()){
            if(non == que.peek()){
                System.out.print(-1+" ");
                que.poll();
                val = -1;
            }else{
                if(val == -1){
                    non = que.peek();
                    val = 1;
                }
                System.out.print(non+" ");
                que.poll();
            }
        }


    }
    
    public static void solve2(String s){
        int[] freq = new int[26];
        Queue<Character> que = new LinkedList<>();
        for(char c :s.toCharArray()){
            freq[c-'a']++;
            que.add(c);
            while(!que.isEmpty() && freq[que.peek()-'a']>1 ){
                que.poll();
            }
            if(que.isEmpty()){
                System.out.print(-1+" ");
            }else{
                System.out.print(que.peek()+" ");
            }
        }
    }
    public static void reverseK(Queue<Integer> que,int k){
        if(k>que.size() || k==0) {System.out.println("Invalid test"); return;}
        int n = que.size();
        int y = k;
        Stack<Integer> stack = new Stack<>();
        while(k>0){
            stack.push(que.poll());
            k--;
        }
        while(!stack.isEmpty()){
            que.add(stack.pop());
        }
        while(n-y>0){
            que.add(que.poll());
            y++;
        }
        for(int val : que){
            System.out.print(val+" ");
        }
    }
    public static void interleave(Queue<Integer> que){
        int i=0;
        int n = que.size();
        Stack<Integer> stack = new Stack<>();
        while(i<n/2){
            stack.push(que.poll());
            i++;
        }
        Stack<Integer> stack2 = new Stack<>();
        while(!stack.isEmpty()){
            stack2.push(stack.pop());
        }
        System.out.println(stack);
        while(i>0){
            que.add(stack2.pop());
            que.add(que.poll());
            i--;
        }
        for(int val : que) System.out.print(val+" ");

    }
    public static void firstNegative(int[] a,int k){
        
    }
    public static void main(String[] args) {
      //  int n = 5;
    //   Queue<Integer> que = new LinkedList<>();
    //   for(int i=1;i<=6;i++){
    //     que.add(i);
    //   }
    //   interleave(que);
        int[] a = {1,3,-1,-3,5,3,6,7};
        int k = 3,n=a.length,idx =0;
        Deque<Integer> dq = new LinkedList<>();
        int[] res = new int[n-k+1];
        for(int i=0;i<n;i++){
            while(!dq.isEmpty() && dq.peekFirst()==i-k){ //clearing window
                dq.pollFirst();
            }
            while(!dq.isEmpty() && a[dq.peekLast()]<a[i]){ //remove smaller elements
                dq.pollLast();
            }
            dq.addLast(i);//add  curr idx
            if(i>=k-1){
                res[idx++] = a[dq.peekFirst()];
            }
        }
        for(int val:res) System.out.println(val);

    }
}
