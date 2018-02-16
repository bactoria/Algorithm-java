import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author : Juno Hwang (sbukkk)
 * @date : 2018. 2. 1. https://github.com/bactoria/BOJ/
 *       https://www.acmicpc.net/problem/2581
 * 
 */
public class _2581Sosu {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int START = Integer.parseInt(br.readLine());
		final int END = Integer.parseInt(br.readLine());
		int min = Integer.MAX_VALUE;
		int sum = 0;
		boolean[] sosu = new boolean[10001];
		Arrays.fill(sosu, true);
		sosu[1] = false;
		for (int i = 2; i <= 100; i++) {
			if (!sosu[i])
				continue;

			int count = 2;
			while (true) {
				int temp = i * count++;
				if (temp > 10000)
					break;
				sosu[temp] = false;
			}
		}

		for (int i = START; i <= END; i++) {
			if (sosu[i]) {
				min = Math.min(min, i);
				sum += i;
			}
		}
		if (min == Integer.MAX_VALUE)
			System.out.println(-1);
		else {
			System.out.println(sum);
			System.out.println(min);
		}
	}

}
