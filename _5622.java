import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _5622 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int[] alp = { -1, -1, -1, 3, 6, 9, 12, 15, 19, 22, 26 };
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < alp.length; j++) {
				if (s.charAt(i) - 'A' < alp[j]) {
					count += j;
					break;
				}
			}
		}
		System.out.println(count);
	}
}