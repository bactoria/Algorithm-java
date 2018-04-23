package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2294 {
	public static int min(int a, int b) {
		return a<b? a : b;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] cost = new int[n];
		int[] dp = new int[k+1];
		
		for (int i = 0; i < n; i++) {
			cost[i] = Integer.parseInt(br.readLine());
		}
		Arrays.fill(dp, -1);
		dp[0]  = 0;

		for (int i = 1; i <= k; i++) { //dp[i]
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < n; j++) { //cost[j]
 				int temp = i-cost[j];
				if(temp < 0 || dp[temp]<0) continue;
				min= min(dp[temp]+1,min);
			}
			if(min != Integer.MAX_VALUE) dp[i] = min;
		}
		System.out.println(Arrays.toString(dp[k]));
	}

}
