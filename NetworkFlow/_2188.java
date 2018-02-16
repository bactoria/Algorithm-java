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
 *  https://www.acmicpc.net/problem/2188
 *  
 */
public class _2188 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		final int N = Integer.parseInt(st.nextToken());
		final int M = Integer.parseInt(st.nextToken());
		final int SINK = N+M+1;
		int [][] cap = new int[N+M+2][N+M+2];
		int [][] flow = new int[N+M+2][N+M+2];
		Arrays.fill(cap[0], 1,N+1,1);
		for (int i = N+1; i <= N+M; i++) 	cap[i][SINK] = 1;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine()); 	
			st.nextToken();
			while(st.hasMoreTokens()) cap[i][N+Integer.parseInt(st.nextToken())] = 1;
		}
		
		//Source : 0
		//소 : 1~N
		//축사 : N+1 ~ N+M
		//Sink : SINK
		int count = 0;
		while(true) {
			int tempC = count;
			Queue<Integer> q = new LinkedList<Integer>();
			int[] prev = new int[N+M+2];
			Arrays.fill(prev, -1);
			
			prev[0] = Integer.MAX_VALUE;
			for (int i = 1; i <= N; i++) {
				prev[i] = 0;
				if(flow[0][i] == 0) q.add(i);
			}
			while(!q.isEmpty()) {
				int cur = q.poll();
				for (int next = 1; next <= SINK; next++) {
					if(cur == next) continue;
					if(cap[cur][next] - flow[cur][next] <=0) 	continue;
					if(prev[next] <= 0) prev[next] = cur; //축사를 방문안했거나 소일 경우
					else continue; //이미 방문했으면 add안한다.
					
					//arrived at SINK
					if(prev[SINK] != -1) {
						q.clear();
						count++;
						break;
					}
					
					q.add(next);
				}
			}
			
			if(tempC == count) break;
			
			for (int i = SINK; i != 0; i = prev[i]) {
				int next = i;
				int cur = prev[i];
				flow[cur][next] += 1;
				if(cur!=0) flow[next][cur] -= 1;
			}
		}//end While(true)
		System.out.println(count);
	}
}
