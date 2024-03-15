import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_18808 {

    static int[][] noteBook;
    static  int N;
    static  int M;
    static  int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());

        noteBook = new int[N][M];



        for(int round=0; round<K; round++){
            token = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(token.nextToken());
            int c = Integer.parseInt(token.nextToken());

            int[][] temp = new int[r][c];

            for(int i=0; i<r; i++){
                token = new StringTokenizer(br.readLine());
                for(int j=0; j<c; j++){
                    temp[i][j] = Integer.parseInt(token.nextToken());
                }
            }


            boolean attach = false;

            for(int spin=0; spin<4; spin++){
                if(!attach){
                    attachSticker:
                    for(int i=0; i<N; i++){
                        for(int j=0; j<M; j++){
                            if(checkPossible(i,j,r,c)){
                                if(checkSticker(i,j,r,c,temp)){
                                    attach(i,j,r,c,temp);
                                    attach = true;
                                    break attachSticker;
                                }
                            }
                        }
                    }
                    if(!attach){
                        temp = rotate(temp);
                        r = temp.length;
                        c = temp[0].length;

                    }
                }else{
                    break;
                }
            }
        }

        System.out.println(answer);
    }

    static boolean checkSticker(int i, int j, int r, int c,int[][] arr){

        for(int x=0; x<r; x++){
            for (int y=0; y<c; y++){
                if(noteBook[i+x][j+y]==1 && arr[x][y]==1){
                    return false;
                }
            }
        }
        return true;

    }

    static boolean checkPossible(int i, int j, int r, int c){

        if(i+r-1<N && j+c-1<M){
            return true;
        }else{
            return false;
        }
    }

    static void attach(int i, int j, int r, int c, int[][] arr){

        for(int x=0; x<r; x++){
            for (int y=0; y<c; y++){
                if(arr[x][y]==1){
                    noteBook[i+x][j+y] = 1;
                    answer++;
                }
            }
        }
    }


    static int[][] rotate(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;
        int[][] rotate = new int[m][n];

        for(int i=0; i<rotate.length; i++){
            for (int j=0; j<rotate[0].length; j++){
                rotate[i][j] = arr[n-1-j][i];
            }
        }

        return rotate;
    }

}
