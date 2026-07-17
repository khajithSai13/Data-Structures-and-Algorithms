public class CustomLinkedList {
    Node head;
    public class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
        }
    }
    public boolean isEmpty(){
        return head==null;
    }
    public void add(int data){
        if(isEmpty()){
            Node node = new Node(data);
            head = node;
            return;
        }
        Node node = new Node(data);
        node.next = head;
        head = node;
    }
    public void removeAthead(){
        if(isEmpty()){
            System.out.println("is Empty");
            return ;
        }
        head = head.next;
    }
    public void removeAtEnd(){
        if(isEmpty()){
             System.out.println("is Empty");
            return ;
        }
        Node curr = head;
        while(curr.next.next!=null){
            curr = curr.next;
        }
        curr.next = null;
    }
    public void addAtend(int data){
        if(isEmpty()){
            Node node = new Node(data);
            head = node;
            return;
        }
        Node curr = head;
        Node newNode = new Node(data);
        while(curr.next!=null){
            curr = curr.next;
        }
        curr.next = newNode;
    }
    public void printlist(){
        if(isEmpty()){
            System.out.println("Empty");
            return;
        }
        Node curr = head;
        while(curr!=null){
            System.out.print(curr.data+"->");
            curr=curr.next;
        }
        System.out.print("null");
        }
    public static void main(String[] args) {
        CustomLinkedList list = new CustomLinkedList();
        list.add(1);
        list.add(5);
        list.add(6);
        list.addAtend(9);
        list.removeAthead();
        list.removeAtEnd();
        list.printlist();

    }
}
