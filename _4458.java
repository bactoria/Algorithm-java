import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _4458 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		final int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			char[] c = br.readLine().toCharArray();
			
			if(c[0] >=97) c[0] -= 32;
			
			String s = new String(c);
			sb.append(s+"\n");
		}
		System.out.println(sb.toString());
	}
}
