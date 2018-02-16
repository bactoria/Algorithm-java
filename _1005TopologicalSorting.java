import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author : Juno Hwang (sbukkk)
 * @date   : 2018. 1. 31.
 *  https://github.com/bactoria/BOJ/
 *  https://www.acmicpc.net/problem/1005
 *  위상정렬
 *  
 *  참고자료 :
 *  https://m.blog.naver.com/PostView.nhn?blogId=kks227&logNo=220620723528&proxyReferer=https%3A%2F%2Fwww.google.co.kr%2F
 */
public class _1005TopologicalSorting {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int TT = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for (int tt = 1; tt <= TT; tt++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int countOfLeft[] = new int[v+1];
			int[] cost = new int[v+1];
			int[] maxCost = new int[v+1];
			List<Integer>[] list = new ArrayList[v+1];
			for (int i = 0; i < list.length; i++) 	list[i] = new ArrayList<Integer>();
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= v; i++) {
				cost[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 1; i <= e; i++) {
				st = new StringTokenizer(br.readLine());
				//left : 선행자
				int left = Integer.parseInt(st.nextToken());
				//right : 후행자
				int right = Integer.parseInt(st.nextToken());
				list[left].add(right);
				countOfLeft[right] ++;
			}
			int point = Integer.parseInt(br.readLine());
			
			//선행자 개수
			Queue<Integer> q = new LinkedList<Integer>();
			
			//처음에 제일 왼쪽에 있는거 q에 추가.
			for (int i = 1; i <= v ; i++)	{
				if(countOfLeft[i] == 0 ) {
					q.add(i);
					maxCost[i] = cost[i];
				}
			}
				while(countOfLeft[point] > 0) {
					int cur = q.poll();
					for (int next : list[cur]) { 
						countOfLeft[next] --;
						maxCost[next] = Math.max(maxCost[next], (maxCost[cur] + cost[next]));
						if(countOfLeft[next] == 0) q.add(next);
					
					}
			}
				sb.append(maxCost[point]+"\n");
		}
		System.out.println(sb.toString());
	}
}
