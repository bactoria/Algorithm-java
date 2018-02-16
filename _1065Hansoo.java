import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1065Hansoo {

	public void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(br.readLine());
		int[] c = new int[3];
		int count = N;

		for (int i = 1; i <= N; i++) {
			String s = String.valueOf(i);
			
			if(s.length()>2) {
				c[0] = Integer.parseInt(String.valueOf(s.charAt(0))) - Integer.parseInt(String.valueOf(s.charAt(1)));
				
				for (int j = 1; j <= s.length()-2; j++) {	
				if(c[0] != Integer.parseInt(String.valueOf(s.charAt(j))) - Integer.parseInt(String.valueOf(s.charAt(j+1)))){
					count--;
					break;
				}
			}
			}
		}
		System.out.println(count);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		_1065Hansoo s = new _1065Hansoo();
		s.solve();
	}

}
