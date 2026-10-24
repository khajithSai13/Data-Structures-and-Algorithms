package graphs;
import java.util.*;
public class Base {
    public static void bfs(int start,List<List<Integer>> graph){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[graph.size()];
        q.add(start);
        visited[start] = true;
        while(!q.isEmpty()){
            int curr = q.poll();
            System.out.print(curr+" ");
            visited[curr] = true;
            for(int a : graph.get(curr)){
                if(!visited[a]){
                    visited[a] = true;
                    q.add(a);
                }
            }
        }
    }
    public static void dfs(int start,boolean[] visited,List<List<Integer>> list){
        visited[start] = true;
        System.out.print(start+ " ");
        for(int v : list.get(start)){
            if(!visited[v]){
                dfs(v, visited, list); 
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m= sc.nextInt();
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            list.get(u).add(v);
            list.get(v).add(u);
        }
        sc.close();
        bfs(0,list);
        boolean[] visited = new boolean[list.size()];
        dfs(0,visited,list);
    }
}
