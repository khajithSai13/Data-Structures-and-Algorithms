package ScreeningTest;

import java.util.HashMap;
import java.util.Map;

public class IMP {
    public static void main(String[] args) {
        int[] a ={1,2,2,1,2};
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int val : a){   
                map.put(val,map.getOrDefault(val,0)+1);
        }
        int m = -1;
       for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int k = entry.getValue();
            if(k>a.length/2){
                m = k;
            }
        }
        System.out.println(m);
    }
}
