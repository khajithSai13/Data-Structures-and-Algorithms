package Dynamic_Programming;

public class IntegerReplacement {
    public static int minReplaces(int n){
        if( n == 1) return 0;
        if( n %2 == 0){
            return 1+minReplaces(n/2);
        }else{
            if(n == Integer.MAX_VALUE){
                long v = (long)n+1;
                v = v/2;
                int n1 = (int) v;
                n = (n-1)/2;
                return 2+Math.min(minReplaces(n1),minReplaces(n));
            }
            return 1+Math.min(minReplaces(n+1),minReplaces(n-1));
        }
    }
    public static void main(String[] args) {
        int n = 2147483647;
        System.out.println(minReplaces(n));
    }
}
