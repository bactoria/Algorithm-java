package DP;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author : Juno Hwang (sbukkk)
 * @date   : 2018. 2. 8.
 *  https://github.com/bactoria/BOJ/
 *  https://www.acmicpc.net/problem/1309
 *  
 */
public class _1309 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[N+1][3];
		
		if(N<2) {
			System.out.println(N*3);
			return;
		}
		
		dp[1][0] = 1;
		dp[1][1] = 1;
		dp[1][2] = 1;
		
		for (int i = 2; i <= N; i++) {
			dp[i][0] = dp[i-1][0] + dp[i-1][1] + dp[i-1][2] ;
			dp[i][1] = dp[i-1][0] + dp[i-1][2] ;
			dp[i][2] = dp[i-1][0] + dp[i-1][1] ;
			dp[i][0] %= 9901;
			dp[i][1] %= 9901;
			dp[i][2] %= 9901;
		}
		
		System.out.println((dp[N][0] + dp[N][1] + dp[N][2]) % 9901);
	}

}
