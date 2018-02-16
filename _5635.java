import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author : Juno Hwang (sbukkk)
 * @date   : 2018. 1. 28.
 *  https://github.com/bactoria/BOJ/
 *  

 */
public class _5635 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(br.readLine());
		
		String maxP = null;
		String minP = null;
		int maxBirth = Integer.MAX_VALUE;
		int minBirth = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String tempP = st.nextToken();
			int tempBirth =0;
			tempBirth += Integer.parseInt(st.nextToken());
			tempBirth += Integer.parseInt(st.nextToken())*100;
			tempBirth += Integer.parseInt(st.nextToken())*10000;
			
			if(maxBirth > tempBirth) {
				maxBirth = tempBirth;
				maxP = tempP;
			}
			if(minBirth < tempBirth) {
				minBirth = tempBirth;
				minP = tempP;
			}
		}
		System.out.println(minP);
		System.out.println(maxP);
	}
}
