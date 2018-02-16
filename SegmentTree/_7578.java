package SegmentTree;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author : Juno Hwang (sbukkk)
 * @date   : 2018. 2. 8.
 *  https://github.com/bactoria/BOJ/
 *  https://www.acmicpc.net/problem/7578
 *  
 */
public class _7578 {

	static class STree{
		int[] tree;
		
		//»ý¼ºÀÚ
		STree(final int N){
			int height = (int)Math.ceil(Math.log10(N) / Math.log10(2)) + 1;
			tree = new int[2<<height];
		}
		
		public void process(int index, int start, int end , int searchL, int searchR) {
			if(searchR < start || end < searchL) return;
			if (start >= searchL && end <= searchR) tree[index] += 1;
			else {
				process(index*2, start,(start+end)/2,searchL,searchR);
				process(index*2+1, (start+end)/2+1,end,searchL,searchR);
			}
		}
		
		public int find(int index, int start, int end, int leaf) {
			if(leaf < start || end < leaf) return 0;
			if(start == end) return tree[index];
			return find(index*2,start,(start+end)/2,leaf) + find(index*2+1,(start+end)/2+1,end,leaf) + tree[index];
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		final int N = Integer.parseInt(br.readLine());
		int[] firstLine = new int[1000001];
		int[] order = new int[N+1];
		long result = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int j = 1; j <= N; j++)	firstLine[Integer.parseInt(st.nextToken())] = j;

		st = new StringTokenizer(br.readLine());
		for (int j = 1; j <= N; j++) 	order[j] = firstLine[Integer.parseInt(st.nextToken())];

		STree sTree = new STree(N);
		for (int j = 1; j <= N; j++) 	{
			sTree.process(1,1,N,1,order[j]-1);
			result += sTree.find(1,1,N,order[j]);
		}
		System.out.println(result);
	}
}
