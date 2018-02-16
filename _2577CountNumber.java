import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class _2577CountNumber{

	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		String ABC = String.valueOf(A*B*C);
		int[] counts = new int[10];
		for (int i = 0; i < ABC.length(); i++) {			
			counts[Integer.parseInt(String.valueOf(ABC.charAt(i)))]++;
		}
		
		for (int i = 0; i <10; i++) {
			System.out.println(counts[i]);
		}
	}	

}
