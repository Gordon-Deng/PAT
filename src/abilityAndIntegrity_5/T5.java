////import java.util.Scanner;
////import java.util.TreeSet;
////
////public class T5 {
////    public static void main(String[] args) {
////        Scanner sc = new Scanner(System.in);
////        int n = sc.nextInt();
////        int L = sc.nextInt();
////        int H = sc.nextInt();
////
////        TreeSet<Stu> both = new TreeSet<Stu>();
////        TreeSet<Stu> dc1 = new TreeSet<Stu>();
////        TreeSet<Stu> dc2 = new TreeSet<Stu>();
////        TreeSet<Stu> dc3 = new TreeSet<Stu>();
////        while(n != 0){
////            Stu stu = new Stu(sc.nextInt(), sc.nextInt(), sc.nextInt());
////            if(stu.d < L || stu.c <L){
////                n--;
////                continue;
////            }
////            if(stu.d >= H && stu.c >= H)
////                both.add(stu);
////            else if(stu.d >= H)
////                dc1.add(stu);
////            else if(stu.d >= stu.c)
////                dc2.add(stu);
////            else
////                dc3.add(stu);
////            n--;
////        }
////        System.out.println(both.size()+dc1.size()+dc2.size()+dc3.size());
////        print(both);
////        print(dc1);
////        print(dc2);
////        print(dc3);
////        sc.close();
////
////    }
////
////    private static void print(TreeSet<Stu> set) {
////        for(Stu s : set)
////            System.out.println(s.id + " " + s.d + " " + s.c);
////    }
////
////    static class Stu implements Comparable<Stu>{
////        int id, d, c, sum;
////        public Stu(int id, int d, int c) {
////            this.id = id;
////            this.d = d;
////            this.c = c;
////            this.sum = d+c;
////        }
////        @Override
////        public int compareTo(Stu o) {
////            if(this.sum != o.sum)
////                return o.sum-this.sum;
////            if(this.d != o.d)
////                return o.d-this.d;
////            return this.id-o.id;
////        }
////
////    }
////
////}
//
////JAVA 跑得太慢，换C++试试
////总体思路：
////先分类再排序，可借助STL中的set组件统一进行
////建立结构体。    除了考号、德分、才分，再添加总分sum、等级level，方便排序
////自定义结构体的排序函数。      先按等级排，再按总分、德分、考号排
////分类。      对读入的考生分类，设定其level值，并插入set中
////输出。       set可根据自定义的排序函数自动排序，直接反序输出即可
////代码如下：
//
//#include <iostream>
//#include <set>
//
//using namespace std;
//
//class Student
//{
//public:
//    int id, morality, ability, sum, level;
//    Student(int id, int morality, int ability) {
//        this->id = id;
//        this->morality = morality;
//        this->ability = ability;
//        this->sum = morality + ability;
//        level = 4;//默认为第4等级，可改
//    }
//    bool operator <(const Student& another)const {
//        if(level != another.level) {
//            return level>another.level;
//        } else if(sum != another.sum) {
//            return another.sum>sum;
//        } else if(morality != another.morality) {
//            return another.morality>morality;
//        } else {
//            return id>another.id;
//        }
//    }
//};
//
//int main()
//{
//// 基本变量
//int N, L, H;
//cin >> N >> L >> H;
//set<Student> student;
//
//// 分类划级
//for(int i=0; i<N; i++) {
//int id, morality, ability;
//cin >> id >> morality >> ability;
//Student stu(id, morality, ability);
//if(stu.morality<L || stu.ability<L) {
//continue;
//} else if(stu.morality >= H && stu.ability >= H) {
//stu.level = 1;
//} else if(stu.morality >= H) {
//stu.level = 2;
//} else if(morality>=ability) {
//stu.level = 3;
//} else {
//stu.level = 4;
//}
//student.insert(stu);
//}
//
//// 输出结果
//set<Student>::reverse_iterator iter;
//cout << student.size() << endl;
//for(iter=student.rbegin(); iter != student.rend(); iter++) {
//cout << (*iter).id << " " << (*iter).morality << " " << (*iter).ability << endl;
//}
//return 0;
//}
