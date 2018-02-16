import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1021 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// 첫째줄 입력
		st = new StringTokenizer(br.readLine());
		final int N = Integer.parseInt(st.nextToken());
		final int M = Integer.parseInt(st.nextToken());
		// 둘째줄 입력
		int[] info = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			info[i] = Integer.parseInt(st.nextToken());
		}

		int result = 0;
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			q.add(i);
		}

		int cur = 0;
		for (int i = 0; i < M; i++) {
			int point = info[i];
			int count = 0;
			int temp;

			while (true) {
				if ((temp = q.poll()) == point) {
					break;
				} else {
					q.add(temp);
				}
				count++;
			}

			result += Math.min(count, q.size() - count+1);
		}
		System.out.println(result);
	}

}
