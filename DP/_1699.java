package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1699 {
	public static int min(int a, int b) {
		return a < b ? a : b;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N+1];
		
		int root = (int)Math.sqrt(N) / 1 ;
		
		
		//제곱수배열 넣어놓기
		int[] doubleRoot = new int[root+1];
		for (int i = 1; i <= root; i++) {
			doubleRoot[i] = i*i;
		}
		
		//초기화 ( 제곱수에 1 넣기)
		for (int i = 1; i <= root; i++) {
			dp[doubleRoot[i]] = 1;
		}
		
		for (int i = 1; i <= N; i++) {
			int min = i-1;
			
			for (int j = 1; j<= root; j++) {
				if(i<doubleRoot[j]) break;
				
				min = min(min,dp[i-doubleRoot[j]]);
			}
			dp[i] = min+1;
		}
		System.out.println(dp[N]);
	}
}
