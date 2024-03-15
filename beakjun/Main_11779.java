import java.io.*;
import java.util.*;

public class Main_11779 {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> cost = new ArrayList<>();
    static int[] dist;
    static int[] route;
    static boolean[] visited;

    static class Node implements Comparable<Node>{
        int index;
        int cost;

        public Node(int index, int cost){
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> routePath = new ArrayList<>();
        int minDist = 0;
        int nodeNum = 1;

        int N = Integer.parseInt(token.nextToken());
        dist = new int[N];
        route = new int[N];
        visited = new boolean[N];

        token = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(token.nextToken());

        for(int i=0; i<N; i++){
            graph.add(new ArrayList<>());
            cost.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++){
            token = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(token.nextToken())-1;
            int b = Integer.parseInt(token.nextToken())-1;
            int c = Integer.parseInt(token.nextToken());

            graph.get(a).add(b);
            cost.get(a).add(c);

        }

        token = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(token.nextToken())-1;
        int end = Integer.parseInt(token.nextToken())-1;

        route[start] = -1;
        minDist = dij(start,end);
        System.out.println(minDist);

        int find = end;

        while (route[find]!=-1){
            routePath.add(find+1);
            find = route[find];
            nodeNum++;
        }

        routePath.add(start+1);

        System.out.println(nodeNum);
        for(int i=routePath.size()-1; i>=0; i--){
            bw.write(routePath.get(i)+" ");
        }

        bw.flush();
    }


    static int dij(int start, int end){

        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start] = 0;


        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start,0));

        while (!queue.isEmpty()){
            Node node = queue.poll();

            if(!visited[node.index]){
                visited[node.index] = true;

                for(int i=0; i<graph.get(node.index).size(); i++){
                    if(dist[graph.get(node.index).get(i)] > dist[node.index]+cost.get(node.index).get(i)){
                        dist[graph.get(node.index).get(i)] = dist[node.index]+cost.get(node.index).get(i);
                        queue.add(new Node(graph.get(node.index).get(i),dist[graph.get(node.index).get(i)]));
                        route[graph.get(node.index).get(i)] = node.index;
                    }
                }
            }
        }

        return dist[end];
    }

}
