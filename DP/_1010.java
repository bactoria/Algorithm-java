package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1010 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st ;
		final int TT = Integer.parseInt(br.readLine());
		
		for (int tt = 1; tt <= TT; tt++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			if(M-N < N ) N = M-N;
			
			if(M < 2) {
				sb.append(1+"\n");
				continue;
			}
			
			int[][] combination = new int[M+1][N+1];
			
			for (int i = 0; i <= M; i++) {
				combination[i][0] = 1;
				if(i>N) continue;
				combination[i][i] = 1;
			}

			for (int i = 2; i <= M; i++) {
				for (int j = 1; j <= N; j++) {
					if(i==j) break;
					combination[i][j] = combination[i-1][j-1]+ combination[i-1][j];
				}
			}
			
			sb.append(combination[M][N]+"\n");
		}
		System.out.println(sb.toString());
	}

}
