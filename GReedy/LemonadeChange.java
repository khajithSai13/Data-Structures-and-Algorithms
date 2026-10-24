import java.util.*;
public class LemonadeChange {
    public static boolean change(int[] money){
        int n = money.length;
        int[] bills = {0,0,0};
        int change = 0;
        for(int i=0;i<n;i++){
            bills[money[i]/10]++;
            change = money[i]-5;
            int temp = 0;
            for(int j=0;j<2;j++){
                int tem = 0;
                if(j==0) {
                    tem =5;
                }else if(j==1){
                    temp = 10;
                }else{tem = 20;}

                temp += tem*bills[j];
            }
            System.out.println(change+" "+temp);
            if(temp < change) return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        int[] money = {5,5,5,10,20};
        System.out.println(change(money));
    }
}
