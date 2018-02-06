package findBadKey_1019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @Author : Gordon Deng
 * @Description :旧键盘上坏了几个键，于是在敲一段文字的时候，对应的字符就不会出现。
 * 现在给出应该输入的一段文字、以及实际被输入的文字，请你列出肯定坏掉的那些键。
 *
 * @Input :
 * 输入在2行中分别给出应该输入的文字、以及实际被输入的文字。
 * 每段文字是不超过80个字符的串，由字母A-Z（包括大、小写）、数字0-9、以及下划线“_”（代表空格）组成。题目保证2个字符串均非空。
 * @Output :
 * 按照发现顺序，在一行中输出坏掉的键。其中英文字母只输出大写，每个坏键只输出一次。题目保证至少有1个坏键。
 * @Example :
 * 7_This_is_a_test
 * _hs_s_a_es
 *
 * 7TI
 * @learn :
 * 1）将期待输入转大写后再转为字符数组，放入set中，set不支持重复，所以值唯一，再将遍历同样处理后的实际输入数据，使之从set移除，得到坏的key
 * 2) toUpperCase()转大写
 * 3）toCharArray()转字符数组
 * 4）new LinkedHashSet<>()是带hearder头链接的hashset,而hashset是基于hashmap,所有的set都放入map的key中，value为空
 * @Date :   19:07 2018/2/6
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));

        char []expectedInput = bf.readLine().toUpperCase().toCharArray();
        char []realInput = bf.readLine().toUpperCase().toCharArray();
        Set<Character> set = new LinkedHashSet<>();

        bf.close();
        for(int i=0,j=expectedInput.length;i<j;i++) {
            set.add(expectedInput[i]);
        }
        for(int i=0,j=realInput.length;i<j;i++) {
            set.remove(realInput[i]);
        }
        for(char a:set) {
            System.out.print(a);
        }
    }
}
