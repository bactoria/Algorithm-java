import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author : Juno Hwang (sbukkk)
 * @date   : 2018. 1. 29.
 *  https://github.com/bactoria/BOJ/
 *  https://www.acmicpc.net/problem/15351

 */
public class _15351 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		final int N = Integer.parseInt(br.readLine());
		for (int i = 1; i <=N; i++) {
			int score = 0;
			char[] c = br.readLine().toCharArray();
			for (int j = 0; j < c.length; j++) {
				if(c[j] == ' ') continue;
				score += c[j]-'@';
			}
			if(score == 100) sb.append("PERFECT LIFE\n");
			else sb.append(score+"\n");
		}
			System.out.println(sb.toString());
	}
}
