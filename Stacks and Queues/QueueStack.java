import java.util.Stack;

public class QueueStack {
    Stack<Integer> input;
    Stack<Integer> output;
    public boolean isEmpty(){
        while(!input.isEmpty()){
            output.push(input.pop());
        }
        return output.isEmpty();
    }
    public void enqueue(int num){
        input.push(num);
    }
    public void dequeue(){
        if(!input.isEmpty()){
            while(!input.isEmpty()){
            output.push(input.pop());
        }
        }
        if(!output.isEmpty()){output.pop();}else{System.out.println("que is");}
    }
    public int peek(){
        return (output.isEmpty())?-1:output.peek();
    }
    public void print(){
        while(!input.isEmpty()){
            output.push(input.pop());
        }
        while (!output.isEmpty()) {
            System.out.println(input.push(output.pop()));
        }
    }
    public static void main(String[] args) {
        QueueStack q = new QueueStack();
        System.out.println(q.isEmpty());
        q.enqueue(0);
        q.enqueue(5);
        q.dequeue();
        
    }

}
