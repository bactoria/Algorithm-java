import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author : Juno Hwang (sbukkk)
 * @date   : 2018. 1. 31.
 *  https://github.com/bactoria/BOJ/
 *  https://www.acmicpc.net/problem/9950
 *  
 */
public class _9950 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		while(true) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(a == 0 && b == 0 && c == 0) break;
			if(a == 0) a = c/b;
			if(b == 0) b = c/a;
			if(c == 0) c = a*b;

			sb.append(a+" "+b+" "+c+"\n");
		}
	System.out.println(sb.toString());
	}
}
