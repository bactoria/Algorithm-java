package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9507 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		final int TT = Integer.parseInt(br.readLine());
		long[] dp = new long[68];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
	
		for (int i = 4; i <= 67; i++) {
			dp[i] = dp[i-1]+dp[i-2]+dp[i-3]+dp[i-4];
		}
		
		for (int tt = 1; tt <= TT; tt++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(dp[n]+"\n");
		}
		System.out.println(sb.toString());
	}

}
