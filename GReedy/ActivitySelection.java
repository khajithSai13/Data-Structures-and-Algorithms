import java.util.*;
class ActivitySelection{
    static class Activity{
        int start;
        int end;
        public Activity(int s,int e){
            this.start = s;
            this.end = e;
        }
    }
    public static int MaxNonOverlapping(int[] start,int[] end){
        int n = start.length;
        Activity[] activities = new Activity[n];
        for(int i=0;i<n;i++){
            activities[i] = new Activity(start[i],end[i]);
        }
        int count = 0;
        Arrays.sort(activities,(a1,a2) -> a1.end-a2.end);
        for(Activity a : activities){
            System.out.println(a.start+" "+a.end);
        }
        int e = 0;
        for(int i=0;i<activities.length;i++){
            if(activities[i].start >=e){
                count++;
                e = activities[i].end;
            }
        }
        return count;
    }
    public static void main(String[] args) {

        int []start = {1,3,0,5,8,5}; 
        int[] end = {2,4,6,7,9,9};
        System.out.println(MaxNonOverlapping(start,end));   
    }

}