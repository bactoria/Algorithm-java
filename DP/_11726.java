package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.plaf.synth.SynthSplitPaneUI;

public class _11726 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(br.readLine());
		int[] array = new int[N+1];
		if (N < 3) {
			System.out.println(N);
			return;
		} else {
			array[1] = 1;
			array[2] = 2;
			for (int i = 3; i <= N; i++) {
				array[i] = array[i-1] + array[i-2];
				if(array[i]>100000000) 	array[i] %= 10007;
			}
			array[N] %= 10007;
			System.out.println(array[N]);
		}

	}

}
