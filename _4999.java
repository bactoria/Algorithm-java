import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author : PC
 * @date   : 2018. 1. 25.
 *   문제        : ahhhhhhh!
 *  남길 말      : 

 */
public class _4999 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int me = br.readLine().length();
		int doctor = br.readLine().length();
		
		if(me >= doctor) System.out.println("go");
		else System.out.println("no");
	}
}
