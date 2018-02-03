package reverseList_1015;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @Author      : Gordon Deng
 * @Description : 给定一个常数K以及一个单链表L，请编写程序将L中每K个结点反转。
 *
 * @Example     : 1→2→3→4→5→6；K=3   3→2→1→6→5→4；
 *                4→3→2→1→5→6；K=4   4→3→2→1→5→6；
 * @Input       : 每个输入包含1个测试用例。
 * 每个测试用例第1行给出第1个结点的地址、结点总个数正整数N(<= 105)、以及正整数K(<=N)，
 * 即要求反转的子链结点的个数。结点的地址是5位非负整数，NULL地址用-1表示。
 * @Output :对每个测试用例，顺序输出反转后的链表，其上每个结点占一行，格式与输入相同。
 * @learn : Node结构体
 * @Date :        13:43 2018/2/1
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = sc.nextInt();
        int nc = sc.nextInt();
        ArrayList<Node> ll = new ArrayList<Node>();
        int k = sc.nextInt();
        //节点地址-节点映射
        HashMap<Integer, Node> map = new HashMap<Integer, Node>();
        while(nc != 0){
            int ad = sc.nextInt();
            int val = sc.nextInt();
            int next = sc.nextInt();
            map.put(ad, new Node(ad, val, next));
            nc--;
        }
        sc.close();

        //把链表按给出顺序排列,放入集合中
        while(first != -1){
            Node n = map.get(first);
            ll.add(n);
            first = n.next;
        }

        //每k位逆转顺序
        for(int i = k; i < ll.size(); i += k){
            int l = i-k;
            int r = i-1;
            while(l < r){
                Node t = ll.get(l);
                ll.set(l, ll.get(r));
                ll.set(r, t);
                l++;
                r--;
            }
        }

        //输出结果,地址小于5位前面补0
        for(int i = 0; i<ll.size()-1; i++){
            String str = ""+ll.get(i).address;
            String str2 = ""+ll.get(i+1).address;
            while(str.length() < 5)
                str = "0"+str;
            while(str2.length() < 5)
                str2 = "0"+str2;
            System.out.println(str + " " + ll.get(i).val + " " + str2);
        }
        String str = ""+ll.get(ll.size()-1).address;
        while(str.length() < 5)
            str = "0"+str;
        System.out.println(str + " " + ll.get(ll.size()-1).val + " -1");

    }

    static class Node{
        int address;
        int val;
        int next;

        public Node(int adr, int v, int next){
            address = adr;
            val = v;
            this.next = next;
        }
    }
}
