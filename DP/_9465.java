package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _9465 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		StringBuilder sb = new StringBuilder();
		final int TT = Integer.parseInt(br.readLine());
		
		for (int tt = 1; tt <= TT; tt++) {
			int n = Integer.parseInt(br.readLine());
			int[][] score = new int[2][n+2];
			int[][] dp = new int[2][n+2];
			
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 2; j <= n+1; j++) {
					score[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
				for (int j = 2; j <= n+1; j++) {
					for (int i = 0; i < 2; i++) {
					int temp = (i+1)%2;
					int tempA = dp[temp][j-2];
					int tempB = dp[temp][j-1];
					
					if(tempA > tempB) dp[i][j] = score[i][j] + tempA;
					else dp[i][j] = score[i][j] + tempB;
						
				}
			}
			
			if(dp[0][n+1] > dp[1][n+1]) sb.append(dp[0][n+1]+"\n");
			else sb.append(dp[1][n+1]+"\n");
		}
		System.out.println(sb.toString());
	}

}
