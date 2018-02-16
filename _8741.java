import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author : Juno Hwang (sbukkk)
 * @date   : 2018. 2. 6.
 *  https://github.com/bactoria/BOJ/
 *  https://www.acmicpc.net/problem/8741
 *  StringBuilder -> capacity : 16 - 34 - 70 - 142... 2πË¡ı∞°
 */
public class _8741 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sbOne = new StringBuilder();
		StringBuilder sbZero = new StringBuilder();
		final int K = Integer.parseInt(br.readLine());
		for (int i = 1; i <= K; i++)	sbOne.append('1');
		System.out.print(sbOne.toString());
		for (int i = 1; i < K; i++)   	sbZero.append('0');
		System.out.print(sbZero.toString());
	}
}