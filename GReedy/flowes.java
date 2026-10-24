public class flowes {
    public static boolean place(int[] a,int k){
        int n = a.length;
        if(k == 0) return true;
        if(n == 1) return (a[0] != 1);
        if(n==2){
            if(k<2){
            return (a[0] != 1 && a[1] != 1);}else{
                return false;
            }
        }
        int spots = 0;
        for(int i=0;i<n;i++){
            if(i==0){
                if( a[i] != 1 && a[i+1] != 1){
                spots++;
                a[i] =1;
                }
            }else if(i==n-1){
                if(a[i] != 1 &&  a[i-1] != 1){
                spots++;
                a[i] = 1;
                }
            }else{
                if(a[i] != 1 && a[i-1] !=1  && a[i+1] != 1  ){
                    spots++;
                    a[i] = 1;
                }
            }
            if(spots >= k) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int[] bed = {0,1,0};
        System.out.println(place(bed,1));
    }
}
