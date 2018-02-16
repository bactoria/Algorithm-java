package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11055 {
	public static int max( int a, int b) {
		return a>b ? a : b;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		final int N = Integer.parseInt(br.readLine());
		int[] cost = new int[N+1];
		int[] dp = new int[N+1];
		int result = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= N; i++) {
			int max = 0;
			for (int j = 1; j < i; j++) {
				if(cost[i] <= cost[j]) continue;
				max = max(max,dp[j]);
			}
			dp[i] = max + cost[i];
			if(result < dp[i]) result = dp[i];
		}
		
		System.out.println(result);
	}

}
