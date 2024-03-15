import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_7570 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(token.nextToken());
        int[] arr = new int[N+1];
        int answer = 0;

        token = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            int a = Integer.parseInt(token.nextToken());
            arr[a] = arr[a-1]+1;
        }

        Arrays.sort(arr);

        System.out.println(N-arr[N]);
    }
}

/*
6
1 2 5 6 4 3

 */