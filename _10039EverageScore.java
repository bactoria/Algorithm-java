import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10039EverageScore {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum=0;
		for (int i = 0; i < 5; i++) {
			int temp = Integer.parseInt(br.readLine());
			sum += temp>40 ? temp : 40;
		}
		
		System.out.println(sum/5);
	}
}
