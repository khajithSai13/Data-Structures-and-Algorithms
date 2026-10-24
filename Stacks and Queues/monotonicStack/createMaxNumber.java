package monotonicStack;

import java.util.Stack;

public class createMaxNumber {
    public static int[] maxNumber(int[] a,int b[],int k){
        int n1 = a.length;
        int n2 = b.length;
        Stack<Integer> stack = new Stack<>();
        int i=n1-1,j=n2-1;
        if( i>=0 && j>=0 &&  a[i] < b[j]){
            stack.push(a[i]);
            i--;
        }else if(j>=0 && i>=0 && b[j]<a[i]){
                stack.push(b[j]);
                j--;
        }
        while(i >=0 || j>=0){
            while(!stack.isEmpty() && i>= 0 && a[i] < stack.peek()){
                i--;
            }
            while(!stack.isEmpty() && j>=0 && b[j] < stack.peek()){
                j--;
            }
            if(i>=0 && j>=0){
                if(!stack.isEmpty() && a[i] < b[j]){
                    stack.push(a[i--]);
                }else{
                    if(!stack.isEmpty())
                        stack.push(b[j--]);
                }
            }else if(i>=0){
                if(!stack.isEmpty() && a[i] > stack.peek()){
                    stack.push(a[i]);
                }
                i--;
            }else if(j>=0){
                if(!stack.isEmpty() && b[j] > stack.peek() ){
                    stack.push(b[j]);
                }
                j--;
            }
        }
        int [] sol = new int[k];
        for(int h = 0;h<k;h++){
            if(!stack.isEmpty())
            sol[h] = stack.pop();
        }
        return sol;
    }
    public static void main(String[] args) {
        int[] a = {9,1,2};
        int[] b= {9,8,3};
        for(int val : maxNumber(a, b,5)){
            System.out.print(val +" ");
        }
    }
}
