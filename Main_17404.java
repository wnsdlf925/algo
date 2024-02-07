import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_17404 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(token.nextToken());
        int[][] arr = new int[n][3];
        int[][] answer = new int[n][3];
        int min = Integer.MAX_VALUE;



        for(int i=0; i<n; i++){
            token = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                arr[i][j] = Integer.parseInt(token.nextToken());
            }
        }

            for(int z=0; z<3; z++){
                for(int i=0; i<n; i++){
                    Arrays.fill(answer[i], Integer.MAX_VALUE);
                }
                for(int i=1; i<n; i++){
                    for(int j=0; j<3; j++){


                            if(i==1){
                                if(z==0){
                                    answer[1][1] = arr[0][0]+arr[1][1];
                                    answer[1][2] = arr[0][0]+arr[1][2];
                                }else if(z==1){
                                    answer[1][0] = arr[0][1]+arr[1][0];
                                    answer[1][2] = arr[0][1]+arr[1][2];
                                }else{
                                    answer[1][0] = arr[0][2]+arr[1][0];
                                    answer[1][1] = arr[0][2]+arr[1][1];
                                }

                            }else{
                                if(j==0){
                                    answer[i][j] = Math.min(answer[i-1][1],answer[i-1][2]);
                                }else if(j==1){
                                    answer[i][j] = Math.min(answer[i-1][0],answer[i-1][2]);
                                }else{
                                    answer[i][j] = Math.min(answer[i-1][0],answer[i-1][1]);
                                }
                                answer[i][j] += arr[i][j];
                            }



                    }
                }

                if(z==0){
                    min = (min>Math.min(answer[n-1][1],answer[n-1][2]))?Math.min(answer[n-1][1],answer[n-1][2]):min;
                }else if(z==1){
                    min = (min>Math.min(answer[n-1][0],answer[n-1][2]))?Math.min(answer[n-1][0],answer[n-1][2]):min;
                }else{
                    min = (min>Math.min(answer[n-1][0],answer[n-1][1]))?Math.min(answer[n-1][0],answer[n-1][1]):min;
                }
            }
            System.out.println(min);


    }
}

/*
3
10 50 50
15 15 15
10 50 50

2
1000 1000 1
1000 1000 1
 */