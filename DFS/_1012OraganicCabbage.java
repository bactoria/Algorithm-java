package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1012OraganicCabbage {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Solution_1012 s = new Solution_1012();
		s.solve();
	}

}

class Solution_1012{
	  private BufferedReader br;
	  private StringTokenizer st;
	       int m; //가로
	int n; //세로
	int k; //배추 갯수
	int[][] bat;
	int[] dx = {-1,0,0,1};
	int[] dy = {0,-1,1,0};
	
	 private boolean inRange(int y, int x) {
	        return 0 > y || y >= n || 0 > x || x >= m;
	    }
	 
	public void DFS(int i, int j) {
		bat[i][j] = 0;
		for (int j2 = 0; j2 < 4; j2++) {			
			if( inRange(i+dx[j2],j+dy[j2] )) continue;
			if(bat[i+dx[j2]][j+dy[j2]] == 0) continue;
				DFS(i+dx[j2],j+dy[j2]);
			}
		}
	
	
	public void solve() throws IOException {
	//	Scanner sc = new Scanner(System.in);
		  br = new BufferedReader(new InputStreamReader(System.in));
		 
			  int T = Integer.parseInt(br.readLine());
	       //  	int T = sc.nextInt();
		int tempH;
		int tempW;
		
		while(T-- > 0) {
			 st = new StringTokenizer(br.readLine());
	            m = Integer.parseInt(st.nextToken());
	            n = Integer.parseInt(st.nextToken());
	            k = Integer.parseInt(st.nextToken());
	          //	m = sc.nextInt();
			//n = sc.nextInt();
			//k = sc.nextInt();
			int result = 0;
			
			bat = new int[n][m];
			for (int i = 0; i < k; i++) {
				   st = new StringTokenizer(br.readLine());
	                tempW = Integer.parseInt(st.nextToken());
	                tempH = Integer.parseInt(st.nextToken());
				bat[tempH][tempW] = 1;
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if(bat[i][j] == 1) {
						DFS(i,j);
						result++;
					}
				}
			}
			System.out.println(result);
		}
	}
}
