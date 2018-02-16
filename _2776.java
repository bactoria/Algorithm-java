import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * @author : PC
 * @date   : 2018. 1. 25.
 *   문제        : 
 *  남길 말      : 

 */

public class _2776 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		final int TT = Integer.parseInt(br.readLine());
		
		for (int tt = 1; tt <= TT; tt++) {
			
			Set<Integer> set = new HashSet<Integer>();
			
			int n = Integer.parseInt(br.readLine());
			st= new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				set.add(Integer.parseInt(st.nextToken()));
			}
			
			int m = Integer.parseInt(br.readLine());
			st= new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
				
				if(set.contains(Integer.parseInt(st.nextToken()))) sb.append("1\n");
				else sb.append("0\n");
			}	
		}
		System.out.println(sb.toString());
	}
}
