package shortestRoad_0; /**
 *      coding=utf-8
 *      author:Gordon Deng
 *      5 Dec 2017 4:34 PM
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class shortestRoad {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int row,col;
        String []size = new String [2];
        size = in.readLine().split(" ");
        row = Integer.parseInt(size[0]);
        col = Integer.parseInt(size[1]);
        
        int arr[][] = new int[row][col];
        for (int i = 0; i < row; i++) {
            String []num = in.readLine().split(" ");
            for (int j = 0; j < col; j++) {
                arr[i][j] = Integer.parseInt(num[j]);
            }
        }
        
        System.out.println("ShortestRoad : " + shortestRoad(arr));
        
    }
    public static int shortestRoad(int arr[][])
    {
        int dp[][]=new int [arr.length][arr[0].length];
        dp[0][0]=arr[0][0];
        for(int i=1;i<arr.length;i++)
        {
            dp[i][0]=dp[i-1][0]+arr[i][0];
        }
        for(int j=1;j<arr[0].length;j++)
        {
            dp[0][j]=dp[0][j-1]+arr[0][j];
        }
        for(int i=1;i<arr.length;i++)
            for(int j=1;j<arr[0].length;j++)
            {
                dp[i][j]=Math.min(dp[i-1][j], dp[i][j-1])+arr[i][j];
            }
        
        return dp[arr.length-1][arr[0].length-1];
    }
}
