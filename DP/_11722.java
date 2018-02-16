package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11722 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(br.readLine());
		int[] cost = new int[N + 1];
		int[] dp = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
		int result = 0;
		for (int i = 1; i <= N; i++) {
			int max = 0;
			for (int j = 1; j < i; j++) {
				if (cost[i] >= cost[j])
					continue;
				max = max > dp[j] ? max : dp[j];
			}
			dp[i] = max + 1;
			if (result < dp[i])
				result = dp[i];
		}
		System.out.println(result);
	}
}
