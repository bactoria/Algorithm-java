package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2748 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		final int N = Integer.parseInt(br.readLine());
		long[] array = new long[N+1];
		
		if(N<=2) {
			System.out.println(1);
			return;
		}
		array[0] = 0;
		array[1] = 1;
		for (int i = 2; i <= N; i++) {
			array[i] = array[i-1] + array[i-2];
		}
		
		System.out.println(array[N]);
	}

}
