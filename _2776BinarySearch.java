import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author : PC
 * @date   : 2018. 1. 25.
 *   문제        : 
 *  남길 말      : 

 */

public class _2776BinarySearch {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		final int TT = Integer.parseInt(br.readLine());
		
		for (int tt = 1; tt <= TT; tt++) {
			
			int n = Integer.parseInt(br.readLine());
			int array[] = new int[n];
			st= new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				array[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(array);
			boolean visited;
			int m = Integer.parseInt(br.readLine());
			st= new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
				
				int cur = Integer.parseInt(st.nextToken());
				int start = 0;
				int end = n-1;
				int mid = (start+end)/2;
				visited = false;
				while(start <= end) {
					if(array[mid] > cur) {
						end = mid-1;
						mid = (start+end)/2;
					}else if(array[mid] < cur) {
						start = mid+1;
						mid = (start+end)/2;
					}else {
						sb.append("1\n");
						visited = true;
						break;
					}				
				}
				if(!visited) sb.append("0\n");
			}
		}
		System.out.print(sb.toString());
	}
}
