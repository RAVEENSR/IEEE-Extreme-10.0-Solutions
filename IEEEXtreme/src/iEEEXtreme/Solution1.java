/*package iEEEXtreme;

public class Solution1 {
    public static int solution(int[] a,int m){
		int[][] cost = new int[a.length][a.length];
		dp = new int[a.length][m+1];
 
		//base cases (compute the maximum in range [i] to [j] and store in cost array)
		for(int i=0; i<a.length;i++){
			cost[i][i]=a[i];
			for(int j=i+1; j<a.length;j++){
				cost[i][j]=Math.max(cost[i][j-1],a[j]);
			}
		}
 
		for(int j=0;j<dp.length;j++){
			dp[j][1]=cost[j][a.length-1];
		}
 
		//now use the dynamic programming recurrence
		for(int i= a.length-1;i>=0;i--){
			for(int j=2; j<=m;j++){
				//start out assuming dp[i][j] is as large as possible
				dp[i][j] = Integer.MAX_VALUE; 
				for(int k=a.length-j-1;k>=i;k--){
					dp[i][j]=Math.min(dp[i][j], cost[i][k]+dp[k+1][j-1]);
				}
			}
		}
		return dp[0][m];
	}
}
*/