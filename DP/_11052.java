package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11052 {
	public static int max(int a, int b) {
		return (a > b ? a : b);
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] cost = new int[n+1];
		
		for (int i = 1; i <= n; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
 		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= i/2; j++) {
				cost[i] = max(cost[i],cost[j] + cost[i-j]);
			}
		}
		
		System.out.println(cost[n]);
	}

}
