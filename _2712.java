import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author : Juno Hwang (sbukkk)
 * @date   : 2018. 1. 29.
 *  https://github.com/bactoria/BOJ/
 *  https://www.acmicpc.net/problem/2712
 *  
 *  String.format("%.4d",value)
 *  Math.round(...
 */
public class _2712 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		final double TO_LB = 2.2046;
		final double TO_KG = 0.4536;
		final double TO_G = 0.2642;
		final double TO_L = 3.7854;
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			double value = Double.parseDouble(st.nextToken());
			String w = st.nextToken();
			
			switch (w) {
			//kg -> lb
			case "kg":
				System.out.println(String.format("%.4f lb",value*TO_LB));
				break;
			//lb-> kg
			case "lb":
				System.out.println(String.format("%.4f kg",value*TO_KG));
				break;
			//l -> g	
			case "l":
				System.out.println(String.format("%.4f g",value*TO_G));
				break;
			//g -> l	
			case "g":
				System.out.println(String.format("%.4f l",value*TO_L));
				break;
			}
		
		}
	}

}
