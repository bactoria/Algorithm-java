import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author : PC
 * @date   : 2018. 1. 25.
 *   문제        : 약수구하기
 *  남길 말      : hashmap으로구하면 더 빠를까?

 */
public class _2501 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		final int N = Integer.parseInt(st.nextToken());
		final int K = Integer.parseInt(st.nextToken());
		List<Integer> list = new ArrayList<Integer>();
		double rootN = (double) Math.sqrt(N);
				
		for (int i = 1; i <= rootN; i++) {
			if(( N % i) == 0 ) {
				list.add(i);
				if(i != rootN) list.add(N/i);
			}
		}
		
		Collections.sort(list);
		if(list.size() < K) System.out.println(0);
		else System.out.println(list.get(K-1));
	}

}
