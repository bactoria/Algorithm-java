DP로 풀 수 있는문제임.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10942 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[] array = new int[N+1];
		for (int i = 1; i <= N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		final int M = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			if(S>E) {
				int temp = S;
				S = E;
				E = temp;
			}
			
			int temp = (E-S+1)/2;
			int result = 1;
			for (int j = 0; j < temp; j++) {
				if(array[S+j] != array[E-j]) {
					result = 0;
					break;
				}
			}
			sb.append(result+"\n");
		}
		System.out.println(sb.toString());
	}
}
