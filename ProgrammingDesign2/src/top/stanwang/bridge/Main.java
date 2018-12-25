package top.stanwang.bridge;

import java.io.File;

public class Main {
	public static void main(String[] args) {
		File file = new File("D:\\ÎÒµÄÎÄµµ\\Tencent Files\\2481101267\\FileRecv\\UISupport.kt");
		Display rd = new RandomDisplay(new FileDisplayImpl(file));
		rd.display();
		RandomDisplay hd = new RandomDisplay(new HomeWorkDisplayImpl());
		hd.countDisplay(5);
	}
}
