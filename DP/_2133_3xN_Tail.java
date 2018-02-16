package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2133_3xN_Tail {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(br.readLine());
		
		
		int[] dp = new int[N+1];
		
		if(N<3) {
			System.out.println((N*3)-3);
			return;
		}
		
		//ÃÊ±âÈ­
		dp[0] = 1;
		dp[2] = 3;
		
		for (int i = 3; i <= N; i++) {
			dp[i] = dp[i-2]*3;
			
			int curI = i-4;
			while(curI >= 0) {
				dp[i] += 2 * dp[curI];
				curI -= 2;
			}
		}
		
		System.out.println(dp[N]);
	}
}