/* https://www.acmicpc.net/problem/4948

베르트랑 공준은 임의의 자연수 n에 대하여, n보다 크고, 2n보다 작거나 같은 소수는 적어도 하나 존재한다는 내용을 담고 있다.

이 명제는 조제프 베르트랑이 1845년에 추측했고, 파프누티 체비쇼프가 1850년에 증명했다.

예를 들어, 10보다 크고, 20보다 작거나 같은 소수는 4개가 있다. (11, 13, 17, 19) 또, 14보다 크고, 28보다 작거나 같은 소수는 3개가 있다. (17,19, 23)

n이 주어졌을 때, n보다 크고, 2n보다 작거나 같은 소수의 개수를 구하는 프로그램을 작성하시오.

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int MAX_N = 123456;

        // 에라토스테네스의 체 (28 ~ 37)
        boolean[] isPrime = new boolean[MAX_N * 2 + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        IntStream.rangeClosed(2, MAX_N)
                .filter(i -> isPrime[i] == true)
                .forEach(i -> {
                    for (int j = i * 2; j <= MAX_N * 2; j += i) isPrime[j] = false;
                });


        while (true) {
            final int N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            System.out.println(IntStream.rangeClosed(N + 1, N * 2)
                    .filter(x -> isPrime[x] == true)
                    .count());
        }

    }
}
