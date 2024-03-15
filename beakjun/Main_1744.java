import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(token.nextToken());
        int[] arr = new int[N];
        boolean[] check = new boolean[N];
        boolean zero = false;
        int zeroPoint = 0;
        int minerNum = 0;
        int answer = 0;

        for(int i=0; i<N; i++){
            token = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(token.nextToken());
            if(arr[i]<0){
                minerNum++;
            }else if(arr[i]==0){
                zero = true;
            }
        }
        Arrays.sort(arr);

        if(zero){


            for(int i=0; i<minerNum+1; i++){
                if(!check[i]){
                    if((minerNum+1)%2==1){
                        if(i!=minerNum){
                            answer += arr[i]*arr[i+1];
                            check[i+1] = true;
                        }
                    }else {
                        answer += arr[i]*arr[i+1];
                        check[i+1] = true;
                        if(i+1==minerNum){
                            break;
                        }
                    }
                    check[i] = true;
                }

            }

            for(int i=N-1; i>=minerNum+1; i--){
                if(i-1!=minerNum){
                    answer += Math.max(arr[i]*arr[i-1],arr[i]+arr[i-1]);
                    i--;
                }else{
                    answer += arr[i];
                    break;
                }
                check[i] = true;
            }

        }else{
            for(int i=0; i<minerNum; i++){
                if(i!=minerNum-1){
                    answer += arr[i]*arr[i+1];
                    i++;
                }else{
                    answer += arr[i];
                    break;
                }

            }

            for(int i=N-1; i>=minerNum; i--){
                if(i!=minerNum){
                    answer += Math.max(arr[i]*arr[i-1],arr[i]+arr[i-1]);
                    i--;
                }else{
                    answer += arr[i];
                    break;
                }
                check[i] = true;
            }

        }



        System.out.println(answer);


    }
}
