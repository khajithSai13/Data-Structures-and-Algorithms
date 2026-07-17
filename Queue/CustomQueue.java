package Queue;

class CustomQueue{
    int Max_Size = 10000;
    int[] stackArray = new int[Max_Size];
    int front= -1;
    int back = -1;
    public boolean isEmpty(){
        return front ==-1 || front>back;
    }
    public void enque(int data){
        if(isEmpty()){
            stackArray[++back] = data;
            front++; 
        }else{
        stackArray[++back] = data;
        }
    }
    public int dequeue(){
        if(front > back){
            front =-1;
            back = -1;
        }
        if(isEmpty()){ 
            System.out.println("queue is Empty");
            return -1;}
        int v = stackArray[front];
        stackArray[front++] = 0;
        return v;
    }
    public void printq(){
        int v = 0;
        for(v = front;v<=back;v++){
            System.out.print(stackArray[v]);
        }
    }
    public static void main(String[] args) {
        int [] a = new int[]{1,2,3,4,5};
        CustomQueue q = new CustomQueue();
        for(int i=0;i<a.length;i++){
            q.enque(a[i]);
        }
       q.dequeue();q.dequeue();q.dequeue();q.dequeue();q.dequeue();
       System.out.println(q.isEmpty());

    }
}