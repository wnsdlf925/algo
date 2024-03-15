import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_2533 {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[][] dp;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(token.nextToken());
        int start = 0;
        visited = new boolean[N];
        dp = new int[N][2];

        for(int i=0; i<N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<N-1; i++){
            token = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(token.nextToken())-1;
            int b = Integer.parseInt(token.nextToken())-1;

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        dfs(0);
        System.out.println(Math.min(dp[0][0],dp[0][1]));

    }
    static void dfs(int node){

            visited[node] = true;
            boolean check = false;
            int childAdapt = 0;
            int childNoAdapt = 0;

            for(int i=0; i<graph.get(node).size(); i++){
                if(!visited[graph.get(node).get(i)]){
                    check = true;
                    dfs(graph.get(node).get(i));
                    childAdapt += dp[graph.get(node).get(i)][1];
                    childNoAdapt += Math.min(dp[graph.get(node).get(i)][0],dp[graph.get(node).get(i)][1]);
                }
            }
            if(!check){
                dp[node][1] = 1;
            }else{
                dp[node][0] = childAdapt;
                dp[node][1] = Math.min(childNoAdapt,childAdapt)+1;
            }
            return;

    }
}
/*
8
5 2
2 1
2 6
1 3
1 4
4 7
4 8
 */