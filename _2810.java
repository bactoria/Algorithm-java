import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2810 {

    private int N;
    private String str;

    _2810() throws IOException {
        init();
        System.out.println(findMaxCup());
    }

    private void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        str = br.readLine();

    }

    private int findMaxCup(){
        int S_Count = 0;
        int L_Count = 0;

        for (int i = 0; i < N; i++) {
            if(str.charAt(i) == 'S') S_Count ++ ;
        }


        L_Count = ( N - S_Count ) / 2 ;

        if(S_Count == N) return S_Count;
        else return S_Count + L_Count + 1;
    }

    public static void main(String[] args) throws IOException {

        new _2810();
    }
}
