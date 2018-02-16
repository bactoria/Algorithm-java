import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author : Juno Hwang (sbukkk)
 * @date   : 2018. 1. 29.
 *  https://github.com/bactoria/BOJ/
 *  https://www.acmicpc.net/problem/15318
 *  
 */
public class _15318 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		final int N = Integer.parseInt(br.readLine());
		int[] a = new int[N];
		long[] b = new long[N];
		int[] d = {1,-1};
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			for (int k = 0; k < N; k++) {
				b[i] += d[k%2] * (k+1) * a[(i+k)%N];
			}
			sb.append(b[i]+" ");
		}
		System.out.println(sb.toString());
	}

}
