import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author : PC
 * @date   : 2018. 1. 25.
 *   문제        : 햄버거 가격구하기
 *  남길 말      : 단순노가다

 */
public class _5543 {

	public static int min(int a, int b) {
		return a < b ? a : b;
	}
	public static int min(int a, int b, int c) {
		if(a > b) 
			if(b > c) return c;
			else return b;
		else if(a > c) return c;
		else return a;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] sell = new int[5];
		
		for (int i = 0; i < sell.length; i++) {
			sell[i] = Integer.parseInt(br.readLine());
		}
		System.out.println(min(sell[0],sell[1],sell[2])+min(sell[3],sell[4])-50);
	}
}
