import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
/**
 * @author : Juno Hwang (sbukkk)
 * @date   : 2018. 2. 11.
 *  https://github.com/bactoria/BOJ/
 *  https://www.acmicpc.net/problem/3425
 *  
 */
interface GoStack {

	public void NUM(Long x);

	public void POP();

	public void INV();

	public void DUP();

	public void SWP();

	public void ADD();

	public void SUB();

	public void MUL();

	public void DIV();

	public void MOD();

	public String[] END();
}



class GoStackImpl implements GoStack {

	List<Long>[] stackList;
	int stackListLen;
	boolean[] isError;
	// »ý¼ºÀÚ
	GoStackImpl(int n,int[] firstV) {
		stackList = new List[n];
		isError = new boolean[n];
		stackListLen = n;
		for (int i = 0; i < n; i++) {
			stackList[i] = new ArrayList<Long>();
			stackList[i].add((long)firstV[i]);
		}
	}

	@Override
	public void NUM(Long x) {
		// TODO Auto-generated method stub
		for (int i = 0; i < stackListLen; i++) {
			stackList[i].add(x);
		}
	}

	@Override
	public void POP() {
		// TODO Auto-generated method stub
		for (int i = 0; i < stackListLen; i++) {
			int sSize = stackList[i].size();
			if(sSize != 0) stackList[i].remove(sSize-1);
			else isError[i] = true;
		}
	}

	@Override
	public void INV() {
		// TODO Auto-generated method stub
		for (int i = 0; i < stackListLen; i++) {
			int sSize = stackList[i].size();
			if(sSize != 0) {
				Long temp = stackList[i].get(sSize-1);
				stackList[i].remove(sSize-1);
				stackList[i].add(temp * -1);
			}else isError[i] = true;
		}
	}

	@Override
	public void DUP() {
		// TODO Auto-generated method stub
		for (int i = 0; i < stackListLen; i++) {
			int sSize = stackList[i].size();
			if(sSize != 0) {
				Long temp = stackList[i].get(sSize-1);
				stackList[i].add(temp);
			}else isError[i] = true;
		}
	}

	@Override
	public void SWP() {
		// TODO Auto-generated method stub
		for (int i = 0; i < stackListLen; i++) {
			int sSize = stackList[i].size();
			if(sSize >= 2) {
				Long tempA = stackList[i].get(sSize-1);
				stackList[i].remove(sSize-1);
				Long tempB = stackList[i].get(sSize-2);
				stackList[i].remove(sSize-2);
				stackList[i].add(tempA);
				stackList[i].add(tempB);
			}else isError[i] = true;
}	
	}

	@Override
	public void ADD() {
		// TODO Auto-generated method stub
		for (int i = 0; i < stackListLen; i++) {
			int sSize = stackList[i].size();
			if(sSize >= 2) { 
				Long tempA = stackList[i].get(sSize-1);
				stackList[i].remove(sSize-1);
				Long tempB = stackList[i].get(sSize-2);
				stackList[i].remove(sSize-2);
				stackList[i].add(tempA+tempB);
			}else {
				isError[i] = true;
			}
			
		}	
	}

	@Override
	public void SUB() {
		// TODO Auto-generated method stub
		for (int i = 0; i < stackListLen; i++) {
			int sSize = stackList[i].size();
			if(sSize >= 2) { 
				Long tempA = stackList[i].get(sSize-1);
				stackList[i].remove(sSize-1);
				Long tempB = stackList[i].get(sSize-2);
				stackList[i].remove(sSize-2);
				stackList[i].add(tempB - tempA);
			}else {
				isError[i] = true;
			}
		}
	}

	@Override
	public void MUL() {
		// TODO Auto-generated method stub
		for (int i = 0; i < stackListLen; i++) {
			int sSize = stackList[i].size();
			if(sSize >= 2) { 
				Long tempA = stackList[i].get(sSize-1);
				stackList[i].remove(sSize-1);
				Long tempB = stackList[i].get(sSize-2);
				stackList[i].remove(sSize-2);
				stackList[i].add(tempA * tempB);
			}else {
				isError[i] = true;
			}
		}	
	}

	@Override
	public void DIV() {
		// TODO Auto-generated method stub
		for (int i = 0; i < stackListLen; i++) {
			int sSize = stackList[i].size();
			if(sSize >= 2) { 
				Long tempA = stackList[i].get(sSize-1);
				stackList[i].remove(sSize-1);
				Long tempB = stackList[i].get(sSize-2);
				stackList[i].remove(sSize-2);
				if(tempA != 0) stackList[i].add(tempB / tempA);
				else isError[i] = true;
			}else isError[i] = true;
		}	
}

	@Override
	public void MOD() {
		// TODO Auto-generated method stub
			for (int i = 0; i < stackListLen; i++) {
				int sSize = stackList[i].size();
				if(sSize >= 2) { 
					Long tempA = stackList[i].get(sSize-1);
					stackList[i].remove(sSize-1);
					Long tempB = stackList[i].get(sSize-2);
					stackList[i].remove(sSize-2);
					if(tempA != 0) stackList[i].add(tempB % tempA);
					else isError[i] = true;
				}else isError[i] = true;
			}	
	}	
	@Override
	public String[] END() {
		// TODO Auto-generated method stub
		String[] temp = new String[stackListLen];
		for (int i = 0; i < stackListLen; i++) {
			if(isError[i]) temp[i] = "ERROR";
			else if(stackList[i].size() != 1) temp[i] = "ERROR";
			else if(Math.abs(stackList[i].get(0)) > 1e9) temp[i] = "ERROR";
			else temp[i] = String.valueOf(stackList[i].get(0));
		}	
		return temp;
	}
}


class _3425 {

	public static void main(String[] args) throws IOException
 {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		while(true) {
			
		List<String> list = new ArrayList<String>();
		String s = null;
		while (!(s = br.readLine()).equals("END")) {
			if(s.equals("QUIT")) {
				System.out.println(sb.toString());
				return;
			}
			list.add(s);
		}
		list.add("END");

		int N = Integer.parseInt(br.readLine());
		int[] firstV = new int[N];
		for (int i = 0; i < N; i++) {
			firstV[i] = Integer.parseInt(br.readLine());
		}
		br.readLine();
		GoStack goStack = new GoStackImpl(N, firstV);

		for (int i = 0; i < list.size(); i++) {
			st = new StringTokenizer(list.get(i));
			String s1 = st.nextToken();

			switch (s1) {
			case "NUM":
				goStack.NUM(Long.parseLong(st.nextToken()));
				break;

			case "POP":
				goStack.POP();
				break;
			
			case "INV":
				goStack.INV();
				break;
			
			case "DUP":
				goStack.DUP();
				break;
			
			case "SWP":
				goStack.SWP();
				break;
			
			case "ADD":
				goStack.ADD();
				break;
			
			case "SUB":
				goStack.SUB();
				break;
			
			case "MUL":
				goStack.MUL();
				break;
			
			case "DIV":
				goStack.DIV();
				break;
			
			case "MOD":
				goStack.MOD();
				break;

			case "END":
				String[] result = goStack.END();
				for (int j = 0; j < result.length; j++) {
					sb.append(result[j]).append("\n");
				}
				break;
			}
		}
		sb.append("\n");
		}
	}
}
