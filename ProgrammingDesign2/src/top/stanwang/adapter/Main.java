package top.stanwang.adapter;

import java.io.IOException;
import java.io.InputStream;

public class Main {
	public static void main(String[] args) {
		FileIO f = new FileProperties();
		String filePath = "D:\\learning_materials\\PrimaryJava\\ProgrammingDesign2\\src\\top\\stanwang\\adapter\\file.txt";
		try {
			f.readFromFile(filePath);
			f.setValue("year", "2018");
			f.setValue("month","12");
			f.setValue("day", "30");
			f.writeToFile(filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

/*
 * 习题 2-1:
 * 		1.使用Print接口作为PrintBanner的引用从语义上表明我只需要这个对象的printWeak和printStrong方法
 * 		2.可以随时用别的实现Print接口的类来代替PrintBanner。
 *	3-1:
 *		
 *  3-2:
 *  	不允许子类重载该方法
 *  3-3:
 * 		把这三个方法的修饰符改成默认
 * 	3-4:
 * 		我们需要在类中实现某些方法，例如函数display。接口不能有实现方法，而抽象类可以。 	
 */
