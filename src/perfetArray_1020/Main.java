package perfetArray_1020;

import java.util.Scanner;
import java.util.Arrays;

/**
 * @Author : Gordon Deng
 * @Description : 给定一个正整数数列，和正整数p，设这个数列中的最大值是M，最小值是m，如果M <= m * p，则称这个数列是完美数列。
 * 现在给定参数p和一些正整数，请你从中选择尽可能多的数构成一个完美数列。
 *
 * @Input :
 * 输入第一行给出两个正整数N和p，其中N（<= 105）是输入的正整数的个数，p（<= 109）是给定的参数。
 * 第二行给出N个正整数，每个数不超过109。
 * @Output :
 * 在一行中输出最多可以选择多少个数可以用它们组成一个完美数列。
 * @Example :
 * 10 8
 * 2 3 20 4 5 1 6 7 8 9
 *
 * 8
 *
 * 10 8
 * 1 1 1 1 1 1 1 1 1 8
 *
 * 9(非1)
 * @learn :
 * 1）关键在循环时剪支
 * @Date :   10:05 2018/2/7
 */

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int p = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i<n;i++)
            arr[i] = in.nextInt();
        Arrays.sort(arr);
        int maxlen = 0;
        for(int i = 0;i<n;i++){
            for(int j = i+maxlen;j<n;j++){//剪支
                if(arr[j]>arr[i]*p)
                    break;
                maxlen++;
            }

        }
        System.out.println(maxlen);
    }
}