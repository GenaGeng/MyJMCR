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
