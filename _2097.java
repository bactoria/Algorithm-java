import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author : Juno Hwang (sbukkk)
 * @date   : 2018. 1. 28.
 *  https://github.com/bactoria/BOJ/
 *  퐁당퐁당조약돌

 */
public class _2097 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(br.readLine());
		final int rootN = (int) Math.sqrt(N);
		//조약돌 1,2,3,4개 -> 둘레 : 4
		if(N<5) {
			System.out.println(4);
			return;
		}
		
		int result = 4*(rootN-1);
		if( N == rootN * rootN ) {}
		else if(N - (rootN*rootN) > rootN) result += 4;
		else result += 2;
		System.out.println(result);
	}

}
