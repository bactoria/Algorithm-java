import java.awt.AlphaComposite;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


/**
 * @author : PC
 * @date   : 2018. 1. 26.
 *   문제        : Letter Cookies
 *  남길 말      : 2018년 1월 20일 삼성전자 S/W 역량Test A형과 유사. (DFS는 아니지만 알파벳을 중복안되게 저장할 수 있어야 함)

 */
public class _11117_Eng {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		final int TT = Integer.parseInt(br.readLine());
		
		for (int tt = 1; tt <= TT; tt++) {
			
			char[] c = br.readLine().toCharArray();
			int[] alphaC = new int[26];
			int[] tempC = new int[26];
			for (int i = 0; i < c.length; i++) {
				alphaC[c[i]-'A'] ++;
			}
		
			int N = Integer.parseInt(br.readLine());
			for (int i = 0; i < N; i++) {
				
				for (int j = 0; j < 26; j++) alphaC[j] += tempC[j];
				Arrays.fill(tempC, 0);
				
				String s = br.readLine();
				
				boolean possible = true;
				for (int j = 0; j < s.length(); j++) {
					int cur = s.charAt(j)-'A';
					if(alphaC[cur] == 0) {
						sb.append("NO\n");
						possible = false;
						break;
					}
					alphaC[cur]--;
					tempC[cur]++;
				}
				if(possible) sb.append("YES\n");
			}
		}
		System.out.print(sb.toString());
	}
}