package Dynamic_Programming;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
    // public static int triangleSolve(List<List<Integer>> triangle){ Greedy
    //     int minSum = 0;
    //     int currSum = 0;
    //     int lastIdx = 0;
    //     for(List<Integer> list : triangle){
    //         currSum += minSum;
    //         currSum += list.get(lastIdx);
    //         if(lastIdx +1 < list.size() && minSum+list.get(lastIdx+1) < currSum){
    //             currSum = minSum+list.get(lastIdx+1);
    //             lastIdx = lastIdx+1;
    //         }
    //         minSum = currSum;
    //         currSum =0;
    //     }
    //     return minSum;
    // }
    public static int solveTriangle(List<List<Integer>> triangle, int i, int j){ //good recursion approach fror dp evrythign perfect but goes TLE
        if(i >= triangle.size() ){
            return 0;
        }
        return triangle.get(i).get(j)+Math.min(solveTriangle(triangle, i+1, j),solveTriangle(triangle, i+1, j+1));
    }
    public static int minimumDistance(List<List<Integer>> triangle, int i, int j,Integer[][] memo){
        if(i>=triangle.size()){
            return 0;
        }
        if(memo[i][j] != null){
            return memo[i][j];
        }
        memo[i][j] = triangle.get(i).get(j)+Math.min(minimumDistance(triangle, i+1, j, memo),minimumDistance(triangle, i+1, j+1, memo));
        return memo[i][j];
    }
    public static void main(String[] args) {
        int[][] a = {{2},{3,4},{6,5,7},{4,1,8,3}};
        List<List<Integer>> triangle = new ArrayList<>();
        int x = 0;
        for(int i=0;i<a.length;i++) triangle.add(new ArrayList<>());
        for(List<Integer> list : triangle){
            for(int i=0;i<a[x].length;i++){
                list.add(a[x][i]);
            }
            x++;
        }
        System.out.println(minimumDistance(triangle,0,0,new Integer[triangle.size()][triangle.size()]));
    }
}
