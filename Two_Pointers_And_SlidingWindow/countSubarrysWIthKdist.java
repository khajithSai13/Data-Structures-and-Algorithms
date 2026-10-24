import java.util.*;
class coutnSubarraysWithKdist{
    public static long atmostKdistinct(int[] a,int k){
        int n = a.length;
        if(n == 0) return 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int l = 0;
        int count=0;
        for(int r=0;r<n;r++){
            int val = a[r];
            map.put(val,map.getOrDefault(val,0)+1);
            while(l<r && map.size() > k ){
                int v = a[l];
                if(map.containsKey(v)){
                    if(map.get(v) <=1){
                        map.remove(v);
                    }else{
                        map.put(v,map.get(v)-1);
                    }
                }
                l++;
            }
            if(map.size() <= k){
                count += r-l+1;
            }
        }
        return count;

    }
    public static long withKdstinct(int[] a,int k){
        return atmostKdistinct(a, k)-atmostKdistinct(a, k-1);
    }
    public static void main(String args[]){
        int[] a  = {1,2,1,2,3};
        System.out.println(withKdstinct(a, 2));
    }
}