package findBadKey2_1023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String badKey = bf.readLine();
        String inputData = bf.readLine();
        int deleteNum = 0;
        char[] inputData_Char = inputData.toCharArray();
        bf.close();

        TreeSet<Integer> indexOfKey = new TreeSet<Integer>();
        boolean flag = false;

        for (int i = 0; i < badKey.length(); i++) {
            if (badKey.charAt(i) == '+'){
                flag = true;
                break;
            }
        }

        if (!flag){
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
            String badKey_Lower = badKey.toLowerCase();
            loop2:
                for (int i = 0; i < inputData.length(); i++) {
                    for (int j = 0; j < badKey.length(); j++) {
                        if (badKey_Lower.charAt(j) == inputData.charAt(i) || Character.isUpperCase(inputData.charAt(i))){
                            indexOfKey.add(i);
                            continue loop2;
                        }
                    }
                }
        }

        StringBuilder sb = new StringBuilder(inputData);
        Iterator<Integer> iterator = indexOfKey.iterator();
        while (iterator.hasNext()){
            sb.deleteCharAt(iterator.next()-deleteNum);
            deleteNum ++;
        }
        System.out.println(sb.toString());
    }
}
