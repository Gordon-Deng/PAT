package bestSchool_1022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] gameInfo = new int[100001];

        int participantNum = Integer.parseInt(bf.readLine());
        int bestSchoolId = 0;
        int maxScore = 0;

        for (int i = 0; i < participantNum; i++) {
            String gameData = bf.readLine();
            int schoolId = Integer.parseInt(gameData.split(" ")[0]);
            int gameScore = Integer.parseInt(gameData.split(" ")[1]);

            gameInfo[schoolId] += gameScore;

        }

        for (int j = 0; j < 100001; j++) {
            if (maxScore < gameInfo[j]){
                maxScore = gameInfo[j];
                bestSchoolId = j;
            }
        }

        System.out.println(bestSchoolId + " " + maxScore);
    }
}
