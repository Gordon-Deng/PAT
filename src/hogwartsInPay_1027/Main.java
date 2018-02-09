package hogwartsInPay_1027;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String shouldPay = sc.next();
        String realPay = sc.next();
        int shouldPayToKnut = changeToKnut(shouldPay);
        int realPayToKnut = changeToKnut(realPay);
        boolean negativeFlag = shouldPayToKnut > realPayToKnut;

        if (negativeFlag){
            System.out.print("-");
            printPay(shouldPayToKnut - realPayToKnut);
        }

        else {
            printPay(realPayToKnut - shouldPayToKnut);
        }

    }

    public static int changeToKnut(String pay){
        String[] payInfo = pay.split("\\.");
        int Galleon = Integer.parseInt(payInfo[0]);
        int Sickle = Integer.parseInt(payInfo[1]);
        int Knut = Integer.parseInt(payInfo[2]);
        int paySum = Galleon *17*19 + Sickle *19 + Knut;

        return paySum;
    }

    public static void printPay(int sum){
        int Galleon = sum / (17*19);
        int Sickle = (sum - Galleon*(17*19)) / 19;
        int Knut = sum - Galleon*(17*19) - Sickle*19;

        System.out.println(Galleon + "." + Sickle + "." + Knut);

    }
}
