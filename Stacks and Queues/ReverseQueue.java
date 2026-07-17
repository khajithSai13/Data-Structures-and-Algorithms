import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {
    public static void Reverse(Queue<Integer> q){//using stack
        Stack<Integer> stack = new Stack<>();
        while(!q.isEmpty()){
            stack.push(q.poll());
        }
        while(!stack.isEmpty()){
            q.offer(stack.pop());
        }
    }
    public static void recursion(Queue<Integer> q,int n,int v){//lol rotation
        if(n==v)return;
        q.add(q.poll());
        System.out.println(q.peek());
        recursion(q, n-1,v);
    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=1;i<=10;i++){
            q.offer(i);
        }int n =q.size();
        // for(int val:q){
        //     System.out.print(val+" ");
        // }
        System.out.println(n);
        recursion(q,n,n/2);
        for(int val:q){
            System.out.print(val+" ");
        }
    }
}
