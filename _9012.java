import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9012 {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int TT = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int tt = 1; tt <= TT; tt++) {
			int count = 0;
			
			String s = br.readLine();
			for (int i = 0; i < s.length(); i++) {
				if(s.charAt(i) == '(') count++;
				else count--;
				
				if(count<0) break;
				
			}
			if(count == 0) sb.append("YES\n");
			else sb.append("NO\n");
		}
		System.out.println(sb.toString());
		
	}

}
