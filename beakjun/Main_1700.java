import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1700 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());
        int[] arr = new int[K];
        HashMap<Integer, Integer> map = new HashMap<>();
        Set<Integer> tap = new HashSet<>();
        int answer = 0;

        token = new StringTokenizer(br.readLine());

        for (int i=0; i<K; i++){
            arr[i] = Integer.parseInt(token.nextToken());
            if(!map.containsKey(arr[i])){
                map.put(arr[i],1);
            }else{
                map.replace(arr[i],map.get(arr[i])+1);
            }
        }


        for(int i=0; i<K; i++){
            if(tap.size()<N){
                tap.add(arr[i]);
                map.replace(arr[i],map.get(arr[i])-1);
            }else{
                if(tap.contains(arr[i])){
                    map.replace(arr[i],map.get(arr[i])-1);
                }else{
                    int min = Integer.MAX_VALUE;
                    int minNum = 0;
                    for(int z: tap){
                        if(min>map.get(z)){
                            min = map.get(z);
                            minNum = z;
                        }
                    }
                    if(min!=0){
                        Set<Integer> temp = new HashSet<>();
                        temp.addAll(tap);
                        for(int j=i; j<K; j++){
                                if(temp.contains(arr[j])){
                                    temp.remove(arr[j]);
                                    if(temp.size()==1){
                                        minNum = temp.iterator().next();
                                    }
                                }
                        }
                    }
                    tap.remove(minNum);
                    tap.add(arr[i]);
                    map.replace(arr[i],map.get(arr[i])-1);
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}

/*
3 14
1 4 3 2 5 4 3 2 5 3 4 2 3 4

4 20
1 2 3 4 5 1 2 3 4 5 1 2 3 4 5 1 2 3 4 5
 */