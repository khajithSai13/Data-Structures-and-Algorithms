public class LinkedList {
    public static class ListNode{
        ListNode next;
        String val;
        int value;
        public ListNode(int value){
            this.value = value;
        }
        public ListNode(int value,ListNode next){
            this.value = value;
            this.next = next;
        }
        public ListNode(String val){
            this.val = val;
        }
        public ListNode(String val,ListNode next){
            this.val = val;
            this.next = next;
        }
}
public static ListNode reverseLL(ListNode head){
    if(head==null) return null;
    ListNode prev = null;
    ListNode curr = head;
    while(curr !=null){
        ListNode temp = curr.next;
        curr.next =prev;
        prev = curr;
        curr = temp;
    }
    return prev;
}
public static void print(ListNode head){
    ListNode curr  = head;
    while(curr!=null){
        System.out.print(curr.value+"->");
        curr=curr.next;
    }
    
}


public static ListNode rotate(ListNode head,int k){
    if(head == null) return null;
    if(head.next == null) return head;
    while(k>0){
        ListNode curr = head;
        ListNode prev = null;
        while(curr.next!=null){
            prev = curr;
            curr = curr.next;
        }//BRUTEFORCE
        ListNode sechead = curr;
        prev.next = null;
        sechead.next = head;
        head = sechead;
        k--;
    }
    return head;
}
public static ListNode rotOptimal(ListNode head,int k){
    if(head == null || head.next==null) return head;
    int len =1;
    ListNode curr = head;
    while(curr.next!=null){curr = curr.next;
        len++;
    }
    k = k%len;
    if(k==0)return head;
    ListNode prev = null;
    curr = head;
    while(len>k){
        prev = curr;
        curr = curr.next;
        len--;
    }
    ListNode sec = curr;prev.next = null;
    curr = sec;
    while(curr.next!=null){
        curr = curr.next;
    }
    curr.next= head;
    return sec;
}
public static ListNode removeK(ListNode head,int k){
    if(head == null) return null;
    if(k==0) return head;
    ListNode curr = head;
    int n = 0;
    while(curr !=null){
        n++;
        curr = curr.next;
    }
    int y = n-k;
    curr = head;
    while(y>1){
        curr = curr.next;
        y--;
    }
    ListNode t1 = curr.next;
    ListNode t2 = t1.next;
    curr.next = t2;
    return head;
}
public static void main(String[] args) {
    ListNode head = null,tail=null;
        int[] a = {1,2,3,4,5};
        for (int val : a) {
            ListNode newnode = new ListNode(val);
            if (head == null) {
                head = newnode;
                tail = newnode;
            } else {
                tail.next = newnode;
                tail = newnode;
            }
        }
        print(head);
        System.out.println();
        head = removeK(head, 2);
        print(head);

}
}
