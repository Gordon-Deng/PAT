package rationalNumberOperation_1024;

import java.util.Scanner;

/**
 * @Author : Gordon Deng
 * @Description :本题要求编写程序，计算2个有理数的和、差、积、商。
 *
 * @Input :
 * 输入在一行中按照“a1/b1 a2/b2”的格式给出两个分数形式的有理数.
 * 其中分子和分母全是整型范围内的整数，负号只可能出现在分子前，分母不为0。
 * @Output :
 * 分别在4行中按照“有理数1 运算符 有理数2 = 结果”的格式顺序输出2个有理数的和、差、积、商。注意输出的每个有理数必须是该有理数的
 * 最简形式“k a/b”，其中k是整数部分，a/b是最简分数部分；若为负数，则须加括号；若除法分母为0，则输出“Inf”。题目保证正确的输出中
 * 没有超过整型范围的整数。
 * @Example :
 * 1 2/3 + 0 = 1 2/3
 * 1 2/3 - 0 = 1 2/3
 * 1 2/3 * 0 = 0
 * 1 2/3 / 0 = Inf
 * @learn :
 * 1）String[] b = in.next().split("/")
 * @Date :   15:33 2018/2/9
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] a = in.next().split("/");
        String[] b = in.next().split("/");
        int afz = Integer.parseInt(a[0]);
        int afm = Integer.parseInt(a[1]);
        int bfz = Integer.parseInt(b[0]);
        int bfm = Integer.parseInt(b[1]);
        String left = convert(afz, afm);
        String right = convert(bfz, bfm);
        System.out.println(left+" + "+right+" = "+getNum(afz, afm, bfz, bfm, "+"));
        System.out.println(left+" - "+right+" = "+getNum(afz, afm, bfz, bfm, "-"));
        System.out.println(left+" * "+right+" = "+getNum(afz, afm, bfz, bfm, "*"));
        System.out.println(left+" / "+right+" = "+getNum(afz, afm, bfz, bfm, "/"));
    }
    private static String convert(int fz,int fm){
        if(fz==0)
            return "0";
        if(fm==0)
            return "Inf";
        StringBuilder result = new StringBuilder();
        boolean flag = false;
        int k = 0;
        if(fz<0){
            result.append("(-");
            fz = -fz;
            flag = true;
        }
        k = fz/fm;
        fz = fz%fm;
        if(fz==0){
            if(k!=0)
                result.append(k);
            if(!flag)
                return result.toString();
            else
                return result.append(")").toString();
        }
        int gcd = gcd(fz, fm);
        if(gcd!=1){
            fz /= gcd;
            fm /= gcd;
        }
        if(k!=0)
            result.append(k).append(" ");
        result.append(fz).append("/").append(fm);
        if(flag)
            result.append(")");
        return result.toString();
    }
    private static String getNum(int afz,int afm,int bfz,int bfm,String op){
        switch (op) {
            case "+":
                if(afm==bfm)
                    return convert(afz+bfz, afm);
                else{
                    int gcd = gcd(afm, bfm);
                    int fm = afm*bfm/gcd;
                    afz *= fm/afm;
                    bfz *= fm/bfm;
                    return convert(afz+bfz, fm);
                }
            case "-":
                if(afm==bfm)
                    return convert(afz-bfz, afm);
                else{
                    int gcd = gcd(afm, bfm);
                    int fm = afm*bfm/gcd;
                    afz *= fm/afm;
                    bfz *= fm/bfm;
                    return convert(afz-bfz, fm);
                }
            case "*":
                return convert(afz*bfz,afm*bfm);
            case "/":
                int fm = bfz*afm;
                int fz = afz*bfm;
                if(fm<0){
                    fm = -fm;
                    fz = -fz;
                }
                return convert(fz,fm);
            default:
                break;
        }
        return null;
    }
    private static int gcd(int a,int b){
        while(a%b!=0){
            int temp = a%b;
            a = b;
            b = temp;
        }
        return b;//最大公因数
    }
}

