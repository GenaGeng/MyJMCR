package top.stanwang.factory.idcard;

import top.stanwang.factory.framework.Product;

public class IDCard extends Product {
	private int id;
	private String owner;
	public IDCard(String owner,int id) {
		System.out.println("制作" + owner + "的ID卡。");
		this.owner = owner;
		this.id = id;
	}
	
	@Override
	public void use() {
		System.out.println("使用"+owner+"的ID卡。");
	}
	
	public String getOwner() {
		return owner;
	}
	
	public int getId() {
		return id;
	}
}

