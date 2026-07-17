public class Code360 {
    public static void rec(int n){
        if(n==0){
            return;
        }
        rec(n-1);//recursion stack example
        System.out.print(n+" ");
        
    }
   
    public static void main(String[] args) {
        int n = 5;
        rec(n);
    }
}
