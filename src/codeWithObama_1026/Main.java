package codeWithObama_1026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author : Gordon Deng
 * @Description :美国总统奥巴马不仅呼吁所有人都学习编程，甚至以身作则编写代码，成为美国历史上首位编写计算机代码的总统。
 * 2014年底，为庆祝“计算机科学教育周”正式启动，奥巴马编写了很简单的计算机代码：在屏幕上画一个正方形。现在你也跟他一起画吧！
 *
 * @Input :
 * 输入在一行中给出正方形边长N（3<=N<=20）和组成正方形边的某种字符C，间隔一个空格。
 * @Output :
 * 输出由给定字符C画出的正方形。但是注意到行间距比列间距大，所以为了让结果看上去更像正方形，我们输出的行数实际上是列数的50%(四舍五入取整)
 * @Example :
 * 10 a
 *
 * aaaaaaaaaa
 * a        a
 * a        a
 * a        a
 * aaaaaaaaaa
 * @learn :
 * 1）M = (int) (N * 1.0 / 2 + 0.5)简易四舍五入
 * @Date :   01:39 2018/2/10
 */

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] read = bf.readLine().split(" ");
        int N = Integer.valueOf(read[0]);
        String C = read[1];
        int M = (int) (N * 1.0 / 2 + 0.5);
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (i == 0) System.out.print(C);
                else if (i == M - 1) System.out.print(C);
                else if (j == 0 || j == N - 1) System.out.print(C);
                else System.out.print(" ");
            }
            System.out.println();
        }
    }
}
