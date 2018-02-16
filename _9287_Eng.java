import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author : PC
 * @date   : 2018. 1. 26.
 *   문제        : Jenga
 *  남길 말      : 

 */
public class _9287_Eng {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		final int TT = Integer.parseInt(br.readLine());
		for (int tt = 1; tt <= TT; tt++) {

			boolean isStanding = true;
			int n = Integer.parseInt(br.readLine());

			for (int i = 0; i < n; i++) {
				String s = br.readLine();
				int c1 = s.charAt(0) - '0';
				int c2 = s.charAt(1) - '0';
				int c3 = s.charAt(2) - '0';
				
				if(c2 == 1) continue;
				if(c1 + c3 == 2) continue;
			
				isStanding = false;
			}
			if (isStanding) sb.append("Case "+tt+": Standing\n");
			else sb.append("Case "+tt+": Fallen\n");
		}
		System.out.println(sb.toString());

	}
}