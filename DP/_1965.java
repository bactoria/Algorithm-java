package DP;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class _1965 {
	public static int max(int a, int b) {
		return a > b ? a : b;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(br.readLine());
		int[] cost = new int[N];
		int[] dp = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
		int maxValue = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if(cost[i] <= cost[j]) continue;
				
				dp[i] = max(dp[i],dp[j]);
			}
			dp[i]++;
			if(maxValue < dp[i]) maxValue = dp[i];
		}
		System.out.println(maxValue);
	}
}
