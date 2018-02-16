package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9461 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		final int TT = Integer.parseInt(br.readLine());
		
		for (int tt = 1; tt <= TT; tt++) {
			int n = Integer.parseInt(br.readLine());
			long[] dp = new long[n+1];
			
			if(n<5) {
				sb.append( ( ( n / 4 ) + 1 ) + "\n");
				continue;
			}
			
			dp[1] = 1;
			dp[2] = 1;
			dp[3] = 1;
			dp[4] = 2;
			
			for (int i = 5; i <= n; i++) {
				dp[i] = dp[i-5] + dp[i-1];
			}
			
			sb.append(dp[n]+"\n");
		}
		System.out.println(sb.toString());
	}

}
