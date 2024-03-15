import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_4195 {

    static StringBuilder sb = new StringBuilder();
    static int mapIndex;
    static int[] union;
    static int[] size;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int testCase = Integer.parseInt(token.nextToken());

        for(int z=0; z<testCase; z++){

            HashMap<String,Integer> map = new HashMap<>();
            token = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(token.nextToken());
            union = new int[f*2];
            size = new int[f*2];
            mapIndex = 0;

            Arrays.fill(union, -1);
            Arrays.fill(size, 1);

            for(int relation=0; relation<f; relation++){
                token = new StringTokenizer(br.readLine());
                String a = token.nextToken();
                String b = token.nextToken();

                sb.append(findfriend(a,b,map)).append("\n");
                //System.out.println(Arrays.toString(union));
            }
        }
        System.out.println(sb.toString());

    }

    static int findfriend(String a, String b, HashMap<String,Integer> map){

        int check = 0;
        String notFindString = "";
        String findString = "";

        if(map.containsKey(a)){
            check++;
            notFindString = b;
            findString = a;
        }

        if(map.containsKey(b)){
            check++;
            notFindString = a;
            findString = b;
        }

        if(check==0){

            map.put(a,mapIndex);
            mapIndex++;
            map.put(b,mapIndex);
            mapIndex++;

            if (map.get(a)>map.get(b)){

                union[map.get(a)] = map.get(b);
                size[map.get(b)]++;
                return size[map.get(b)];

            }else {

                union[map.get(b)] = map.get(a);
                size[map.get(a)]++;
                return size[map.get(a)];

            }

        } else if (check==1) {

            map.put(notFindString,mapIndex);
            mapIndex++;

            int root = find(map.get(findString));
            union[map.get(notFindString)] = root;
            size[root]++;
            return size[root];

        }else{

            int aroot = find(map.get(a));
            int broot = find(map.get(b));

            if(aroot!=broot){
                if(size[aroot]>size[broot]){
                    union[broot] = aroot;
                    size[aroot]+=size[broot];
                    return size[aroot];
                }else{
                    union[aroot] = broot;
                    size[broot]+=size[aroot];
                    return size[broot];
                }
            }else{
                return size[aroot];
            }

        }
    }


    static int find(int findNum){

        if(union[findNum]==-1){
            return findNum;
        }else{
            return union[findNum]=find(union[findNum]);
        }

    }

}

/*
2
3
Fred Barney
Barney Betty
Betty Wilma
4
Fred Barney
Betty Wilma
Barney Betty
Barney fff

1
5
a b
b c
a d
a e
e a
 */
