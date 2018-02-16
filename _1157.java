import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _1157 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int[] alphabet = new int[26];
		
		for (int i = 0; i < s.length(); i++) {
			int temp = s.charAt(i);
			if(temp < 'a') alphabet[temp-'A']++;
			else alphabet[temp-'a']++;
		}
		int max = 0;
		int value = 100000;
		boolean doubled = false;
		for (int i = 0; i < alphabet.length; i++) {
			if(alphabet[i] > max) {
				max = alphabet[i];
				value = i;
				doubled = false;
			}else if(alphabet[i] == max) doubled = true;
		}
		
		if(doubled) {
			System.out.println('?');
		}else {
			System.out.println((char)('A'+value));
		}
	}

}
