import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author : Juno Hwang (sbukkk)
 * @date   : 2018. 2. 13.
 *  https://github.com/bactoria/BOJ/
 *  https://www.acmicpc.net/problem/14614
 *  
 */
public class _14614 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st;
			st = new StringTokenizer(br.readLine(), " ");
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			String c = st.nextToken();
			
			//c°¡ Â¦¼öÀÏ¶§
			int lastOfC = c.charAt(c.length()-1) - '0';
			if((lastOfC&1) == 0) { 
				System.out.println(a);
				return;
			}
			
			int result = 0;
			int cur = 1;
			while( a + b != 0 ) {
			if(( a & 1 ) + ( b & 1 ) == 1) result += cur;
			
			a = a>>1;
			b = b>>1;
			cur = cur<<1;
			}
			
			System.out.println(result);
	}
}