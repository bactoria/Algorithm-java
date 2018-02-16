import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
어렵노
public class _2658 {
	static class Node{
		int x;
		int y;
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}


	private static List<Integer> row;
	private static List<Integer> col;
	private static List<Node> answer;
	private static int[][] map;
	
	public static void findLastAnswer() {
		Node firstA = answer.get(0);
		Node secondA = answer.get(1);
		
		if(row.get(0) != 1) 		answer.add(new Node(secondA.x,firstA.y));
		if(row.get(0) == 1)    	answer.add(new Node(firstA.x,secondA.y));
	}
	
	
	
	public static void checkRow() {
		int lastJ = -1;
		for (int i = 0; i < 10; i++) {
			int count = 0;
			for (int j = 0; j < 10; j++) {
				if(map[i][j] == 1) {
					count += map[i][j];
					lastJ = j;
				}
			}
			if(count == 1) {
				answer.add(new Node(i,lastJ));
			}
			if(count != 0) row.add(count);
		}
	}
	public static void checkCol() {
		int lastI = -1;
		for (int j = 0; j < 10; j++) {
			int count = 0;
			for (int i = 0; i < 10; i++) {
				if(map[i][j] == 1) {
					count += map[i][j];
					lastI = i;
				}
			}
			if(count == 1) answer.add(new Node(lastI,j));
			if(count != 0) col.add(count);
		}
	}
	public static boolean isTri() {
			int temp = row.get(1)-row.get(0);
			System.out.println(row.get(0));
			System.out.println(row.get(1));
			System.out.println(row.get(2));
			System.out.println(row);
			System.out.println("----");
			System.out.println(temp);
		if (!(temp == -1 || temp == 1 || temp == 2 || temp == -2)) return false; 
		for (int i = 1; i < row.size(); i++) {
			if(row.get(i) - row.get(i-1) != temp) return false;
		}
		
		temp = col.get(1)-col.get(0);
		System.out.println(temp);
		System.out.println(temp);
		System.out.println(temp);
		if (!(temp == -1 || temp == 1 || temp == 2 || temp == -2)) return false; 
		for (int i = 1; i < col.size(); i++) {
			if(col.get(i) - col.get(i-1) != temp) return false;
		}
			return true;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		map = new int[10][10];
		answer = new ArrayList<>();
		row = new ArrayList<>();
		col = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			String temp = br.readLine();
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(String.valueOf(temp.charAt(j)));
			}
		}
		checkCol();
		checkRow();
		if(!isTri()) {
			System.out.println(0);
			return;
		}
		
		if(answer.size() == 2) findLastAnswer();
		
		
		//Answer 정렬
		Collections.sort(answer,new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				if(o1.x > o2.x) return 1;
				else if(o1.x < o2.x) return -1;
				else return o1.y-o2.y;
			}
		});
		
		//출력
		System.out.println((answer.get(0).x+1)+" "+ (answer.get(0).y+1));
		System.out.println((answer.get(1).x+1)+" "+ (answer.get(1).y+1));
		System.out.println((answer.get(2).x+1)+" "+ (answer.get(2).y+1));
		}
}
