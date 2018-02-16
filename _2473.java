import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class _2473 {

	static class Node {
		int first;
		int second;
		int value;

		Node(int first, int second, int value) {
			this.first = first;
			this.second = second;
			this.value = value;
		}

		@Override
		public String toString() {
			return "Node [first=" + first + ", second=" + second + ", value=" + value + "]";
		}

	}

	private static List<Node> calList;
	private static int min, A, B, C;

	public static void binarySearch(int i, int left, int right,int w) {
		int mid = (left + right) / 2;
		Node midN = calList.get(mid);

		if (min > Math.abs(midN.value - i)) {
			min = Math.abs(midN.value - i);
			A = midN.first * w;
			B = midN.second * w;
			C = i*(-w);
		}

		if (midN.value == i) {
			return;
		}
		if (left >= right) {
			return;
		}

		if (midN.value > i) {
			binarySearch(i, left, mid - 1,w);
		} else {
			binarySearch(i, mid + 1, right,w);
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		final int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		List<Integer> minusList = new ArrayList<>();
		List<Integer> plusList = new ArrayList<>();
		calList = new ArrayList<>();

		A = 0;
		B = 0;
		C = 0;

		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			if (temp < 0)
				minusList.add(-temp);
			else
				plusList.add(temp);
		}

		Collections.sort(plusList);
		Collections.sort(minusList);
		int plusMin = Integer.MAX_VALUE;
		int minusMin = Integer.MAX_VALUE;
		if(plusList.size()>=3) {
			A = plusList.get(0);
			B = plusList.get(1);
			C = plusList.get(2);
			plusMin = A+B+C;
		}
		if(minusList.size()>=3) {
			A = -minusList.get(0);
			B = -minusList.get(1);
			C = -minusList.get(2);
			minusMin = -(A+B+C);
		}
		
		min = Math.min(plusMin, minusMin);

		// 마이너스 2개씩 조합
		int listLen = minusList.size();
		if (listLen >= 2) {
			for (int i = 0; i < listLen - 1; i++) {
				int temp = minusList.get(i);
				for (int j = i + 1; j < listLen; j++) {
					calList.add(new Node(temp, minusList.get(j), temp + minusList.get(j)));
				}
			}
			Collections.sort(calList, new Comparator<Node>() {
				@Override
				public int compare(Node o1, Node o2) {
					return o1.value - o2.value;
				}
			});
			for (int i : plusList) {
				if (min == 0)
					continue;
				binarySearch(i, 0, calList.size() - 1,-1);
			}
		}
		calList.clear();

		// 플러스 2개씩 조합
		listLen = plusList.size();
		if(listLen>=2) {
		
		for (int i = 0; i < listLen - 1; i++) {
			int temp = plusList.get(i);
			for (int j = i + 1; j < listLen; j++) {
				calList.add(new Node(temp, plusList.get(j), temp + plusList.get(j)));
			}
		}
		Collections.sort(calList, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.value - o2.value;
			}
		});
		for (int i : minusList) {
			if (min == 0)
				continue;
			binarySearch(i, 0, calList.size() - 1,1);
		}
		}
		int[] result = new int[3];
		result[0] = A;
		result[1] = B;
		result[2] = C;
		Arrays.sort(result);
		
		System.out.println(result[0] +" "+result[1]+" " +result[2]);
	}
}
