package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author : Juno Hwang (sbukkk)
 * @date   : 2018. 2. 1.
 *  https://github.com/bactoria/BOJ/
 *  https://www.acmicpc.net/problem/6593
 *  BFS
 *  inRange 대신에 외곽에다가 사이즈를 하나씩 더 추가했음.
 *  간편한것 같으면서도 잔실수가 나올확률이 높아짐.
 */
public class _6593 {

	static class Node{
		int l;
		int r;
		int c;
		int count;
		Node(int l, int r, int c, int count){
			this.l = l;
			this.r = r;
			this.c = c;
			this.count = count;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int[] dx = {1,-1,0,0,0,0};
		int[] dy = {0,0,1,-1,0,0};
		int[] dz = {0,0,0,0,-1,1};
		
		while (true) {
			st = new StringTokenizer(br.readLine());
			final int L = Integer.parseInt(st.nextToken());
			final int R = Integer.parseInt(st.nextToken());
			final int C = Integer.parseInt(st.nextToken());
			
			boolean[][][] visited = new boolean[L+2][R+2][C+2];
			if (L == 0 && R == 0 && C == 0) {
				break;
			}
			
			char[][][] map = new char[L+2][R+2][C+2];
			int startA=0,startB=0,startC=0;
		
			for (int l = 1; l < L+1; l++) {
				for (int r = 1; r < R+1; r++) {
					map[l][r][0] = '#';
					map[l][r][C+1] = '#';
					String s = br.readLine();
					for (int c = 1; c <= C; c++) {
						map[l][r][c] = s.charAt(c-1);
						if(map[l][r][c] == 'S') {startA = l; startB = r; startC = c;};
					}
				}
				br.readLine();
			}
			
			Queue<Node> q = new LinkedList<>();
			q.add(new Node(startA,startB,startC,0));
			
			boolean arrived = false;
			while(!q.isEmpty()) {
				Node cur = q.poll();
				int curl = cur.l;
				int curr = cur.r;
				int curc = cur.c;
				int curCount = cur.count;
				
				for (int i = 0; i < 6; i++) {
					int nextl = curl+dx[i];
					int nextr = curr+dy[i];
					int nextc = curc+dz[i];
					int nextCount = curCount+1;
					if(visited[nextl][nextr][nextc]) continue;
					if(map[nextl][nextr][nextc]== '.' ) {
						q.add(new Node(nextl,nextr,nextc,nextCount));
						visited[nextl][nextr][nextc] = true;
					}
					else if(map[nextl][nextr][nextc]== 'E') {
						sb.append("Escaped in "+nextCount+" minute(s).\n");
						q.clear();
						arrived = true;
					}
				}
			}
			if(!arrived) sb.append("Trapped!\n");
		}
		System.out.println(sb.toString());
	}
}
