package charPrint_1017;

/**
 * @Author : Gordon Deng
 * @Description :本题要求你写个程序把给定的符号打印成沙漏的形状。例如给定17个“*”，要求按下列格式打印
 *****
  ***
   *
  ***
 *****
所谓“沙漏形状”，是指每行输出奇数个符号；各行符号中心对齐；相邻两行符号数差2；符号数先从大到小顺序递减到1，再从小到大顺序递
增；首尾符号数相等。
给定任意N个符号，不一定能正好组成一个沙漏。要求打印出的沙漏能用掉尽可能多的符号。
 *
 * @Input :
 * 输入在一行给出1个正整数N（<=1000）和一个符号，中间以空格分隔。
 * @Output :
 * 首先打印出由给定符号组成的最大的沙漏形状，最后在一行中输出剩下没用掉的符号数。
 * @Example :
 * 19 * ->  *****
 *           ***
 *            *
 *           ***
 *          *****
 *          2
 * @learn :
 * @Date :   23:27 2018/2/4
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(" ");
        bf.close();
        int n = Integer.parseInt(input[0]);
        String c = input[1];

        int ln = (int) Math.sqrt((float)(n+1)/2);
        int line = 2 * ln - 1;
        int pnum = (ln - 1) * 2 + 1;

        for(int i = 1; i <= ln; i++){
            System.out.println(Printstr(line, pnum, c));
            pnum -= 2;
        }
        pnum = 1;
        for(int i = ln+1; i <= line; i++){
            pnum += 2;
            System.out.println(Printstr(line, pnum, c));
        }
        System.out.println(n - (ln*ln*2-1));
    }
    public static String Printstr(int total, int pn, String c){
        int blank = (total-pn)/2;
        StringBuilder res = new StringBuilder();
        for(int i = 1; i <= blank; i++){
            res.append(" ");
        }
        for(int i = 1; i <= pn; i++){
            res.append(c);
        }
        return res.toString();
    }
}
