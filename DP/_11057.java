package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _11057 {
	public static int sum(int[] count) {
		int sum=0;
		for (int i : count) {
			sum += i;
		}
		return sum % 10007;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(br.readLine());
		int[] count = new int[10];
		Arrays.fill(count, 1);
		
		if(N==1) {
			System.out.println(sum(count));
			return;
		}
		
		for (int n = 2; n <= N; n++) {

			for (int i = 1; i <= 9; i++) {
				count[i] += count[i-1];
				count[i] %= 10007;
			}
		}
		System.out.println(sum(count));
	}
}
