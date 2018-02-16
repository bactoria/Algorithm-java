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
 *  ���� : List , PQ�� �̿�
 *  		List�� Level�� �뵿�ڹ�ȣ �߰��ؼ� ����
 *  		(List�� Level�� ����)
 *  		(PQ�� K �� ���� ����)
 *  
 *  		K�� �����ͺ��� �ִ�뵿�� �� ����
 *  		ó���� PQ�ΰ� ��µ�
 *  		�뵿�� ��ȣ �����Ϸ��� List�� �ٲ�
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
				if(failed[listOfLevel.get(i)[1]]) continue; //Ratio�� ���Ƽ� �̹� �̿�Ǿ����� Pass
			
				Integer[] tempLevelPQ = listOfLevel.get(i);
				curTotalLevel += tempLevelPQ[0];
				selected[tempLevelPQ[1]] = true; //selected : ���ϴ³뵿��
				count++; //selected ��ȸ�ϱ⿣ �ð��� ���ڶ��Ű��Ƽ� ī��Ʈ����
				
				while(curTotalLevel * k > MY_MONEY) { //�����⺸�� ��������
					if(selected[prevI]) { //���õ� �뵿�ڶ��
						count--; // ī��Ʈ���ش�
						curTotalLevel -= level[prevI]; // ��뻩�ش�
						selected[prevI] = false;
					}
					failed[prevI] = true; //pqOfLevel ���� ���õ������ϰ� �Ÿ���
					
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