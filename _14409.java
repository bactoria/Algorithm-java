import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14409 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		final int N = Integer.parseInt(br.readLine());
		final int X = Integer.parseInt(br.readLine());
		int result = 0;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int tempA = Integer.parseInt(st.nextToken());
			int tempB = Integer.parseInt(st.nextToken());
			if(Math.abs(tempA-tempB) > X) {
				result += Integer.parseInt(br.readLine());
			}else {
				result += Math.max(tempA,tempB);
			}
		}
		System.out.println(result);
	}

}
