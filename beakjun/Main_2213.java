import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_2213 {

    static int[] arr;
    static int[][] dp;
    static String[][] arrRoute;
    static PriorityQueue<Integer> queue;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        StringBuilder st = new StringBuilder();

        int N = Integer.parseInt(token.nextToken());
        arr = new int[N];
        dp = new int[N][2];
        arrRoute = new String[N][2];
        queue = new PriorityQueue<>();
        visited = new boolean[N];
        token = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(token.nextToken());
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<N; i++){
            Arrays.fill(arrRoute[i],"");
        }

        for(int i=0; i<N-1; i++){
            token = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(token.nextToken())-1;
            int b = Integer.parseInt(token.nextToken())-1;

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        dfs(0);
        Arrays.fill(visited, false);

        if(dp[0][0]>dp[0][1]){
            route(0, false);
            System.out.println(dp[0][0]);

        }else {
            route(0, true);
            System.out.println(dp[0][1]);
        }


        while (!queue.isEmpty()){
            st.append((queue.poll()+1)+" ");
        }

        System.out.println(st.toString());

    }

    static void route(int index, boolean include) {
        visited[index] = true;

        if(include){
            queue.add(index);
            for (int i = 0; i < graph.get(index).size(); i++) {
                if (!visited[graph.get(index).get(i)]) {
                    route(graph.get(index).get(i), false);
                }
            }
        }else{
            for (int i = 0; i < graph.get(index).size(); i++) {
                if (!visited[graph.get(index).get(i)]) {
                    if (dp[graph.get(index).get(i)][1] > dp[graph.get(index).get(i)][0]) {
                        route(graph.get(index).get(i), true);
                    }else{
                        route(graph.get(index).get(i), false);
                    }
                }
            }
        }



    }
    static void dfs(int index){
        visited[index] = true;


        dp[index][0] = 0;
        dp[index][1] = arr[index];

        for(int i=0; i<graph.get(index).size(); i++){
            if(!visited[graph.get(index).get(i)]){
                dfs(graph.get(index).get(i));

                if(dp[graph.get(index).get(i)][0]>dp[graph.get(index).get(i)][1]){
                    dp[index][0] += dp[graph.get(index).get(i)][0];
                }else {
                    dp[index][0] += dp[graph.get(index).get(i)][1];
                }
                dp[index][1] += dp[graph.get(index).get(i)][0];

            }
        }

    }
}

/*
8
10 50 30 40 20 60 60 30
1 2
1 3
1 4
2 5
2 6
4 7
4 8

8
10 10 10 10 10 10 10 10
1 2
2 3
2 5
3 4
3 8
5 6
5 7

7
10 30 40 400 20 20 70
1 2
2 3
4 3
4 5
6 2
6 7

7
1000 3000 4000 1000 2000 2000 7000
1 4
1 6
4 5
2 6
2 3
3 7
 */