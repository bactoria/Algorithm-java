계속 런타임에러뜸

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2061Sosu {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		final int K = Integer.parseInt(st.nextToken());
		final int L = Integer.parseInt(st.nextToken());
		
		int rootK = (int) Math.sqrt(K);
		boolean[] Sosu = new boolean[rootK + 1];
		Arrays.fill(Sosu, true);
		
		for (int i = 2; i <= rootK; i++) {
			if (!Sosu[i]) continue; // 소수라면 진행

			// K 가 소수로 나눠떨어지면
			if (K % i == 0) {
				if (i >= L) {
					System.out.println("GOOD");
					return;
				} else {
					System.out.println("BAD");
					System.out.println(i);
					return;
				}
			} else {
				for (int j = 2; i * j <= rootK; j++) {
					Sosu[i * j] = false;
				}
			}
		}
		System.out.println("BAD");
		System.out.println(K);
	}
}
