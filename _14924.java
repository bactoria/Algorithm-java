import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author : PC
 * @date   : 2018. 1. 26.
 *   문제        : 폰노이만과 파리
 *  남길 말      : 

 */
public class _14924 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		final int S = Integer.parseInt(st.nextToken());
		final int T = Integer.parseInt(st.nextToken());
		final int D = Integer.parseInt(st.nextToken());
		
		System.out.println(D / (S<<1) * T);
		
	}

}
