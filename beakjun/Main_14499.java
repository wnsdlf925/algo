import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14499 {

    static int N;
    static int M;
    static int x;
    static int y;
    static int[][] map;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static int[] dice = new int[6];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        x = Integer.parseInt(token.nextToken());
        y = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());

        map = new int[N][M];

        for(int i=0; i<N; i++){
            token = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(token.nextToken());
            }
        }

       Arrays.fill(dice, 0);


        token = new StringTokenizer(br.readLine());


        for(int count=0; count<K; count++){
            int direc = Integer.parseInt(token.nextToken());
            if(canMove(direc)){
                moveDice(direc);
                System.out.println(dice[5]);
            }
        }
    }

    static void moveDice(int direc){


        int temp = dice[0];

        switch (direc){
            case 1:
                dice[0] = dice[3];
                dice[3] = dice[5];
                dice[5] = dice[2];
                dice[2] = temp;
                break;
            case 2:
                dice[0] = dice[2];
                dice[2] = dice[5];
                dice[5] = dice[3];
                dice[3] = temp;
                break;
            case 3:
                dice[0] = dice[1];
                dice[1] = dice[5];
                dice[5] = dice[4];
                dice[4] = temp;
                break;
            case 4:
                dice[0] = dice[4];
                dice[4] = dice[5];
                dice[5] = dice[1];
                dice[1] = temp;
                break;
        }

        if(map[x][y]==0){
            map[x][y] = dice[0];
        }else{
            dice[0] = map[x][y];
            map[x][y] = 0;
        }


    }


    static boolean canMove(int direction){
        int nx = dx[direction-1]+x;
        int ny = dy[direction-1]+y;

        if(nx<0||nx>=N||ny<0||ny>=M){

            return false;
        }else {
            x = nx;
            y = ny;
            return true;
        }

    }
}
