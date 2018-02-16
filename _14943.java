import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author : Juno Hwang (sbukkk)
 * @date   : 2018. 1. 29.
 *  https://github.com/bactoria/BOJ/
 *  2017 ¼­°­´ë
 */
public class _14943 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(br.readLine());
		int[] cost = new int[N];
		long count = 0;
		long value = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) cost[i] = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			value += cost[i]; 
			count += Math.abs(value);
		}
		
		System.out.println(count);
	}

}
