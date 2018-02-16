package SegmentTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author : Juno Hwang (sbukkk)
 * @date   : 2018. 2. 10.
 *  https://github.com/bactoria/BOJ/
 *  https://www.acmicpc.net/problem/6549
 *  
 */
public class _6549 {
	private static int[] height;

	static class Node{
		int width;
		int minH;

		public Node(int width, int minH) {
			this.width = width;
			this.minH = minH;
		}

	}
	
	static class SegmentTree {
		Node[] tree;
		
		SegmentTree(int n){
			final int TREE_HEIGHT = (int)Math.ceil(Math.log10(n) / Math.log10(2));
			tree = new Node[2<<TREE_HEIGHT];
		}
		
		public Node init(int index, int start, int end) {
			
			if(start == end) return tree[index] = new Node(1,height[start]);
			
			Node leftN = init(index*2, start, (start+end) / 2 );
			Node rightN = init(index*2+1 , (start+end) / 2 + 1 , end );
			
			int rootWidth = leftN.width + rightN.width;
			int rootMinH = Math.min ( leftN.minH , rightN.minH );
			return tree[index] = new Node (  rootWidth , rootMinH );
		}
		
		
		public Node findMaxArea(int index, int start, int end, int searchL, int searchR) {

			if(searchR < start || end < searchL) 	return new Node(0, Integer.MAX_VALUE);
			else if(searchL <= start && end <= searchR ) return tree[index];
			
			Node leftN = findMaxArea(index*2, start, (start+end)/2, searchL, searchR);
			Node rightN = findMaxArea(index*2+1, (start+end)/2+1, end, searchL, searchR);
			
			int rootWidth = leftN.width + rightN.width;
			int rootMinH = Math.min ( leftN.minH , rightN.minH );

			return new Node(rootWidth, rootMinH);
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		while(true) {
			//st = new StringTokenizer(br.readLine(), " ");
			//int n = Integer.parseInt(st.nextToken());
			int n = 100000;
			if(n == 0) break;
			
			height = new int[n+1];
			for (int i = 1; i <= n; i++) {
				//height[i] = Integer.parseInt(st.nextToken());
				height[i] = i;
			}
			
			SegmentTree sTree = new SegmentTree(n);
			//tree ÃÊ±âÈ­
			sTree.init(1, 1, n);
			
			long maxV = 0;
			Node tempN;
			for (int i = 1; i <= n; i++) {
				for (int j = i; j <= n; j++) {
					tempN = sTree.findMaxArea(1,1,n,i,j);
					maxV = Math.max(maxV , (long)tempN.minH * tempN.width);
				}
			}
			
			sb.append(maxV+"\n");	
		}
		System.out.println(sb.toString());
	}
}
