import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * @author : Juno Hwang (sbukkk)
 * @date   : 2018. 1. 29.
 *  https://github.com/bactoria/BOJ/
 *  https://www.acmicpc.net/problem/2318
 *  사원정렬하기
 *  소트 후 binarySearch 이용하여 시간복잡도 단축
 *  
 */
public class _2318BinarySearch {

	
	private static int[][] person;

	public static int[] binarySearch(final int id,int left, int right) {
		
		int cur = (left+right)/2;
		int curV = person[cur][0];
		if(id==curV) {
			return  new int[] {person[cur][3],person[cur][4]};
		}
		//사원없는경우
		if(left==right) {
			return null;
		}
		
		// >>탐색
		if(id > curV) {
			return binarySearch(id,cur+1,right);
		
		//<<탐색
		}else {
			return binarySearch(id,left,cur-1);
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		final int N = Integer.parseInt(st.nextToken());
		final int M = Integer.parseInt(st.nextToken());
		person = new int[N][5]; //0:사원ID 1:급여 2:기간 3:상사 4:부하수
		for (int i = 0; i < N; i++) {  // 0 ~ N-1
			st = new StringTokenizer(br.readLine());
			person[i][0] = Integer.parseInt(st.nextToken());  //ID
			person[i][1] = Integer.parseInt(st.nextToken());  //급여
			person[i][2] = Integer.parseInt(st.nextToken());  //기간
		}
		
		//급여순으로 정렬
		Arrays.sort(person,new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]-o2[1]; 
			}
		});
		
		for (int i = 0; i < N-1 ; i++) {
			for (int j = i+1; j < N; j++) {
				if(person[i][1] == person[j][1]) continue; // 급여같으면 상사가 아니다
				if(person[i][2] <= person[j][2]) { //일한기간이 크거나같아야 한다.
					person[i][3] = person[j][0]; //상사정보 넣기
					person[j][4] += person[i][4]+1; //부하수 채우기
					break;
				}
			}
		}		
		
		//사원ID순으로 정렬
		Arrays.sort(person,new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0]; 
			}
		});
		
		for (int i = 0; i < M; i++) {
			
			int[] result = binarySearch(Integer.parseInt(br.readLine()),0,N-1);
			sb.append(result[0]+" "+result[1]+"\n");
		}
		System.out.println(sb.toString());
	}
}
