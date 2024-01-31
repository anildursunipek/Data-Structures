public class Knapsack {
    public int max(int value1, int value2){
        return (value1 > value2) ? value1 : value2;
    }

    public int maxValueKnapsack(int C, int[] w, int[] val, int length){
        int j, wt;
        int dp[][] = new int[length+1][C+1];

        for(j=0; j <= length; j++){
            for(wt=0; wt <= C; wt++){
                if(j==0 || wt==0){
                    dp[j][wt]=0;
                } else if (w[j-1] <= wt) {
                    dp[j][wt] = max(val[j-1] + dp[j-1][wt - w[j-1]], dp[j-1][wt]);
                }
                else{
                    dp[j][wt] = dp[j-1][wt];
                }
            }
        }
        return dp[j-1][C];
    }
}
