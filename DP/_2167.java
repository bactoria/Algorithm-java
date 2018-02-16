package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _2167 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String ss = br.readLine();
		String[] s = ss.split(" ");
		final int N = Integer.parseInt(s[0]);
		final int M = Integer.parseInt(s[1]);
		int[][] cost = new int[N+1][M+1];
		
		for (int i = 1; i <= N; i++) {
			ss = br.readLine();
			for (int j = 1; j <= M; j++) {
				s = ss.split(" ");
				cost[i][j] = Integer.parseInt(s[j-1]) + cost[i][j-1] + cost[i-1][j]-cost[i-1][j-1];
			}
		}

		final int K = Integer.parseInt(br.readLine());
		
		for (int z = 0; z < K; z++) {
			ss = br.readLine();
			s = ss.split(" ");
			int i = Integer.parseInt(s[0]);
			int j = Integer.parseInt(s[1]);
			int x = Integer.parseInt(s[2]);
			int y = Integer.parseInt(s[3]);
			
			System.out.println(cost[x][y] - cost[x][j-1] - cost[i-1][y] + cost[i-1][j-1]);
		}
		
		
		
		
	}

}
