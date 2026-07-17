public class ListNode {

    ListNode next;
    int val;
    ListNode head;

    public ListNode() {
        head = null;
    }

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    public boolean isEmpty() {
        return head == null;
    }
    public void addAtEnd(int data) {
        ListNode node = new ListNode(data);

        if (isEmpty()) {
            head = node;
            return;
        }

        ListNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = node;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Empty");
            return;
        }

        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + "->");
            curr = curr.next;
        }
        System.out.println("null");
    }
    public void revrese(ListNode head){
        
    }
    public static ListNode addTwo(ListNode l1,ListNode l2){
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        ListNode dummy = new ListNode();
        int carry =0;
        while(curr1!=null&&curr2!=null){
            int val = curr1.val+curr2.val+carry;
            if(val>9){
                carry = val%9;
                val = val/9;
            }
            dummy.addAtEnd(val);
        }
        return dummy.head;

    }
    public static void rotate(ListNode head,int k){
    
    }
    public static ListNode shuffle(ListNode list1,ListNode list2){
        ListNode curr1 = list1;
        ListNode curr2 = list2;
        while(curr1!=null|| curr2!=null){
            ListNode t1 = curr1.next;
            ListNode t2 = curr2.next;
            curr1.next = curr2;
            curr2.next = t1;
            curr1 = t1;
            curr2 = t2;
        }
        return list1;
    }
    public static void main(String[] args) {
        ListNode list = new ListNode();
        ListNode list2 = new ListNode();
        // list.addAtEnd(2);
        // list.addAtEnd(4);
        // list.addAtEnd(3);
        // //list.print();
        // ListNode list2 = new ListNode();
        // list2.addAtEnd(5);list2.addAtEnd(6);list2.addAtEnd(4);
        // //list2.print();
        // ListNode ans = addTwo(list.head,list2.head);
        // ListNode curr = ans;
        // while(curr !=null){
        //     System.out.println(curr.val);
        // }       
        for(int i=1;i<=5;i++){
            list.addAtEnd(i);
        }
        for(int i=6;i<=10;i++){
            list2.addAtEnd(i);
        }
       list.head = shuffle(list.head,list2.head);
        list.print();
    }
}
