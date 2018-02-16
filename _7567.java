import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author : Juno Hwang (sbukkk)
 * @date   : 2018. 1. 30.
 *  https://github.com/bactoria/BOJ/
 *  https://www.acmicpc.net/problem/7567
 *  
 */
public class _7567 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] c = br.readLine().toCharArray();
		int height = 10;
		
		for (int i = 1; i < c.length; i++) {
			if(c[i] == c[i-1]) height += 5;
			else height += 10;
		}
		System.out.println(height);
	}

}
