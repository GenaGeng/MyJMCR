package top.stanwang.state;

public class Main {
	public static void main(String[] args) {
		SafeFrame frame = new SafeFrame("sample");
		while(true) {
			for(int i = 0; i < 24; i++) {
				frame.setClock(i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
