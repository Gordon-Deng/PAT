package partOfAaddB_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class T6 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String []in = new String[4];
        in = bf.readLine().split(" ");
        String S1 = in[0];
        String N1 = in[1];
        String S2 = in[2];
        String N2 = in[3];

        int count1= 0,count2 = 0;
        for (int i = 0; i < S1.length(); i++) {
            if (S1.charAt(i) == N1.charAt(0))
                count1++;
        }

        int P1 = 0;
        for (int i = 0; i < count1; i++) {
            P1 += Integer.parseInt(N1)*Math.pow(10,i);
        }

        for (int i = 0; i < S2.length(); i++) {
            if (S2.charAt(i) == N2.charAt(0))
                count2++;
        }

        int P2 = 0;
        for (int i = 0; i < count2; i++) {
            P2 += Integer.parseInt(N2)*Math.pow(10,i);
        }

        System.out.println(P1+P2);
    }
}
