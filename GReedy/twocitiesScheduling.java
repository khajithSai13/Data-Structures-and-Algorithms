import java.util.Arrays;

public class twocitiesScheduling {
    public static int schedule(int[][] cost){
        int min = 0;
        int n = cost.length;
        //if(n == 1) return Math.min(cost[0][0],cost[0][1]);
        Integer[] idx = new Integer[n];
        for(int i=0;i<n;i++) idx[i] = i;
        Arrays.sort(idx,(a,b) -> Math.abs(cost[b][0]-cost[b][1])-Math.abs(cost[a][0]-cost[a][1]));
        int a = 0,b=0;
        int choice = 0;
        for(int i=0;i<n;i++){
            System.out.println(cost[idx[i]][0]+" "+cost[idx[i]][1]+" "+a+" "+b);
            if(a == n/2){
                choice = cost[idx[i]][1];
                min+=cost[idx[i]][1];
            }else if(b == n/2){
                choice = cost[idx[i]][0];
                min += cost[idx[i]][0];
            }else{
                if(cost[idx[i]][0] > cost[idx[i]][1]){
                    b++;
                    choice = cost[idx[i]][1];
                    min += cost[idx[i]][1];
                }else{
                    a++;
                    choice = cost[idx[i]][0];
                    min += cost[idx[i]][0];
                }
            }
            System.out.println(choice);
        }
        return min;
    }
    public static void main(String[] args) {
        int[][] cost =
        {{1, 100},
    {2, 99},
    {3, 98},
    {100, 4},
    {99, 5},
    {98, 6}};
        System.out.println(schedule(cost));
        
    }
}
