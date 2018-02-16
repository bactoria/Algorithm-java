import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author : Juno Hwang (sbukkk)
 * @date   : 2018. 1. 27.
 *  https://github.com/bactoria/BOJ/
 *  https://www.acmicpc.net/problem/1504
 *  
	fromAtoB �� �ּҰ��� ���ϰ�.
	1. fromStart toA + fromB toEnd
	2. fromStart toB + fromA toEnd 
	�ΰ� �߿� �ּҰ��� ���ؼ� fromAtoB�� ���ϸ� �ȴ�.
 */
public class _1504Dijkstra {

	private int[][] graph;
	private int N;
	private int E;

	public int[] dijkstra(int point) {
		boolean[] visited = new boolean[N + 1];
		int[] distence = new int[N + 1];
		Arrays.fill(distence, Integer.MAX_VALUE);
		int cur = point;
		distence[point] = 0;
		while (true) {
			// ���� �湮
			visited[cur] = true;
			for (int i = 1; i <= N; i++) {
				if (graph[cur][i] != 0) { // cur �� ����
					if (distence[i] > graph[cur][i] + distence[cur]) {
						distence[i] = graph[cur][i] + distence[cur];
					}
				}
			}
			// distence �ּ� ���� ���ϱ�
			int min = Integer.MAX_VALUE;
			for (int i = 1; i <= N; i++) {
				if (visited[i]) continue; // �̹� �湮

				if (min > distence[i]) {
					min = distence[i];
					cur = i;
				}
			}
			if (min == Integer.MAX_VALUE) //���̻� �湮������ ������ ���ٸ� return
				return distence;
		}
	}

	// ������
	_1504Dijkstra() throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		//�������� �Է¹ޱ�
		graph = new int[N + 1][N + 1];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int tempI = Integer.parseInt(st.nextToken());
			int tempJ = Integer.parseInt(st.nextToken());
			int tempValue = Integer.parseInt(st.nextToken());
			graph[tempI][tempJ] = tempValue;
			graph[tempJ][tempI] = tempValue;
		}
		//A,B �Է¹ޱ�
		st = new StringTokenizer(br.readLine());
		int pointA = Integer.parseInt(st.nextToken());
		int pointB = Integer.parseInt(st.nextToken());
		
		//���ͽ�Ʈ�� ������
		int[] dijkstraA = dijkstra(pointA);
		int[] dijkstraB = dijkstra(pointB);
		
		int AtoB = dijkstraA[pointB]; // = dykstraB[pointA]
		int temp1 = dijkstraA[1]+dijkstraB[N];
		int temp2 = dijkstraB[1]+dijkstraA[N];
		if(dijkstraA[1] == Integer.MAX_VALUE || dijkstraB[N] == Integer.MAX_VALUE) temp1 = Integer.MAX_VALUE;
		if(dijkstraB[1] == Integer.MAX_VALUE || dijkstraA[N] == Integer.MAX_VALUE) temp2 = Integer.MAX_VALUE;
		int minSum = Math.min(temp1,temp2);

		//������ �� ���� ���
		if(dijkstraA[pointB] == Integer.MAX_VALUE || minSum == Integer.MAX_VALUE) { 
			System.out.println(-1);
			return;
		}
		
		//���� �� ��� ���
		System.out.println(AtoB + minSum);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		new _1504Dijkstra();
	}
}
