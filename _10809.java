import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10809 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringBuilder sb = new StringBuilder();
		int[] alphabet = new int[26];
		for (int i = 0; i < alphabet.length; i++) {
			alphabet[i] = -1;
		}
		
		for (int i = 0; i < s.length(); i++) {
			if(alphabet[s.charAt(i)-'a'] != -1) continue;
			alphabet[s.charAt(i)-'a'] = i;
		}
		for (int i : alphabet) {
			sb.append(i+" ");
		}
		
		System.out.println(sb.toString());
	}

}
