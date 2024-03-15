import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_2170 {
    static class Node implements Comparable<Node>{
        int start;
        int end;

        public Node(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Node o) {
            return this.start - o.start;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        PriorityQueue<Node> queue = new PriorityQueue<>();

        int N = Integer.parseInt(token.nextToken());
        int answer = 0;
        int start = Integer.MIN_VALUE;
        int end = Integer.MIN_VALUE;

        for(int i=0; i<N; i++){

            token = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());

            queue.add(new Node(a,b));

        }



        while (!queue.isEmpty()){
            Node nowNode = queue.poll();

            if(nowNode.start>end){
                answer += end-start;
                end = nowNode.end;
                start = nowNode.start;
            }else if(nowNode.end>end && nowNode.start<=end){
                end = nowNode.end;
            }

        }
        answer += end-start;
        System.out.println(answer);


    }
}
