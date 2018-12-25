package top.stanwang.factory.idcard;

import java.util.Map;

import top.stanwang.factory.framework.Creator;
import top.stanwang.factory.framework.Product;

public class IDCardFactory extends Creator {
	
	private IDCardFactory() {
		
	}

	private static int id = 0;
	public Map<Integer,String> idMap;
	
	@Override
	public void registerProduct(Product p) {
		idMap.put(((IDCard)p).getId() ,((IDCard)p).getOwner());
	}

	@Override
	public Product createProduct(String owner) {
		Product product = new IDCard(owner, id++);
		return product;
	}

}
