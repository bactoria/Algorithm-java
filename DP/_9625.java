package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author : Juno Hwang (sbukkk)
 * @date   : 2018. 1. 28.
 *  https://github.com/bactoria/BOJ/
 *	https://www.acmicpc.net/problem/9625  

 */
public class _9625 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(br.readLine());
		
		int dp[] = new int[N+1];
		if(N == 1) {
			System.out.println("0 1");
			return;
		}
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		System.out.println(dp[N-2] + " "+ dp[N-1]);
	}
}
