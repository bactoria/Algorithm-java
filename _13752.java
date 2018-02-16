import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _13752 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			int cur = Integer.parseInt(br.readLine());
			for (int j = 0; j < cur; j++) sb.append("=");
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
