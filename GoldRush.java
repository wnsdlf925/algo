import java.util.Scanner;

public class GoldRush {
    public static void main(String[] args) {

        int count = 0;
        int gold = 1;
        int bronze = 10;

        while (true){

            Scanner sc = new Scanner(System.in);

            if(sc.nextInt()==1){
                int random = (int)(Math.random()*1000)+1;
                if(random<gold){
                    System.out.println("gold");
                    break;
                }else if(random<bronze+gold && random>=gold){
                    System.out.println("bronze");
                    gold++;
                    System.out.println("gold: "+gold+"%");
                }
            }else {
                break;
            }

            count++;
            System.out.println("gold%: "+(double)gold/1000*100);
            System.out.println("count: "+count);

        }

    }
}
