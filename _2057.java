import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2057 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		long result = 1;
		long count = 1;
		String s = "YES";
		while(!(N==result)) {
			count++;

			if(result > N/count) {
				s = "NO";
				break;
			}
			
			result *= count;
		}
		System.out.println(s);
	}
}
