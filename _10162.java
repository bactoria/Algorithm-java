import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author : Juno Hwang
 * @date : 2018. 1. 26. https://github.com/bactoria/BOJ/
 * 
 * 
 */
public class _10162 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		int buttonA = 300;
		int buttonB = 60;
		int buttonC = 10;
		int countA = 0;
		int countB = 0;
		int countC = 0;

		if (t % buttonC != 0) {
			System.out.println(-1);
			return;
		}

		if (t >= buttonA) {
			countA = (t / buttonA);
			t %= buttonA;
		}
		if (t >= buttonB) {
			countB = (t / buttonB);
			t %= buttonB;
		}
		if (t >= buttonC) {
			countC = (t / buttonC);
		}

		System.out.println(countA + " " + countB + " " + countC);
	}

}
