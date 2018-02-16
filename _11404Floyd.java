import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author : Juno Hwang (sbukkk)
 * @date   : 2018. 1. 30.
 *  https://github.com/bactoria/BOJ/
 *  https://www.acmicpc.net/problem/11404
 *  �÷��̵�˰���
 *  ��������� ���� ����� ���ؾ���.
 *  ���⼭ MAX_VALUE�� ó���������
 *  2
 *  1
 *  1 2 1
 *  �־��� ��
 *  
 *  0 1
 *  0 0
 *  ���;� �ϴµ� 
 *  
 *  0 1
 *  2147483647 0
 *  ����
 *  �̹��� ä���� �̰� �ݿ���Ű�� ������.
 */
public class _11404Floyd {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		final int N = Integer.parseInt(br.readLine());
		final int M = Integer.parseInt(br.readLine());
		
		int[][] graph = new int[N+1][N+1];
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= N; j++) {
				graph[i][j] = Integer.MAX_VALUE;
				if(i==j) graph[i][j] = 0;
			}
		}

		for (int i = 0; i < M; i++) {	
			st = new StringTokenizer(br.readLine());
			int tempI = Integer.parseInt(st.nextToken());
			int tempJ = Integer.parseInt(st.nextToken());
			int tempV = Integer.parseInt(st.nextToken());
			graph[tempI][tempJ] = Math.min(graph[tempI][tempJ], tempV);
		}
		
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if(graph[i][k] == 0 || graph[k][j] == 0) continue;
					if(graph[i][k] == Integer.MAX_VALUE || graph[k][j] == Integer.MAX_VALUE) continue;
					graph[i][j] = Math.min(graph[i][j],graph[i][k]+graph[k][j]);
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				sb.append(graph[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
