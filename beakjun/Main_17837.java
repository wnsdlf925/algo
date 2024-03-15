import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_17837 {

    static class Node{

        int nodeNum;
        int i;
        int j;
        int direction;


        public Node(int nodeNum, int i, int j, int direction){
            this.nodeNum = nodeNum;
            this.i = i;
            this.j = j;
            this.direction = direction;
        }





    }

    static int N;
    static  int[] dx = {0,1,-1,0,0};
    static int[] dy = {0,0,0,-1,1};
    static int[][] arr;

    static Stack<Node> stack = new Stack<>();

    static LinkedList<Node>[][] nodeCarryList;
    static ArrayList<Node> nodeList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());
        int answer = 0;
        arr = new int[N][N];
        nodeList = new ArrayList<>();
        nodeCarryList = new LinkedList[N][N];


        for(int i=0; i<N; i++){
            token = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(token.nextToken());
                nodeCarryList[i][j] = new LinkedList<>();
            }
        }

        for(int i=0; i<K; i++){

            token = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(token.nextToken())-1;
            int col = Integer.parseInt(token.nextToken())-1;
            int dir = Integer.parseInt(token.nextToken());

            Node node = new Node((i+1),row, col, dir);
            nodeCarryList[row][col].add(node);
            nodeList.add(node);

        }

        stop:
        while (answer<1000){
            answer++;
            for(int nodeRound=0; nodeRound<K; nodeRound++){

                moving(nodeList.get(nodeRound).nodeNum);
                for(int i=0; i<N; i++){
                    for(int j=0; j<N; j++){

                        if(nodeCarryList[i][j].size()>=4){
                            break stop;
                        }
                    }
                }
//                System.out.println(nodeList.get(nodeRound).nodeNum);
//                for(int i=0; i<N; i++){
//                    for(int j=0; j<N; j++){
//                        System.out.print("["+view(arr[i][j])+"] ");
//                        for(int z=0; z<nodeCarryList[i][j].size(); z++){
//                            System.out.print(nodeCarryList[i][j].get(z).nodeNum+vew(nodeCarryList[i][j].get(z).direction)+" ");
//                        }
//                    }
//                    System.out.println();
//
//                }
//                System.out.println();
            }
            if(answer>10){
                System.exit(1);
            }


        }

        System.out.println((answer>=1000)?-1:answer);

    }

    static String vew(int i){
        if(i==1){
            return "->";
        } else if (i==2) {
            return "<-";
        } else if (i==3) {
            return "^";
        }else {
            return "v";
        }
    }
    static String view(int i){
        if(i==0){
            return "흰";
        } else if (i==1) {
            return "빨";
        } else {
            return "파";
        }
    }

    static void moving(int num){

        movingStop:
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                for(int z=0; z<nodeCarryList[i][j].size(); z++){
                    if(nodeCarryList[i][j].get(z).nodeNum==num){
                        Node node = nodeCarryList[i][j].get(z);

                        int nx = node.j+dx[node.direction];
                        int ny = node.i+dy[node.direction];
                        //넘었다면
                        if(overArrayCheck(node)){
                            blue(node);
                        }else{
                            if(arr[ny][nx]==1){
                                red(node);
                            }else if(arr[ny][nx]==2){
                                blue(node);
                            }else{
                                move(node);
                            }
                        }
                        break movingStop;
                    }
                }
            }
        }

    }

    static void move(Node node){
        int nx = node.j+dx[node.direction];
        int ny = node.i+dy[node.direction];
       // System.out.println(node.direction);

        boolean carryCheck = false;
        int startIndex = -1;
        //System.out.println(node.nodeNum);
        for(int i=0; i<nodeCarryList[node.i][node.j].size(); i++){

            if(carryCheck){
                // System.out.println(ny+" "+nx+" "+ node.j+" "+ node.i+" ");
                //System.out.println("11111");
                Node temp = nodeCarryList[node.i][node.j].get(i);
                nodeCarryList[ny][nx].add(new Node(temp.nodeNum,ny,nx, temp.direction));

            }else{
                //System.out.println("2222");
                if(nodeCarryList[node.i][node.j].get(i).nodeNum== node.nodeNum){
                    carryCheck = true;
                    startIndex = i;
                    nodeCarryList[ny][nx].add(new Node(node.nodeNum,ny,nx, node.direction));


                }
            }
        }

        int endPoint = nodeCarryList[node.i][node.j].size();

        for(int i=startIndex; i<endPoint; i++){
            nodeCarryList[node.i][node.j].removeLast();
        }

    }
    static void red(Node node){

        int nx = node.j+dx[node.direction];
        int ny = node.i+dy[node.direction];
        int startIndex = 0;
        boolean carryCheck = false;

        for(int i=0; i<nodeCarryList[node.i][node.j].size(); i++){
            if(carryCheck){
                Node temp = nodeCarryList[node.i][node.j].get(i);
                stack.add(new Node(temp.nodeNum, ny,nx, temp.direction));

            }else{
                if(nodeCarryList[node.i][node.j].get(i).nodeNum== node.nodeNum){
                    carryCheck = true;
                    startIndex = i;

                    stack.add(new Node(node.nodeNum, ny,nx, node.direction));

                }
            }
        }

        int endPoint = nodeCarryList[node.i][node.j].size();

        for(int i=startIndex; i<endPoint; i++){
            nodeCarryList[node.i][node.j].removeLast();
        }

        while (!stack.isEmpty()){

            nodeCarryList[ny][nx].add(stack.pop());

        }

    }
    static void blue(Node node){

        if(node.direction%2==1){
            node.direction++;
        }else{
            node.direction--;
        }

        int nx = node.j+dx[node.direction];
        int ny = node.i+dy[node.direction];

        if(!overArrayCheck(node)&&arr[ny][nx]!=2){
            if(arr[ny][nx]==1){
                red(node);
            }else {
                move(node);
            }
        }

    }

    static boolean overArrayCheck(Node node){

        int nx = node.j+dx[node.direction];
        int ny = node.i+dy[node.direction];

        if(nx<0||nx>=N||ny<0||ny>=N){
            return true;
        }else{
            return false;
        }

    }
}
