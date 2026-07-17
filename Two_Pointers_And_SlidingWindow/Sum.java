import java.util.*;
class Sum{
    public static List<List<Integer>> sum4(int[] a){
        List<List<Integer>> result = new ArrayList<>();
        int n = a.length;
        int l1 =0,r1=n-1;
        while(l1<r1){
            int l2=l1+1,r2 = r1-1;
            while(l2<r2){
                int sum = a[l1]+a[l2]+a[r1]+a[r2];
                if(sum == 0){
                    result.add(Arrays.asList(a[l1],a[l2],a[r2],a[r1]));
                    l2++;r2--;
                }else if(sum<0){
                    l2++;
                }else{
                    r2--;
                }
            }
            l1++;r1--;
        }
        return result;
    }
    public static void main(String[] args) {
        int[] a = {1,0,-1,0,-2,2};
        List<List<Integer>> result = sum4(a);
        for(List<Integer> list:result){
            System.out.print(list+",");
        }
    }
}