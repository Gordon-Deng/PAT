package findBadKey2_1023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String badKey = bf.readLine();
        String inputData = bf.readLine();
        char[] inputData_Char = inputData.toCharArray();
        bf.close();

        Set<Integer> indexOfKey = new HashSet<Integer>();
        boolean flag = false;

        for (int i = 0; i < badKey.length(); i++) {
            if (badKey.charAt(i) == '+'){
                flag = true;
                break;
            }
        }

        if (!flag){
            System.out.println("++++++");
            String inputData_Upper = inputData.toUpperCase();

            for (int i = 0; i < badKey.length(); i++) {
                for (int j = 0; j < inputData.length(); j++) {
                    if (badKey.charAt(i) == inputData_Upper.charAt(j)){
                        indexOfKey.add(j);
                    }
                }
            }
        }

        else {
            System.out.println("------");
            String badKey_Lower = badKey.toLowerCase();

            for (int i = 0; i < badKey.length(); i++) {
                for (int j = 0; j < inputData.length(); j++) {
                    if (badKey_Lower.charAt(i) == inputData.charAt(j) || Character.isUpperCase(inputData.charAt(j))){
                        System.out.println(inputData.charAt(j));
                        indexOfKey.add(j);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder(inputData);
        //Iterator<Integer> iterator = indexOfKey.iterator();
        //while (iterator.hasNext()){
        //    sb.deleteCharAt(iterator.next());
        //}

        indexOfKey.
        System.out.println(sb.toString());
    }
}
