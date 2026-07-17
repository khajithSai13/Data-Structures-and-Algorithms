package Queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Medium {
    public static void firstNegative(int[ ]a,int k){//using deque
        if(k>a.length) return;
        if(k==0) return;
        int n = a.length;
        Deque<Integer> dq = new LinkedList<>();
        int[] result = new int[n-k+1];
        int idx = 0;
        for(int i=0;i<a.length;i++){
            while(!dq.isEmpty() && dq.peekFirst() == i-k){//emptying
                dq.pollFirst();
            }
            while(!dq.isEmpty() && a[dq.peekFirst()] > a[i] && a[dq.peekFirst()] >0){
                dq.pollFirst();//removiing unnecessary elements
            }
            dq.addLast(i);
            if(k-dq.peekFirst()>0){
                result[idx++] = a[dq.peekFirst()];
            }
        }
        for(int val : result) System.out.println(val);
    }
    public static void firstNdegative(int[] a,int k){
        Queue<Integer> que = new LinkedList<>();
        int n = a.length;
        int [] result = new int[n-k+1];
        int idx = 0;
        for(int i=0;i<a.length;i++){
            while(!que.isEmpty() && que.peek()== i-k){
                que.poll();
            }
            if(a[i]<0) que.add(i);
            if(i>=k-1){
                result[idx++] = (que.isEmpty())?0:a[que.peek()];
            }
        }
        for(int val : result) System.out.println(val);
    }
    public static void main(String[] args) {
        int[] a = {12, -1, -7, 8, -15, 30, 16, 28};
        firstNdegative(a, 3);

    }
}
