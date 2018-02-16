import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class _14864 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		final int N = Integer.parseInt(st.nextToken());
		final int M = Integer.parseInt(st.nextToken());
		boolean[] hasNumber = new boolean[N+1];
		
		int count[] = new int[N+1];
		for (int i = 1; i <= N; i++) count[i] = i;
		
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			count[Integer.parseInt(st.nextToken())]++;
			count[Integer.parseInt(st.nextToken())]--;
		}
		for (int j = 1; j <= N; j++) {
			if(hasNumber[count[j]] == true) {
				System.out.println(-1);
				return;
			}
			hasNumber[count[j]] = true;
		}
		
		IntStream.of(count).filter(i-> i != 0).forEach(i-> sb.append(i+" "));
		System.out.println(sb.toString());
	}
}
