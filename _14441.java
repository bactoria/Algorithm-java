
//180121 강변 스타벅스
//14441번 문제.
//못풀겟다
// 도라이네
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class _14441 {

	private static int N;
	private static int K;
	private static int M;
	private static char[][] graph;
	private static boolean[] visited;
	private static int depth;
	private static int firstnode;
	private static List<Integer> list;
	private static int[] count;
	private static int[] cal;
	public static void DFS(int node) {

		if (node == firstnode) {
			count[depth]++;
			return;
		}	
		
		if(depth == 0) {
			firstnode = node;
		}
		
		for (int i = 0; i < N; i++) {
			if(visited[node]) continue;
			if (graph[node][i] == 'Y') {
				visited[node] = true;
				depth++;
				DFS(i);
				depth--;
				visited[node] = false;
			}
			}
		}


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new char[N][N];
		visited = new boolean[N];
		list = new ArrayList<Integer>();
		count = new int[N+1];
		cal = new int[K];
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				graph[i][j] = s.charAt(j);
			}
		}

		// DFS
		for (int node = 0; node < N; node++) {
			firstnode = -1;
			list.clear();
			DFS(node);
			System.out.println(Arrays.toString(count));
		}
		
		
	}
}