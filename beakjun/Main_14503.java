import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14503 {

    static class Robot{
        int i;
        int j;
        int direction;

        public Robot(int i, int j, int direction){
            this.i = i;
            this.j = j;
            this.direction = direction;
        }

        void turning(){
            direction--;
            if(direction<0){
                direction = 3;
            }
        }

    }

    static int[] dx = {0,1,0,-1};
    static int[] dy = {-1,0,1,0};
    static int n;
    static int m;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());
        arr = new int[n][m];

        token = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(token.nextToken());
        int c = Integer.parseInt(token.nextToken());
        int d = Integer.parseInt(token.nextToken());

        int answer = 0;

        Robot robot = new Robot(r,c,d);

        for(int i=0; i<n; i++){
            token = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        while (true){

            if(arr[robot.i][robot.j]==0){
                arr[robot.i][robot.j] = 2;
                answer++;
            }

            if(cleanBlank(robot.i,robot.j)){
                robot.turning();
                forword(robot);
            }else{
                if(!checkBack(robot)){
                    break;
                }
            }
        }
        System.out.println(answer);
    }

    static boolean cleanBlank(int i, int j){

        for(int z=0; z<4; z++){
            int nx = dx[z]+j;
            int ny = dy[z]+i;
            if(nx<0||nx>=m||ny<0||ny>=n){
                return false;
            }else{
                if(arr[ny][nx]==0){
                    return true;
                }
            }
        }
        return false;
    }

    static boolean checkForword(int i, int j ,int d){


            int nx = dx[d]+j;
            int ny = dy[d]+i;

            if(nx<0||nx>=m||ny<0||ny>=n){
                return false;
            }
            if(arr[ny][nx]==0){
                return true;
            }else {
                return false;
            }
    }

    static boolean checkBack(Robot robot){

        int nowD = 0;
        switch (robot.direction){
            case 0:
                nowD = 2;
                break;
            case 1:
                nowD = 3;
                break;
            case 2:
                nowD = 0;
                break;
            case 3:
                nowD = 1;
                break;
        }

        int nx = dx[nowD]+robot.j;
        int ny = dy[nowD]+robot.i;

        if(nx<0||nx>=m||ny<0||ny>=n){
            return false;
        }
        if(arr[ny][nx]!=1){
            robot.i = ny;
            robot.j = nx;
            return true;
        }else {
            return false;
        }
    }

    static void forword(Robot robot){
        switch (robot.direction){
            case 0:
                if(checkForword(robot.i, robot.j, 0)){
                   robot.i--;
                }
                break;
            case 1:
                if(checkForword(robot.i, robot.j, 1)){
                    robot.j++;
                }
                break;
            case 2:
                if(checkForword(robot.i, robot.j, 2)){
                    robot.i++;
                }
                break;
            case 3:
                if(checkForword(robot.i, robot.j, 3)){
                    robot.j--;
                }
                break;
        }
    }
}
