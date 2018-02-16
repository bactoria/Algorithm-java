import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author : PC
 * @date   : 2018. 1. 25.
 *   문제        : 달팽이는 올라가고싶다.
 *  남길 말      : 

 */
public class _2869 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		final int A = Integer.parseInt(st.nextToken());
		final int B = Integer.parseInt(st.nextToken());
		final int V = Integer.parseInt(st.nextToken());
		
		int newA = A - B ;
		int newV = V - B ;
		
		int count = newV / newA ;
		if(newV % newA != 0) count ++;
		System.out.println(count);
	}
}
