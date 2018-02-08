package verifyIdCard_1021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        final ArrayList<Integer> WEIGHT = new ArrayList<Integer>(Arrays.asList(7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2));
        final ArrayList<Character> VERIFY_KEY = new ArrayList<Character>();
        VERIFY_KEY.add(0, '1');
        VERIFY_KEY.add(1, '0');
        VERIFY_KEY.add(2, 'X');
        VERIFY_KEY.add(3, '9');
        VERIFY_KEY.add(4, '8');
        VERIFY_KEY.add(5, '7');
        VERIFY_KEY.add(6, '6');
        VERIFY_KEY.add(7, '5');
        VERIFY_KEY.add(8, '4');
        VERIFY_KEY.add(9, '3');
        VERIFY_KEY.add(10, '2');

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int idCardNum = Integer.parseInt(bf.readLine());
        int validNum = 0;

        loop1:
        for (int i = 0; i < idCardNum; i++) {
            int weightedValue = 0;
            String idCard = bf.readLine();
            for (int j = 0; j < idCard.length() - 1; j++) {
                int chr = idCard.charAt(j) - '0';
                if (idCard.charAt(j) == 'X'){
                    System.out.println(idCard);
                    continue loop1;
                }
                else {
                    weightedValue += chr*WEIGHT.get(j);
                }
            }

            if (!(VERIFY_KEY.get(weightedValue % 11).equals(idCard.charAt(17)))){
                System.out.println(idCard);
                continue;
            }

            validNum ++;
        }

        bf.close();

        if (idCardNum == validNum){
            System.out.println("All passed");
        }

    }
}
