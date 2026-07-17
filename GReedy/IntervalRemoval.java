import java.util.Arrays;

public class IntervalRemoval {
    static class interval{
        int st;
        int ed;
        public interval(int s,int e){
            this.st = s;
            this.ed = e;
        }
    }
    public static int minRemovals(int[] start, int[] end) {
    int n = start.length;
    Integer[] idx = new Integer[n];

    for (int i = 0; i < n; i++) {
        idx[i] = i;
    }

    Arrays.sort(idx, (a, b) -> Integer.compare(end[a], end[b]));

    int lastEnd = Integer.MIN_VALUE;
    int removals = 0;

    for (int i : idx) {
        if (start[i] < lastEnd) {
            removals++;
        } else {
            lastEnd = end[i];
        }
    }
    return removals;
}

    public static int remove(int[] star,int[] end){
        int n = star.length;
        interval[] a = new interval[n];
        for(int i=0;i<n;i++){
            a[i] = new interval(star[i], end[i]); 
        }
        Arrays.sort(a,(a1,a2) -> a1.ed-a2.ed);
        int min = 0;int last = 0;
        for(int i=0;i<n;i++){
            if(a[i].st<last){
                min++;
            }else{
                last = a[i].ed;
            }
        }
        return min;
    }
    public static void main(String[] args) {
        int[] st = {1,2,3,1};
        int[] end = {2,3,4,3};
        System.out.println(minRemovals(st,end));
    }
}
