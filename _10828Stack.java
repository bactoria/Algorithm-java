import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10828Stack {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(br.readLine());
		int pointer = -1;
		int[] stack = new int[N];
		
		for (int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			switch(s[0]){
				case "push":
					pointer++;
					stack[pointer] = Integer.parseInt(s[1]);
					break;
				
				case "top":
					if(pointer == -1) {
						System.out.println(-1);
						break;
					}else {
						System.out.println(stack[pointer]);
						break;
					}
				
				case "size":
					System.out.println(pointer+1);
					break;
					
				case "empty":
					if(pointer == -1) System.out.println(1);
					else System.out.println(0);
					
					break;
					
				case "pop":
					if(pointer == -1) System.out.println(-1);
					else {
						System.out.println(stack[pointer]);
						pointer--;
					}
					
					break;
			}
		}
	}

}
