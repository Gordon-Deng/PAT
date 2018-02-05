package theOldestAndTheYoungest_1018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.TreeMap;

/**
 * @Author : Gordon Deng
 * @Description :
 * 某城镇进行人口普查，得到了全体居民的生日。现请你写个程序，找出镇上最年长和最年轻的人。
 * 这里确保每个输入的日期都是合法的，但不一定是合理的——假设已知镇上没有超过200岁的老人，而今天是2014年9月6日，所以超过200岁的生日和未出生的生日都是不合理的，应该被过滤掉。
 *
 * @Input :
 * 输入在第一行给出正整数N，取值在(0, 105]；随后N行，每行给出1个人的姓名（由不超过5个英文字母组成的字符串）、以及
 * 按“yyyy/mm/dd”（即年/月/日）格式给出的生日。题目保证最年长和最年轻的人没有并列。
 * @Output :
 * 在一行中顺序输出有效生日的个数、最年长人和最年轻人的姓名，其间以空格分隔。
 * @Example :
 * 5
 * John 2001/05/12
 * Tom 1814/09/06
 * Ann 2121/01/30
 * James 1814/09/05
 * Steve 1967/11/20
 *
 * 3 Tom John
 * @learn :
 * 1）读入数据，去掉200岁以上和未出生的，保存在treeMap中，自定义比较器使得map的key按出生日期升序，值为名字，输出第一个和最后一个数据
 * 2）treeMap 里面的比较器口诀："就是要当老大"，public int compare(ob a, ob b){return a.comparTo(b)}，升序，即传入的参数与实际排列看上去是相反
 * firstEntry()：返回该map中最小的key对应的key-value
 * lastEntry()：返回该map中最大的key对应的key-value
 * @Date :   18:24 2018/2/5
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String sNum = bf.readLine();
        int personNum = Integer.parseInt(sNum);
        int validNum = 0;
        TreeMap<Integer, String> personMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        while (personNum != 0){
            String[] personInfo = bf.readLine().split(" ");
            String personName = personInfo[0];
            String personBirday = personInfo[1].replace("/", "");
            int birdayNum = Integer.parseInt(personBirday);
            if (birdayNum >= 18140906 && birdayNum <= 20140906){
                personMap.put(birdayNum, personName);
                validNum ++;
            }
            personNum --;
        }
        bf.close();
        System.out.print(validNum + " " + personMap.get(personMap.firstKey()) + " " + personMap.get(personMap.lastKey()));
    }
}
