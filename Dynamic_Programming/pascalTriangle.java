package Dynamic_Programming;

import java.util.ArrayList;
import java.util.List;

public class pascalTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        list.get(0).add(1);
        if(numRows == 1) return list;
        list.add(new ArrayList<>());
        list.get(1).add(1);
        list.get(1).add(1);
        for(int i=2;i<numRows;i++){
            list.add(new ArrayList<>());
            for(int j=0;j<=i;j++){
                if(j==0 || j== i){
                    list.get(i).add(1);
                }else{
                    int curr = list.get(i-1).get(j-1)+ list.get(i-1).get(j);
                    list.get(i).add(curr);
                }
            }
        }
        return list;
    }
    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}
