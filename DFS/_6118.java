package DFS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _6118 {
	private static int N;
	private static int M;
	private static int[] depth;
	private static int[][] graph;
	private static int curDepth;
	private static boolean visited[];
	
	public static void DFS(int i) {
		if(curDepth < depth[i]) depth[i] = curDepth;
		
		for (int j = 1; j <= N; j++) {
			if(graph[i][j] == 0) continue;
			if(visited[j]) continue;
			visited[j] = true;
			curDepth++;
			DFS(j);
			curDepth--;
			visited[j] = false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N+1];
		depth = new int[N+1];
		Arrays.fill(depth, Integer.MAX_VALUE);
		graph = new int[N+1][N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int tempI = Integer.parseInt(st.nextToken());
			int tempJ = Integer.parseInt(st.nextToken());
			graph[tempI][tempJ] = 1;
			graph[tempJ][tempI] = 1;
		}
		curDepth = 0;
		DFS(1);
		
		int maxDepth = Integer.MIN_VALUE;
		int maxCount = Integer.MIN_VALUE;
		int maxPoint = Integer.MIN_VALUE;
		
		for (int i = 2; i <= N; i++) {			
			if(maxDepth < depth[i]) {
				maxDepth = depth[i];
				maxCount = 1;
				maxPoint = i; 
			}
			else if(maxDepth == depth[i]) {
				maxCount++;
			}
		}
		System.out.println(maxPoint+" "+maxDepth+" " + maxCount);
	}

}
