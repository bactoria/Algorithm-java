package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _11053 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(br.readLine());
		int[] cost = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] dist = new int[N];
		
		for (int i = 0; i < N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N; i++) {
			dist[i] = 1;
			for (int j = 0; j < i; j++) {
				if(cost[i] > cost[j]) {
					dist[i] = dist[i] > dist[j] ? dist[i] : dist[j] +1;
				}
			}
		}
		
		Arrays.sort(dist);
		
		System.out.println(dist[N-1]);
	}

}
