import java.text.DecimalFormat;
import java.util.Scanner;

public class T2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.0");

        int n = in.nextInt();
        int N[] = new int[n];
        int A1=0,A2=0,A3=0,A5=0;
        double A4=0.0;
        int A2_cout=2,A4_cout=0;
        for (int i = 0; i < n; i++) {
            N[i] = in.nextInt();
        }

        for (int i = 0; i < n; i++) {
            if (N[i]%5==0&&N[i]%2==0){
                A1 = A1 + N[i];
            }

            if (N[i]%5==1){
                A2 = A2 + (int)(N[i]*Math.pow(-1,A2_cout));
                A2_cout++;
            }

            if (N[i]%5==2){
                A3++;
            }

            if (N[i]%5==3){
                A4 = A4 + N[i];
                A4_cout++;
            }

            if (N[i]%5==4){
                if (N[i]>A5){
                    A5 = N[i];
                }
            }

        }
        System.out.print((A1==0?"N":A1) + " " +(A2==0?"N":A2) + " " +(A3==0?"N":A3) + " " +(A4==0?"N":df.format(A4/A4_cout)) + " " +(A5==0?"N":A5));
    }
}
