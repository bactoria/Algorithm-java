package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10844 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(br.readLine());
		int[][] array = new int[2][10];
		array[0][0] = 0;
		for (int i = 1; i < 10; i++) {
			array[0][i] = 1;
		}
		//0 1 1 1 1 1 1 1 1 1
		
		for (int i = 1; i < N; i++) {
			if((i&1) == 1) { //Â¦¼öÀÏ¶§
				array[1][0] = array[0][1];
				array[1][9] = array[0][8];
				for (int j = 1; j <= 8; j++) {
					array[1][j] = array[0][j-1] + array[0][j+1];
					if(array[1][j] >= 1000000000)	array[1][j] %= 1000000000;
				
				}
			}else { //i = 0
				array[0][0] = array[1][1];
				array[0][9] = array[1][8];
				for (int j = 1; j <=8; j++) {
					array[0][j] = array[1][j-1] + array[1][j+1];
					if(array[0][j] >= 1000000000)	array[0][j] %= 1000000000;
				}
			}
		}
		int sum = 0;
		for (int i = 0; i <= 9; i++) {
			if((N&1) == 1) {
				sum += array[0][i];
			}else {
				sum += array[1][i];
			}
			sum%=1000000000;
		}
		
		System.out.println(sum);
		
	}

}
