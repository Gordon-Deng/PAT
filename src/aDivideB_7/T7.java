package aDivideB_7;

import java.io.BufferedInputStream;
import java.math.BigInteger;
import java.util.Scanner;

public class T7 {
    public static void main(String[] args) {
        Scanner cin = new Scanner (new BufferedInputStream(System.in));
        BigInteger bigone = cin.nextBigInteger();
        BigInteger division = cin.nextBigInteger();
        cin.close();
        BigInteger[] answer = bigone.divideAndRemainder(division);
        System.out.println(answer[0]+" "+answer[1]); }
}
