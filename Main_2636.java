import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2636 {
    static class Node{
        int i;
        int j;

        public Node(int i, int j){
            this.i = i;
            this.j = j;
        }
    }

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int r;
    static int c;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        r = Integer.parseInt(token.nextToken());
        c = Integer.parseInt(token.nextToken());

        int allCheese = 0;
        int our = 0;
        int ourCheese = 0;
        arr = new int[r][c];
        boolean[][] visited = new boolean[r][c];
        Queue<Node> queue = new LinkedList<>();

        for(int i=0; i<r; i++){
            token = new StringTokenizer(br.readLine());
            for (int j=0; j<c; j++){
                arr[i][j] = Integer.parseInt(token.nextToken());
                if(arr[i][j]!=0){
                    allCheese++;
                }
            }
        }


        while (allCheese>0){
            our++;
            ourCheese = 0;
            queue.add(new Node(0,0));
            for(int i=0; i<r; i++){
                Arrays.fill(visited[i],false);
            }

            while (!queue.isEmpty()){
                Node node = queue.poll();
                for(int z=0; z<4; z++){
                    int ny = dy[z]+node.i;
                    int nx = dx[z]+node.j;

                    if(nx>=0&&nx<c&&ny>=0&&ny<r){
                        if(!visited[ny][nx]){
                            visited[ny][nx] = true;
                            if(arr[ny][nx]==0){
                                queue.add(new Node(ny,nx));
                            }else{
                                arr[ny][nx] = 0;
                                allCheese--;
                                ourCheese++;
                            }
                        }
                    }
                }
            }

        }

        System.out.println(our);
        System.out.println(ourCheese);

    }
}
