package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _11060 {
	public static int min(int a, int b) {
		return a < b ? a:b;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(br.readLine());
		int cost[] = new int[N+1];
		int dp[] = new int[N+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i =1; i <= N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[1] = 0;
		
		for (int i = 1; i < N; i++) {
			if(dp[i] == Integer.MAX_VALUE) continue;
			
			for (int j = cost[i]; j > 0; j--) {
				if((i+j) > N) continue;
				dp[i+j] = min(dp[i+j],dp[i] + 1);
			}
		}
		
		int result = dp[N];
		if(result == Integer.MAX_VALUE) result = -1;
		System.out.println(result);
	}

}
