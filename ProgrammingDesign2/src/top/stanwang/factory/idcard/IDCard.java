package top.stanwang.factory.idcard;

import top.stanwang.factory.framework.Product;

public class IDCard extends Product {
	private int id;
	private String owner;
	public IDCard(String owner,int id) {
		System.out.println("����" + owner + "��ID����");
		this.owner = owner;
		this.id = id;
	}
	
	@Override
	public void use() {
		System.out.println("ʹ��"+owner+"��ID����");
	}
	
	public String getOwner() {
		return owner;
	}
	
	public int getId() {
		return id;
	}
}

