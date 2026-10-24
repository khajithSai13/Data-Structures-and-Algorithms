package graphs;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

class NumberOfProvinces{
    public static void bfs(int idx,List<List<Integer>> graph){
        Queue<Integer> que = new LinkedList<>();
        boolean[] visited = new boolean[graph.size()];
        que.add(idx);
        while(!que.isEmpty()){
            int curr = que.poll();
            System.out.print(curr+ " ");
            visited[curr] = true;
            for(int val : graph.get(curr)){
                if(!visited[val]){
                    visited[val] = true;
                    que.add(val);
                }
            }
        }
    }
    public static void dfs(List<List<Integer>> graph, boolean[] visited,int curr){
        System.out.print(curr+" ");
        visited[curr] = true;
        for(int val: graph.get(curr)){
            if(!visited[val]){
                dfs(graph, visited, val);
            }
        }
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<List<Integer>> graph = new ArrayList<>();
        for(int i =0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        int startidx = sc.nextInt();
        sc.close();
        bfs(startidx,graph);
        System.out.println();
        dfs(graph,new boolean[n],startidx);
    }
}