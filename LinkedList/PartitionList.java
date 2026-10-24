import java.util.*;
public class PartitionList {
    static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
        }
    }
    public static void print(Node head){
        if(head == null) return;
        Node curr = head;
        while(curr != null){
            System.out.print(curr.data+" ");
            curr = curr.next;
        }
    }
    public static Node partition(Node head,int x){
        if(head == null) return null;
        Node dummy = new Node(0);
        dummy.next = head;
        Node slow = dummy,fast = head;
        int v = 0;
        while(fast != null){
            if(fast.data < x){
                if(slow.next == fast){
                    slow = fast;
                    fast = fast.next;
                }else{
                Node t1 = slow.next;
                Node t2 = fast.next;
                slow.next = fast;
                fast.next = t1;
                slow = slow.next;
                fast = t2;
                }
            }else{
                fast = fast.next;
            }
           
        }
        return dummy.next;
    }
    public static Node partition2(Node head, int x) {
    if (head == null) return null;

    Node dummy = new Node(0);
    dummy.next = head;

    Node slow = dummy;
    Node fast = head;
    Node prevFast = dummy;   // node before fast

    while (fast != null) {

        if (fast.data < x) {

            // Already in the correct position
            if (slow.next == fast) {
                slow = fast;
                prevFast = fast;
                fast = fast.next;
            }

            // Move fast node forward
            else {
                Node t2 = fast.next;

                // Remove fast from its current position
                prevFast.next = t2;

                // Insert fast after slow
                fast.next = slow.next;
                slow.next = fast;

                // Update pointers
                slow = fast;
                fast = t2;
            }

        } else {
            prevFast = fast;
            fast = fast.next;
        }
    }

    return dummy.next;
}
    public static void main(String[] args) {
        int[] a = {1,4,2,3,2,5};
        Node head = null,tail = null;
        for(int i : a){
            Node nn = new Node(i);
            if(head == null){
                head = nn;
                tail = nn;
            }else{
                tail.next = nn;
                tail = nn;
            }
        }
        print(partition(head,3 ));

    }
}
