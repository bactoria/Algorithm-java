package SegmentTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author : Juno Hwang (sbukkk)
 * @date   : 2018. 2. 7.
 *  https://github.com/bactoria/BOJ/
 *  https://www.acmicpc.net/problem/2042
 *  
 */
public class _2042 {

	private static long[] a;
	private static int N;
	private static int COUNT;


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		//첫째줄 입력
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		COUNT = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
		
		a = new long[N+1];
		for (int i = 1; i <= N; i++)	a[i] = Long.parseLong(br.readLine());
		
		final int HEIGHT = (int) Math.ceil(Math.log10(N) / Math.log10(2)) + 1 ;
		final int COUNT_NODE = (int) Math.pow(2, HEIGHT) ;
		
		SegmentTree sTree = new SegmentTree(COUNT_NODE);
		sTree.init(1,1,N);
		//sTree.print();
		
		for (int i = 1; i <= COUNT; i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			
			if(first==1) { //Update
				int second = Integer.parseInt(st.nextToken());
				long third = Long.parseLong(st.nextToken());
				long changedValue = third - a[second];
				a[second] = third;
				sTree.update(1, second, changedValue,1,N);
				//sTree.print();
				
			}else if(first == 2) { //Sum
				int left = Integer.parseInt(st.nextToken());
				int right = Integer.parseInt(st.nextToken());
				long result = sTree.sum(1,1,N,left,right);
				sb.append(result+"\n");
			}else break;//Error
		}
		//출력
		System.out.println(sb.toString());
	}
	
	static class SegmentTree{
		private long[] Tree;
		
		SegmentTree(final int COUNT_NODE){
			Tree = new long[COUNT_NODE];
		}
		
		public long init(int node,int start,int end) {
			if(start == end) return Tree[node] = a[start];
			else return Tree[node] = init(node * 2 , start , (start + end) / 2 ) + init( node*2 + 1 , (start + end) / 2 + 1 , end) ;
		}
		
		public void print() {
			System.out.println(Arrays.toString(Tree));
		}
		
		public void update(final int node, final int index, final long changedValue,final int start,final int end) {
			if(index < start || index > end) return;
			Tree[node] += changedValue;
			if( start != end){
				update(node*2, index, changedValue, start,(start+end)/2);
				update(node*2+1, index, changedValue, (start+end)/2+1,end);
			}
		}

		public long sum(final int node, final int start , final int end , final int left , final int right) {
			if(end < left || start > right) return 0;
			if(start >= left && end <= right) return Tree[node];
			return sum(node*2,start,(start+end)/2,left,right) + sum(node*2+1,(start+end)/2 +1, end, left, right);
		}
	}
}
