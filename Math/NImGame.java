package Math;

public class NImGame {
    //main logic is game theroy and whenever the number is the multiple of 4 its false except its true other wise
    public static boolean nimgame(int n){
        return n%4 !=0;
    }
    public static void main(String[] args) {
        int n = 99;
        System.out.println(nimgame(n));
    }
}
