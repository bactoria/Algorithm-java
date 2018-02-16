import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author : PC
 * @date   : 2018. 1. 26.
 *   문제        : 체스판
 *  남길 말      : 

 */
public class _1100 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[][] chesse = new char[8][8];
		int count = 0;
		for (int i = 0; i < 8; i++) chesse[i] = br.readLine().toCharArray();
		
		for (int i = 0; i < chesse.length; i++) {
			for (int j = 0; j < chesse.length; j++) {
				if(( (i+j) & 1 ) != 0) continue;
				if(chesse[i][j] != 'F') continue;
				count++;
			}
		}
		System.out.println(count);
	}	
}