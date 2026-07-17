import java.util.Arrays;

public class AssignCookies {
    public static int assign(int[] g,int[] s){
        if(s.length==0) return 0;
        int satisfied = 0;
        int i=0,j=0;
        Arrays.sort(g);
        Arrays.sort(s);
        while(i<g.length && j<s.length){
            int l = g[i];
            int r = s[j];
            if(l<=r){
                satisfied++;
            }
            i++;j++;
        }
        return satisfied;
    }
    public static void main(String[] args) {
        int[] g = {5,6,7};
        int[] s = {1,2,3};
        System.out.println(assign(g, s));
    }
}
