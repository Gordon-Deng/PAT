package hogwartsInPay_1027;

import java.util.Scanner;

/**
 * @Author : Gordon Deng
 * @Description :
 * 本题要求读入N名学生的成绩，将获得某一给定分数的学生人数输出。
 *
 * @Input :
 * 输入在第1行给出不超过105的正整数N，即学生总人数。随后1行给出N名学生的百分制整数成绩，中间以空格分隔。
 * 最后1行给出要查询的分数个数K（不超过N的正整数），随后是K个分数，中间以空格分隔。
 * @Output :
 * 在一行中按查询顺序给出得分等于指定分数的学生人数，中间以空格分隔，但行末不得有多余空格。
 * @Example :
 * 10
 * 60 75 90 55 75 99 82 90 75 50
 * 3 75 90 88
 *
 * 3 2 0
 * @learn :
 * 1）布尔表达式(表达式)?:
 * @Date :   15:53 2018/2/10
 */
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
