import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_8980 {

    static class Node implements Comparable<Node> {
        int start;
        int end;
        int cost;

        public Node(int start, int end, int cost){
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            if(this.end == o.end){
                return this.start - o.start;
            }else{
                return this.end - o.end;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(token.nextToken());
        int truckSize = Integer.parseInt(token.nextToken());

        token = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(token.nextToken());

        int[] arr = new int[N];
        Node[] truck = new Node[M];
        int truckBox = 0;
        int answer = 0;

        for(int i=0; i<M; i++){
            token = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(token.nextToken())-1;
            int b = Integer.parseInt(token.nextToken())-1;
            int c = Integer.parseInt(token.nextToken());

            truck[i] = new Node(a,b,c);
        }



        Arrays.sort(truck);
        Arrays.fill(arr,truckSize);

        for(int i=0; i<M; i++){
            int sum = Integer.MAX_VALUE;
            boolean overCheck = false;

            for(int j=truck[i].start; j<truck[i].end; j++){
                sum = Math.min(sum, arr[j]);
            }

            if(sum-truck[i].cost<0){
                for(int j=truck[i].start; j<truck[i].end; j++){
                    arr[j] -= sum;
                }

            }else{
                for(int j=truck[i].start; j<truck[i].end; j++){
                    arr[j] -= truck[i].cost;
                }
                sum = truck[i].cost;
            }

            answer += sum;

        }



        System.out.println(answer);


    }
}
