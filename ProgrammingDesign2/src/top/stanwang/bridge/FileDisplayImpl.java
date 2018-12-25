package top.stanwang.bridge;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileDisplayImpl extends DisplayImpl {
	
	private byte bytes[];
	private boolean isFile = false;
	private File file;
	private FileInputStream fis;
	public FileDisplayImpl(File file) {
		this.file = file;
	}

	@Override
	public void rawOpen() {
		if(file.isFile()) {
			try {
				fis = new FileInputStream(file);
				bytes = new byte[(int) file.length()];
				fis.read(bytes);
				} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("文件不存在!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("IO");
			}
			isFile = true;
		} else {
			System.out.println("不是文件！");
		}
	}

	@Override
	public void rawPrint() {
		if(isFile) {
			System.out.println(new String(bytes));
		}
	}

	@Override
	public void rawClose() {
		try {
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
