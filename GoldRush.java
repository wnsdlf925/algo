import java.util.Scanner;

public class GoldRush {
    public static void main(String[] args) {

        int count = 0;
        int gold = 1;
        int bronze = 2000;
        int silver = 200;

        while (true){


            int i = 1;
            if(i==1){
                int random = (int)(Math.random()*100000)+1;
                if(random<=gold){
                    System.out.println("gold");
                    break;
                }else if(random<bronze+gold && random>=gold){
                    System.out.println("bronze");
                    gold+=1;

                    //bronze=0;
                }else if(random>bronze+gold && random<bronze+gold+silver){
                    System.out.println("silver");
                    gold+=10;
                    //silver =0;

                }
            }else {
                break;
            }

            count++;
            System.out.println("gold: "+(double)gold/100000*100+"%");
            System.out.println("count: "+count);

        }

    }
}
