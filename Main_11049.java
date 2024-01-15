import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11049 {

    static class Matrix{
        int a;
        int b;

        public Matrix(int a, int b){
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(token.nextToken());
        Matrix[] arr = new Matrix[N];
        int[][] dp = new int[N][N];

        for(int i=0;i<N;i++){
            token = new StringTokenizer(br.readLine());
            arr[i] = new Matrix(Integer.parseInt(token.nextToken()),Integer.parseInt(token.nextToken()));
        }

        for(int k=1; k<N; k++){
            for(int i=0; i<N-k; i++){
                dp[i][i+k] = Integer.MAX_VALUE;

                for(int j=0; j<k; j++){

                    dp[i][i+k]=Math.min(dp[i][i+k],dp[i][i+j]+dp[i+j+1][i+k]+arr[i].a*arr[i+j].b*arr[i+k].b);
                }

            }
        }

        System.out.println(dp[0][N-1]);
    }

}

