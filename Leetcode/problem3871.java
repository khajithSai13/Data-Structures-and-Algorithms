package Leetcode;
class problem3871{
    public static int commas(int n){
        if(n <= 999) return 0;
        int dig = 0,temp =n;
        while(temp > 0){
            temp /=10;
            dig++;
        }
        System.out.println(dig);
        return 0;
    }
    public static void main(String[] args) {
        int n = 1004590;
        System.out.println(commas(n));
    }
}