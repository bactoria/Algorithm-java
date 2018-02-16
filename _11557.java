import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11557 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		final int TT = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int tt = 1; tt <= TT; tt++) {
			int N = Integer.parseInt(br.readLine());
			String maxN = null;
			int maxV = Integer.MIN_VALUE;
			
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				String tempN = st.nextToken();
				int tempV = Integer.parseInt(st.nextToken());
				if(maxV < tempV) {
					maxV = tempV;
					maxN = tempN;
				}
			}
			
			sb.append(maxN+"\n");
		}
		System.out.println(sb.toString());
	}

}
