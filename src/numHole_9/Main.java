package numHole_9;

/**
 *     @Author: Gordon Deng
 *     @Description:
 *     @Date:   11:12 2017/12/27
 */

import java.util.Scanner;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String num = in.next();
        int result = 0;
        while(result!=6174){
            int left = 0;
            int right = 0;
            char[] temp = creat(num);
            char[] l = new char[4];
            Arrays.sort(temp);//asc
            for(int i = 3;i>=0;i--){
                left = left*10+temp[i]-'0';//减数
                right = right*10+temp[3-i]-'0';//被减数
                l[i] = temp[3-i];
            }
            if(left==right){
                System.out.println(new String(l)+" - "+new String(temp)+" = 0000");
                return;
            }
            result = left-right;
            System.out.println(new String(l)+" - "+new String(temp)+" = "+result);
            num = ""+result;
        }
    }

    private static char[] creat(String s)//3位数补0
    {
        char[] num = new char[4];
        for(int i = 0;i<num.length;i++){
            if(i>=s.length())
                num[i] = '0';
            else
                num[i] = s.charAt(i);
        }
        return num;
    }

}
