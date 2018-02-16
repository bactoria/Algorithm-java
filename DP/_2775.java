package DP;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2775 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		final int TT = Integer.parseInt(br.readLine());
		
		for (int tt = 1; tt <= TT; tt++) {
			int k = Integer.parseInt(br.readLine()); //Ãþ
			int n = Integer.parseInt(br.readLine()); //È£
			
			int[][] dp = new int[k+1][n+1];
			for (int i = 0; i <= n; i++) {
				dp[0][i] = i;
			}
			
			for (int i = 1; i <= k; i++) {
				for (int j = 1; j <= n; j++) {
					dp[i][j] = dp[i-1][j] + dp[i][j-1];
				}
			}
			sb.append(dp[k][n]+"\n");
		}
		System.out.println(sb.toString());
	}

}
