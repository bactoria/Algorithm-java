package DP;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11719Print {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(br.readLine());
		int[] sugar = new int[N+1];
		
		for (int i = 0; i < sugar.length; i++) {
			sugar[i] = N;
		}
		
		if(N>=3) sugar[3] = 1;
		if(N>=5) sugar[5] = 1;
		
		for (int i = 0; i < sugar.length; i++) {
			if(i<=5) continue;
			if(sugar[i-3] == N && sugar[i-5] == N) continue;
			sugar[i] = Math.min(sugar[i-3], sugar[i-5]);
			sugar[i]++;
		}
		
			
		if(sugar[N] == N) {
			System.out.println(-1);
		}else {
			System.out.println(sugar[N]);
			}
	}
}
