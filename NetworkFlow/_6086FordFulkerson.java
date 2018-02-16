package NetworkFlow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author : Juno Hwang (sbukkk)
 * @date   : 2018. 1. 30.
 *  https://github.com/bactoria/BOJ/
 *  https://www.acmicpc.net/problem/6086
 *  	by Edmonds-Karp Algorithm  O(VE^2)
 */
public class _6086FordFulkerson {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		final int N = Integer.parseInt(br.readLine());
		int[][] c = new int[52][52];
		int[][] f = new int[52][52];
		int totalFlow = 0;
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int temp1 = st.nextToken().charAt(0) - 'A';
			int temp2 = st.nextToken().charAt(0) - 'A';
			if(temp1 > 25) temp1-=6;
			if(temp2 > 25) temp2-=6;
			int tempV = Integer.parseInt(st.nextToken());
			c[temp1][temp2] += tempV;
		}
		
		
		while(true) {
			Queue<Integer> q = new LinkedList<Integer>();
			int[] trace = new int[52];
			Arrays.fill(trace, -1);
			//A노드 큐에 넣기
			q.add(0);
			
			while(!q.isEmpty()) {
				int cur = q.poll();
				if(cur == 25) break;
				for (int i = 1; i < 52; i++) {
					int next = i;
					if(trace[next] > -1) continue; //이미 방문했다면 continue
					if(c[cur][next] == f[cur][next]) continue; //용량보다 흐른게 더 크다면 continue
					trace[next] = cur;
					q.add(next);
				}
			}
				//'Z'까지 방문을 못했을 경우 break;
				if(trace[25] == -1) break;

				int flow = Integer.MAX_VALUE;
				for (int i = 25; i != 0; i=trace[i] )  flow = Math.min(flow, c[trace[i]][i] - f[trace[i]][i]);
				for (int i = 25; i != 0; i=trace[i] )  f[trace[i]][i] += flow;
				for (int i = 25; i != 0; i=trace[i] )  f[i][trace[i]] -= flow; //이거빼먹으면 안됨. (테스트케이스 통과는 됨)
				totalFlow += flow;
		}
		System.out.println(totalFlow);
	}
}