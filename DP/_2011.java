package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author : Juno Hwang (sbukkk)
 * @date   : 2018. 2. 9.
 *  https://github.com/bactoria/BOJ/
 *  https://www.acmicpc.net/problem/2011
 *  
 */ //ÇïÆÄÆ¼³×
public class _2011 {
	private static String s;
	
	public static int toInt(int i) {
		return s.charAt(i) - '0';
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s = br.readLine();
		int[] dp = new int[s.length()+1];
		dp[0] = 1 ;
		dp[1] = 1 ;
		
		
		if(s.charAt(0) == '0') {
			System.out.println(0);
			return;
		}

		for (int i = 2; i <= s.length(); i++) {
			int count = toInt(i-2) * 10 + toInt(i-1);
			if( count == 0) {
				System.out.println(0);
				return;
			}
			if( count == 10 || count == 20) dp[i] = dp[i-2]; 
			else if( count < 10 ) dp[i] = dp[i-1];
			else if(toInt(i-1) == 0) {
				System.out.println(0);
				return;
			}
			else if( count <= 26 ) dp[i] = dp[i-1] + dp[i-2];
			else dp[i] = dp[i-1];
			
			dp[i] %= 1000000;
		}
		System.out.println(dp[s.length()]);
	}
}
