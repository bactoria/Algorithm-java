package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9251 {
	public static int max(int a, int b) {
		return a > b ? a : b;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		String str2 = br.readLine().trim();
		int length1 = str1.length();
		int length2 = str2.length();
		int[] int1 = new int[length1];
		int[] int2 = new int[length2];
		int[] count = new int[length1];
		int[] tempCount = new int[length1];
		for (int i = 0; i < length1; i++) {
			int1[i] = str1.charAt(i);
		}

		for (int i = 0; i < length2; i++) {
			int2[i] = str2.charAt(i);
		}
		int maxValue = 0;
		for (int i = 0; i < int2.length; i++) {
			for (int j = 0; j < int1.length; j++) {
				if (int2[i] != int1[j])
					continue;
				int max = 0;
				for (int j2 = 0; j2 < j; j2++) {
					max = max(count[j2], max);
				}
				tempCount[j] = max + 1;
				maxValue = (tempCount[j] > maxValue) ? tempCount[j] : maxValue ;
			}
			for (int j = 0; j < tempCount.length; j++) {
				count[j] = tempCount[j];
			}
		}
		
		System.out.println(maxValue);
	}
}
