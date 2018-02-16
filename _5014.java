import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _5014 {
	static class Node{
		int count;
		int stair;
		Node(int c, int s){
			count = c;
			stair = s;
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int F = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int U = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		boolean[] visited = new boolean[F + 1];
		
		Queue<Node> q = new LinkedList<Node>();

		
		q.add(new Node(0,S));

		while (!q.isEmpty()) {
			Node curN = q.poll();
			int curS = curN.stair;
			
			if(curS == G) {
				System.out.println(curN.count);
				return;
			}
			int nextC = curN.count + 1;
			int nextU = curS + U;
			int nextD = curS - D;
			
			
			if (nextU <= F) {
				if (!visited[nextU]) {
					visited[nextU] = true;
					q.add(new Node(nextC,nextU));
				}
			}
			
			if(nextD > 0) {
				if(!visited[nextD]) {
					visited[nextD] = true;
					q.add(new Node(nextC,nextD));
				}
			}

		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write("use the stairs");
		bw.flush();

	}

}
