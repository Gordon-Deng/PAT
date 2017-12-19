package countPrimeNum_3;

import java.util.Scanner;

public class T3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int M = in.nextInt();
        int N = in.nextInt();
        int n = N-M+1;
        int count = 2;
        int spider = 0;
        int []Prime = new int[n];

        while (spider<N) {
            if (isPrime(count)){
                spider++;
                if(spider>=M) {
                    Prime[spider - M] = count;
                }
            }
            count++;
        }

        for (int j = 0; j < N - M; j++) {
            if(j%10==9)
                System.out.print(Prime[j] + "\n");
            else
                System.out.print(Prime[j] + " ");
        }
        System.out.print(Prime[N-M]);
    }

    private static boolean isPrime(int num){
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if(num%i==0)
                return false;
        }
        return true;
    }
}
