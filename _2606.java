import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2606 {

	private static int M;
	private static int N,count;
	private static int[][] sun;
	private static boolean[] visited;
	
	
	public static void DFS(int n) {
		for (int i = 1; i <= N; i++) {
			if(sun[n][i] == 1) {
				if(!visited[i]) {
					visited[i] = true;
					count++;
					DFS(i);
				}
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		 N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		sun = new int[N+1][N+1];
		visited = new boolean[N+1];
		for (int i = 0; i < M; i++) {
			st= new StringTokenizer(br.readLine());
			int tempA = Integer.parseInt(st.nextToken());
			int tempB = Integer.parseInt(st.nextToken());
			
			sun[tempA][tempB] = 1;
			sun[tempB][tempA] = 1;
		}
		count = 0;
		visited[1] = true;
		DFS(1);
		System.out.println(count);
	}

}
