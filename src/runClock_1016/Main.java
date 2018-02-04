package runClock_1016;

/**
 * @Author : Gordon Deng
 * @Description :要获得一个C语言程序的运行时间，常用的方法是调用头文件time.h，其中提供了clock()函数，可以捕捉从程序开始运行到clock()被调用时所耗费的时间。
 * 这个时间单位是clock tick，即“时钟打点”。
 * 同时还有一个常数CLK_TCK，给出了机器时钟每秒所走的时钟打点数。
 * 于是为了获得一个函数f的运行时间，我们只要在调用f之前先调用clock()，获得一个时钟打点数C1；
 * 在f执行完成后再调用clock()，获得另一个时钟打点数C2；
 * 两次获得的时钟打点数之差(C2-C1)就是f运行所消耗的时钟打点数，再除以常数CLK_TCK，就得到了以秒为单位的运行时间。
 * 这里不妨简单假设常数CLK_TCK为100。现给定被测函数前后两次获得的时钟打点数，请你给出被测函数运行的时间。
 * @Example : 123 4577973 -> 12:42:59
 * @Input : 123 4577973
 * @Output : 12:42:59
 * @learn :  1）Math UP DOWN FlOOR 等四舍五入处理小数点。
 *           2）%02d的输出格式化,4变04
 * @Date :   23:40 2018/2/3
 */

import java.util.Scanner;

public class Main{
    private static final double CLK_TCK = 100.0;
    private static final int MINUTE = 60;
    private static final int HOURS = 3600;
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int c1 = in.nextInt();
        int c2 = in.nextInt();

        double time = (c2-c1)/CLK_TCK;

        int h = (int)time/HOURS;

        time %= HOURS;
        int m = (int)time/MINUTE;
        time %= MINUTE;
        System.out.printf("%02d:%02d:%02.0f\n",h,m,time);
    }
}
