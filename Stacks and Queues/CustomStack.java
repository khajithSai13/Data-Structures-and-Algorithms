public class CustomStack {
        int top =-1;
        int maxSize;
        int[] stackArray;
        public CustomStack(int size){
            maxSize = size;
            stackArray = new int[maxSize];
        }
        public boolean isEmpty(){
                
                return top==-1;
        }
        public void push(int data){
                if(top==maxSize-1){
                        System.out.println("StackOverflow");
                        return;
                }
                stackArray[++top]=data;
        }
        public int pop(){
                if(isEmpty()){
                        System.out.println("Stack Is Empty");
                        return -1;
                }
                int val = stackArray[top];
                stackArray[top--]=0;
                return val;
        }
        public int peek(){
                if(isEmpty()){
                        System.out.println("Stack Is Empty");
                        return -1;
                }
                return stackArray[top];
        }
        public static void main(String args[]){
                CustomStack stack = new CustomStack(10);
                for(int i=0;i<10;i++){
                        stack.push(i);
                        System.out.print(stack.peek()+" ");
                }
        }

}
