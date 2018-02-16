package DFS;

import java.util.Scanner;

public class _2250TreeHeightWidth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution_2250 s = new Solution_2250();
		s.solve();
	}
}

 class Solution_2250 {
	int N;
	Node[] node;
	int[] width;
	int widthCal = 1;
	int heightCal = 1;
	int[] height;
	int[] minValue;
	int[] maxValue;
			public void solve() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		node = new Node[N];
		width = new int[N + 1];
		height = new int[N + 1];
		minValue = new int[N+1];
		maxValue = new int[N+1];
		for (int i = 0; i < N; i++) {
			node[i] = new Node(sc.nextInt(), sc.nextInt(), sc.nextInt());
			}
		for (int i = 0; i <= N; i++) {
			minValue[i] = N;
		}
		
		DFS(node[0]);
		
		int max = 0;
		int ll=0;
		/*ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= N; i++) {   //i 는 높이임
			for (int j = 1; j <= N; j++) {
				if(i == height[j]) {
					list.add(width[j]);
				}
		}
			if(list.size()>0) {
			Collections.sort(list);
			int temp = list.get(list.size()-1) - list.get(0) + 1; //면적이므로 1 더함
			if(max < temp ) {
				max = temp;
				ll = i;
			}
			list.removeAll(list);
			}
		}*/
		for (int i = 0; i <= N; i++) {
			if(max< ( maxValue[i]-minValue[i]+1 )) {
				max = maxValue[i]-minValue[i]+1;
				ll = i;
			}
		}
		System.out.printf("%d %d",ll,max);
	}

	void DFS(Node node) {
		height[node.nowN] = heightCal;
		for (int j = 0; j < N; j++) {
			if (node.leftN == this.node[j].nowN) {
				heightCal++;
				DFS(this.node[j]);
				heightCal--;
			}
		}
		width[node.nowN] = widthCal;
		if(minValue[height[node.nowN]] > width[node.nowN]) {
			minValue[height[node.nowN]] = width[node.nowN];
		}
		if(maxValue[height[node.nowN]] < width[node.nowN]) {
			maxValue[height[node.nowN]] = width[node.nowN];
		}
		widthCal++;
		
		for (int j = 0; j < N; j++) {
			if (node.rightN == this.node[j].nowN) {
				heightCal++;
				DFS(this.node[j]);
				heightCal--;
			}
		}
	}

	static class Node {
		int nowN, leftN, rightN;

		Node(int nowN, int leftN, int rightN) {
			this.nowN = nowN;
			this.leftN = leftN;
			this.rightN = rightN;
		}
	}
}
