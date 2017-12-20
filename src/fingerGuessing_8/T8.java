package fingerGuessing_8;

import java.util.Scanner;

public class T8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int [] num = new int[3];
        char [] b = {'B','C','J'};
        int [][] bt = new int[3][2];
        char[] w = new char[2];

        for (int i = 0; i < n; i++) {
            char t1 = in.next().charAt(0);
            char t2 = in.next().charAt(0);
            int te1 = -10,te2 = -10;
            for (int j = 0; j < b.length; j++) {
                if (t1 == b[j])
                    te1 = j ;
                if (t2 == b[j])
                    te2 = j;
            }
            switch (te1 - te2){
                case -2:
                    num[2]++;
                    bt[te2][1]++;
                    break;
                case -1:
                    num[0]++;
                    bt[te1][0]++;
                    break;
                case 1:
                    num[2]++;
                    bt[te2][1]++;
                    break;
                case 2:
                    num[0]++;
                    bt[te1][0]++;
                    break;
                default:
                    num[1]++;
            }
        }
        System.out.println(String.valueOf(num[0]) + " " + num[1] + " " + num[2]);
        System.out.println(String.valueOf(num[2]) + " " + num[1] + " " + num[0]);
        for (int j = 0; j < 2; j++) {
            int max = bt[0][j];
            int ww  = 0;
            for (int i = 1; i < 3; i++) {
                if (bt[i][j]>max){
                    max = bt[i][j];
                    ww  = i;
                }
            }
            System.out.print(b[ww]);
            if (j !=1)
                System.out.print(" ");
        }
    }
}