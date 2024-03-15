import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1238 {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> cost = new ArrayList<>();
    static int[] village;
    static boolean[] visited;
    static class Node implements Comparable<Node> {
        int index;
        int cost;

        public Node(int index, int cost){
            this.index = index;
            this.cost = cost;
        }


        @Override
        public int compareTo(Node o) {
            return this.cost-o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        int X = Integer.parseInt(token.nextToken())-1;

        int answer = 0;
        village = new int[N];
        visited = new boolean[N];

        for(int i=0; i<N; i++){
            graph.add(new ArrayList<>());
            cost.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++){

            token = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(token.nextToken())-1;
            int b = Integer.parseInt(token.nextToken())-1;
            int v = Integer.parseInt(token.nextToken());

            graph.get(a).add(b);
            cost.get(a).add(v);
        }

        for(int i=0; i<N; i++){
            int time = 0;
            time += dij(i,X);
            time += dij(X,i);
            if(time>answer){
                answer = time;
            }
        }

        System.out.println(answer);

    }

    static int dij(int start, int end){

        Arrays.fill(village,Integer.MAX_VALUE);
        Arrays.fill(visited,false);
        village[start] = 0;


        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start,0));

        while (!queue.isEmpty()){
            Node nowNode = queue.poll();

            if(!visited[nowNode.index]){
                visited[nowNode.index] = true;

                for(int i=0; i<graph.get(nowNode.index).size(); i++){
                    if(village[graph.get(nowNode.index).get(i)]>village[nowNode.index]+cost.get(nowNode.index).get(i)){
                        village[graph.get(nowNode.index).get(i)] = village[nowNode.index]+cost.get(nowNode.index).get(i);
                        queue.add(new Node(graph.get(nowNode.index).get(i), village[graph.get(nowNode.index).get(i)]));

                    }
                }
            }

        }


        return village[end];
    }
}
