package SegmentTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author : Juno Hwang (sbukkk)
 * @date   : 2018. 2. 7.
 *  https://github.com/bactoria/BOJ/
 *  https://www.acmicpc.net/problem/2357
 *  세그먼트트리
 */
public class _2357 {

	private static int[] a;
	
	static class Node {
		int maxV;
		int minV;
		
		Node(int maxV, int minV){
			this.maxV = maxV;
			this.minV = minV;
		}
	}
	
	static class SegmentTree{
		
		private Node[] Tree;
	
		
		SegmentTree(int N){
			int height = (int)Math.ceil((Math.log10(N)/Math.log10(2))+1); 
			Tree = new Node[2<<height];
		}
		
		
		public Node init(int index, int start, int end) {

			if(start == end) return Tree[index] = new Node(a[start],a[start]);
			Node leftN = init(index*2,start,(start+end)/2);
			Node rightN = init(index*2+1, (start+end)/2 +1, end);
			return Tree[index] = new Node(Math.max(leftN.maxV, rightN.maxV),Math.min(leftN.minV, rightN.minV));
		}
		
		
		public Node findMaxMin(int index, int start, int end, int left, int right) {
			
			if(end < left || right < start) return new Node(Integer.MIN_VALUE,Integer.MAX_VALUE); 
			if(start >= left && end<=right) return Tree[index];
			Node leftN = findMaxMin(index * 2, start, (start+end)/2, left, right);
			Node rightN = findMaxMin(index * 2+1,  (start+end)/2+1, end, left, right);
			return 	new Node(Math.max(leftN.maxV,rightN.maxV), Math.min(leftN.minV, rightN.minV));
		}
		
	}

	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		final int N = Integer.parseInt(st.nextToken());
		final int M = Integer.parseInt(st.nextToken());
		
		//a 삽입
		a = new int[N+1];
		for (int i = 1; i <= N; i++)	a[i] = Integer.parseInt(br.readLine());
		
		//트리 초기화
		SegmentTree sTree = new SegmentTree(N);
		sTree.init(1, 1, N);
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			Node result = sTree.findMaxMin(1,1,N,left,right);
			sb.append(result.minV+" "+result.maxV+"\n");
		}
		
		System.out.println(sb.toString());
	}
}