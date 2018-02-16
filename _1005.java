import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class _1005 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;		
		final int TT = Integer.parseInt(br.readLine());
		for (int tt = 1; tt <= TT; tt++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int[] buildCost = new int[n+1];
			boolean[][] graph = new boolean[n+1][n+1];
			int[] max = new int[n+1];
			boolean[] visited = new boolean[n+1];
			st = new StringTokenizer(br.readLine());
			
			for (int i = 1; i <= n; i++)	buildCost[i] = Integer.parseInt(st.nextToken());

			for (int i = 1; i <= k; i++) {
				st = new StringTokenizer(br.readLine());
				int bottom = Integer.parseInt(st.nextToken());
				int cur = Integer.parseInt(st.nextToken());
				graph[cur][bottom] = true;
			}
			
			int topPoint = Integer.parseInt(br.readLine());
			//1~n
			Queue<Integer[]> q = new LinkedList<>();
			
			q.add(new Integer[] {topPoint,0}); //제일 마지막건물 넣기.
			visited[topPoint] = true;
		
			while(!q.isEmpty()){
				Integer[] curN = q.poll();
				int cur = curN[0];
				int depth = curN[1];
				max[depth] = Math.max(max[depth], buildCost[cur]);
				depth++;
				for (int next = 1; next <= n; next++) {
					if(visited[next]) continue;
					if(!graph[cur][next]) continue;
					visited[next] = true;
					q.add(new Integer[] {next,depth});
				}
			}
			sb.append(IntStream.of(max).sum()+"\n");
		}
		System.out.println(sb.toString());
	}
}
