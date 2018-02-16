import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author : Juno Hwang (sbukkk)
 * @date   : 2018. 1. 29.
 *  https://github.com/bactoria/BOJ/
 *  

 */
public class _2965 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		final int A = Integer.parseInt(st.nextToken());
		final int B = Integer.parseInt(st.nextToken());
		final int C = Integer.parseInt(st.nextToken());
		
		System.out.println(Math.max(B-A-1, C-B-1));
	}

}
