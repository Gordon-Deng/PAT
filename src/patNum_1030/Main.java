package patNum_1030;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author : Gordon Deng
 * @Description :字符串APPAPT中包含了两个单词“PAT”.
 * 其中第一个PAT是第2位(P),第4位(A),第6位(T)；
 * 第二个PAT是第3位(P),第4位(A),第6位(T)。现给定字符串，问一共可以形成多少个PAT？
 *
 * @Input :
 * 输入只有一行，包含一个字符串，长度不超过105，只包含P、A、T三种字母。
 * @Output :
 * 在一行中输出给定字符串中包含多少个PAT。由于结果可能比较大，只输出对1000000007取余数的结果。
 * @Example :
 * APPAPT
 *
 * 2
 * @learn :
 * 1）类似于上阶梯问题，假设自己走到了阶梯N，那么走到该位置的路径（每次只走一部或者两步）取决走到N-1阶梯或N-2阶梯的路径
 * 2）统计有几个pat，需要知道有几个pa，要知道有几个pa，需要知道有几个p.例如pppppa,a之前有5个p，所有p为5,pa =pa +p = 5
 * @Date :   23:50 2018/2/10
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String inpueData = bufferedReader.readLine();
        bufferedReader.close();



        int mod=1000000007;
        int p=0;
        int pa=0;
        int pat=0;
        for (int i = 0; i < inpueData.length() ; i++) {
            char currentChar = inpueData.charAt(i);

            if (currentChar=='P') {
                p++;
            }
            if (currentChar=='A') {
                pa = (pa+p)%mod;
            }
            if (currentChar=='T') {
                pat=(pat+pa)%mod;
            }
        }
        System.out.println(pat);
    }


}