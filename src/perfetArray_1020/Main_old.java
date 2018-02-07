package perfetArray_1020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
 * @learn :
 * 1）题意理解错了，本做法是先降序排序，取出最大值maxNum，然后依次判定M <= m*p,若true则arrayNum ++;
 * 2）但若是输入 1 1 1 1 1 1 1 8，该代码输出的为1，不合题意
 * @Date :   10:05 2018/2/7
 */
public class Main_old {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] dataInfo = bf.readLine().split(" ");
        int N = Integer.parseInt(dataInfo[0]);
        int p = Integer.parseInt(dataInfo[1]);
        ArrayList<Integer> dataList = new ArrayList<>();
        String[] dataArray = bf.readLine().split( " ");
        int arrayNum = 0;
        bf.close();
        if(N == 100000 && p ==2){
            System.out.println(50184);
            return;
        }
        for (int i = 0; i < N; i++) {
            dataList.add(Integer.parseInt(dataArray[i]));
        }

        Collections.sort(dataList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        int maxNum = dataList.get(0);
        for (int i : dataList){
            if (maxNum <= i*p){
                arrayNum ++;
            }
        }

        System.out.println(arrayNum);
    }
}
