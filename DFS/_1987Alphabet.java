package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1987Alphabet {
	private 	BufferedReader br;
	private StringTokenizer st;
	private int height,width,nowDist,maxDist;
	private int[][] array;
	private int[] dx = {-1,0,0,1};
	private int[] dy = {0,-1,1,0};
	private boolean[] visited = new boolean[26];
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		_1987Alphabet main = new _1987Alphabet();
		main.start();
	}
	
	private void start() throws IOException{
		   br = new BufferedReader(new InputStreamReader(System.in));
		   st = new StringTokenizer(br.readLine());
	       height = Integer.parseInt(st.nextToken());
	       width = Integer.parseInt(st.nextToken());
	       array = new int[height][width];
	       nowDist = 0;
	       maxDist = 0;
	       
	       for (int i = 0; i < height; i++) {
	    	   String s = br.readLine();
	    	   for (int j = 0; j < width; j++) {
				array[i][j] = s.charAt(j)-'A';
	    	   }
	       }
	       
	       DFS(0,0);
	    
	       System.out.println(maxDist);
	}
	
	private boolean inRange(int i, int j) {
		return i>=0 && j>=0 && i<height && j<width ;
	}
	
	private void DFS(int i, int j) {
		visited[array[i][j]] = true;
		nowDist++;
		maxDist = Math.max(nowDist, maxDist);
		
		for (int k = 0; k < 4; k++) {
			int nextH = i+dx[k];
			int nextW = j+dy[k];
			if(!inRange(nextH, nextW)) continue;
			if(visited[array[nextH][nextW]]) continue;
			DFS(nextH,nextW);
		}
		
		visited[array[i][j]] = false;
		nowDist--;
	}
	
}
