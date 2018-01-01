package aAddBToDigits_1011;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * @Description: 输入两个非负10进制整数A和B(<=230-1)，输出A+B的D (1 < D <= 10)进制数。
 * @return:
 * @Date:   23:05 2018/1/1
 */

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(" ");
        bf.close();
        int ab = Integer.parseInt(input[0])+Integer.parseInt(input[1]);
        int d = Integer.parseInt(input[2]);
        StringBuilder res = new StringBuilder();
        while(ab!=0){
            res.append(ab%d);
            ab = ab/d;
        }
        System.out.print(res.reverse());
    }
}
