import java.util.Arrays;

public class AssignCookies {
    public static int assign(int[] g,int[] s){
        int n = g.length;
        int m = s.length;
        Arrays.sort(g);
        Arrays.sort(s);
        if(m==0) return 0;
        int satisfied = 0;
        int x = m-1;
        for(int i=n-1;i>=0;i--){
            if(x<0) break;
            if(s[x] >= g[i]){
                satisfied++;
                x--;
            }
        }
        return satisfied;
    }
    public static void main(String[] args) {
        int[] g = {5, 6, 7, 8};
        int[] s = {1, 2, 3, 4, 5, 6};
        System.out.println(assign(g, s));
    }
}
