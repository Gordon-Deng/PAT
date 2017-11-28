import java.util.Scanner;
import java.util.TreeSet;

public class T5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int L = sc.nextInt();
        int H = sc.nextInt();

        TreeSet<Stu> both = new TreeSet<Stu>();
        TreeSet<Stu> dc1 = new TreeSet<Stu>();
        TreeSet<Stu> dc2 = new TreeSet<Stu>();
        TreeSet<Stu> dc3 = new TreeSet<Stu>();
        while(n != 0){
            Stu stu = new Stu(sc.nextInt(), sc.nextInt(), sc.nextInt());
            if(stu.d < L || stu.c <L){
                n--;
                continue;
            }
            if(stu.d >= H && stu.c >= H)
                both.add(stu);
            else if(stu.d >= H)
                dc1.add(stu);
            else if(stu.d >= stu.c)
                dc2.add(stu);
            else
                dc3.add(stu);
            n--;
        }
        System.out.println(both.size()+dc1.size()+dc2.size()+dc3.size());
        print(both);
        print(dc1);
        print(dc2);
        print(dc3);
        sc.close();

    }

    private static void print(TreeSet<Stu> set) {
        for(Stu s : set)
            System.out.println(s.id + " " + s.d + " " + s.c);
    }

    static class Stu implements Comparable<Stu>{
        int id, d, c, sum;
        public Stu(int id, int d, int c) {
            this.id = id;
            this.d = d;
            this.c = c;
            this.sum = d+c;
        }
        @Override
        public int compareTo(Stu o) {
            if(this.sum != o.sum)
                return o.sum-this.sum;
            if(this.d != o.d)
                return o.d-this.d;
            return this.id-o.id;
        }

    }

}