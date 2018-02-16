import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author : PC
 * @date   : 2018. 1. 26.
 *   문제        : 동전개수 구하기
 *  남길 말      : 

 */
public class _5585 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int money = 1000 - Integer.parseInt(br.readLine());
		int count = 0;
		while(money>=500) {
			count++;
			money -= 500;
		}
		
		while(money>=100) {
			count++;
			money -= 100;
		}
		while(money>=50) {
			count++;
			money -= 50;
		}
		while(money>=10) {
			count++;
			money -= 10;
		}
		while(money>=5) {
			count++;
			money -= 5;
		}
		while(money>=1) {
			count++;
			money -= 1;
		}
		
		System.out.print(count);
	}
}