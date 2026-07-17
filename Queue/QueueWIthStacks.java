package Queue;

import java.util.Stack;

public class QueueWIthStacks {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    public boolean isEmpty(){
        return s2.isEmpty()&&s1.isEmpty();
    }
    public void add(int data){
        if(isEmpty()){
            s2.add(data);
            return;
        }
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
        s1.push(data);
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
    }
    public int poll(){
        if(isEmpty()) {System.out.println("Underflow");
        return -1;}
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
        int v  = s1.pop();
        while(!s1.isEmpty()) s2.push(s1.pop());
        return v;
    }
    public void print(){
        if(isEmpty()) {
            System.out.println("Underflow");
            return;
        }
        while(!s2.isEmpty()){
            s1.push(s2.pop());
            System.out.println(s1.peek());
        }
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
    }
    public static void main(String[] args) {
        QueueWIthStacks q = new QueueWIthStacks();
        q.add(1);
        q.add(2);
        q.print();
        q.poll();
        q.print();
    }
}
