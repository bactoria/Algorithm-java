import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author : Juno Hwang (sbukkk)
 * @date   : 2018. 1. 30.
 *  https://github.com/bactoria/BOJ/
 *  https://www.acmicpc.net/problem/11006
 *  
 */
public class _11006 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		final int N = Integer.parseInt(br.readLine());

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int legs = Integer.parseInt(st.nextToken());
			int chiken = Integer.parseInt(st.nextToken());
			int result1 = (chiken<<1)-legs;
			sb.append(result1+" "+(chiken-result1)+"\n");
		}
		System.out.println(sb.toString());
	}
}
