package top.stanwang.bridge;

public class RandomDisplay extends Display {

	public RandomDisplay(DisplayImpl impl) {
		super(impl);
	}

	public void multiDisplay(int times) {
		int a = (int)(Math.random() * times) + 1;
		open();
		for(int i = 0;i < a; i++) {
			print();
		}
		close();
	}
	
	public void countDisplay(int times) {
		open();
		for(int i = 0;i < times; i++) {
			print();
		}
		close();
	}
}
