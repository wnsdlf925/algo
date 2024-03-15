import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14890 {

    static int N;
    static int L;
    static int[][] arr;
    static boolean[][] makeRamp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        L = Integer.parseInt(token.nextToken());
        arr = new int[N][N];
        makeRamp = new boolean[N][N];

        int answer = 0;

        for(int i=0; i<N; i++){
            token = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        for(int i=0; i<N; i++){
            int height = arr[i][0];
            boolean check = true;
            for(int j=1; j<N; j++){
                if(height<arr[i][j]){
                    if(!checkUp(i,j-1,0,height)){
                        check = false;
                        break;
                    }
                }else if(height>arr[i][j]){
                    if(!checkDown(i,j,0,arr[i][j])){
                        check = false;
                        break;
                    }
                }
                height = arr[i][j];
            }
            if(check){
                answer++;
            }
        }

        for(int i=0; i<N; i++){
            Arrays.fill(makeRamp[i], false);
        }


        for(int j=0; j<N; j++){
            int height = arr[0][j];
            boolean check = true;
            for(int i=1; i<N; i++){
                if(height<arr[i][j]){
                    if(!checkUp(i-1,j,1,height)){
                        check = false;
                        break;
                    }
                }else if(height>arr[i][j]){
                    if(!checkDown(i,j,1,arr[i][j])){
                        check = false;
                        break;
                    }
                }
                height = arr[i][j];
            }
            if(check){
                answer++;
            }
        }

        System.out.println(answer);
    }

    static boolean checkUp(int i, int j, int z, int height){
        //가로 체크
        if(z==0){
            for(int x=0; x<L; x++){
                if(x==0){
                    if(Math.abs(arr[i][j]-arr[i][j+1])!=1){
                        return false;
                    }
                }else{
                    if(j-x>=0){
                        if(arr[i][j-x]!=height){
                            return false;
                        }
                    }else{
                        return false;
                    }
                }
                if(makeRamp[i][j-x]){
                    return false;
                }
            }
            for(int x=0; x<L; x++){
                makeRamp[i][j-x] = true;
            }
            return true;
        //세로 체크
        }else {
            for(int x=0; x<L; x++){
                if(x==0){
                    if(Math.abs(arr[i][j]-arr[i+1][j])!=1){
                        return false;
                    }
                }else{
                    if(i-x>=0){
                        if(arr[i-x][j]!=height){
                            return false;
                        }
                    }else{
                        return false;
                    }
                }
                if(makeRamp[i-x][j]){
                    return false;
                }
            }
            for(int x=0; x<L; x++){
                makeRamp[i-x][j] = true;
            }
            return true;
        }
    }

    static boolean checkDown(int i, int j, int z, int height){
        if(z==0){
            for(int x=0; x<L; x++){
                if(x==0){
                    if(Math.abs(arr[i][j]-arr[i][j-1])!=1){
                        return false;
                    }
                }else{
                    if(j+x<N){
                        if(arr[i][j+x]!=height){
                            return false;
                        }
                    }else{
                        return false;
                    }
                }
                if(makeRamp[i][j+x]){
                    return false;
                }
            }
            for(int x=0; x<L; x++){
                makeRamp[i][j+x] = true;
            }
            return true;
            //세로 체크
        }else {
            for(int x=0; x<L; x++){
                if(x==0){
                    if(Math.abs(arr[i][j]-arr[i-1][j])!=1){
                        return false;
                    }
                }else{
                    if(i+x<N){
                        if(arr[i+x][j]!=height){
                            return false;
                        }
                    }else{
                        return false;
                    }
                }
                if(makeRamp[i+x][j]){
                    return false;
                }
            }
            for(int x=0; x<L; x++){
                makeRamp[i+x][j] = true;
            }
            return true;
        }
    }



}

/*
6 3
2 3 1 1 2 3
3 2 2 1 2 3
3 2 2 2 3 3
3 3 3 3 3 3
3 3 3 3 2 2
3 3 3 3 2 2
 */
