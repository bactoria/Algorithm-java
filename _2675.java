import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2675 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TT = Integer.parseInt(br.readLine());
		for (int tt = 1; tt <= TT; tt++) {
			StringBuilder sb = new StringBuilder();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int len = Integer.parseInt(st.nextToken());
			String s = st.nextToken();

			for (int i = 0; i < s.length(); i++) {
				for (int j = 0; j < len; j++) {
					sb.append(s.charAt(i));
				}
			}
		System.out.println(sb.toString());
		}
	}
}