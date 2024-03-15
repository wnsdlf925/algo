import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_2212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int answer = 0;
        int[] arr = new int[N];
        int[] gap = new int[N-1];


        token = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(token.nextToken());

        token = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(token.nextToken());
        }

        Arrays.sort(arr);

        for(int i=0; i<N-1; i++){
            gap[i] = arr[i+1]-arr[i];
        }

        System.out.println(Arrays.toString(gap));
        Arrays.sort(gap);

        for(int i=0; i<N-K; i++){
            answer+=gap[i];
        }

        System.out.println(answer);

    }
}
