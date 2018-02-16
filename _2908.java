import java.io.IOException;

public class _2908 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int[] A = new int[3];
		int[] B = new int[3];
		for (int i = 0; i < A.length; i++) {
			A[i] = System.in.read()-'0';
		}
		System.in.read();
		for (int i = 0; i < B.length; i++) {
			B[i] = System.in.read()-'0';
		}
		int tA = A[0]+A[1]*10+A[2]*100;
		int tB = B[0]+B[1]*10+B[2]*100;
		System.out.println(tA>tB? tA : tB );
	}

}
