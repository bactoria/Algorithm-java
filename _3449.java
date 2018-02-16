import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _3449 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		final int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			char[] c1 = br.readLine().toCharArray();
			char[] c2 = br.readLine().toCharArray();
			
			int count = 0;
			for (int j = 0; j < c2.length; j++) {
				if(c1[j] != c2[j]) count++;
			}
			sb.append("Hamming distance is "+count+".\n");
		}
		System.out.println(sb.toString());
	}

}
