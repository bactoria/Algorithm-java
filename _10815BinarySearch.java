import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        solution.process();
    }

}

final class Solution {

    private int n, m;
    private int[] card, supposedArray;

    public Solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        card = new int[n];

        for (int i = 0; i < n; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        supposedArray = new int[m];

        for (int i = 0; i < m; i++) {
            supposedArray[i] = Integer.parseInt(st.nextToken());
        }

    }

    public void process() {

        Arrays.sort(card);
        StringBuilder sb = new StringBuilder();

        for (int supossed : supposedArray) {
            int result = 0;
            int start = 0;
            int end = n - 1;

            while (true) {
                int mid = (start + end) / 2;
                if (card[mid] == supossed) {
                    result = 1;
                    break;
                }

                if (card[mid] < supossed) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }

                if (start > end) break;
            }
            sb.append(result + " ");
        }
        System.out.println(sb.toString());
    }
}
