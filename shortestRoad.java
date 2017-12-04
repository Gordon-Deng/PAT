public class shortestRoad {
    public static void main(String[] args) {

    }
    public static int shortestRoad(int arr[][])
    {
        int dp[][]=new int [arr.length][arr[0].length];
        dp[0][0]=arr[0][0];
        for(int i=1;i<arr.length;i++)
        {
            dp[i][0]=dp[i-1][0]+arr[i][0];
            //第一列只能由上向下
        }
        for(int j=1;j<arr[0].length;j++)
        {
            dp[0][j]=dp[0][j-1]+arr[0][j];
            //第一行只能由左向右
        }
        for(int i=1;i<arr.length;i++)
            for(int j=1;j<arr[0].length;j++)
            {
                dp[i][j]=Math.min(dp[i-1][j], dp[i][j-1])+arr[i][j];
            }

        return dp[arr.length-1][arr[0].length-1];
    }
}
