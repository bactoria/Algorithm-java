package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11727 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N+1];
		if(N<3) {
			System.out.println(N*2-1);
			return;
		}
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 3;
		for (int i = 3; i <= N; i++) {
			dp[i] = 2*dp[i-3] + 3*dp[i-2];
			dp[i] %= 10007;
		}
		
		System.out.println(dp[N]);
	}

}
