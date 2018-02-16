import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @author : Juno Hwang (sbukkk)
 * @date   : 2018. 2. 13.
 *  https://github.com/bactoria/BOJ/
 *  https://www.acmicpc.net/problem/5461
 * 
 *  모토 : List , PQ를 이용
 *  		List와 Level에 노동자번호 추가해서 정렬
 *  		(List에 Level로 정렬)
 *  		(PQ에 K 값 역순 정렬)
 *  
 *  		K값 높은것부터 최대노동자 수 구함
 *  		처음에 PQ두개 썼는데
 *  		노동자 번호 추적하려고 List로 바꿈
 */

public class _5461 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	//	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\PC\\Desktop\\ioi2009_tests\\Day 1\\hiring\\hiring.024.in"));
		//BufferedReader br2 = new BufferedReader(new FileReader("C:\\Users\\PC\\Desktop\\ioi2009_tests\\Day 1\\hiring\\hiring.005.sol"));
		
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		final int N = Integer.parseInt(st.nextToken());
		final long MY_MONEY = Long.parseLong(st.nextToken());
		StringBuilder sb = new StringBuilder(0);
		
		List<Integer[]> listOfLevel = new ArrayList<>(); // [0] : level     [1] : index
		PriorityQueue<Double[]> pqOfRatio = new PriorityQueue<>((o1,o2) ->  o2[0] > o1[0] ? 1 : o2[0] == o1[0] ? 0 : -1 ); // [0] : ratio     [1] : index
		
		int[] level = new int[N+1];	
		boolean[] selected = new boolean[N+1];
		boolean[] failed = new boolean[N+1];
		
		// scan
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int tempPrice = Integer.parseInt(st.nextToken());
			int tempLevel = Integer.parseInt(st.nextToken());
			double tempRatio = tempPrice / (double)tempLevel ;
			listOfLevel.add(new Integer[] {tempLevel,i});
			pqOfRatio.add(new Double[] {tempRatio,(double)i});
			level[i] = tempLevel;
		}
		
		// O(NlogN)
		listOfLevel.sort((o1,o2) -> o1[0] - o2[0] );
		
		
		Double[] tempPQ = pqOfRatio.poll();
		Double k = tempPQ[0];
		int curTotalLevel = 0;
		int prevI = (int) Math.round(tempPQ[1]);
		int count = 0;
		int maxCount = 0;
		int endPoint = -1;
		Double minTotalLevel = Double.MAX_VALUE;
		
		
		for (int i = 0; i < N; i++) {
				if(failed[listOfLevel.get(i)[1]]) continue; //Ratio가 높아서 이미 이용되었으면 Pass
			
				Integer[] tempLevelPQ = listOfLevel.get(i);
				curTotalLevel += tempLevelPQ[0];
				selected[tempLevelPQ[1]] = true; //selected : 일하는노동자
				count++; //selected 순회하기엔 시간이 모자랄거같아서 카운트하자
				
				while(curTotalLevel * k > MY_MONEY) { //나누기보다 곱셈연산
					if(selected[prevI]) { //선택된 노동자라면
						count--; // 카운트빼준다
						curTotalLevel -= level[prevI]; // 비용빼준다
						selected[prevI] = false;
					}
					failed[prevI] = true; //pqOfLevel 에서 선택되지못하게 거른다
					
					tempPQ = pqOfRatio.poll();
					k = tempPQ[0];
					prevI = (int) Math.round(tempPQ[1]);
				}
				
				//Max
				if (maxCount <= count ) {
					if(maxCount == count) if(minTotalLevel < curTotalLevel * k) continue;
					
					maxCount = count;
					minTotalLevel = curTotalLevel * k; 
					endPoint = i;
					
					int tempC = maxCount;

					sb = new StringBuilder();
					//sb.append(maxCount).append("\n");
					//while(tempC-->0) {
					//	while(!selected[listOfLevel.get(endPoint)[1]]) endPoint--;
					//	sb.append(listOfLevel.get(endPoint--)[1]).append("\n");
					//}
					
			}
		}
			
		//print
		System.out.println(sb.toString());
	}
}