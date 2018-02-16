import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1316 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int TT = Integer.parseInt(br.readLine());
		int count = TT;
		for (int tt = 1; tt <= TT; tt++) {
			boolean[] visited = new boolean[26];
			String s = br.readLine();
			char prev = s.charAt(0);
			visited[prev-'a'] = true;
			
			for (int i = 1; i < s.length(); i++) {
				if(prev == s.charAt(i)) continue;
				prev = s.charAt(i);
				if(visited[prev-'a']) {
					count--;
					break;
				}
				visited[prev-'a'] = true;
			}
		}
		System.out.println(count);
	}

}
