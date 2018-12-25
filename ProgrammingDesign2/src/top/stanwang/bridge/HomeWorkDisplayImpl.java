package top.stanwang.bridge;

import java.util.Arrays;

public class HomeWorkDisplayImpl extends DisplayImpl {
	
	private int index = 0;
	static int []a = {3,2,4,6,5,1};
	
	public static void main(String[] args) {
		Arrays.sort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}	
	}
	

	@Override
	public void rawOpen() {		
	}
	
	@Override
	public void rawPrint() {
		System.out.print('|');
		for (int i = 0; i < index; i++) {
			System.out.print('#');
		}
		System.out.println('-');
		index++;
	}

	@Override
	public void rawClose() {
	}

}
