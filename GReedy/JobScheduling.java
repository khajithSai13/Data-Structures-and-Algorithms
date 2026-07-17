import java.util.*;
public class JobScheduling {
    public static int maxddp(int[] id,int [] dead,int[]profits){
        int n = id.length;
        Integer[] idx = new Integer[n];
        for(int i=0;i<n;i++){
            idx[i] = i;
        }
        ///DOPED LOLLL
        int maxp = profits[idx[0]];
        int maxj = dead[idx[0]];
        int jbs = 1;
        int last = maxj;
        for(int i=1;i<n;i++){
            int d = dead[idx[i]];
            int p = profits[idx[i]];
            if(d<=last && jbs<maxj){
                jbs++;
                maxp+= p;
                last = d;
            }
        }
        System.out.println(maxj+" "+maxp);
        return 0;
    }
    
    public static void main(String[] args) {
        int [] id = {1,2,3,4};
        int deadLines[] = {2,2,2,2};
        int[] profits = {50,50,50,50};
        System.out.println(maxProfits(id,deadLines,profits));
    }
    public static int maxProfits(int[] id,int[] dead,int[] profits){
        int n= id.length;
        Integer [] idx = new Integer[n];
        for(int i=0;i<n;i++){
            idx[i]= i;
        }
        int max = Integer.MIN_VALUE;
        for(int val:dead){
            if(val>max){
                max = val;
            }
        }
        int[] slots = new int[max+1];
        Arrays.sort(idx, (a,b) ->{
            if(profits[a] != profits[b]){
                return profits[b] - profits[a];
            }
            return dead[b]-dead[a];
        });
        int maxj = 1;
        int profit = profits[idx[0]];
        slots[dead[idx[0]]] = id[idx[0]];
        for(int i=1;i<n;i++){
            int d = dead[idx[i]];
            int p = profits[idx[i]];
            int temp =d;
            while(temp>0){
                if(slots[temp] == 0){
                    slots[temp] = d;
                    profit += p;
                    maxj++;
                    break;
                }
                temp--;
            }
        }
        System.out.println(profit+" "+maxj);
        return 0;
    }
}
