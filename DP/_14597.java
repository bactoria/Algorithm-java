package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author : Juno Hwang (sbukkk)
 * @date   : 2018. 1. 29.
 *  https://github.com/bactoria/BOJ/
 *  https://www.acmicpc.net/problem/14597
 *  University > 아주대학교 > 2017 아주대학교 프로그래밍 경시대회 (APC) Division 1 C2번
 */
public class _14597 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		final int N = Integer.parseInt(st.nextToken());
		final int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N+1][M+2];
		int[][] dp = new int[N+1][M+2];
		for (int i = 1; i <= N; i++) {
			dp[i][0] = Integer.MAX_VALUE;
			dp[i][M+1] = Integer.MAX_VALUE;
		}
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = (int)Math.pow(map[i][j] - Integer.parseInt(st.nextToken()),2);
			}
		}
		for (int i = 1; i <=N; i++) {
			for (int j = 1; j <= M; j++) {
				dp[i][j] = Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]),dp[i-1][j+1]) + map[i][j];
			}
		}
		
		int ans = Integer.MAX_VALUE;
		for (int i = 1; i <= M; i++) {
			ans = Math.min(dp[N][i],ans);
		}
		System.out.println(ans);
		
		//System.out.println(Arrays.stream(dp[N]).min().getAsInt());
	}
}
