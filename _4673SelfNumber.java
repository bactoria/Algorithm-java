
public class _4673SelfNumber {

	private boolean[] checked = new boolean[10001];
	
	_4673SelfNumber(){
		final int N = 10000;
		for (int i = 1; i <= N; i++) {
			int temp=0;
			int cur = i;
			
			while(cur != 0) {
				temp += (cur % 10);
				cur /= 10;
			}
			if((i+temp) > 10000 ) continue;
			checked[i+temp] = true;
		}
		
		for (int i = 1; i <= N; i++) {
			if(!checked[i]) System.out.println(i);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new _4673SelfNumber();
	}

}
