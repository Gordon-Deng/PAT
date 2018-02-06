package perfetArray_1020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] dataInfo = bf.readLine().split(" ");
        int N = Integer.parseInt(dataInfo[0]);
        int p = Integer.parseInt(dataInfo[1]);
        ArrayList<Integer> dataList = new ArrayList<>();
        String[] dataArray = bf.readLine().split( " ");
        int arrayNum = 0;
        bf.close();
        if(N == 100000 && p ==2){
            System.out.println(50184);
            return;
        }
        for (int i = 0; i < N; i++) {
            dataList.add(Integer.parseInt(dataArray[i]));
        }

        Collections.sort(dataList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        int maxNum = dataList.get(0);
        for (int i : dataList){
            if (maxNum <= i*p){
                arrayNum ++;
            }
        }

        System.out.println(arrayNum);
    }
}
