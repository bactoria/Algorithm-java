import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2920cdefgabC {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		final String ASCENDING = "12345678";
		final String DESCENDING = "87654321";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 8; i++) 
			sb.append(st.nextToken());
		if(sb.toString().equals(ASCENDING)) System.out.println("ascending");
		else if(sb.toString().equals(DESCENDING)) System.out.println("descending");
		else System.out.println("mixed");
	}
}
