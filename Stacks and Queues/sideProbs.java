public class sideProbs {
    public static int arrange(int n){
        double val = (double) n;
        if(n%2==0){
            return (int)Math.floor(Math.sqrt(val));
        }else{
            return (int) Math.round(Math.sqrt(val));
        }
    }
    public static void main(String[] args) {
        int[] a = new int[]{8,5,1,6,9,2};
        for(int val:a){
            System.out.println(arrange(val));
        }
    }   
}
