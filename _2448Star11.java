import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2448Star11 {
	
	
		_2448Star11() throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(br.readLine());
		int k = (int) (Math.log(N/3) / Math.log(2)); 
		StringBuilder[] s = new StringBuilder[N+1]; //s[1~24]
		for (int i = 1; i < s.length; i++) {
			s[i] = new StringBuilder();
		}
		s[1].append("*");
		s[2].append("* *");
		s[3].append("*****");
		int space = 4;
		for (int i = 1; i <= k; i++) {
			for (int j = 1; j <= 3*(int)Math.pow(2,i-1); j++) {
				s[space].append(String.valueOf(s[j]));			
				for (int j2 = 0; j2 < (s[3*(int)Math.pow(2,i-1)-j+1].length()) ; j2++) { String.valueOf(s[space].append(" ")); }
				s[space].append(String.valueOf(s[j]));
				space++;
			}
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = N; j > i; j--) {
			sb.append(" ");
			}
			sb.append(s[i]);
			for (int j = N; j > i; j--) {
				sb.append(" ");
				}
			sb.append("\n");	
		}
		System.out.println(sb.toString());
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		new _2448Star11();
	}

}
