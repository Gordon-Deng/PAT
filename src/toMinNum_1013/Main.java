package toMinNum_1013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author : Gordon Deng
 * @Description : 给定数字0-9各若干个。你可以以任意顺序排列这些数字，但必须全部使用。目标是使得最后得到的数尽可能小（注意0不能做首位）
 *                用贪心就行
 * @Date :   21:21 2018/1/17
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String []b = bf.readLine().trim().split(" ");
        int []a = new int[b.length];
        int count = 0;
        int zero = Integer.parseInt(b[0]);
        for (int i = 1, j = a.length; i < j; i++) {
            a[i] = Integer.parseInt(b[i]);
            if (a[i] !=0 ){
                for (int k = 0; k < a[i]; k++) {
                    System.out.print(i);
                    count++;
                    if(zero != 0 && count ==1){
                        for (int l = 0; l < zero; l++) {
                            System.out.print("0");
                        }
                    }
                }
            }
        }
    }
}
