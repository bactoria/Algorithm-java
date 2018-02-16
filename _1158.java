import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * @author : Juno Hwang (sbukkk)
 * @date   : 2018. 2. 11.
 *  https://github.com/bactoria/BOJ/
 *  https://www.acmicpc.net/problem/1158
 *  
 *  joining ���ٷ� �ذ��� �� �޸� 12240 / �ð� 260MS
 *  StringBuilder ���� �޸� 8884 / �ð� 120MS
 */
public class _1158 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		
		final int N = Integer.parseInt(st.nextToken());
		final int M = Integer.parseInt(st.nextToken());
	
		List<Integer> list = new LinkedList<Integer>();
		
		for (int i = 1; i <= N; i++)	list.add(i);
		
		List<Integer> result = new LinkedList<Integer>();
		
		int point = -1, listLen;
		while(!list.isEmpty()) {
			point += M;
			listLen = list.size();
			while(point >= listLen) point -= listLen; 
			
			result.add(list.remove(point));
			point--;
		}
		StringBuilder sb = new StringBuilder("<");
		while(!result.isEmpty()) sb.append(result.remove(0)).append(", ");
		sb.delete(sb.length()-2, sb.length()).append(">");
		
		System.out.println(sb.toString());
	}

}
