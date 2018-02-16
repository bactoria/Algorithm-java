import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class _11651Sort2 {

	static class Node implements Comparable<Node> {
		int x;
		int y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.y > o.y? 1 : this.y < o.y ? -1 : this.x > o.x ? 1 : -1;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		List<Node> list = new ArrayList<Node>();

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list.add(new Node(x, y));
		}

		/*Collections.sort(list, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.y > o2.y ? 1 : ((o1.y < o2.y) ? -1 : ((o1.x > o2.x) ? 1 : -1));
			}
		});*/
		
		Collections.sort(list);
		
		for (int i = 0; i < N; i++) {
			Node curN = list.get(i);
			sb.append(curN.x + " " + curN.y + "\n");
		}
		System.out.println(sb.toString());
	}
}
