package top.stanwang.factory.framework;

public abstract class Creator {
	public final Product create(String owner) {
		Product p = createProduct(owner);
		registerProduct(p);
		return p;
	}

	public abstract void registerProduct(Product p);

	public abstract Product createProduct(String owner);

}
