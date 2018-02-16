package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2156 {
	public static int max(int a, int b, int c) {
		if(a>b) 
			if(a>c)return a;
			else return c;
		else if(b>c) return b;
		else return c;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(br.readLine());
		int[] cost = new int[N];
		int[][] array = new int[N][3];
		
		for (int i = 0; i < N; i++) {
			cost[i] = Integer.parseInt(br.readLine());
		}
		
		if(N==1) {
			System.out.println(cost[0]);
			return;
		}
		array[0][1] = cost[0];
		
		for (int i = 1; i < N; i++) {
			
		array[i][0] = max(array[i-1][1],array[i-1][2],array[i-1][0]);
		array[i][1] = cost[i]+array[i-1][0];
		array[i][2] = cost[i]+array[i-1][1];
		
		}
		
		
		System.out.println(max(array[N-1][0],array[N-1][1],array[N-1][2]));
	}

}
