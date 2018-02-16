import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * @author : Juno Hwang (sbukkk)
 * @date   : 2018. 2. 6.
 *  https://github.com/bactoria/BOJ/
 *  https://www.acmicpc.net/problem/1620
 *  
 */
public class _1620BinarySearch {
	private static int N;
	private static int M;
	private static Node[] arrS;
	private static Node[] arrI;
	static StringBuilder sb = new StringBuilder();
	
	static class Node {
		String str;
		int num;
		Node(){}
		Node(String str, int num){
			this.str = str;
			this.num = num;
		}
	}
	
	public static void ItoS(int temp) {
		int left = 0;
		int right = N-1;
		
		while(left <= right) {
			int cur = (left+right) /2;
			Node curN = arrI[cur];
			if(curN.num == temp) {
				sb.append(curN.str+"\n");
				break;
			}else if(curN.num> temp) {
						right = cur-1;
			}else {
				left = cur+1;
			}
		}
	}
	
	public static void StoI(String temp) {
		
		int left = 0;
		int right = N-1;
		while(left <= right) {
			int cur = (left+right) /2;
			Node curN = arrS[cur];
			if(curN.str.equals(temp)) {
				sb.append(curN.num+"\n");
				break;
			}else if(curN.str.compareTo(temp) >0) {
						right = cur-1;
			}else {
				left = cur+1;
			}
		}
	}
	
	public static void sorting() {
		Arrays.sort(arrS,new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.str.compareTo(o2.str);
			}
		});
		
		Arrays.sort(arrI,new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.num - o2.num;
			}
		});
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arrS = new Node[N];
		arrI = new Node[N];
		
		for (int i = 0; i < N; i++) {
			arrS[i] = new Node();
			arrI[i] = arrS[i];
		}
		
		for (int i = 0; i < N; i++) {
			arrS[i].str = br.readLine().trim();
			arrI[i].str = arrS[i].str;
			arrS[i].num = i+1;
			arrI[i].num = i+1;
		}
		
		sorting();
		
		for (int i = 0; i < M; i++) {
			String temp = br.readLine().trim();
			if(temp.charAt(0)<58) ItoS(Integer.parseInt(temp));
			else StoI(temp);
		}
		System.out.println(sb.toString());
		}
	}
