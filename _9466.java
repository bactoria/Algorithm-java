import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _9466 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		final int TT = Integer.parseInt(br.readLine());

		for (int tt = 1; tt <= TT; tt++) {
			int n = Integer.parseInt(br.readLine());
			boolean[] visited = new boolean[n + 1];
			int count = 0;
			int[] student = new int[n + 1];
			List<Integer> curStudent = new ArrayList<Integer>();

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) {
				student[i] = Integer.parseInt(st.nextToken());
			}

			// i = 학생번호
			for (int i = 1; i < student.length; i++) { // 1번학생부터 가보즈아
				if (visited[i])
					continue;

				int nextS = i;
				int curS;
				int tempC = 0; // curStudent.size()
				while (true) {
					curS = nextS;
					visited[curS] = true;
					curStudent.add(curS);
					tempC++;
					nextS = student[curS];
					if (visited[nextS]) {
						if (curStudent.contains(nextS))
							count += curStudent.indexOf(nextS);
						else
							count += tempC;
						break;
					}
				}
				curStudent.clear();
			}
			sb.append(count + "\n");
		}
		System.out.println(sb.toString());
	}

}
