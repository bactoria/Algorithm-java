import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author : Juno Hwang (sbukkk)
 * @date   : 2018. 2. 2.
 *  https://github.com/bactoria/BOJ/
 *  https://www.acmicpc.net/problem/4312
 *  
 */
public class _4312BigInteger {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		List<Integer> list = new ArrayList<>();
		while (true) {
			Long n = Long.parseLong(br.readLine()) - 1 ;
			if (n == -1)
				break;
			if(n==0) {
				sb.append("{ }\n");
				continue;
			}
			
			sb.append("{ ");

			while (n >= 1) {
				int count = 0;
				long tempN = n;
				while(tempN>1) {
				tempN=(tempN>>1);
				count++;
				}
				n-= (long) Math.pow(2, count);
				list.add(count);
			}
			Collections.sort(list);
			for (int i : list) {
				BigInteger a = BigInteger.ONE;
				BigInteger b = new BigInteger("3");
				for (int j = 0; j < i; j++) {
					a = a.multiply(b);
				}
				sb.append(a + ", ");
			}
			sb.delete(sb.length()-2,sb.length());
			sb.append(" }\n");
			list.clear();
		}
		System.out.println(sb.toString());
	}
}