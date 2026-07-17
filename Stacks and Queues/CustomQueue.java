public class CustomQueue {
    int front =0;
    int back = -1;
    int maxSize;
    int[] queue;
    public CustomQueue(int size){
        maxSize = size;
        queue = new int[maxSize];
    }
    public boolean isEmpty(){
        return (front>back)||(front==-1);
    }
    public void enqueue(int num){
        if(back==maxSize-1){
            System.out.println("queue is full");
            return;
        }
        queue[++back] = num;
    }
    public void dequeue(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return;
        }
        queue[front]=0;
        front++;
    }
    public void printQueue(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return;
        }
        for(int i=front;i<=back;i++){
            System.out.println(queue[i]);
        }
    }
    public static void main(String[] args) {
        CustomQueue que = new CustomQueue(10);
        System.out.println(que.isEmpty());
        que.printQueue();
        que.enqueue(0);
        que.enqueue(2);
        que.enqueue(5);
        //que.printQueue();
        que.dequeue();
        que.dequeue();
        que.printQueue();

    }
    
}
