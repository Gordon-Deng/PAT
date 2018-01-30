package scientificCount_1014;

/**
 * @Author : Gordon Deng
 * @Description :
 * 科学计数法是科学家用来表示很大或很小的数字的一种方便的方法，其满足正则表达式[+-][1-9]"."[0-9]+E[+-][0-9]+，即数字的整数部分
 * 只有1位，小数部分至少有1位，该数字及其指数部分的正负号即使对正数也必定明确给出。
 * 现以科学计数法的格式给出实数A，请编写程序按普通数字表示法输出A，并保证所有有效位都被保留。
 *
 * in:+1.23400E-03
 * out:0.00123400
 *
 * @Date :   17:41 2018/1/30
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String num = in.next();
        int ei = num.indexOf('E');
        String right = num.substring(3,ei);
        int offset = Integer.parseInt(num.substring(ei + 2));
        boolean flag = num.charAt(ei + 1) == '+' ? true : false;
        if(num.charAt(0) == '-')
            System.out.print("-");
        if (flag)
        {
            System.out.println(num.charAt(1));
            for (int i = 0; i < offset; i++) {
                if (i >= right.length())
                    System.out.print("0");
                else
                    System.out.print(right.charAt(i));
            }
            if (offset<right.length()){
                System.out.print(".");
                for (int i = offset; i < right.length(); i++) {
                    System.out.print(right.charAt(i));
                }
            }
        }
        else {
            System.out.print("0.");
            for (int i = 1; i < offset; i++) {
                System.out.print("0");
            }
            System.out.print(num.charAt(1));
            System.out.print(right);
        }
    }


}
