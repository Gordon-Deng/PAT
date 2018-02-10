package statisticsGrade_1028;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author : Gordon Deng
 * @Description :
 * 如果你是哈利·波特迷，你会知道魔法世界有它自己的货币系统 —— 就如海格告诉哈利的：“十七个银西可(Sickle)兑一个加隆(Galleon)，二十九个纳特(Knut)兑一个西可，很容易。”
 * 现在，给定哈利应付的价钱P和他实付的钱A，你的任务是写一个程序来计算他应该被找的零钱。
 *
 * @Input :
 * 输入在1行中分别给出P和A，格式为“Galleon.Sickle.Knut”，其间用1个空格分隔。
 * 这里Galleon是[0, 107]]区间内的整数，Sickle是[0,17)区间内的整数，Knut是[0, 29)区间内的整数。
 * @Output :
 * 在一行中用与输入同样的格式输出哈利应该被找的零钱。如果他没带够钱，那么输出的应该是负数。
 * @Example :
 * 10.16.27 14.1.28
 *
 * 3.2.1
 * @learn :
 * 1）全转为Knut再实现差额计算，再将差额转回xx:xx:xx格式
 * @Date :   20:21 2018/2/10
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        bf.readLine();
        String[] studentGrade = bf.readLine().split(" ");
        String[] queryInfo = bf.readLine().split(" ");
        int queryNum = Integer.parseInt(queryInfo[0]);
        int[] queryResult = new int[queryNum];
        int count ;
        bf.close();
        for (int i = 1; i < queryNum + 1; i++) {
            count = 0;
            for (int j = 0; j < studentGrade.length; j++) {

                if (queryInfo[i].equals(studentGrade[j])){
                    count ++;
                }
            }
            queryResult[i-1] = count;
        }

        for (int i = 0; i < queryNum; i++) {
            if (i == queryNum -1){
                System.out.print(queryResult[i]);
            }
            else
            System.out.print(queryResult[i] + " ");
        }
    }
}
