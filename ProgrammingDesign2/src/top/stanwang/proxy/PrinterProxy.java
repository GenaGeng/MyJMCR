package top.stanwang.proxy;

import java.lang.reflect.Constructor;

public class PrinterProxy implements Printable{
	private String name;
 	private Printer real;
	private String proxy;
	public PrinterProxy(String proxyClass) {
		
	}
	public PrinterProxy(String name,String proxyClass) {
		this.name = name;
	}
	public synchronized void setPrinterName(String name) {
		if(real!=null) {
			real.setPrinterName(name);
		}
		this.name = name;
	}
	@Override
	public String getPrinterName() {
		return name;
	}
	@Override
	public void print(String string) {
		realize();
		real.print(string);		
	}
	
	private synchronized void realize() {
		if(real==null) {
			try {
				Class cls = Class.forName(proxy);
				Constructor cons = cls.getConstructor(String.class);
				real = (Printer) cons.newInstance(name);
			}  catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
