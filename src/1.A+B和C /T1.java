import java.math.BigInteger;
import java.util.Scanner;

public class T1 {
    public static void main(String[] args) {
        Scanner a1 = new Scanner(System.in);
        int con = 0 , n,i;
        n = a1.nextInt();
        for (i = 0; i < n; i++) {
            BigInteger a =a1.nextBigInteger();
            BigInteger b =a1.nextBigInteger();
            BigInteger c =a1.nextBigInteger();
            BigInteger d = a.add(b);
            con++;
            System.out.print("Case #" +con+ ": ");
            if (d.compareTo(c)>0)
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
}
