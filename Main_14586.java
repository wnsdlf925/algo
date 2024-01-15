import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_14586 {

    static long[][] arr;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());

        arr = new long[N][2];
        long[] left = new long[N];
        long[] right = new long[N];
        long[] answer = new long[N];


        for(int i=0; i<N; i++){
            token = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(token.nextToken());
            arr[i][1] = Integer.parseInt(token.nextToken());
        }
        Arrays.sort(arr, Comparator.comparingInt(a -> Math.toIntExact(a[0])));



//        for(int i=0; i<N; i++){
//            int min = arr[i][0]-arr[i][1];
//            int minIndex = i;
//            for(int j=i-1; j>=0; j--){
//                    if(arr[j][0]>=min){
//                        minIndex = j;
//
//                    }
//            }
//            left[i]=minIndex;
//
//            int z = N-(i+1);
//            int max = arr[z][0]+arr[z][1];
//            int maxIndex = z;
//            for(int j=z+1; j<N; j++){
//                if(arr[j][0]<=max){
//                    maxIndex = j;
//
//                }
//            }
//            right[z]=maxIndex;
//        }

        for(int i=0; i<N; i++){
            left[i] = findLeft(i);
            right[N-(i+1)] = findRight(N-(i+1));
        }

        Arrays.fill(answer, Integer.MAX_VALUE);
        answer[0] = 1;

        for(int i=0; i<N; i++){

            if(left[i]==0){
                answer[i] = Math.min(answer[i],1);
            }else{
                answer[i] = Math.min(answer[i], answer[(int) (left[i]-1)]+1);
            }

            for(int j=0; j<i; j++){
                if(right[j]>=i){
                    if(j==0){
                        answer[i] = Math.min(answer[i],1);
                    }else{
                        answer[i] = Math.min(answer[i],answer[j-1]+1);
                    }
                }
            }

        }


        System.out.println("answer: "+ Arrays.toString(answer));
        System.out.println("left: "+ Arrays.toString(left));
        System.out.println("right: "+ Arrays.toString(right));

    }

    static int findLeft(int index){

        if(index==0){
            return 0;
        }else {
            long min = arr[index][0]-arr[index][1];
            if(min<=0){
                return 0;
            }else {
                int minIndex = index;
                for(int i=index-1; i>=0; i--){
                    if(arr[i][0]>=min){
                        minIndex = i;
                        if(arr[i][0]-arr[i][1]<min){
                            min = arr[i][0]-arr[i][1];
                        }
                    }
                }
                return minIndex;
            }
        }

    }
    static int findRight(int index){

        if(index==N-1){
            return index;
        }else {
            long max = arr[index][0]+arr[index][1];
            if(max>=arr[N-1][0]){
                return N-1;
            }else {
                int minIndex = index;
                for(int i=index; i<N; i++){
                    if(arr[i][0]<=max){
                        minIndex = i;
                        if(arr[i][0]+arr[i][1]>max){
                            max = arr[i][0]+arr[i][1];
                        }
                    }
                }
                return minIndex;
            }
        }

    }
}

/*
7
1 1
3 2
6 3
10 100
15 1
20 1
30 1

7
1 1
14 1
12 2
3 2
6 2
8 2
13 2


7
1 100
3 2
6 3
10 50
50 1
60 10
70 1

5
1 2
3 1
6 2
7 1
9 2
 */
