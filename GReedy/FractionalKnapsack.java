import java.util.Arrays;

public class FractionalKnapsack {
    public static void main(String[] args) {
        double [] wts = {5,8,10};
        double [] val = {30,40,45};
        double M = 15;
        System.out.println(max(wts,val,M));
    }
    public static double max(double[] wts,double [] values,double MaxWeight){
        if(wts.length != values.length)return 0;
        if(MaxWeight <=0)return 0;
        int n = values.length;
        Integer[] idx = new Integer[n];
        for(int i=0;i<n;i++){
            idx[i] = i;
        }
        Arrays.sort(idx,(a,b) -> Double.compare((values[b]/wts[b]),(values[a]/wts[a])));
        double temp = MaxWeight;
        double profit = 0;
        for(int i=0;i<n;i++){
            if(temp>0){
                double wt = wts[idx[i]];
                double val = values[idx[i]];
                if(wt<=temp){
                    profit += val;
                    temp -= wt;
                } else if(wt > temp){
                    double frac = temp*(val/wt);
                    profit += frac;
                    temp = 0;
                }
            }
        }
        return profit;
    }
}
