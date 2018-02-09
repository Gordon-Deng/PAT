package findBadKey2_1023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @Author : Gordon Deng
 * @Description :
 * 旧键盘上坏了几个键，于是在敲一段文字的时候，对应的字符就不会出现。
 * 现在给出应该输入的一段文字、以及坏掉的那些键，打出的结果文字会是怎样？
 *
 * @Input :
 * 输入在2行中分别给出坏掉的那些键、以及应该输入的文字。其中对应英文字母的坏键以大写给出；每段文字是不超过10^5个字符的串。可用的
 * 字符包括字母[a-z, A-Z]、数字0-9、以及下划线“_”（代表空格）、“,”、“.”、“-”、“+”（代表上档键）。题目保证第2行输入的文字串非空。
 * 注意：如果上档键坏掉了，那么大写的英文字母无法被打出。
 * @Output :
 * 在一行中输出能够被打出的结果文字。如果没有一个字符能被打出，则输出空行。
 * @Example :
 * 7+IE.
 * 7_This_is_a_test.
 *
 * _hs_s_a_tst
 * @learn :
 * 1）先遍历第一行输入判定是否有上档键的损坏，如有则将第一行数据转换为小写字符进行匹配，因为所有的大写字符都会被筛掉；若无，则将第二行数据转换为大写字符进行匹配，因为key是大写的。全程使用treemap进行记录第二行哪个字符需要去除。
 * 2）treemap里面的数据即有序又唯一，arraylist有序但不唯一，set无序但唯一
 * 3）跳出指定循环可以用 break +（循环名)的
 * @Date :   13:26 2018/2/9
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String badKey = bf.readLine();
        String inputData = bf.readLine();
        int deleteNum = 0;
        char[] inputData_Char = inputData.toCharArray();
        bf.close();

        TreeSet<Integer> indexOfKey = new TreeSet<Integer>();
        boolean flag = false;

        for (int i = 0; i < badKey.length(); i++) {
            if (badKey.charAt(i) == '+'){
                flag = true;
                break;
            }
        }

        if (!flag){
            String inputData_Upper = inputData.toUpperCase();

            for (int i = 0; i < badKey.length(); i++) {
                for (int j = 0; j < inputData.length(); j++) {
                    if (badKey.charAt(i) == inputData_Upper.charAt(j)){
                        indexOfKey.add(j);
                    }
                }
            }
        }

        else {
            String badKey_Lower = badKey.toLowerCase();
            loop2:
                for (int i = 0; i < inputData.length(); i++) {
                    for (int j = 0; j < badKey.length(); j++) {
                        if (badKey_Lower.charAt(j) == inputData.charAt(i) || Character.isUpperCase(inputData.charAt(i))){
                            indexOfKey.add(i);
                            continue loop2;
                        }
                    }
                }
        }

        StringBuilder sb = new StringBuilder(inputData);
        Iterator<Integer> iterator = indexOfKey.iterator();
        while (iterator.hasNext()){
            sb.deleteCharAt(iterator.next()-deleteNum);
            deleteNum ++;
        }
        System.out.println(sb.toString());
    }
}
