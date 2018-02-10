package buyOrNot_1029;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author : Gordon Deng
 * @Description :
 * 小红想买些珠子做一串自己喜欢的珠串。卖珠子的摊主有很多串五颜六色的珠串，但是不肯把任何一串拆散了卖。
 * 于是小红要你帮忙判断一下，某串珠子里是否包含了全部自己想要的珠子？
 * 如果是，那么告诉她有多少多余的珠子；
 * 如果不是，那么告诉她缺了多少珠子。
 * 为方便起见，我们用[0-9]、[a-z]、[A-Z]范围内的字符来表示颜色。
 * 例如，YrR8RrY是小红想做的珠串；那么ppRYYGrrYBR2258可以买，因为包含了全部她想要的珠子，还多了8颗不需要的珠子；
 * ppRYYGrrYB225不能买，因为没有黑色珠子，并且少了一颗红色的珠子。
 *
 * @Input :
 * 每个输入包含1个测试用例。每个测试用例分别在2行中先后给出摊主的珠串和小红想做的珠串，两串都不超过1000个珠子。
 * @Output :
 * 如果可以买，则在一行中输出“Yes”以及有多少多余的珠子；如果不可以买，则在一行中输出“No”以及缺了多少珠子。其间以1个空格分隔。
 * @Example :
 * ppRYYGrrYBR2258
 * YrR8RrY
 *
 * Yes 8
 * @learn :
 * 1）字符顶替法实现字符的消去
 * @Date :   22:34 2018/2/10
 */
public class Main {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader bufr =new BufferedReader(new InputStreamReader(System.in)) ;
        String s1 =bufr.readLine();
        String s2= bufr.readLine();
        int cnt=0;
        char[] sample=s1.toCharArray();
        char[] need =s2.toCharArray();
        for(int i=0;i<need.length;i++){
            for(int j=0;j<sample.length;j++){
                if(sample[j]==need[i]){
                    cnt++;
                    sample[j]='*';
                    break;
                }

            }

        }
        if(cnt==need.length){
            int n=sample.length-cnt;
            System.out.println("Yse"+n);
        }
        else
        {
            int n=need.length-cnt;
            System.out.println("No "+n);
        }
    }

}
