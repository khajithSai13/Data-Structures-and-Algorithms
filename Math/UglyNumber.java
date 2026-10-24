package Math;
class UglyNumber{
    public static boolean ugly(int n){
        if(n ==1) return true;
        if(n<1) return false;
        if(n >= Integer.MAX_VALUE) return false;
        int nums[] = {2,3,5};
        for(int i : nums){
            while(n % i==0){
                n /= i;
            }
        }
        return !isPrime(n);
    }
    public static boolean isPrime(int n){
        if(n < 2) return false;
        for(int i=2;i*i <= n;i++){
            if(n%i ==0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int n =99;
        System.out.println(ugly(1073741824));
    }
}