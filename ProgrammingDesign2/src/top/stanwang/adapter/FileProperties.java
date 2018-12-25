package top.stanwang.adapter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class FileProperties implements FileIO {

	private Properties properties;

	public FileProperties() {
		properties = new Properties();
	}

	@Override
	public void readFromFile(String filename) throws IOException {
		File file = new File(filename);
		FileInputStream fis = new FileInputStream(file);
		properties.load(fis);
		fis.close();
	}

	@Override
	public void writeToFile(String filename) throws IOException {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		String dateStr = sdf.format(date);
		File file = new File(filename);
		FileOutputStream fos = new FileOutputStream(file);
		properties.store(fos, "written by FileProperties\n"+dateStr);
		fos.close();
	}

	@Override
	public void setValue(String key, String value) {
		properties.put(key, value);
	}

	@Override
	public String getValue(String key) {
		return properties.getProperty(key);
	}
}
