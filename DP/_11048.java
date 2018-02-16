package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _11048 {
	public static int max(int a, int b) {
		return a>b? a: b;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		final int N = Integer.parseInt(st.nextToken());
		final int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			int max = Integer.MIN_VALUE;
			for (int j = 0; j < M; j++) {
				if(i>0 && j>0) max = max(map[i-1][j-1], max);
				if(i>0) max = max(map[i-1][j], max);
				if(j>0) max = max(map[i][j-1], max);
				
				if(max!= Integer.MIN_VALUE) map[i][j] += max;
			}
		}
		
		System.out.println(map[N-1][M-1]);
	}

}
