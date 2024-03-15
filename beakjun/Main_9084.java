import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9084 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(token.nextToken());

        for(int testCase=0; testCase<T; testCase++){
            token = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(token.nextToken());
            int[] coin = new int[n+1];

            token = new StringTokenizer(br.readLine());
            for(int i=1; i<=n; i++){
                coin[i] = Integer.parseInt(token.nextToken());
            }

            token = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(token.nextToken());
            int[][] answer = new int[n+1][m+1];

            for(int i=1; i<=n; i++){
                for(int j=0; j<=m; j++){
                    if(j==0){
                        answer[i][j] = 1;
                    }else{
                        if(j<coin[i]){
                            answer[i][j] = answer[i-1][j];
                        }else{
                            answer[i][j] = answer[i][j-coin[i]]+answer[i-1][j];
                        }
                    }
                }
            }
            System.out.println(answer[n][m]);
        }
    }
}
