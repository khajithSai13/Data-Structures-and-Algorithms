public class DoublyLibkedList {
    Node head;
    public class Node{
        int data;
        Node next;
        Node prev;
        public Node(int data){
            this.data = data;
        }
    }
    public boolean isEmpty(){
        return head==null;
    }
    public void addatStart(int data){
        if(isEmpty()){
            Node node = new Node(data);
            head = node;
            return;
        }
        Node node = new Node(data);
        node.next = head;
        head.prev = node;
        head = node;
    }
    public void removeAthead(){
        if(isEmpty()){
            System.out.println("is Empty");
            return ;
        }
        head = head.next;
        if(head==null) return;
        head.prev = null;
    }
    public void removeAtEnd(){
        if(isEmpty()){
             System.out.println("is Empty");
            return ;
        }
        if(head.next ==null){
            removeAthead();
            return;
        }
        Node curr = head;
        Node sl = curr.next;
        while(sl.next!=null){
             sl = sl.next;
            curr = curr.next;
        }
        curr.next = null;
        sl.prev = null;
        
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
        newNode.prev = curr;
    }
    public void printlist(){
        if(isEmpty()){
            System.out.println("Empty");
            return;
        }
        Node curr = head;
        while(curr!=null){
            System.out.print(curr.data+"<->");
            curr=curr.next;
        }
        System.out.print("null");
        }
    public static void main(String[] args) {
        DoublyLibkedList list = new DoublyLibkedList();
        list.addatStart(1);
        list.addatStart(5);
        list.addatStart(6);
        list.addAtend(9);
        list.removeAtEnd();
        list.removeAtEnd();
        list.printlist();

    }
}
