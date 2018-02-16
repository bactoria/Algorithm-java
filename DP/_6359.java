package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _6359 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tt = Integer.parseInt(br.readLine());
		
		while(tt-->0) {
			int n = Integer.parseInt(br.readLine());
			boolean[] isEscaped = new boolean[n+1];
			for (int i = 1; i <= n; i++) {
				for (int j = i; j <= n ; j += i) {
					isEscaped[j] = !isEscaped[j];
				}
			}
			
			int count = 0;
			for (int i = 1; i <= n; i++) {
				if(isEscaped[i]) count++;
			}
			sb.append(count+"\n");
		}
		System.out.println(sb.toString());
	}
}
