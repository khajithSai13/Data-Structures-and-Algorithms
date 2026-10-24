import java.util.Arrays;
//import java.util.HashMap;

public class TrainsAndPlatforms {
    // static class train{
    //     int a;
    //     int d;
    //     public train(int arr,int dep){
    //         a = arr;
    //         d = dep;
    //     }
    // }
    // public static int Platforms(int[] arr,int [] dep){
    //     HashMap<Integer,Integer> platform = new HashMap<>();
    //     int n = arr.length;
    //     train[] trains = new train[arr.length];
    //     for(int i=0;i<arr.length;i++){
    //         trains[i] = new train(arr[i], dep[i]);
    //     }
    //     Arrays.sort(trains,(a,b) -> a.d-b.d);
    //     int max_platforms = 1;
    //     int platformsrq = 1;
    //     int[] ar = new int[arr.length];
    //     int [] dp = new int[dep.length];
    //     for(int i =0;i<ar.length;i++){
    //         ar[i]=trains[i].a;
    //         dp[i]=trains[i].d;
    //     }
    //     int i=0,j=0;
    //     while(i<n){
    //         if(ar[i]>=dp[j]){
    //             platformsrq++;
    //             j++;
    //         }else{
    //             platformsrq--;
    //             i++;
    //         }
    //         max_platforms = Math.max(platformsrq,max_platforms);
    //     }
    //     return max_platforms;
    // }
    public static int Platforms(int[] arr,int[] dep){
        int n = arr.length;
        Arrays.sort(arr);
        Arrays.sort(dep);
        int max = 0;
        int req = 0;
        int i=0,j=0;
        while(i<n){
            if(arr[i]<=dep[j]){
                req++;
                i++;
            }else{
                req--;
                j++;
            }
            max = Math.max(max,req);
        }
        return max;

    }
    public static void main(String[] args) {
        int[] arr = {900,940,950,1100,1500,1800};
        int[] dep = {910,1200,1120,1130,1900,2000};
        System.out.println(Platforms(arr,dep));
    }
}
