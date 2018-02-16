package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2293 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		final int N = Integer.parseInt(st.nextToken());
		final int K = Integer.parseInt(st.nextToken());
		int cost[] = new int[N+1];
		int dp[][] = new int[N+1][K+1];
		
		for (int i = 1; i <= N; i++) {			
			cost[i] = Integer.parseInt(br.readLine());
		}
		
		for (int k = 1; k <= K; k++) {
			for (int n = 1; n <= N; n++) {
				int temp = 0;
				if(k == cost[n]) {dp[n][k]++; continue;}
				if(k<cost[n]) continue;
				for (int i = 1; i <= n; i++) {					
				temp += dp[i][k-cost[n]];
				}
				dp[n][k] = temp;
			}
		}
		
		int sum=0;
		for (int i = 1; i <= N; i++) {
			sum+=dp[i][K];
		}
		
		System.out.println(sum);
	}
}