import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2879 {

    static boolean[] check;
    static int[] now;
    static int[] target;
    static int[] decision;
    static int N;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        now = new int[N];
        target = new int[N];
        decision = new int[N];
        check = new boolean[N];
        answer = 0;

        token = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            now[i] = Integer.parseInt(token.nextToken());
        }

        token = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            target[i] = Integer.parseInt(token.nextToken());
            decision[i] = now[i]-target[i];
            if(decision[i]==0){
                check[i] = true;
            }
        }

        for(int i=0; i<N; i++){
            if(!check[i]){
                count(i,decisionCheck(i));
                answer++;
                i--;
                System.out.println(Arrays.toString(now));

//                System.out.println(Arrays.toString(check));
            }
        }

        System.out.println(answer);

    }
    static void count(int i, int decision){

        if(decisionCheck(i)==decision){
            setNow(i,decision);
            check[i] = checkNowAndTarget(i);
            i++;
            if(i<N){
                count(i,decision);
            }
        }

    }

    static int decisionCheck(int i){
        if(now[i]-target[i]>0){
            return -1;
        } else if (now[i]-target[i]<0) {
            return 1;
        }else{
            return 0;
        }
    }

    static boolean checkNowAndTarget(int i){
        if(now[i]==target[i]){
            return true;
        }else{
            return false;
        }
    }
    static void setNow(int i , int decision){
        if(decision>0){
            now[i]++;
        }else if(decision<0){
            now[i]--;
        }
    }
}

/*
8
5 5 5 5 5 3 4 5
1 5 0 1 5 6 7 8

4
1 2 3 4
1 1 1 0

5
5 3 2 3 5
1 1 0 1 1

5
1 1 1 1 1
5 3 2 3 5
 */