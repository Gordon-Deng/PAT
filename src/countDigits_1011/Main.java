package countDigits_1011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int [] result = new int[10];
        String originString = bf.readLine();
        for (int i = 0; i < originString.length(); i++) {
            result[originString.charAt(i) - '0'] ++;
        }
        for (int j = 0; j < 10; j++) {
            if (result[j] != 0){
                System.out.println(j + ":" + result[j]);
            }
        }
    }
}
//public class Main {
//    public static void main(String[] args) {
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        int[] result = new int[10];
//        try {
//            for(byte b: bf.readLine().getBytes()) {
//                result[b - '0'] += 1;
//            }
//            for(int i = 0; i < 10; i++) {
//                if(result[i] > 0) {
//                    System.out.println(i + ":" + result[i]);
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                bf.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//    }
//}
