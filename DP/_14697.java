package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author : Juno Hwang (sbukkk)
 * @date   : 2018. 1. 29.
 *  https://github.com/bactoria/BOJ/
 *  https://www.acmicpc.net/problem/14697
 *  방배정하기
 *  
 */
public class _14697 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		final int A = Integer.parseInt(st.nextToken());
		final int B = Integer.parseInt(st.nextToken());
		final int C = Integer.parseInt(st.nextToken());
		final int N = Integer.parseInt(st.nextToken());
		
		boolean[] dp = new boolean[N+1];
		
		dp[0] = true;
		
		for (int i = A; i <= N; i++) {
			if(i-A >= 0) dp[i] = dp[i] || dp[i-A];
			if(i-B >= 0) dp[i] = dp[i] || dp[i-B];
			if(i-C >= 0) dp[i] = dp[i] || dp[i-C];
		}
		if(dp[N]) System.out.println(1);
		else System.out.println(0);
	}

}
